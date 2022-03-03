package cc.nekoneko.bilibili.model;

public class BilibiliUser {
    /**
     * 数字uid
     */
    private Integer uid;
    /**
     * 用户名
     */
    private String uname;
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
     * 认证信息
     */
    private UserOfficialVerify verify;
    /**
     * 牌子
     */
    private Pendant pendant;
    /**
     * 大会员信息
     */
    private VipInfo vipInfo;
}
