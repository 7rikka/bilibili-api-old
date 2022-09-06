package nya.nekoneko.bilibili.api.login;

import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliLoginQRInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;

/**
 * @author Ho
 */
public class LoginApi implements ILogin {
    private final BilibiliLoginInfo loginInfo;

    public LoginApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 获取扫码信息
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
        return s.getData().toObject(BilibiliLoginQRInfo.class);
    }
}
