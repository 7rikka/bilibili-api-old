package nya.nekoneko.bilibili.util;

import java.util.HashMap;
import java.util.Map;

public class UrlUtil {
    private static final Map<String, String> map = new HashMap<>();

    static {
        map.put("%7B", "\\{");
        map.put("%22", "\"");
        map.put("%3A", ":");
        map.put("%2C", ",");
        map.put("%7D", "}");
        map.put("%2F", "/");
        map.put("%0A", "\n");
        map.put("%3D", "=");
        map.put("%2B", "\\+");
        map.put("%20", " ");
    }

    /**
     * Url反转义
     * @param s
     * @return
     */
    public static String unescape(String s) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            s = s.replaceAll(entry.getKey(), entry.getValue());
        }
        return s;
    }
    /**
     * Url转义
     * @param s
     * @return
     */
    public static String escape(String s) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            s = s.replaceAll(entry.getValue(),entry.getKey());
        }
        return s;
    }
}
