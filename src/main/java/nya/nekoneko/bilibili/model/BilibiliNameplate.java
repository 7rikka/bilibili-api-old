package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.time.LocalDateTime;

/**
 * 成就勋章
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliNameplate {
    /**
     * 勋章id
     */
    @ONodeAttr(name = "nid")
    private Integer id;
    /**
     * 勋章名称
     */
    @ONodeAttr(name = "name")
    private String name;
    /**
     * 描述
     */
    @ONodeAttr(name = "description")
    private String description;
    /**
     * 图标
     */
    @ONodeAttr(name = "image")
    private String image;
    /**
     * 小图标
     */
    @ONodeAttr(name = "image_small")
    private String imageSmall;
    /**
     * 勋章等级
     */
    @ONodeAttr(name = "level")
    private Integer level;
    /**
     * 获取条件
     */
    @ONodeAttr(name = "condition")
    private String condition;
    /**
     *
     */
    @ONodeAttr(name = "gid")
    private Integer gid;
    /**
     *
     */
    @ONodeAttr(name = "level_rank")
    private String levelRank;
    /**
     *
     */
    @ONodeAttr(name = "level_desc")
    private String levelDesc;
    /**
     *
     */
    @ONodeAttr(name = "sort")
    private Integer sort;
    /**
     *
     */
    @ONodeAttr(name = "detail_link")
    private String detailLink;
    /**
     * 分类
     */
    private String type;
    //个人勋章状态
    /**
     *
     */
    @ONodeAttr(name = "is_activated")
    private String isActivated;
    /**
     *
     */
    @ONodeAttr(name = "is_new_get")
    private String isNewGet;
    /**
     *
     */
    @ONodeAttr(name = "get_time",format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime getTime;

}
