package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.util.List;

/**
 * 视频分区类型
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliVideoType {
    /**
     * 分区id
     */
    @ONodeAttr(name = "id")
    private int id;
    /**
     * 父级分区id
     */
    @ONodeAttr(name = "parent")
    private int parentId;
    /**
     * 父级分区名称
     */
    @ONodeAttr(name = "parent_name")
    private String parentName;
    /**
     * 分区名称
     */
    @ONodeAttr(name = "name")
    private String name;
    /**
     *
     */
    @ONodeAttr(name = "description")
    private String description;
    /**
     *
     */
    @ONodeAttr(name = "desc")
    private String desc;
    /**
     *
     */
    @ONodeAttr(name = "intro_original")
    private String introOriginal;
    /**
     *
     */
    @ONodeAttr(name = "intro_copy")
    private String introCopy;
    /**
     *
     */
    @ONodeAttr(name = "notice")
    private String notice;
    /**
     * 稿件类型
     * 1.自制
     * 2.转载
     */
    @ONodeAttr(name = "copy_right")
    private int copyright;
    /**
     *
     */
    @ONodeAttr(name = "show")
    private boolean show;
    /**
     *
     */
    @ONodeAttr(name = "rank")
    private int rank;
    /**
     *
     */
    @ONodeAttr(name = "max_video_count")
    private int maxVideoCount;
    /**
     * 子分区 列表
     */
    @ONodeAttr(name = "children")
    private List<BilibiliVideoType> children;
}
