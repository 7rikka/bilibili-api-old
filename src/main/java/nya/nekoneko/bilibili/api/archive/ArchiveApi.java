package nya.nekoneko.bilibili.api.archive;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliActivity;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliVideoType;
import nya.nekoneko.bilibili.model.archive.BilibiliArchive;
import nya.nekoneko.bilibili.model.archive.BilibiliArchiveVideo;
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
    public BilibiliArchive getArchiveView(String bvid, String history) {
        Map<String, String> map = new HashMap<>();
        map.put("bvid", bvid);
        map.put("history", history);
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_ARCHIVE_VIEW, map)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        System.out.println(result);
        ONode archive = result.getData().get("archive");
        BilibiliArchive bilibiliArchiveView = archive.toObject(BilibiliArchive.class);
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
    public BilibiliArchive getArchiveView(String bvid) {
        return getArchiveView(bvid, null);
    }

    @Override
    public void submit(BilibiliArchive archive) {
        ONode node = ONode.newObject();
        //是否开启稿件预约 0: 不开启 1: 开启
        node.set("act_reserve_create", 0);
        //是否开启杜比音效? 0: 关闭 1: 开启
        node.set("dolby", 0);
        node.set("interactive", 0);
        //参加的任务id
        node.set("mission_id", null);
        node.set("no_disturbance", 0);
        //参加的话题id
        node.set("topic_id", null);
        //{from_topic_id: 3221, from_source: "arc.web.recommend"}
        node.set("topic_detail", null);

        //互动设置
        //关闭弹幕
        node.set("up_close_danmu", false);
        //关闭评论(与 开启精选评论 不可同时选择)
        node.set("up_close_reply", false);
        //开启精选评论(与 关闭评论 不可同时选择)
        node.set("up_selection_reply", false);

    }

    /**
     * 21011 新增稿件分P不能为空
     *
     * @param archive
     */
    @Override
    public void edit(BilibiliArchive archive) {
        ONode node = ONode.newObject();
        //稿件aid
        node.set("aid", archive.getAid());

        //稿件标题
        node.set("title", archive.getTitle());

        //稿件封面
        node.set("cover", archive.getCover());

        //稿件分区id
        node.set("tid", archive.getTid());

        //稿件来源类型 1: 自制 2: 转载
        node.set("copyright", archive.getCopyright());
        if (archive.getCopyright() == 2) {
            node.set("source", archive.getSource());
        }

        //稿件Tag
        node.set("tag", archive.getTag());

        //简介
        node.set("desc", archive.getDesc());

        //粉丝动态
        node.set("dynamic", archive.getDynamic());

        //启用未经作者授权 禁止转载? 0: 不启用 1: 启用
        node.set("no_reprint", archive.getNo_reprint());

        //是否开启稿件预约 0: 不开启 1: 开启
//        node.set("act_reserve_create", 0);

        node.set("desc_format_id", archive.getDesc_format_id());

        //定时发布时间
//        node.set("dtime", archive.getDtime());

        //是否开启充电面板? 0: 不开启 1: 开启
//        node.set("open_elec", 0);

        //启用全景视频? -1: 不启用 1: 启用
//        node.set("is_360", -1);
        //分p列表
        ONode node1 = ONode.newArray();
        for (BilibiliArchiveVideo video : archive.getVideos()) {
            ONode videoNode = ONode.newObject();
            videoNode.set("filename", video.getFilename());
            videoNode.set("title", video.getTitle());
            videoNode.set("desc", video.getDesc());
//            videoNode.set("cid", video.getCid());
//            videoNode.set("editor", null);
            node1.addNode(videoNode);
        }
        node.set("videos", node1);
        System.out.println(node.toString());

        //活动相关


        //启用合作投稿?
//        node.set("handle_staff", false);
//        node.set("interactive", 0);
//        node.set("origin_state", 0);
//        node.set("topic_grey", 1);
        //EDIT_ARCHIVE
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.EDIT_ARCHIVE)
                .addParam("csrf", loginInfo.getCsrf())
                .postJson(node.toString())
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        System.out.println(result);
    }
}
