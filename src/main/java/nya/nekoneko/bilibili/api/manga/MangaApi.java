package nya.nekoneko.bilibili.api.manga;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.exception.RequestException;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.manga.BilibiliMangaClockInInfo;
import nya.nekoneko.bilibili.model.manga.BilibiliMangaDetail;
import nya.nekoneko.bilibili.model.manga.BilibiliMangaImageData;
import nya.nekoneko.bilibili.model.manga.BilibiliMangaShopItem;
import nya.nekoneko.bilibili.model.manga.season.BilibiliMangaSeasonInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import nya.nekoneko.bilibili.util.PrintUtil;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

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

    @Deprecated
    @Override
    public BilibiliMangaClockInInfo getClockInInfo() {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.MANGA_CLOCK_IN_INFO)
                .postForm(new HashMap<>())
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        return result.getData().toObject(BilibiliMangaClockInInfo.class);
    }

    @Override
    public BilibiliMangaSeasonInfo getSeasonInfo() {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_SEASON_INFO)
                .addParam("device", "h5")
                .addParam("platform", "web")
                .postForm(new HashMap<>())
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        System.out.println(result.getData().toJson());
        return null;
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
                .url(UrlConfig.MANGA_DETAIL)
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

    /**
     * 获取漫画详情
     *
     * @param mangaId 漫画id(comicId)
     * @return
     */
    @Override
    public BilibiliMangaDetail getMangaDetail(int mangaId) {
        String s = ONode.load(new HashMap<String, Integer>() {{
            put("comicId", mangaId);
        }}).toString();
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.MANGA_DETAIL)
                .addParam("device", "android")
                .postJson(s)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (0 == result.getCode()) {
            return result.getData().toObject(BilibiliMangaDetail.class);
        }
        return null;
    }

    /**
     * 获取章节图片信息
     *
     * @param epId 章节id
     * @return
     */
    @Override
    public BilibiliMangaImageData getMangaImageList(int epId) {
        return getMangaImageList(epId, false);
    }

    /**
     * 获取章节图片信息
     *
     * @param epId  章节id
     * @param login
     * @return
     */
    @Override
    public BilibiliMangaImageData getMangaImageList(int epId, boolean login) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_MANGA_IMAGE_INDEX)
                .addParam("device", "android")
                .addParam("platform", "android")
                .postJson(ONode.load(new HashMap<String, Integer>() {{
                    put("ep_id", epId);
                }}).toString())
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (0 == result.getCode()) {
            return result.getData().toObject(BilibiliMangaImageData.class);
        }
        PrintUtil.error("epId:" + epId + " Error Code " + result.getCode() + ": " + result.getMsg());
        return null;
    }

    /**
     * 获取单个图片的带token url
     *
     * @param url
     * @return
     */
    @Override
    public String getImageUrl(String url) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_IMAGE_TOKEN)
                .addParam("device", "android")
                .addParam("platform", "android")
                .postJson("{\"urls\": \"[\\\"" + url + "\\\"]\"}")
                .buildRequest();
        BiliResult result = Call.doCall(request);
        ONode node = result.getData().get(0);
        String url1 = node.get("url").getString();
        String token = node.get("token").getString();
        return url1 + "?token=" + token;
    }

    /**
     * 获取多个个图片的带token url
     *
     * @param urls
     * @return
     */
    @Override
    public List<String> getImageUrl(List<String> urls) {

        StringJoiner sj = new StringJoiner(",");
        for (String url : urls) {
            sj.add("\\\"" + url + "\\\"");
        }
        String json = "{\"urls\": \"[" + sj + "]\"}";
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_IMAGE_TOKEN)
                .addParam("device", "android")
                .addParam("platform", "android")
                .postJson(json)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        ONode node = result.getData().get(0);
        List<String> urlList = new LinkedList<>();
        result.getData().forEach(node1 -> {
            String url1 = node.get("url").getString();
            String token = node.get("token").getString();
            urlList.add(url1 + "?token=" + token);
        });
        return urlList;
    }
}
