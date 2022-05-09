package nya.nekoneko.bilibili.api.uploader;

import cn.hutool.core.codec.Base64;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.util.*;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Ho
 */
public class KodoUploader implements Uploader {
    private static final int CHUNK_SIZE = 4 * 1024 * 1024;
    private static final int THREAD_COUNT = 16;
    private static final int CHECK_INTERVAL = 3 * 1000;

    @Override
    public String upload(BilibiliLoginInfo bilibiliLoginInfo, File file) throws Exception {
        long start = System.currentTimeMillis();
        String fileName = file.getName();
        PrintUtil.info("使用 KodoUploader 上传");
        long fileSize = file.length();
        int chunkNum = (int) Math.ceil(1.0 * fileSize / CHUNK_SIZE);
        PrintUtil.info("文件名: " + fileName);
        PrintUtil.info("分块数: " + chunkNum);
        PrintUtil.info("文件大小: " + StatUtil.convertFileSize(fileSize));
        PrintUtil.info("分块大小: " + StatUtil.convertFileSize(CHUNK_SIZE));
        PrintUtil.info("线程数: " + THREAD_COUNT);
        //STEP1.获取上传信息
        Map<String, String> map = new HashMap<>();
        map.put("name", fileName);
        map.put("size", String.valueOf(fileSize));
        map.put("r", "kodo");
//        map.put("bucket", "bvcupcdnkodobm");
        map.put("profile", "ugcupos/bup");
        map.put("ssl", "0");
        map.put("version", "2.11.0");
        map.put("build", "2110000");
        Request request = BiliRequestFactor.getBiliRequest()
                .url("https://member.bilibili.com/preupload", map)
                .get()
                .cookie(bilibiliLoginInfo)
                .buildRequest();
        String result1 = Call.doCallGetString(request);
        ONode node = ONode.loadStr(result1);
        String biliFilename = node.get("bili_filename").getString();
        String bizId = node.get("biz_id").getString();
        String endpoint = node.get("endpoint").getString();
        String fetchUrl = "http:" + node.get("fetch_url").getString();
        String fetchUrls = node.get("fetch_urls").getString();
        String X_Upos_Auth = node.get("fetch_headers").get("X-Upos-Auth").getString();
        String X_Upos_Fetch_Source = node.get("fetch_headers").get("X-Upos-Fetch-Source").getString();
        String key = node.get("key").getString();
        String uptoken = node.get("uptoken").getString();
        String basicUrl = "http:" + endpoint + "/mkblk/";
        String endUrl = "http:" + endpoint + "/mkfile/" + fileSize + "/key/" + Base64.encode(key);
        //STEP2.开始上传
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(THREAD_COUNT);
        Progress progress = new Progress(fileSize);
        Map<Integer, String> infoMap = new ConcurrentHashMap<>();
        for (int chunkIndex = 0; chunkIndex < chunkNum; chunkIndex++) {
            byte[] b = new byte[CHUNK_SIZE];
            int read = bis.read(b);
            if (read < CHUNK_SIZE) {
                //最后一个分块
                b = Arrays.copyOf(b, read);
            }
            byte[] finalB = b;
            int finalChunkIndex = chunkIndex;
            String info = String.format("[%s/%s]", chunkIndex + 1, chunkNum);
            while (service.getActiveCount() >= THREAD_COUNT) {
                //如果活动线程数小于并发数, 继续添加任务, 解决堆内存溢出问题
                // java.lang.OutOfMemoryError: Java heap space
                Thread.sleep(CHECK_INTERVAL);
            }
            service.execute(() -> {
                uploadChunk(basicUrl, uptoken, finalChunkIndex, finalB, info, progress, infoMap);
            });
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        //STEP3.确认上传分块
        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < chunkNum; i++) {
            sj.add(infoMap.get(i));
        }
        Request request3 = BiliRequestFactor.getBiliRequest()
                .url(endUrl)
                .postJson(sj.toString())
                .header("Authorization", "UpToken " + uptoken)
                .buildRequest();
        String result3 = Call.doCallGetString(request3);
        //STEP4.确认上传数据
        Map<String, String> map4 = new HashMap<>();
        map4.put("output", "json");
        map4.put("profile", "ugcupos/fetch");
        map4.put("name", fileName);
        map4.put("biz_id", bizId);
        map4.put("fetch", "");
        Request request4 = BiliRequestFactor.getBiliRequest()
                .url(fetchUrl)
                .postForm(map4)
                .header("X-Upos-Auth", X_Upos_Auth)
                .header("X-Upos-Fetch-Source", X_Upos_Fetch_Source)
                .buildRequest();
        String result4 = Call.doCallGetString(request4);
        PrintUtil.info("fns: " + biliFilename);
        StatUtil.uploadInfoStat(start, System.currentTimeMillis(), fileSize);
        return biliFilename;
    }

    private void uploadChunk(String basicUrl, String uptoken, int chunkIndex, byte[] data, String info, Progress progress, Map<Integer, String> infoMap) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(basicUrl + data.length)
                .post(data)
                .header("Authorization", "UpToken " + uptoken)
                .buildRequest();
        while (true) {
            try {
                String result = Call.doCallGetString(request);
                String ctx = ONode.loadStr(result).get("ctx").getString();
                infoMap.put(chunkIndex, ctx);
                //进度条+1
//                progress.add(data.length, ctx);
                progress.add(data.length);
                break;
            } catch (Exception e) {
                e.printStackTrace();
                PrintUtil.info(info + "发生异常, 3秒后重新上传.");
                try {
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
    }
}
