package nya.nekoneko.bilibili.model.manga;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.util.List;

/**
 * 漫画签到信息
 *
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Deprecated
public class BilibiliMangaClockInInfo {
    /**
     * 连续签到天数
     */
    @ONodeAttr(name = "day_count")
    private int dayCount;
    /**
     * 今日签到状态
     * 0: 未签到
     * 1: 已签到
     */
    @ONodeAttr(name = "status")
    private int status;
    /**
     * 一个签到周期内每天获取点数的数量
     */
    @ONodeAttr(name = "points")
    private List<Integer> points;
    /**
     *
     */
    @ONodeAttr(name = "credit_icon")
    private String creditIcon;
    /**
     *
     */
    @ONodeAttr(name = "sign_before_icon")
    private String signBeforeIcon;
    /**
     *
     */
    @ONodeAttr(name = "sign_today_icon")
    private String signTodayIcon;
    /**
     *
     */
    @ONodeAttr(name = "breathe_icon")
    private String breatheIcon;
    /**
     * 每日奖品详细说明
     */
    @ONodeAttr(name = "point_infos")
    private List<BilibiliPointInfo> pointInfos;
    /**
     *
     */
    @ONodeAttr(name = "new_credit_x_icon")
    private String newCreditxIcon;
    /**
     *
     */
    @ONodeAttr(name = "coupon_pic")
    private String couponPic;
}