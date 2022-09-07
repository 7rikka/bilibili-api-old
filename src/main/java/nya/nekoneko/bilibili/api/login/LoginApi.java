package nya.nekoneko.bilibili.api.login;

import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliLoginQRInfo;
import nya.nekoneko.bilibili.model.BilibiliLoginQRScanInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;
import okhttp3.Response;
import org.noear.snack.ONode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ho
 */
public class LoginApi implements ILogin {
    private final BilibiliLoginInfo loginInfo;

    public LoginApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 获取扫码信息, 返回扫描Url和二维码key
     *
     * @return
     */
    @Override
    public BilibiliLoginQRInfo getQRCode() {
        //http://passport.bilibili.com/x/passport-login/web/qrcode/generate
        Request request = BiliRequestFactor.getBiliRequest()
                .url("https://passport.bilibili.com/x/passport-login/web/qrcode/generate")
                .get()
                .buildRequest();
        BiliResult s = Call.doCall(request);
        if (0 == s.getCode()) {
            return s.getData().toObject(BilibiliLoginQRInfo.class);
        }
        return null;
    }

    /**
     * 获取二维码扫描的结果
     * Code 0: 成功, 同时返回登录信息
     * Code 86038: 二维码已失效
     * Code 86090: 二维码已扫码未确认
     * Code 86101: 未扫码
     *
     * @param key 验证码key
     */
    @Override
    public BilibiliLoginQRScanInfo QRLogin(String key) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url("https://passport.bilibili.com/x/passport-login/web/qrcode/poll")
                .addParam("qrcode_key", key)
                .get()
                .buildRequest();
        try {
            Response response = Call.doCallGetResponse(request);
            ONode data = ONode.loadStr(response.body().string()).get("data");
            int code = data.get("code").getInt();
            String message = data.get("message").getString();
            BilibiliLoginQRScanInfo info = new BilibiliLoginQRScanInfo();
            info.setCode(code);
            info.setMessage(message);
            if (code == 0) {
                String url = data.get("url").getString();
                info.setUrl(url);
                Map<String, String> map = processMap(url);
                info.setDedeUserId(map.get("DedeUserID"));
                info.setDedeUserIdCkMd5(map.get("DedeUserID__ckMd5"));
                info.setExpires(map.get("Expires"));
                info.setSessData(map.get("SESSDATA"));
                info.setBiliJct(map.get("bili_jct"));
                info.setGoUrl(map.get("gourl"));
            }
            return info;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将url中的参数 转为 Map
     *
     * @param url
     * @return
     */
    private Map<String, String> processMap(String url) {
        Map<String, String> map = new HashMap<>();
        String[] split = url.split("\\?");
        String s2 = split[1];
        String[] split1 = s2.split("&");
        for (String s : split1) {
            String[] split2 = s.split("=");
            map.put(split2[0], split2[1]);
        }
        return map;
    }
}
