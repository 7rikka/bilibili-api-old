package nya.nekoneko.bilibili.util;

import cn.hutool.crypto.SecureUtil;

import java.util.Map;
import java.util.StringJoiner;

/**
 * @author Ho
 */
public class AppUtil {
    public static String getSign(Map<String, String> map, String appSecret) {
        StringJoiner sj = new StringJoiner("&");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sj.add(entry.getKey() + "=" + entry.getValue());
        }
        return SecureUtil.md5(sj + appSecret);
    }
}
