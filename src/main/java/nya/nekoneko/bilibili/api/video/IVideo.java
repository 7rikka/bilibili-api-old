package nya.nekoneko.bilibili.api.video;

import nya.nekoneko.bilibili.model.BilibiliVideoPlayUrlInfo;

/**
 * @author Ho
 */
public interface IVideo {
    BilibiliVideoPlayUrlInfo getPlayUrl(Integer aid, String bvid, Integer cid, Integer qn, Integer fnval);
}
