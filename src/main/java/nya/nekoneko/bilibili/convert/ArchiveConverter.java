package nya.nekoneko.bilibili.convert;

import org.noear.snack.ONode;

/**
 * 对
 * https://member.bilibili.com/x/web/archives
 * 进行转换
 *
 * @author Ho
 */
public class ArchiveConverter implements Converter {
    /**
     * 处理单个对象
     *
     * @param node
     */
    @Override
    public void modify(ONode node) {
        node.rename("tid", "video_type_id");
        node.rename("desc", "description");
        node.rename("state_desc", "state_description");
        node.rename("desc_format_id", "description_format_id");
        node.set("pass_time", node.get("ptime").getLong() * 1000);
        node.set("submit_time", node.get("ctime").getLong() * 1000);
        node.remove("ptime");
        node.remove("ctime");
    }
}
