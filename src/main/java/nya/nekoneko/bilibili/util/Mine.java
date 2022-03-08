package nya.nekoneko.bilibili.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class Mine {
    public static final Map<String, String> map = new LinkedHashMap<>();
    static {
        map.put("png", "image/png");
        map.put("gif", "image/gif");
        map.put("jpg", "image/jpeg");
    }
}
