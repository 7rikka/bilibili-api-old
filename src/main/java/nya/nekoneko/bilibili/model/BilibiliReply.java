package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.time.LocalDateTime;

/**
 * 评论
 *
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliReply {
    /**
     *
     */
    @ONodeAttr(name = "id")
    private Long id;
    /**
     *
     */
    @ONodeAttr(name = "floor")
    private Integer floor;
    /**
     *
     */
    @ONodeAttr(name = "message")
    private String content;
    /**
     * 这条评论下面的回复数
     */
    @ONodeAttr(name = "count")
    private String count;
    /**
     * 若为一级评论则为 0
     * 大于一级评论则为根评论 id
     */
    @ONodeAttr(name = "root")
    private Long root;
    /**
     * 关联稿件aid
     */
    @ONodeAttr(name = "oid")
    private Integer aid;
    /**
     *
     */
    @ONodeAttr(name = "bvid")
    private String bvid;
    /**
     *
     */
    @ONodeAttr(name = "ctime")
    private LocalDateTime ctime;
    /**
     *
     */
    @ONodeAttr(name = "mtime")
    private LocalDateTime mtime;
    /**
     *
     */
    @ONodeAttr(name = "state")
    private Integer state;
    /**
     * 若为一级评论则为 0
     * 若为二级评论则为根评论 rpid
     * 大于二级评论为上一级评 论 rpid
     */
    @ONodeAttr(name = "parent")
    private Long parent;
    /**
     *
     */
    @ONodeAttr(name = "mid")
    private Integer uid;
    /**
     * 评论获赞数
     */
    @ONodeAttr(name = "like")
    private Integer like;
    /**
     *
     */
    @ONodeAttr(name = "relation")
    private Integer relation;
    /**
     *
     */
    @ONodeAttr(name = "is_elec")
    private Integer isElec;
    /**
     *
     */
    @ONodeAttr(name = "type")
    private Integer type;
    /**
     *
     */
    @ONodeAttr(name = "root_info")
    private String rootInfo;
    /**
     *
     */
    @ONodeAttr(name = "parent_info")
    private String parentInfo;
    /**
     *
     */
    @ONodeAttr(name = "attr")
    private Integer attr;
    /**
     *
     */
    @ONodeAttr(name = "vote")
    private String vote;
    /**
     * 当前用户操作状态
     * 需要登录(Cookie 或 APP)
     * 否则恒为 0
     * 0：无
     * 1：已点赞
     * 2：已点踩
     */
    @ONodeAttr(name = "action")
    private Integer action;
    /**
     * 若为一级评论则为 0
     * 若为二级评论则为该评论 rpid
     * 大于二级评论为上一级评论 rpid
     */
    @ONodeAttr(name = "dialog")
    private Integer dialog;
    /**
     * 是否具有粉丝标签
     * 0：无
     * 1：有
     */
    @ONodeAttr(name = "fansgrade")
    private Integer fansgrade;
    /**
     *
     */
    @ONodeAttr(name = "user")
    private BilibiliUser user;
//    private String title;
//    private String replier;
//    private String uface;
//    private String cover;


}
