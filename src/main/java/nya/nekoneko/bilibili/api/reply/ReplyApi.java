package nya.nekoneko.bilibili.api.reply;

import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.enums.ReplyOrderType;
import nya.nekoneko.bilibili.model.*;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.util.ArrayList;
import java.util.List;


public class ReplyApi implements IReply {
    private final BilibiliLoginInfo loginInfo;

    public ReplyApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    // filter=-1
    // is_hidden=0
    // type=1
    // comment_display=0

    @Override
    public List<BilibiliReply> getRecentReplyList(int pageNum, int pageSize) {
        return getRecentReplyList(pageNum, pageSize, null, ReplyOrderType.CTIME);
    }

    @Override
    public List<BilibiliReply> getRecentReplyList(int pageNum, int pageSize, String bvid) {
        return getRecentReplyList(pageNum, pageSize, bvid, ReplyOrderType.CTIME);
    }

    /**
     * 获取最近收到的评论
     *
     * @param pageNum  页数
     * @param pageSize 分页大小 [1,100]
     * @return
     */
    @Override
    public List<BilibiliReply> getRecentReplyList(int pageNum, int pageSize, String bvid, ReplyOrderType orderType) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_RECENT_REPLY_LIST)
                .addParam("pn", pageNum)
                .addParam("ps", pageSize)
                .addParam("order", orderType)
                .addParam("bvid", bvid)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        List<BilibiliReply> replyList = new ArrayList<>();
        result.getData().forEach(node -> {
            BilibiliReply reply = node.toObject(BilibiliReply.class);
            reply.setUser(
                    BilibiliUser.builder()
                            .uid(node.get("mid").getInt())
                            .name(node.get("replier").getString())
                            .avatar(node.get("uface").getString())
                            .build()
            );
            replyList.add(reply);
            System.out.println(reply);
        });
        return replyList;
    }

    //mode 0 热度
    //mode 1 按热度+按时间
    //mode 2 仅按时间
    //mode 3 热度
    public void getVideoReplyList(int aid, int page) {
        //next=2&type=1&plat=1
        //next=0&type=1&plat=1
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_VIDEO_REPLY_LIST)
                .addParam("oid", aid)
                .addParam("mode", 3)
                .addParam("ps", 20)
                .addParam("next", page)
                .addParam("type", 1)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
//        System.out.println(result);
        result.getData().get("replies").forEach(n -> {
            n.set("ctime", n.get("ctime").getLong() * 1000);
            //
            BilibiliReply r = n.toObject(BilibiliReply.class);
            r.setId(n.get("rpid").getLong());
            //处理用户
            ONode memberNode = n.get("member");
            memberNode.rename("uname", "name");
            BilibiliUser user = memberNode.toObject(BilibiliUser.class);
            System.out.println(r);
            //处理大会员信息
            ONode vipNode = memberNode.get("vip");
            vipNode.rename("vipType", "type");
            vipNode.rename("vipDueDate", "due_date");
            vipNode.rename("dueRemark", "due_remark");
            vipNode.rename("vipStatus", "status");
            vipNode.rename("vipStatusWarn", "status_warn");
            vipNode.rename("themeType", "theme_type");
            BilibiliVipInfo vipInfo = vipNode.toObject(BilibiliVipInfo.class);
            user.setVip(vipInfo);
        });

    }
}
