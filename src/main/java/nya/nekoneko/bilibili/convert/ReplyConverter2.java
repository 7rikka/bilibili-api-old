package nya.nekoneko.bilibili.convert;

import nya.nekoneko.bilibili.model.BilibiliReply;
import org.noear.snack.ONode;

/**
 * @author Ho
 */
public class ReplyConverter2 implements Converter {
    /**
     * 处理单个对象
     *
     * @param node
     */
    @Override
    public void modify(ONode node) {
        node.rename("oid", "aid");
        node.rename("mid", "uid");
        node.rename("message", "content");


        ONode user = ONode.newObject();
        user.set("id", node.get("uid").getString());
        user.set("name", node.get("replier").getString());
        user.set("avatar", node.get("uface").getString());
        user.set("is_elec", node.get("is_elec").getInt());
//        user.set("relation", node.get("relation").getString());
        //稿件封面
        node.remove("cover");
        node.remove("is_elec");
        //稿件标题
        node.remove("title");
        //relation:1 没有关注我
        //relation:2 已经关注我
        node.remove("relation");
        node.setNode("user", user);

        if (!node.get("root_info").isNull()) {
            ConvertFactory.modify(node.get("root_info"), BilibiliReply.class);
        }
        if (!node.get("parent_info").isNull()) {
            ConvertFactory.modify(node.get("parent_info"), BilibiliReply.class);
        }
    }

}
