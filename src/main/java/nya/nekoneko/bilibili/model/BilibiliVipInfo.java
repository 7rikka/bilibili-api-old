package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.time.LocalDate;

/**
 * 大会员信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliVipInfo {
    /**
     * 大会员类型
     * 1.月度大会员
     * 2.年度大会员
     */
    @ONodeAttr(name = "type")
    private Integer type;
    /**
     * 大会员状态
     * 0: 不是大会员
     * 1: 是大会员
     */
    @ONodeAttr(name = "status")
    private Integer status;
    /**
     * 年度大会员过期时间
     */
    @ONodeAttr(name = "due_date",format = "yyyy-MM-dd")
    private LocalDate dueDate;
    /**
     *
     */
    @ONodeAttr(name = "vip_pay_type")
    private String vipPayType;
    /**
     *
     */
    @ONodeAttr(name = "theme_type")
    private Integer themeType;
    /**
     *
     */
    @ONodeAttr(name = "avatar_subscript")
    private Integer avatarSubscript;
    /**
     *
     */
    @ONodeAttr(name = "nickname_color")
    private String nicknameColor;
    /**
     *
     */
    @ONodeAttr(name = "role")
    private Integer role;
    /**
     *
     */
    @ONodeAttr(name = "status_warn")
    private String statusWarn;
    /**
     * 大会员图标角标地址
     */
    @ONodeAttr(name = "avatarSubscript_url")
    private String avatarSubscriptUrl;
    /**
     *
     */
    @ONodeAttr(name = "label")
    private Label label;
    @ONodeAttr(name = "due_remark")
    private String dueRemark;
    @ONodeAttr(name = "due_remark")
    private Integer accessStatus;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Label {
        @ONodeAttr(name = "path")
        private String path;
        @ONodeAttr(name = "text")
        private String text;
        @ONodeAttr(name = "label_theme")
        private String labelTheme;
        @ONodeAttr(name = "text_color")
        private String textColor;
        @ONodeAttr(name = "bg_style")
        private String bgStyle;
        @ONodeAttr(name = "bg_color")
        private String bgColor;
        @ONodeAttr(name = "border_color")
        private String borderColor;
    }
}
