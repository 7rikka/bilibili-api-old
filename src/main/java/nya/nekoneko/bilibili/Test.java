package nya.nekoneko.bilibili;

import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ho
 */
public class Test {
    public static void main(String[] args) {
        BilibiliLoginInfo bilibiliLoginInfo = new BilibiliLoginInfo();
        bilibiliLoginInfo.setSessData("");
        String fileName = "a.mp4";
        long fileSize = 10000L;
        //STEP1.获取上传信息
        //os=kodo&bucket=bvcupcdnkodobm
        Map<String, String> map = new HashMap<>();
        map.put("name", fileName);
//        map.put("size", String.valueOf(fileSize));
        map.put("r", "kodo");
//        map.put("os", "kodo");
        map.put("bucket", "bvcupcdnkodobm");
        //默认bvcupcdnkodohd
//        map.put("bucket", "bvcupcdnkodohd");

        map.put("profile", "ugcupos/bup");
//        map.put("ssl", "0");
//        map.put("version", "2.10.4.0");
//        map.put("build", "2100400");
//        map.put("webVersion", "2.0.0");
        Request request = BiliRequestFactor.getBiliRequest()
                .url("https://member.bilibili.com/preupload", map)
                .get()
                .cookie(bilibiliLoginInfo)
                .buildRequest();
        String s = Call.doCallGetString(request);
        System.out.println(s);
    }
}
