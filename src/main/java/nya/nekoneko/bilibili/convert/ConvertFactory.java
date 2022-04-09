package nya.nekoneko.bilibili.convert;

import nya.nekoneko.bilibili.model.BilibiliReply;
import nya.nekoneko.bilibili.model.BilibiliUser;
import org.noear.snack.ONode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ho
 */
public class ConvertFactory {
    private static final Map<Class<?>, Converter> MAP = new HashMap<>();

    static {
        MAP.put(BilibiliReply.class, new ReplyConverter());
        MAP.put(BilibiliUser.class, new UserConverter());

    }

    public static <T> void modify(ONode node, Class<T> clz) {
        Converter converter = MAP.get(clz);
        converter.modify(node);
    }

    public static <T> T convertObject(ONode node, Class<T> clz) {
        //获取转换器
        Converter converter = MAP.get(clz);
        System.out.println("转换器: " + converter);
        return converter.modifyAndConvert(node, clz);
    }

    public static <T> List<T> convertList(ONode node, Class<T> clz) {
        //获取转换器
        Converter converter = MAP.get(clz);
        System.out.println("批量转换器: " + converter);
        List<T> list = new ArrayList<>();
        node.forEach(node1 -> {
            list.add(converter.modifyAndConvert(node1, clz));
        });
        return list;
    }
}
