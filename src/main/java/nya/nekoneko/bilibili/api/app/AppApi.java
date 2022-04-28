package nya.nekoneko.bilibili.api.app;

import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.app.BilibiliAppSplash;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;

import java.util.List;

/**
 * @author Ho
 */
public class AppApi implements IApp {
    private static final String APPKEY = "1d8b6e7d45233436";
    private final BilibiliLoginInfo loginInfo;

    public AppApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 获取App开屏图片列表
     *
     * @return list
     */
    @Override
    public List<BilibiliAppSplash> getAppSplashList() {
        //
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_APP_SPLASH)
                .addParam("appkey", APPKEY)
                .addParam("ts", System.currentTimeMillis() / 1000)
                .appSign(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        System.out.println(result);
        if (0 == result.getCode()) {
            return result.getData().get("list").toObjectList(BilibiliAppSplash.class);
        }
        return null;
    }
}
