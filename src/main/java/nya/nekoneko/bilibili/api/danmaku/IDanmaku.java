package nya.nekoneko.bilibili.api.danmaku;

import com.google.protobuf.InvalidProtocolBufferException;
import nya.nekoneko.bilibili.model.BilibiliDanmaku;

import java.util.List;

public interface IDanmaku {
    List<BilibiliDanmaku> getRecentDanmakuList(int pageNum,int pageSize);
    List<BilibiliDanmaku> getRecentDanmakuList(int pageNum);
    void getVideoDanmakuList(int cid) throws InvalidProtocolBufferException;
}
