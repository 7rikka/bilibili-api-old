package nya.nekoneko.bilibili.convert;

import nya.nekoneko.bilibili.model.BilibiliUser;
import org.noear.snack.ONode;

/**
 * @author Ho
 */
public class ReplyConverter implements Converter {
    /**
     * 处理单个对象
     *
     * @param node
     */
    @Override
    public void modify(ONode node) {
        node.rename("rpid", "id");
        node.rename("oid", "aid");
        node.rename("mid", "uid");
        node.set("ctime", node.get("ctime").getLong() * 1000);
        node.rename("content", "content_attr");
        node.set("content", node.get("content_attr").get("message").getString());
        node.remove("relation");
        node.rename("member", "user");
        //处理用户
        ConvertFactory.modify(node.get("user"), BilibiliUser.class, 1);
        node.get("user").set("is_elec", node.get("is_elec").getInt());
        node.remove("is_elec");
        //最近回复中的子回复
        node.remove("replier");
        node.remove("uface");
        node.remove("cover");
        node.remove("title");
        //评论区评论
        node.remove("rpid_str");
        node.remove("root_str");
        node.remove("parent_str");
        node.remove("reply_control");
        //UP主点赞了, UP主回复了
        node.remove("up_action");
        //折叠
        node.remove("folder");
        //处理子回复
        if (!node.get("replies").isNull()) {
            node.get("replies").forEach(this::modify);
        }
    }

}
