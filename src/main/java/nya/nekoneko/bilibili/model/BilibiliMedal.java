package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * 粉丝勋章
 *
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliMedal {
    /**
     * 此用户uid
     */
    @ONodeAttr(name = "uid")
    private Integer uid;
    /**
     * 粉丝勋章所属UP的uid
     */
    @ONodeAttr(name = "target_id")
    private Integer targetId;
    /**
     * 粉丝勋章id
     */
    @ONodeAttr(name = "medal_id")
    private Integer medalId;
    /**
     * 粉丝勋章等级
     */
    @ONodeAttr(name = "level")
    private Integer level;
    /**
     * 粉丝勋章名称
     */
    @ONodeAttr(name = "medal_name")
    private String medalName;
    /**
     * 颜色
     */
    @ONodeAttr(name = "medal_color")
    private Integer medalColor;
    /**
     * 当前亲密度
     */
    @ONodeAttr(name = "intimacy")
    private Integer intimacy;
    /**
     * 下一等级所需亲密度
     */
    @ONodeAttr(name = "next_intimacy")
    private Integer nextIntimacy;
    /**
     * 每日亲密度获取上限
     */
    @ONodeAttr(name = "day_limit")
    private Integer dayLimit;
    /**
     * 今日已获得亲密度
     */
    @ONodeAttr(name = "today_feed")
    private Integer todayFeed;
    /**
     *
     */
    @ONodeAttr(name = "medal_color_start")
    private Integer medalColorStart;
    /**
     *
     */
    @ONodeAttr(name = "medal_color_end")
    private Integer medalColorEnd;
    /**
     *
     */
    @ONodeAttr(name = "medal_color_border")
    private Integer medalColorBorder;
    /**
     *
     */
    @ONodeAttr(name = "is_lighted")
    private Boolean isLighted;
    /**
     *
     */
    @ONodeAttr(name = "light_status")
    private Boolean lightStatus;
    /**
     * 当前是否佩戴
     * 0: 未佩戴
     * 1: 已佩戴
     */
    @ONodeAttr(name = "wearing_status")
    private Boolean wearingStatus;
    /**
     *
     */
    @ONodeAttr(name = "score")
    private Integer score;

}
