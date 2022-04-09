package nya.nekoneko.bilibili.convert;

import org.noear.snack.ONode;

/**
 * @author Ho
 */
public interface Converter {
    /**
     * 处理单个对象
     *
     * @param node
     */
    void modify(ONode node);

    /**
     * 转换单个对象
     *
     * @param node
     * @param clz
     * @param <T>
     * @return
     */
    default <T> T convert(ONode node, Class<T> clz) {
        return node.toObject(clz);
    }

    /**
     * 转换并反序列化为对象
     *
     * @param node
     * @param clz
     * @param <T>
     * @return
     */
    default <T> T modifyAndConvert(ONode node, Class<T> clz) {
        modify(node);
        return convert(node, clz);
    }
}
