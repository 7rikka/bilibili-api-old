package nya.nekoneko.bilibili.api.manga;

import nya.nekoneko.bilibili.model.manga.BilibiliMangaClockInInfo;
import nya.nekoneko.bilibili.model.manga.BilibiliMangaShopItem;

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
    BilibiliMangaClockInInfo clockInInfo();

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
}
