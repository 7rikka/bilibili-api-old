package nya.nekoneko.bilibili.api.uploader;

import lombok.extern.slf4j.Slf4j;
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
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Ho
 */
@Slf4j
public class UposUploader implements Uploader {
    /**
     * 线程池活动任务数检测间隔
     */
    private static final int CHECK_INTERVAL = 3 * 1000;
    private static final int THREAD_COUNT = 16;
    //新
//    private static final String profile = "ugcfx/bup";
    //旧
    private static final String PROFILE = "ugcupos/bup";
    //upcdn:
    //  bda2
    //  qn
    //  ws
    private static String upcdn = "qn";
    private static String zone = "cs";

    public UposUploader() {
    }

    public UposUploader(int type) {
        if (1 == type) {
            //sz-bda2
            upcdn = "bda2";
            zone = "sz";
        } else if (2 == type) {
            //sz-qn
            upcdn = "qn";
            zone = "sz";
        } else if (3 == type) {
            //cs-bda2
            upcdn = "bda2";
            zone = "cs";
        } else if (4 == type) {
            //cs-qn
            upcdn = "qn";
            zone = "cs";
        } else if (5 == type) {
            //cs-qnhk
            upcdn = "qnhk";
            zone = "cs";
        } else if (6 == type) {
            //cs-bldsa
            upcdn = "bldsa";
            zone = "cs";
        }
    }

    //http://member.bilibili.com/x/vupre/web/profile?scene=transAndConv&t=1648959564583
    //http://member.bilibili.com/x/vupre/web/profile?scene=videoUgc&t=1648959564583
    @Override
    public String upload(BilibiliLoginInfo bilibiliLoginInfo, File file) throws Exception {
        long start = System.currentTimeMillis();
        String fileName = file.getName();
        PrintUtil.info("使用 UposUploader(cdn：" + upcdn + " zone：" + zone + ") 上传");
        long fileSize = file.length();
        //STEP1.获取上传信息
        Map<String, String> map = new HashMap<>();
        map.put("name", fileName);
        map.put("r", "upos");
        map.put("profile", PROFILE);
        map.put("zone", zone);
        map.put("size", String.valueOf(fileSize));
        map.put("upcdn", upcdn);
        map.put("ssl", "0");
        map.put("version", "2.10.4.0");
        map.put("build", "2100400");
        map.put("webVersion", "2.0.0");
        Request request = BiliRequestFactor.getBiliRequest()
                .url("https://member.bilibili.com/preupload", map)
                .get()
                .cookie(bilibiliLoginInfo)
                .buildRequest();
        String result1 = Call.doCallGetString(request);
        ONode node = ONode.loadStr(result1);
        String auth = node.get("auth").getString();
        String bizId = node.get("biz_id").getString();
        int chunkSize = Integer.parseInt(node.get("chunk_size").getString());
        String endpoint = node.get("endpoint").getString();
        String uposUri = node.get("upos_uri").getString();
        int chunkNum = (int) Math.ceil(1.0 * fileSize / chunkSize);
        PrintUtil.info("文件名: " + fileName);
        PrintUtil.info("分块数: " + chunkNum);
        PrintUtil.info("文件大小: " + StatUtil.convertFileSize(fileSize));
        PrintUtil.info("分块大小: " + StatUtil.convertFileSize(chunkSize));
        PrintUtil.info("线程数: " + THREAD_COUNT);
        String basicUrl = "https:" + endpoint + "/" + uposUri.substring("upos://".length());
        PrintUtil.info("目标地址: " + basicUrl);
        //STEP.2
        Request request2 = BiliRequestFactor.getBiliRequest()
                .url(basicUrl, new HashMap<>() {{
                    put("uploads", "");
                    put("output", "json");
                }})
                .postForm(new HashMap<String, String>())
                .header("X-Upos-Auth", auth)
                .buildRequest();
        String result2 = Call.doCallGetString(request2);
        PrintUtil.info("result2: "+result2 );
        ONode node2 = ONode.loadStr(result2);
        String uploadId = node2.get("upload_id").getString();
        String bucket = node2.get("bucket").getString();
        String key = node2.get("key").getString();
        //STEP3.开始上传
        System.out.println("STEP3.开始上传");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(THREAD_COUNT);
        Progress progress = new Progress(fileSize);
        for (int chunkIndex = 0; chunkIndex < chunkNum; chunkIndex++) {
            byte[] b = new byte[chunkSize];
            int read = bis.read(b);
            if (read < chunkSize) {
                //最后一个分块
                b = Arrays.copyOf(b, read);
            }
            byte[] finalB = b;
            //参数
            Map<String, String> params = new HashMap<>();
            params.put("partNumber", String.valueOf(chunkIndex + 1));
            params.put("uploadId", uploadId);
            params.put("chunk", String.valueOf(chunkIndex));
            params.put("chunks", String.valueOf(chunkNum));
            params.put("size", String.valueOf(b.length));
            params.put("start", String.valueOf(chunkIndex * chunkSize));
            params.put("end", String.valueOf(chunkIndex * chunkSize + b.length));
            params.put("total", String.valueOf(fileSize));
            String info = String.format("[%s/%s]", chunkIndex + 1, chunkNum);
            while (service.getActiveCount() >= THREAD_COUNT) {
                //如果活动线程数小于并发数, 继续添加任务, 解决堆内存溢出问题
                // java.lang.OutOfMemoryError: Java heap space
                Thread.sleep(CHECK_INTERVAL);
            }
            service.execute(() -> {
                uploadChunk(basicUrl, params, auth, finalB, info, progress);
            });
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        //SETP4.上传结束
        ONode array = ONode.newArray();
        for (int i = 0; i < chunkNum; i++) {
            array.add(ONode.newObject()
                    .set("partNumber", i)
                    .set("eTag", "eTag")
            );
        }
        ONode data = ONode.newObject()
                .setNode("parts", array);
        Request request4 = BiliRequestFactor.getBiliRequest()
                .url(basicUrl, new HashMap<>() {{
                    put("output", "json");
                    put("name", fileName);
                    put("profile", PROFILE);
                    put("uploadId", uploadId);
                    put("biz_id", bizId);
                }})
                .postJson(data.toString())
                .header("X-Upos-Auth", auth)
                .buildRequest();
        String result4 = Call.doCallGetString(request4);
//        PrintUtil.info("result4: " + result4);
        String fns = key.substring("/".length(), key.indexOf("."));
        PrintUtil.info("fns: " + fns);
        StatUtil.uploadInfoStat(start, System.currentTimeMillis(), fileSize);
        return fns;
    }

    private void uploadChunk(String basicUrl, Map<String, String> params, String auth, byte[] data, String info, Progress progress) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(basicUrl, params)
                .put(data)
                .header("X-Upos-Auth", auth)
                .buildRequest();
        while (true) {
            try {
                String result = Call.doCallGetString(request);
                //进度条+1
                progress.add(data.length, result);
                break;
            } catch (Exception e) {
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
