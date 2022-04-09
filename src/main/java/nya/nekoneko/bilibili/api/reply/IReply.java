package nya.nekoneko.bilibili.api.reply;

import nya.nekoneko.bilibili.enums.ReplyOrderType;
import nya.nekoneko.bilibili.model.BilibiliReply;

import java.util.List;

/**
 * 评论
 *
 * @author Ho
 */
public interface IReply {
    List<BilibiliReply> getRecentReplyList(int pageNum, int pageSize);

    List<BilibiliReply> getRecentReplyList(int pageNum, int pageSize, String bvid);

    List<BilibiliReply> getRecentReplyList(int pageNum, int pageSize, String bvid, ReplyOrderType orderType);

    List<BilibiliReply> getVideoReplyList(int aid, int page);

}
