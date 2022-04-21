package nya.nekoneko.bilibili.convert;

import org.noear.snack.ONode;

/**
 * 评论中的用户信息
 *
 * @author Ho
 */
public class UserConverter implements Converter {
    /**
     * 处理单个对象
     *
     * @param node
     */
    @Override
    public void modify(ONode node) {
        node.rename("mid", "id");
        node.rename("uname", "name");
        node.remove("DisplayRank");
        node.set("level", node.get("level_info").get("current_level").getInt());
        node.remove("level_info");
        node.get("pendant").rename("pid", "id");
        node.get("nameplate").rename("nid", "id");
        node.rename("vip", "vip_info");
        ONode vipInfo = node.get("vip_info");
        vipInfo.rename("vipType", "type");
        vipInfo.rename("vipDueDate", "due_date");
        vipInfo.rename("dueRemark", "due_remark");
        vipInfo.rename("accessStatus", "access_status");
        vipInfo.rename("vipStatusWarn", "status_warn");
        vipInfo.rename("themeType", "theme_type");
    }
}
