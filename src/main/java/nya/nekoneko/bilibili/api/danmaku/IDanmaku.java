package nya.nekoneko.bilibili.api.danmaku;

import nya.nekoneko.bilibili.model.BilibiliDanmaku;

import java.util.List;

/**
 * @author Ho
 */
public interface IDanmaku {
    List<BilibiliDanmaku> getRecentDanmakuList(int pageNum);

    List<BilibiliDanmaku> getRecentDanmakuList(int pageNum, int pageSize);

    List<BilibiliDanmaku> searchRecentDanmakuList(int pageNum, int cid);


    List<BilibiliDanmaku> searchRecentDanmakuList(int pageNum, int pageSize, int cid);

    /**
     * 获取视频弹幕（第一分包）
     *
     * @param cid 视频cid
     * @return 弹幕list
     */
    List<BilibiliDanmaku> getVideoDanmakuList(int cid);

    List<BilibiliDanmaku> getVideoDanmakuList(int cid, int segmentIndex);
}
