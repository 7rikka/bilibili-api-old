package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.time.LocalDateTime;

/**
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliDanmaku {
    /**
     * 弹幕id
     */
    @ONodeAttr(name = "id")
    private Long id;
    /**
     * 弹幕类型
     * 1.普通
     */
    @ONodeAttr(name = "type")
    private Integer type;
    /**
     * 稿件aid
     */
    @ONodeAttr(name = "aid")
    private Long aid;
    /**
     * 稿件bvid
     */
    @ONodeAttr(name = "bvid")
    private String bvid;
    /**
     * 关联视频cid
     */
    @ONodeAttr(name = "cid")
    private Integer cid;
    /**
     * 发送者uid
     */
    @ONodeAttr(name = "uid")
    private Integer uid;
    /**
     *
     */
    @ONodeAttr(name = "pool")
    private Integer pool;
    /**
     *
     */
    @ONodeAttr(name = "action")
    private String action;
    /**
     *
     */
    @ONodeAttr(name = "attrs")
    private String attrs;
    /**
     * 弹幕所在位置（毫秒值）
     */
    @ONodeAttr(name = "progress")
    private Integer progress;
    /**
     *
     */
    @ONodeAttr(name = "mode")
    private Integer mode;
    /**
     *
     */
    @ONodeAttr(name = "weight")
    private Integer weight;
    /**
     *
     */
    @ONodeAttr(name = "content")
    private String content;
    /**
     *
     */
    @ONodeAttr(name = "state")
    private Integer state;
    /**
     * 字号大小
     */
    @ONodeAttr(name = "fontsize")
    private Integer fontsize;
    /**
     * 弹幕颜色（十六进制RGB值 #FFFFFF）
     */
    @ONodeAttr(name = "color")
    private String color;
    /**
     * 发送时间
     */
    @ONodeAttr(name = "ctime", format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ctime;
    /**
     *
     */
    @ONodeAttr(name = "self_seen")
    private Boolean selfSeen;
    /**
     * 当前弹幕已获得的点赞数
     */
    @ONodeAttr(name = "like_count")
    private Integer likeCount;
    /**
     * 当前用户是否点赞当前弹幕
     */
    @ONodeAttr(name = "user_like")
    private Integer userLike;
    /**
     * 用户信息
     */
    @ONodeAttr(name = "user")
    private BilibiliUser user;

}
