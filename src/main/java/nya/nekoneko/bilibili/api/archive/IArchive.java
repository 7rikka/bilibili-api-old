package nya.nekoneko.bilibili.api.archive;

import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliActivity;
import nya.nekoneko.bilibili.model.BilibiliVideoType;
import nya.nekoneko.bilibili.model.archive.BilibiliArchive;

import java.util.List;

/**
 * 投稿相关
 */
public interface IArchive {
    /**
     * 获取原始信息
     *
     * @return
     */
    BiliResult getArchivePre();

    /**
     * 获取可参加活动列表
     *
     * @return 可参加活动列表
     */
    List<BilibiliActivity> getAvaliableActivity();

    /**
     * 获取分区列表
     *
     * @return 分区列表
     */
    List<BilibiliVideoType> getVideoTypeList();

    /**
     * 获取缩略图
     */
    List<String> getCoverList(String fns);

    /**
     * 获取稿件投稿信息
     *
     * @return
     */
    BilibiliArchive getArchiveInfo(String bvid, String history);

    BilibiliArchive getArchiveInfo(String bvid);

    /**
     * 提交稿件
     * （只提供基础功能）
     */
    void submit(BilibiliArchive archive);

    /**
     * 修改稿件
     * （只提供基础功能）
     */
    void edit(BilibiliArchive archive);

}
