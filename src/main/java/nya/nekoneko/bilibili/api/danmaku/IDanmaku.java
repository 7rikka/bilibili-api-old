package nya.nekoneko.bilibili.api.danmaku;

import nya.nekoneko.bilibili.model.BilibiliDanmaku;

import java.util.List;

public interface IDanmaku {
    List<BilibiliDanmaku> getRecentDanmakuList(int pageNum, int pageSize);

    List<BilibiliDanmaku> getRecentDanmakuList(int pageNum);

    List<BilibiliDanmaku> getVideoDanmakuList(int cid, int segmentIndex);

    List<BilibiliDanmaku> getVideoDanmakuList(int cid);
}
