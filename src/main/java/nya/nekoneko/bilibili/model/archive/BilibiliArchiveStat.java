package nya.nekoneko.bilibili.model.archive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliArchiveStat {
    /**
     *
     */
    @ONodeAttr(name = "aid")
    private Integer aid;
    /**
     *
     */
    @ONodeAttr(name = "bvid")
    private String bvid;
    /**
     *
     */
    @ONodeAttr(name = "view")
    private Integer view;
    /**
     *
     */
    @ONodeAttr(name = "danmaku")
    private Integer danmaku;
    /**
     *
     */
    @ONodeAttr(name = "reply")
    private Integer reply;
    /**
     *
     */
    @ONodeAttr(name = "favorite")
    private Integer favorite;
    /**
     *
     */
    @ONodeAttr(name = "coin")
    private Integer coin;
    /**
     *
     */
    @ONodeAttr(name = "share")
    private Integer share;
    /**
     *
     */
    @ONodeAttr(name = "now_rank")
    private Integer nowRank;
    /**
     *
     */
    @ONodeAttr(name = "his_rank")
    private Integer hisRank;
    /**
     *
     */
    @ONodeAttr(name = "like")
    private Integer like;
    /**
     *
     */
    @ONodeAttr(name = "dislike")
    private Integer dislike;
}
