package nya.nekoneko.bilibili.api.space;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.convert.ConvertFactory;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliRelationStat;
import nya.nekoneko.bilibili.model.BilibiliUser;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SpaceApi implements ISpace {
    private final BilibiliLoginInfo loginInfo;

    public SpaceApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 获取用户信息（登录状态获取）
     *
     * @param uid
     * @return
     */
    @Override
    public BilibiliUser getUserInfo(int uid) {
        Map<String, String> map = new HashMap<>();
        map.put("mid", String.valueOf(uid));
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.USER_INFO, map)
                .cookie(loginInfo)
                .get()
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            return ConvertFactory.convertObject(result.getData(), BilibiliUser.class);
        } else {
            log.error("获取UID: {} 信息错误! {}", uid, result);
            return null;
        }
    }

    @Override
    public BilibiliRelationStat getRelationStat(int uid) {
        Map<String, String> map = new HashMap<>();
        map.put("vmid", String.valueOf(uid));
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.RELATION_STAT, map)
                .cookie(loginInfo)
                .get()
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (0 == result.getCode()) {
            return result.getData().toObject(BilibiliRelationStat.class);
        }
        return null;
    }
}
