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
        node.rename("member", "user");
        node.set("ctime", node.get("ctime").getLong() * 1000);
        node.remove("rpid_str");
        node.remove("root_str");
        node.remove("parent_str");
        //折叠
        node.remove("folder");
        node.remove("up_action");
        node.remove("card_label");
        node.remove("reply_control");
        node.rename("content", "content_attr");
        node.set("content", node.get("content_attr").get("message").getString());
        //处理用户
        ConvertFactory.modify(node.get("user"), BilibiliUser.class);
        //处理子回复
        if (null != node.get("replies")) {
            node.get("replies").forEach(this::modify);
        }
    }

}
