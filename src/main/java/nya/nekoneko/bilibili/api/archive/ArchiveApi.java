package nya.nekoneko.bilibili.api.archive;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliActivity;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliVideoType;
import nya.nekoneko.bilibili.model.archive.BilibiliArchiveVideo;
import nya.nekoneko.bilibili.model.archive.BilibiliArchiveView;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ArchiveApi implements IArchive {
    private final BilibiliLoginInfo loginInfo;

    public ArchiveApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 获取原始信息
     *
     * @return
     */
    @Override
    public BiliResult getArchivePre() {
        Map<String, String> map = new HashMap<>();
        map.put("lang", "cn");
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.ARCHIVE_PRE, map)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        return Call.doCall(request);
    }

    /**
     * 获取可参加活动列表
     *
     * @return 可参加活动列表
     */
    @Override
    public List<BilibiliActivity> getAvaliableActivity() {
        BiliResult result = getArchivePre();
        if (result.getCode() == 0) {
            ONode node = result.getData().get("activities");
            node.forEach(oNode -> {
                oNode.set("stime",oNode.get("stime").getLong() * 1000);
                oNode.set("etime",oNode.get("etime").getLong() * 1000);
            });
            return node.toObjectList(BilibiliActivity.class);
        }
        return null;
    }

    /**
     * 获取分区列表
     *
     * @return
     */
    @Override
    public List<BilibiliVideoType> getVideoTypeList() {
        BiliResult result = getArchivePre();
        if (result.getCode() == 0) {
            return result.getData().get("typelist").toObjectList(BilibiliVideoType.class);
        }
        return null;
    }

    @Override
    public List<String> getCoverList(String fns) {
        Map<String, String> map = new HashMap<>();
        map.put("fns", fns);
        Request request = BiliRequestFactor.getBiliRequest()
//                .url(UrlConfig.GET_RECOVER_LIST, map)
                .url(UrlConfig.GET_RECOVER_LIST)
                .addParam("fns",fns)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        return result.getData().toObjectList(String.class);
    }

    @Override
    public BilibiliArchiveView getArchiveView(String bvid, String history) {
        Map<String, String> map = new HashMap<>();
        map.put("bvid", bvid);
        map.put("history", history);
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_ARCHIVE_VIEW, map)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
//        System.out.println(result);
        ONode archive = result.getData().get("archive");
        BilibiliArchiveView bilibiliArchiveView = archive.toObject(BilibiliArchiveView.class);
//        System.out.println(bilibiliArchiveView);
        ONode videos = result.getData().get("videos");
        List<BilibiliArchiveVideo> bilibiliArchiveVideos = videos.toObjectList(BilibiliArchiveVideo.class);
//        for (BilibiliArchiveVideo bilibiliArchiveVideo : bilibiliArchiveVideos) {
//            System.out.println(bilibiliArchiveVideo);
//        }
        bilibiliArchiveView.setVideos(bilibiliArchiveVideos);
        return bilibiliArchiveView;
    }

    @Override
    public BilibiliArchiveView getArchiveView(String bvid) {
        return getArchiveView(bvid, null);
    }
}
