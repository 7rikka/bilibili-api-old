package cc.nekoneko.bilibili.model;

import lombok.Data;

/**
 * 大会员信息
 */
@Data
public class VipInfo {
    /**
     * 大会员类型
     * 2.年度大会员
     */
    private Integer vipType;
    /**
     * 年度大会员过期时间
     */
    private String vipDueDate;
    private Integer vipStatus;
    private Integer themeType;
    private Integer avatar_subscript;
    private String nickname_color;
    private Integer role;
    private Label label;
    /**
     * 大会员图标角标地址
     */
    private String avatar_subscript_url;
    @Data
    public static class Label{
        private String path;
        private String text;
        private String label_theme;
        private String text_color;
        private String bg_style;
        private String bg_color;
        private String border_color;
    }
}
