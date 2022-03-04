package cc.nekoneko.bilibili.model;

import lombok.Builder;
import lombok.Data;

/**
 * https://api.bilibili.com/x/space/acc/info?mid=2062760
 */
@Data
@Builder
public class BilibiliUser {
    /**
     * 数字uid
     */
    private Integer uid;
    /**
     * 用户名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 签名
     */
    private String sign;
    /**
     * 头像
     */
    private String face;
    /**
     *
     */
    private Integer face_nft;
    /**
     * 账号权限
     */
    private Integer rank;
    /**
     * 当前等级
     */
    private Integer level;
    /**
     *
     */
    private String jointime;
    /**
     *
     */
    private String moral;
    /**
     *
     */
    private String silence;
    /**
     *
     */
    private String coins;
    /**
     *
     */
    private String fans_badge;
    private BilibiliFansMedal fans_medal;
    private Boolean is_followed;
    private String top_photo;
    private String birthday;
    private String tags;
    private Integer is_senior_member;
    /**
     * 认证信息
     */
    private UserOfficialVerify official;
    /**
     * 牌子
     */
    private BilibiliPendant pendant;
    /**
     * 大会员信息
     */
    private VipInfo vip;
    private BilibiliSchool school;
    private BilibiliLiveRoom live_room;
    /**
     * 强转
     */
    private String user_honour_info;
    private String theme;
    private String sys_notice;
    private String profession;
    private String series;

}
