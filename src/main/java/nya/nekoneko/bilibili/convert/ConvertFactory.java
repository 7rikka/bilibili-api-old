package nya.nekoneko.bilibili.convert;

import nya.nekoneko.bilibili.model.BilibiliDanmaku;
import nya.nekoneko.bilibili.model.BilibiliRechargeRecord;
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
    private static final Map<Class<?>, Converter[]> MAP = new HashMap<>();

    static {
        MAP.put(BilibiliReply.class, new Converter[]{new ReplyConverter(), new ReplyConverter2()});
        MAP.put(BilibiliUser.class, new Converter[]{new UserInfoConverter(), new UserConverter()});
        MAP.put(BilibiliDanmaku.class, new Converter[]{new DanmakuConverter()});
        MAP.put(BilibiliRechargeRecord.class, new Converter[]{new RechargeRecordConverter()});


    }

    public static <T> void modify(ONode node, Class<T> clz) {
        modify(node, clz, 0);
    }

    public static <T> void modify(ONode node, Class<T> clz, int index) {
        Converter converter = MAP.get(clz)[index];
        converter.modify(node);
    }

    public static <T> T convertObject(ONode node, Class<T> clz) {
        return convertObject(node, clz, 0);
    }

    public static <T> T convertObject(ONode node, Class<T> clz, int index) {
        //获取转换器
        Converter converter = MAP.get(clz)[index];
        return converter.modifyAndConvert(node, clz);
    }

    public static <T> List<T> convertList(ONode node, Class<T> clz) {
        return convertList(node, clz, 0);
    }

    public static <T> List<T> convertList(ONode node, Class<T> clz, int index) {
        //获取转换器
        Converter converter = MAP.get(clz)[index];
        List<T> list = new ArrayList<>();
        node.forEach(node1 -> {
            list.add(converter.modifyAndConvert(node1, clz));
        });
        return list;
    }
}
