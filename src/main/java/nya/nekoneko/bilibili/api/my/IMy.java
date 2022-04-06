package nya.nekoneko.bilibili.api.my;

import nya.nekoneko.bilibili.model.BilibiliNotify;

import java.util.List;

public interface IMy {
    List<BilibiliNotify> getMyNotifyList();
    List<BilibiliNotify> getMyNotifyList(Long cursor);
    List<BilibiliNotify> getMyNotifyList(int pageSize);
    List<BilibiliNotify> getMyNotifyList(Long cursor,int pageSize);
}
