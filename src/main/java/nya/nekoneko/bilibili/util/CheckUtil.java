package nya.nekoneko.bilibili.util;

public class CheckUtil {
    public static void checkNotEmpty(String s,String exceptionMessage){
        if (null == s || s.strip().length() == 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
