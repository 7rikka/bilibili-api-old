package nya.nekoneko.bilibili.api.uploader;

import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import nya.nekoneko.bilibili.util.PrintUtil;
import nya.nekoneko.bilibili.util.Progress;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ho
 */
public class CosUploader implements Uploader{
    private static final int CHUNK_SIZE = 10 * 1024 * 1024;
    /**
     * 线程池活动任务数检测间隔
     */
    private static final int CHECK_INTERVAL = 3 * 1000;
    private static final int THREAD_COUNT = 8;

    @Override
    public String upload(BilibiliLoginInfo bilibiliLoginInfo, File file) throws Exception {
        long start = System.currentTimeMillis();
        String fileName = file.getName();
        PrintUtil.info("使用 CosUploader 上传: "+fileName);
        long fileSize = file.length();
        int chunkNum = (int) Math.ceil(1.0 * fileSize / CHUNK_SIZE);
        //STEP1.获取上传信息
        Map<String, String> map = new HashMap<>();
        map.put("name", fileName);
        map.put("size", String.valueOf(fileSize));
        map.put("r", "cos");
        map.put("profile", "ugcupos/bupfetch");
        map.put("ssl", "0");
        map.put("version", "2.10.4.0");
        map.put("build", "2100400");
        Request request = BiliRequestFactor.getBiliRequest()
                .url("https://member.bilibili.com/preupload", map)
                .get()
                .cookie(bilibiliLoginInfo)
                .buildRequest();
        String result1 = Call.doCallGetString(request);
        ONode node = ONode.loadStr(result1);
        String biliFilename = node.get("bili_filename").getString();
        String bizId = node.get("biz_id").getString();
        String Fetch_Header_Authorization = node.get("fetch_headers").get("Fetch-Header-Authorization").getString();
        String X_Upos_Auth = node.get("fetch_headers").get("X-Upos-Auth").getString();
        String X_Upos_Fetch_Source = node.get("fetch_headers").get("X-Upos-Fetch-Source").getString();
        String fetch_url = "https:"+node.get("fetch_url").getString();
        String fetch_urls = node.get("fetch_urls").getString();
        String post_auth = node.get("post_auth").getString();
        String put_auth = node.get("put_auth").getString();
        String url = node.get("url").getString();
        PrintUtil.info("url: "+url);
        //SETP2.
        Request request2 = BiliRequestFactor.getBiliRequest()
                .url(url, new HashMap<>() {{
                    put("uploads", "");
                    put("output", "json");
                }})
                .postForm(new HashMap<String, String>())
                .header("Authorization", post_auth)
                .buildRequest();
        String result2 = Call.doCallGetString(request2);
//        PrintUtil.info("result2: "+result2 );
        //<UploadId>164906166394d15a8e0b5c836047f9e6073b01ba3f9f3fa2aa78327db2b309af2a516ec287</UploadId>
        Pattern r = Pattern.compile("<UploadId>(.*?)</UploadId>");
        Matcher m = r.matcher(result2);
        m.find();
        String uploadId = m.group(1);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(THREAD_COUNT);
        Map<Integer,String> infoMap=new ConcurrentHashMap<>();
        Progress progress = new Progress(fileSize);
        for (int chunkIndex = 0; chunkIndex < chunkNum; chunkIndex++) {
            byte[] b = new byte[CHUNK_SIZE];
            int read = bis.read(b);
            if (read < CHUNK_SIZE) {
                //最后一个分块
                b = Arrays.copyOf(b, read);
            }
            byte[] finalB = b;
            int finalChunkIndex = chunkIndex;
            //参数
            Map<String, String> params = new HashMap<>();
            params.put("partNumber", String.valueOf(chunkIndex + 1));
            params.put("uploadId", uploadId);
            params.put("name", fileName);
            String info = String.format("[%s/%s]", chunkIndex + 1, chunkNum);
            while (service.getActiveCount() >= THREAD_COUNT) {
                //如果活动线程数小于并发数, 继续添加任务, 解决堆内存溢出问题
                // java.lang.OutOfMemoryError: Java heap space
                Thread.sleep(CHECK_INTERVAL);
            }
            service.execute(() -> {
                uploadChunk(url, params, finalChunkIndex,put_auth, finalB, info, progress,infoMap);
            });
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
        //STEP3.确认上传分块
        StringBuffer sb=new StringBuffer("<CompleteMultipartUpload>");
        for (int i = 0; i < chunkNum; i++) {
            sb.append("<Part><PartNumber>")
                    .append(i + 1)
                    .append("</PartNumber><ETag>")
                    .append(infoMap.get(i))
                    .append("</ETag></Part>");
        }
        sb.append("</CompleteMultipartUpload>");
        Request request3 = BiliRequestFactor.getBiliRequest()
                .url(url,new HashMap<>(){{
                    put("uploadId",uploadId);
                }})
                .postXml(sb.toString())
                .header("Authorization",post_auth)
                .buildRequest();
        String result3 = Call.doCallGetString(request3);
        System.out.println("result3:"+result3);
        //STEP4.确认上传数据
        Map<String,String> map4 = new HashMap<>();
        map4.put("biz_id", bizId);
        map4.put("fetch", "");
        map4.put("name", fileName);
        map4.put("output", "json");
        map4.put("profile", "ugcupos/fetch");
        System.out.println("fetch_url:"+fetch_url);
        Request request4 = BiliRequestFactor.getBiliRequest()
                .url(fetch_url,map4)
                .postForm(new HashMap<>())
                .header("Fetch-Header-Authorization",Fetch_Header_Authorization)
                .header("X-Upos-Auth",X_Upos_Auth)
                .header("X-Upos-Fetch-Source",X_Upos_Fetch_Source)
                .buildRequest();
        String result4 = Call.doCallGetString(request4);
        System.out.println(result4);
        return biliFilename;
    }

    private void uploadChunk(String url, Map<String, String> params, int chunkIndex,String auth, byte[] data, String info, Progress progress,Map<Integer,String> infoMap) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(url, params)
                .put(data)
                .header("Authorization", auth)
                .buildRequest();
        while (true) {
            try {
                String eTag = Call.doCallGetHeader(request,"ETag");
                eTag = eTag.replace("\"", "");
                infoMap.put(chunkIndex,eTag);
                PrintUtil.info(info+eTag);
                //进度条+1
                progress.add(data.length, eTag);
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
