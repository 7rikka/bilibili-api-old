package nya.nekoneko.bilibili.convert;

import org.noear.snack.ONode;

/**
 * @author Ho
 */
public class DanmakuConverter implements Converter {
    /**
     * 处理单个对象
     *
     * @param node
     */
    @Override
    public void modify(ONode node) {
        node.remove("id_str");
        node.rename("oid", "cid");
        node.rename("mid", "uid");
        node.rename("msg", "content");
        node.set("ctime", node.get("ctime").getLong() * 1000);
        ONode user = ONode.newObject();
        user.set("hash", node.get("mid_hash").getString());
        user.set("name", node.get("uname").getString());
        user.set("id", node.get("uid").getString());
        node.setNode("user", user);
        user.remove("title");
    }
}
