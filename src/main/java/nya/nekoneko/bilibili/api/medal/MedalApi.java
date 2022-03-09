package nya.nekoneko.bilibili.api.medal;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliFansMedalStat;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;

@Slf4j
public class MedalApi implements IMedal {
    private final BilibiliLoginInfo loginInfo;

    public MedalApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 粉丝勋章领取数据总览
     */
    @Override
    public BilibiliFansMedalStat getFansMedalStat() {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.FAN_MEDAL_STAT)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            return result.getData().toObject(BilibiliFansMedalStat.class);
        }
        return null;
    }
}
