package nya.nekoneko.bilibili;

import nya.nekoneko.bilibili.api.uploader.UposUploader;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;

import java.util.List;
import java.util.Scanner;

/**
 * @author Ho
 */
public class T2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String path = "/root/1.mp4";
        BilibiliLoginInfo bilibiliLoginInfo = new BilibiliLoginInfo();
        bilibiliLoginInfo.setSessData("");
//        BilibiliClient bilibiliClient = new BilibiliClient(bilibiliLoginInfo);
            try {
                UposUploader uposUploader = new UposUploader(i);
                uposUploader.upload(bilibiliLoginInfo, path);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
