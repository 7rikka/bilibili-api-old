package nya.nekoneko.bilibili.api.uploader;

import nya.nekoneko.bilibili.model.BilibiliLoginInfo;

import java.io.File;

/**
 * @author Ho
 */
public class BosUpload implements Uploader{
    @Override
    public String upload(BilibiliLoginInfo bilibiliLoginInfo, File file) throws Exception {
//        long start = System.currentTimeMillis();
//        String fileName = file.getName();
//        PrintUtil.info("使用 KodoUploader 上传: "+fileName);
//        long fileSize = file.length();
////        int chunkNum = (int) Math.ceil(1.0 * fileSize / CHUNK_SIZE);
//        //STEP1.获取上传信息
//        Map<String, String> map = new HashMap<>();
//        map.put("name", fileName);
//        map.put("size", String.valueOf(fileSize));
//        map.put("r", "bos");
//        map.put("profile", "ugcupos/bup");
//        map.put("ssl", "0");
//        map.put("version", "2.11.0");
//        map.put("build", "2110000");
//        Request request = BiliRequestFactor.getBiliRequest()
//                .url("https://member.bilibili.com/preupload", map)
//                .get()
//                .cookie(bilibiliLoginInfo)
//                .buildRequest();
//        String result1 = Call.doCallGetString(request);
//        ONode node = ONode.loadStr(result1);
//        String AccessKeyId = node.get("AccessKeyId").getString();
//        String Expiration = node.get("Expiration").getString();
//        String SecretAccessKey = node.get("SecretAccessKey").getString();
//        String SessionToken = node.get("SessionToken").getString();
//        String bili_filename = node.get("bili_filename").getString();
//        String biz_id = node.get("biz_id").getString();
//        String endpoint = node.get("endpoint").getString();
//        String X_Upos_Auth = node.get("fetch_headers").get("X-Upos-Auth").getString();
//        String X_Upos_Fetch_Source = node.get("fetch_headers").get("X-Upos-Fetch-Source").getString();
//        String fetch_url = "http:"+node.get("fetch_url").getString();
//        String fetch_urls = node.get("fetch_urls").getString();
//        String key = node.get("key").getString();

        return null;
    }
}
