package nya.nekoneko.bilibili.model.manga;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.util.Date;
import java.util.List;

/**
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliMangaShopItem {
    /**
     *
     */
    @ONodeAttr(name = "id")
    private int id;
    /**
     *
     */
    @ONodeAttr(name = "type")
    private int type;
    /**
     *
     */
    @ONodeAttr(name = "title")
    private String title;
    /**
     *
     */
    @ONodeAttr(name = "image")
    private String image;
    /**
     *
     */
    @ONodeAttr(name = "amount")
    private int amount;
    /**
     *
     */
    @ONodeAttr(name = "cost")
    private int cost;
    /**
     *
     */
    @ONodeAttr(name = "real_cost")
    private int realCost;
    /**
     *
     */
    @ONodeAttr(name = "remain_amount")
    private int remainAmount;
    /**
     *
     */
    @ONodeAttr(name = "comic_id")
    private int comicId;
    /**
     *
     */
    @ONodeAttr(name = "limits")
    private List<String> limits;
    /**
     *
     */
    @ONodeAttr(name = "discount")
    private int discount;
    /**
     *
     */
    @ONodeAttr(name = "product_type")
    private int productType;
    /**
     *
     */
    @ONodeAttr(name = "pendant_url")
    private String pendantUrl;
    /**
     *
     */
    @ONodeAttr(name = "pendant_expire")
    private int pendantExpire;
    /**
     *
     */
    @ONodeAttr(name = "exchange_limit")
    private int exchangeLimit;
    /**
     *
     */
    @ONodeAttr(name = "address_deadline")
    private Date addressDeadline;
    /**
     *
     */
    @ONodeAttr(name = "act_type")
    private int actType;
    /**
     *
     */
    @ONodeAttr(name = "has_exchanged")
    private boolean hasExchanged;
    /**
     *
     */
    @ONodeAttr(name = "main_coupon_deadline")
    private Date mainCouponDeadline;
    /**
     *
     */
    @ONodeAttr(name = "deadline")
    private String deadline;
    /**
     *
     */
    @ONodeAttr(name = "point")
    private String point;
}