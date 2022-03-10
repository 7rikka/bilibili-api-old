package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.time.LocalDateTime;

/**
 * 活动信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliActivity {
    /**
     * 活动id
     */
    @ONodeAttr(name = "id")
    private int id;
    /**
     * 活动名称
     */
    @ONodeAttr(name = "name")
    private String name;
    /**
     *
     */
    @ONodeAttr(name = "tags")
    private String tags;
    /**
     *
     */
    @ONodeAttr(name = "hot")
    private int hot;
    /**
     * 活动地址
     */
    @ONodeAttr(name = "act_url")
    private String url;
    /**
     *
     */
    @ONodeAttr(name = "protocol")
    private String protocol;
    /**
     * 13
     */
    @ONodeAttr(name = "type")
    private int type;
    /**
     *
     */
    @ONodeAttr(name = "new")
    private int isnew;
    /**
     *
     */
    @ONodeAttr(name = "comment")
    private String comment;
    /**
     * 开始时间
     */
    @ONodeAttr(name = "stime")
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    @ONodeAttr(name = "etime")
    private LocalDateTime endTime;
    /**
     *
     */
    @ONodeAttr(name = "rank")
    private String rank;
    /**
     *
     */
    @ONodeAttr(name = "h5_cover")
    private String h5Cover;
    /**
     *
     */
    @ONodeAttr(name = "cover")
    private String cover;
    /**
     *
     */
    @ONodeAttr(name = "oids")
    private String oids;
    /**
     *
     */
    @ONodeAttr(name = "bvids")
    private String bvids;
    /**
     *
     */
    @ONodeAttr(name = "author")
    private String author;
    /**
     *
     */
    @ONodeAttr(name = "child_sids")
    private String childSids;
    /**
     *
     */
    @ONodeAttr(name = "hot_value")
    private int hotValue;
    /**
     *
     */
    @ONodeAttr(name = "dic")
    private String dic;
    /**
     * 20
     */
    @ONodeAttr(name = "types")
    private String types;
    /**
     *
     */
    @ONodeAttr(name = "bgm_id")
    private int bgmId;
    /**
     *
     */
    @ONodeAttr(name = "poster_id")
    private int posterId;
    /**
     *
     */
    @ONodeAttr(name = "priority_region")
    private String priorityRegion;
    /**
     * 0
     */
    @ONodeAttr(name = "region_weight")
    private int regionWeight;
    /**
     * 15
     */
    @ONodeAttr(name = "global_weight")
    private int globalWeight;
    /**
     * 127
     */
    @ONodeAttr(name = "tag_show_platform")
    private int tagShowPlatform;

}
