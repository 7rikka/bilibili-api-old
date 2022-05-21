package nya.nekoneko.bilibili.model.manga;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.util.List;

/**
 * 漫画详情
 *
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliMangaDetail {
    /**
     *
     */
    @ONodeAttr(name = "id")
    private Integer id;
    /**
     *
     */
    @ONodeAttr(name = "title")
    private String title;
    /**
     *
     */
    @ONodeAttr(name = "comic_type")
    private Integer comicType;
    /**
     *
     */
    @ONodeAttr(name = "page_default")
    private Integer pageDefault;
    /**
     *
     */
    @ONodeAttr(name = "page_allow")
    private Integer pageAllow;
    /**
     *
     */
    @ONodeAttr(name = "horizontal_cover")
    private String horizontalCover;
    /**
     *
     */
    @ONodeAttr(name = "square_cover")
    private String squareCover;
    /**
     *
     */
    @ONodeAttr(name = "vertical_cover")
    private String verticalCover;
    /**
     *
     */
    @ONodeAttr(name = "author_name")
    private List<String> authorName;
    /**
     *
     */
    @ONodeAttr(name = "styles")
    private List<String> styles;
    /**
     *
     */
    @ONodeAttr(name = "last_ord")
    private Integer lastOrd;
    /**
     *
     */
    @ONodeAttr(name = "is_finish")
    private Integer isFinish;
    /**
     *
     */
    @ONodeAttr(name = "status")
    private Integer status;
    /**
     *
     */
    @ONodeAttr(name = "fav")
    private Integer fav;
    /**
     *
     */
    @ONodeAttr(name = "read_order")
    private Integer readOrder;
    /**
     *
     */
    @ONodeAttr(name = "evaluate")
    private String evaluate;
    /**
     *
     */
    @ONodeAttr(name = "total")
    private Integer total;
    /**
     *
     */
    @ONodeAttr(name = "ep_list")
    private List<BilibiliMangaEp> epList;
    /**
     *
     */
    @ONodeAttr(name = "release_time")
    private String releaseTime;
    /**
     *
     */
    @ONodeAttr(name = "is_limit")
    private Integer isLimit;
    /**
     *
     */
    @ONodeAttr(name = "read_epid")
    private Integer readEpId;
    /**
     *
     */
    @ONodeAttr(name = "last_read_time")
    private String lastReadTime;
    /**
     *
     */
    @ONodeAttr(name = "is_download")
    private Integer isDownload;
    /**
     *
     */
    @ONodeAttr(name = "read_short_title")
    private String readShortTitle;
    /**
     *
     */
    @ONodeAttr(name = "styles2")
    private List<String> styles2;
    /**
     *
     */
    @ONodeAttr(name = "renewal_time")
    private String renewalTime;
    /**
     *
     */
    @ONodeAttr(name = "last_short_title")
    private String lastShortTitle;
    /**
     *
     */
    @ONodeAttr(name = "discount_type")
    private Integer discountType;
    /**
     *
     */
    @ONodeAttr(name = "discount")
    private Integer discount;
    /**
     *
     */
    @ONodeAttr(name = "discount_end")
    private String discountEnd;
    /**
     *
     */
    @ONodeAttr(name = "no_reward")
    private Boolean noReward;
    /**
     *
     */
    @ONodeAttr(name = "batch_discount_type")
    private Integer batchDiscountType;
    /**
     *
     */
    @ONodeAttr(name = "ep_discount_type")
    private Integer epDiscountType;
    /**
     *
     */
    @ONodeAttr(name = "has_fav_activity")
    private Boolean hasFavActivity;
    /**
     *
     */
    @ONodeAttr(name = "fav_free_amount")
    private Integer favFreeAmount;
    /**
     *
     */
    @ONodeAttr(name = "allow_wait_free")
    private Boolean allowWaitFree;
    /**
     *
     */
    @ONodeAttr(name = "wait_hour")
    private Integer waitHour;
    /**
     *
     */
    @ONodeAttr(name = "wait_free_at")
    private String waitFreeAt;
    /**
     *
     */
    @ONodeAttr(name = "no_danmaku")
    private Integer noDanmaku;
    /**
     *
     */
    @ONodeAttr(name = "auto_pay_status")
    private Integer autoPayStatus;
    /**
     *
     */
    @ONodeAttr(name = "no_month_ticket")
    private Boolean noMonthTicket;
    /**
     *
     */
    @ONodeAttr(name = "immersive")
    private Boolean immersive;
    /**
     *
     */
    @ONodeAttr(name = "no_discount")
    private Boolean noDiscount;
    /**
     *
     */
    @ONodeAttr(name = "show_type")
    private Integer showType;
    /**
     *
     */
    @ONodeAttr(name = "pay_mode")
    private Integer payMode;
    /**
     *
     */
    @ONodeAttr(name = "chapters")
    private List<String> chapters;
    /**
     *
     */
    @ONodeAttr(name = "classic_lines")
    private String classicLines;
    /**
     *
     */
    @ONodeAttr(name = "pay_for_new")
    private Integer payForNew;
    /**
     *
     */
    @ONodeAttr(name = "fav_comic_info")
    private BilibiliMangaFavComicInfo favComicInfo;
    /**
     *
     */
    @ONodeAttr(name = "serial_status")
    private Integer serialStatus;
    /**
     *
     */
    @ONodeAttr(name = "series_info")
    private BilibiliMangaSeriesInfo seriesInfo;
    /**
     *
     */
    @ONodeAttr(name = "album_count")
    private Integer albumCount;
    /**
     *
     */
    @ONodeAttr(name = "wiki_id")
    private Long wikiId;
    /**
     *
     */
    @ONodeAttr(name = "disable_coupon_amount")
    private Integer disableCouponAmount;
    /**
     *
     */
    @ONodeAttr(name = "japan_comic")
    private Boolean japanComic;
    /**
     *
     */
    @ONodeAttr(name = "interact_value")
    private String interactValue;
    /**
     *
     */
    @ONodeAttr(name = "temporary_finish_time")
    private String temporaryFinishTime;
    /**
     *
     */
    @ONodeAttr(name = "video")
    private String video;
    /**
     *
     */
    @ONodeAttr(name = "introduction")
    private String introduction;
    /**
     *
     */
    @ONodeAttr(name = "comment_status")
    private Integer commentStatus;
    /**
     *
     */
    @ONodeAttr(name = "no_screenshot")
    private Boolean noScreenshot;
    /**
     *
     */
    @ONodeAttr(name = "type")
    private Integer type;
    /**
     *
     */
    @ONodeAttr(name = "vomic_cvs")
    private List<String> vomicCvs;
    /**
     *
     */
    @ONodeAttr(name = "no_rank")
    private Boolean noRank;
    /**
     *
     */
    @ONodeAttr(name = "presale_eps")
    private List<String> presaleEps;
    /**
     *
     */
    @ONodeAttr(name = "presale_text")
    private String presaleText;
    /**
     *
     */
    @ONodeAttr(name = "presale_discount")
    private Integer presaleDiscount;
    /**
     *
     */
    @ONodeAttr(name = "no_leaderboard")
    private Boolean noLeaderboard;
}
