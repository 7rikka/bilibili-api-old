package nya.nekoneko.bilibili.convert;

import org.noear.snack.ONode;

/**
 * 对
 * https://api.bilibili.com/x/space/acc/info?mid=xxx
 * 进行转换
 *
 * @author Ho
 */
public class UserInfoConverter implements Converter {
    /**
     * 处理单个对象
     *
     * @param node
     */
    @Override
    public void modify(ONode node) {
        node.rename("mid", "id");
        node.rename("face", "avatar");
        //注册时间, 恒为0, 删除
        node.remove("jointime");
        //节操值, 恒为0, 删除
        node.remove("moral");
        //硬币数, 只能看到自己的, 删除
        node.remove("coins");
        node.set("school_name", node.get("school").get("name").getString());
        node.rename("user_honour_info", "honour_info");
        node.rename("official", "official_verify");
        node.rename("vip", "vip_info");
        node.get("nameplate").rename("nid", "id");
        node.get("pendant").rename("pid", "id");
    }
}
