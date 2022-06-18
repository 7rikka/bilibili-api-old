package nya.nekoneko.bilibili;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;

@Slf4j
public class Test2 {
    public static void main(String[] args) {
        BilibiliLoginInfo loginInfo = new BilibiliLoginInfo();
        loginInfo.setSESSDATA("8f764e10%2C1671006672%2Cbac77*61");
        loginInfo.setAccessKey("cd4d8ef96b0358ee1499c93ecc0e2061");
        BilibiliClient client = new BilibiliClient(loginInfo);
        client.manga.getSeasonInfo();
    }
}
