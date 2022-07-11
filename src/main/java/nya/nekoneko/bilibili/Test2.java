package nya.nekoneko.bilibili;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.api.archive.ArchiveApi;
import nya.nekoneko.bilibili.api.archive.IArchive;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.archive.BilibiliArchive;
import nya.nekoneko.bilibili.model.archive.BilibiliArchiveVideo;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Test2 {
    public static void main(String[] args) {
        BilibiliLoginInfo loginInfo = new BilibiliLoginInfo();
        loginInfo.setSESSDATA("1ada1bd0,1672129456,57205*61");
        loginInfo.setAccessKey("cd4d8ef96b0358ee1499c93ecc0e2061");


        List<BilibiliArchiveVideo> list = new ArrayList<>();
        list.add(BilibiliArchiveVideo.builder()
                .title("Left 4 Dead 2 2021.08.07 - 19.36.13.11.1 - C5")
                .filename("n220711ko3bcadcn2az2p82tck0auo5d")
                .build());
        list.add(BilibiliArchiveVideo.builder()
                .title("Left 4 Dead 2 2021.08.08 - 21.55.08.04.0 - C14")
                .filename("n220711ko10cvvqy5p7c5b24yu09716o")
                .build());
        list.add(BilibiliArchiveVideo.builder()
                .title("Left 4 Dead 2 2022.05.29 - 11.13.55.01.0 - C1")
                .filename("n220711ko31slrczjg4egk3lyper1w9i")
                .build());
        list.add(BilibiliArchiveVideo.builder()
                .title("Left 4 Dead 2 2022.05.29 - 11.36.29.03.0 - C1")
                .filename("n220711ko29ad1937wa7pc94ebscsmhs")
                .build());
        list.add(BilibiliArchiveVideo.builder()
                .title("Left 4 Dead 2 2022.06.05 - 14.15.59.01.0 - C2")
                .filename("n220711ko1bcgjvw1tw5do2cq7ljm15q")
                .build());
        String title = "[水]求生之路2 技能对抗 划水局 #338";
        String strTime = "2022-07-12 12:00:00";
        BilibiliArchive archive = new BilibiliArchive();
        archive.setTitle(title);
        archive.setCopyright(1);
        archive.setVideoTypeId(65);
        archive.setTag("求生之路,求生之路2,L4D2,打卡挑战,游戏头号玩家");
        archive.setDescriptionFormatId(33);
        archive.setDescription("技能对抗");
        archive.setNoReprint(1);
        archive.setVideos(list);
        IArchive archiveApi = new ArchiveApi(loginInfo);
        archiveApi.submitWithApp(archive, strTime);
    }
}
