package nya.nekoneko.bilibili.api.manga;

import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.exception.RequestException;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.util.HashMap;

/**
 * @author Ho
 */
public class MangaApi implements IManga {
    private final BilibiliLoginInfo loginInfo;

    public MangaApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 漫画签到
     *
     * @return
     */
    @Override
    public boolean clockIn() {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.MANGA_CLOCK_IN)
                .postForm(new HashMap<>() {{
                    put("platform", "android");
                }})
                .cookie(loginInfo)
                .buildRequest();
        try {
            BiliResult result = Call.doCall(request);
            return 0 == result.getCode();
        } catch (RequestException e) {
            ONode node = ONode.loadStr(e.getRawString());
            if ("invalid_argument".equals(node.get("code").getString())) {
                return true;
            }
            e.printStackTrace();
            return false;
        }
    }
}
