package nya.nekoneko.bilibili.api.manga;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.exception.RequestException;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.manga.BilibiliMangaClockInInfo;
import nya.nekoneko.bilibili.model.manga.BilibiliMangaShopItem;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.util.HashMap;
import java.util.List;

/**
 * @author Ho
 */
@Slf4j
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

    @Override
    public BilibiliMangaClockInInfo clockInInfo() {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.MANGA_CLOCK_IN_INFO)
                .postForm(new HashMap<>())
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        return result.getData().toObject(BilibiliMangaClockInInfo.class);
    }

    @Override
    public int getMyPoint() {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_POINT_INFO)
                .postForm(new HashMap<>() {{
                    put("platform", "android");
                }})
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        return result.getData().get("point").getInt();
    }

    @Override
    public List<BilibiliMangaShopItem> getProductList() {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_PRODUCT_LIST)
                .postForm(new HashMap<>())
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        return result.getData().toObjectList(BilibiliMangaShopItem.class);
    }

    @Override
    public boolean exchangeProduct(int productId, int productNum, int point) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.EXECHANGE_PRODUCT)
                .postForm(new HashMap<>() {{
                    put("product_id", productId);
                    put("product_num", productNum);
                    put("point", point);
                }})
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (0 == result.getCode()) {
            return true;
        }
        log.error(result.toString());
        return false;
    }
}
