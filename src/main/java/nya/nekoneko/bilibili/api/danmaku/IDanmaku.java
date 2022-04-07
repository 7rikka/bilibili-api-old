package nya.nekoneko.bilibili.api.danmaku;

import nya.nekoneko.bilibili.model.BilibiliDanmaku;

import java.util.List;

public interface IDanmaku {
    List<BilibiliDanmaku> getRecentDanmakuList(int pageNum,int pageSize);
}
