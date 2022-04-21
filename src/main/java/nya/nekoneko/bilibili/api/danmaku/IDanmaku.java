package nya.nekoneko.bilibili.api.danmaku;

import nya.nekoneko.bilibili.model.BilibiliDanmaku;

import java.util.List;

/**
 * @author Ho
 */
public interface IDanmaku {
    List<BilibiliDanmaku> getRecentDanmakuList(int pageNum, int pageSize);

    List<BilibiliDanmaku> getRecentDanmakuList(int pageNum);

    List<BilibiliDanmaku> getVideoDanmakuList(int cid, int segmentIndex);

    /**
     * 获取视频弹幕（第一分包）
     *
     * @param cid 视频cid
     * @return 弹幕list
     */
    List<BilibiliDanmaku> getVideoDanmakuList(int cid);
}
