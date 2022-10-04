package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.util.List;

/**
 * https://api.bilibili.com/x/space/acc/info?mid=xxx
 *
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliUser {
    /**
     * 数字uid
     */
    @ONodeAttr(name = "id")
    private Long id;
    /**
     * hash
     */
    private String hash;
    /**
     * 用户名
     */
    @ONodeAttr(name = "name")
    private String name;
    /**
     * 性别
     */
    @ONodeAttr(name = "sex")
    private String sex;

    /**
     * 头像
     */
    @ONodeAttr(name = "avatar")
    private String avatar;
    /**
     * 是否为 nft 头像
     * 0.不是nft头像
     * 1.是 nft 头像
     */
    @ONodeAttr(name = "face_nft")
    private Integer faceNft;
    /**
     *
     */
    @ONodeAttr(name = "face_nft_type")
    private Integer faceNftType;
    /**
     * 签名
     */
    @ONodeAttr(name = "sign")
    private String sign;
    /**
     * 账号权限
     */
    @ONodeAttr(name = "rank")
    private Integer rank;
//    /**
//     * 账号权限
//     */
//    @ONodeAttr(name = "display_rank")
//    private Integer displayRank;
    /**
     * 当前等级
     */
    @ONodeAttr(name = "level")
    private Integer level;
    /**
     *
     */
    @ONodeAttr(name = "jointime")
    private Integer jointime;
    /**
     * 节操值 弃用
     */
    @ONodeAttr(name = "moral")
    private Integer moral;
    /**
     * 封禁状态
     * 0：正常
     * 1：被封
     */
    @ONodeAttr(name = "silence")
    private Integer silence;
    /**
     *
     */
    @ONodeAttr(name = "coins")
    private Double coins;
    /**
     * 是否开通粉丝牌
     */
    @ONodeAttr(name = "fans_badge")
    private Boolean fansBadge;
    /**
     *
     */
    @ONodeAttr(name = "fans_medal")
    private BilibiliFansMedal fansMedal;
    /**
     * 认证信息
     */
    @ONodeAttr(name = "official_verify")
    private BilibiliOfficialVerify officialVerify;
    /**
     * 大会员信息
     */
    @ONodeAttr(name = "vip_info")
    private BilibiliVipInfo vipInfo;
    /**
     * 头像框
     */
    @ONodeAttr(name = "pendant")
    private BilibiliPendant pendant;
    /**
     * 成就勋章
     */
    @ONodeAttr(name = "nameplate")
    private BilibiliNameplate nameplate;
    /**
     * 强转
     */
    @ONodeAttr(name = "honour_info")
    private BilibiliUserHonourInfo honourInfo;
    /**
     * 空间头图
     */
    @ONodeAttr(name = "top_photo")
    private String topPhoto;
    /**
     *
     */
    @ONodeAttr(name = "theme")
    private String theme;
    /**
     *
     */
    @ONodeAttr(name = "sys_notice")
    private BilibiliSysNotice sysNotice;
    /**
     * 直播间信息
     */
    @ONodeAttr(name = "live_room")
    private BilibiliLiveRoom liveRoom;
    /**
     *
     */
    @ONodeAttr(name = "birthday")
    private String birthday;
    /**
     *
     */
    @ONodeAttr(name = "school_name")
    private String schoolName;
    /**
     *
     */
    @ONodeAttr(name = "profession")
    private BilibiliProfession profession;
    /**
     * 个人tag
     */
    @ONodeAttr(name = "tags")
    private List<String> tags;
    /**
     *
     */
    @ONodeAttr(name = "series")
    private BilibiliUserSeries series;
    /**
     * 是否为硬核会员
     * 0: 否
     * 1: 是
     */
    @ONodeAttr(name = "is_senior_member")
    private Integer isSeniorMember;
    /**
     * 是否给我充过电
     * 0:
     * 1: 充过
     */
    @ONodeAttr(name = "is_elec")
    private Integer isElec;
//    /**
//     *
//     */
//    @ONodeAttr(name = "fans_detail")
//    private String fans_detail;
//    /**
//     *
//     */
//    @ONodeAttr(name = "following")
//    private String following;
//    /**
//     *
//     */
//    @ONodeAttr(name = "user_sailing")
//    private BilibiliUserSailing userSailing;
//    /**
//     *
//     */
//    @ONodeAttr(name = "is_contractor")
//    private Integer is_contractor;
//    /**
//     *
//     */
//    @ONodeAttr(name = "contract_desc")
//    private String contractDesc;

    /**
     * 我是否关注这个用户
     */
    @ONodeAttr(name = "is_followed")
    private Boolean isFollowed;
    //=============================================================
    @ONodeAttr(name = "mcnInfo")
    private String mcn_info;
    @ONodeAttr(name = "gaiaResType")
    private Integer gaia_res_type;
    @ONodeAttr(name = "gaiaData")
    private String gaia_data;
    @ONodeAttr(name = "isRisk")
    private Boolean is_risk;
    @ONodeAttr(name = "elec")
    private String elec;
}
