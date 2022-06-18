package nya.nekoneko.bilibili.api.manga;

import nya.nekoneko.bilibili.model.manga.BilibiliMangaClockInInfo;
import nya.nekoneko.bilibili.model.manga.BilibiliMangaDetail;
import nya.nekoneko.bilibili.model.manga.BilibiliMangaImageData;
import nya.nekoneko.bilibili.model.manga.BilibiliMangaShopItem;
import nya.nekoneko.bilibili.model.manga.season.BilibiliMangaSeasonInfo;

import java.util.List;

/**
 * @author Ho
 */
public interface IManga {
    /**
     * 签到
     *
     * @return
     */
    boolean clockIn();

    /**
     * 获取签到状态信息（连续签到天数）
     *
     * @return
     */
    @Deprecated
    BilibiliMangaClockInInfo getClockInInfo();

    BilibiliMangaSeasonInfo getSeasonInfo();

    /**
     * @return
     */
    int getMyPoint();

    /**
     * @return
     */
    List<BilibiliMangaShopItem> getProductList();

    /**
     * @param productId
     * @param productNum
     * @param point
     * @return
     */
    boolean exchangeProduct(int productId, int productNum, int point);

    /**
     * 获取漫画详情
     *
     * @param mangaId 漫画id(comicId)
     * @return
     */
    BilibiliMangaDetail getMangaDetail(int mangaId);

    /**
     * 获取章节图片信息
     *
     * @param epId 章节id
     * @return
     */
    BilibiliMangaImageData getMangaImageList(int epId);

    /**
     * 获取章节图片信息
     *
     * @param epId 章节id
     * @return
     */
    BilibiliMangaImageData getMangaImageList(int epId, boolean login);

    String getImageUrl(String url);

    List<String> getImageUrl(List<String> urls);
}
