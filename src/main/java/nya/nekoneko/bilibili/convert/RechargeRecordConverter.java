package nya.nekoneko.bilibili.convert;

import org.noear.snack.ONode;

/**
 * @author Ho
 */
public class RechargeRecordConverter implements Converter {
    /**
     * 处理单个对象
     *
     * @param node
     */
    @Override
    public void modify(ONode node) {
        node.rename("mid", "uid");
        node.rename("originalThirdCoin", "original_third_coin");
        ONode user = ONode.newObject();
        user.set("id", node.get("uid").getInt());
        user.set("name", node.get("name").getString());
        user.set("avatar", node.get("avatar").getString());
        node.setNode("user", user);
        node.remove("name");
        node.remove("avatar");
    }
}
