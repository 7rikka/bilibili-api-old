package nya.nekoneko.bilibili.util;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class Base64Util {
    private static final String form = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    //data:图片类型;base64,图片二进制
    public static String pictureToBase64(InputStream inputStream) {

        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String s = "assadfasfdafa";
        String s1 = "";
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            String s2 = Integer.toBinaryString(aChar);
            for (int i = s2.length(); i < 8; i++) {
                s2 = "0" + s2;
            }
            s1 += s2;
        }
        System.out.println(s1);
        String result = "";
        char[] chars1 = s1.toCharArray();
        for (int i = 0; i < chars1.length; i += 6) {
            int a = scale2Decimal(new String(chars1, i, 6), 2);
//            System.out.println(a);
            result += form.charAt(a);
            System.out.println(result);
        }


    }

    public static int scale2Decimal(String number, int scale) {
        if (2 > scale || scale > 32) {
            throw new IllegalArgumentException("scale is not in range");
        }
        // 不同其他进制转十进制,修改这里即可
        int total = 0;
        String[] ch = number.split("");
        int chLength = ch.length;
        for (int i = 0; i < chLength; i++) {
            total += Integer.valueOf(ch[i]) * Math.pow(scale, chLength - 1 - i);
        }
        return total;

    }
}
