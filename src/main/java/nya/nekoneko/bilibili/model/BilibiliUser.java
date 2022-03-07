package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.util.List;

/**
 * https://api.bilibili.com/x/space/acc/info?mid=2062760
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliUser {
    /**
     * 数字uid
     */
    @ONodeAttr(name = "mid")
    private Integer uid;
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
     * 签名
     */
    @ONodeAttr(name = "sign")
    private String sign;
    /**
     * 头像
     */
    @ONodeAttr(name = "face")
    private String face;
    /**
     *
     */
    @ONodeAttr(name = "face_nft")
    private Integer face_nft;
    /**
     * 账号权限
     */
    @ONodeAttr(name = "rank")
    private Integer rank;
    /**
     * 当前等级
     */
    @ONodeAttr(name = "level")
    private Integer level;
    /**
     *
     */
    @ONodeAttr(name = "jointime")
    private String jointime;
    /**
     *
     */
    @ONodeAttr(name = "moral")
    private String moral;
    /**
     *
     */
    @ONodeAttr(name = "silence")
    private String silence;
    /**
     *
     */
    @ONodeAttr(name = "coins")
    private Double coins;
    /**
     *
     */
    @ONodeAttr(name = "fans_badge")
    private Boolean fansBadge;
    /**
     *
     */
    @ONodeAttr(name = "fans_medal")
    private BilibiliFansMedal fansMedal;
    /**
     *
     */
    @ONodeAttr(name = "is_followed")
    private Boolean isFollowed;
    /**
     * 空间头图
     */
    @ONodeAttr(name = "top_photo")
    private String topPhoto;
    /**
     *
     */
    @ONodeAttr(name = "birthday")
    private String birthday;
    /**
     *
     */
    @ONodeAttr(name = "is_senior_member")
    private Integer isSeniorMember;
    /**
     * 个人tag
     */
    @ONodeAttr(name = "tags")
    private List<String> tags;
    /**
     * 认证信息
     */
    @ONodeAttr(name = "official")
    private BilibiliOfficialVerify official;
    /**
     * 头像框
     */
    @ONodeAttr(name = "pendant")
    private BilibiliPendant pendant;
    /**
     * 大会员信息
     */
    @ONodeAttr(name = "vip")
    private BilibiliVipInfo vip;
    /**
     *
     */
    @ONodeAttr(name = "school")
    private BilibiliSchool school;
    /**
     *
     */
    @ONodeAttr(name = "live_room")
    private BilibiliLiveRoom liveRoom;
    /**
     *
     */
    @ONodeAttr(name = "nameplate")
    private BilibiliNameplate nameplate;
    /**
     * 强转
     */
    @ONodeAttr(name = "user_honour_info")
    private String userHonourInfo;
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
     *
     */
    @ONodeAttr(name = "profession")
    private String profession;
    /**
     *
     */
    @ONodeAttr(name = "series")
    private String series;
}
