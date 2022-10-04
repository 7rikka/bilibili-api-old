package nya.nekoneko.bilibili.util;

import cn.hutool.core.codec.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class PasswordUtil {
    /**
     * 密码加密
     *
     * @param password 用户密码
     * @param key      获取到的证书内容
     * @param hash     获取到的盐值
     * @return
     */
    public static String encryptPassword(String password, String key, String hash) {
        try {
            String[] split = key.strip().split("\n");
            String newKey = split[1] + split[2] + split[3] + split[4];
            //进行加密
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decode(newKey));
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.PUBLIC_KEY, publicKey);
            byte[] bytes = cipher.doFinal((hash + password).getBytes());
            return Base64.encode(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
