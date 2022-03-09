package nya.nekoneko.bilibili.util;

import cn.hutool.core.codec.Base64;

import java.io.InputStream;

public class Base64Util {
    public static String pictureToBase64(InputStream inputStream){
        return  "data:image/jpeg;base64," + Base64.encode(inputStream);
    }
}
