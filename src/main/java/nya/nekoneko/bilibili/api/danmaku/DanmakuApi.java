package nya.nekoneko.bilibili.api.danmaku;

import bilibili.community.service.dm.v1.Dm;
import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliDanmaku;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliUser;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import nya.nekoneko.bilibili.util.PrintUtil;
import okhttp3.Request;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class DanmakuApi implements IDanmaku {
    private final BilibiliLoginInfo loginInfo;

    public DanmakuApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * @param pageNum  页数
     * @param pageSize 分页大小 [1,2052]
     * @return
     */
    @Override
    public List<BilibiliDanmaku> getRecentDanmakuList(int pageNum, int pageSize) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_RECENT_DANMAKU_LIST)
                .addParam("pn", pageNum)
                .addParam("ps", pageSize)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        List<BilibiliDanmaku> list = new ArrayList<>();
        result.getData().get("result").forEach(node -> {
            node.set("ctime", node.get("ctime").getLong() * 1000);
            BilibiliDanmaku danmaku = node.toObject(BilibiliDanmaku.class);
            danmaku.setUser(
                    BilibiliUser.builder()
                            .uid(node.get("mid").getInt())
                            .hash(node.get("mid_hash").getString())
                            .name(node.get("uname").getString())
                            .build()
            );
            list.add(danmaku);
        });
        return list;
    }

    @Override
    public List<BilibiliDanmaku> getRecentDanmakuList(int pageNum) {
        return getRecentDanmakuList(pageNum, 50);
    }

    /**
     * 获取视频实时弹幕
     *
     * @param cid
     * @return
     */
    @Override
    public List<BilibiliDanmaku> getVideoDanmakuList(int cid, int segmentIndex) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_VIDEO_DANMAKU_LIST)
                .addParam("type", 1)
                .addParam("oid", cid)
//                .addParam("pid", "")
                .addParam("segment_index", segmentIndex)
                .cookie(loginInfo)
                .buildRequest();
        byte[] result = Call.doCallGetBytes(request);
        List<BilibiliDanmaku> danmakuList = new ArrayList<>();
        try {
            Dm.DmSegMobileReply dmSegMobileReply = Dm.DmSegMobileReply.parseFrom(result);
            for (Dm.DanmakuElem item : dmSegMobileReply.getElemsList()) {
                BilibiliDanmaku danmaku = BilibiliDanmaku.builder()
                        .cid(cid)
                        .id(item.getId())
                        .progress(item.getProgress())
                        .mode(item.getMode())
                        .weight(item.getWeight())
                        .fontsize(item.getFontsize())
                        .color(String.valueOf(item.getColor()))
                        .content(item.getContent())
                        .ctime(LocalDateTime.ofEpochSecond(item.getCtime(), 0, ZoneOffset.ofHours(8)))
                        .pool(item.getPool())
                        .action(item.getAction())
                        .attrs(String.valueOf(item.getAttr()))
                        .user(BilibiliUser.builder()
                                .hash(item.getMidHash())
                                .build())
                        .build();
                danmakuList.add(danmaku);
            }
        } catch (Exception e) {
            PrintUtil.error("[Protobuf]反序列化弹幕失败: " + e.getMessage());
        }
        return danmakuList;

    }

    @Override
    public List<BilibiliDanmaku> getVideoDanmakuList(int cid) {
        return getVideoDanmakuList(cid, 1);
    }
}
