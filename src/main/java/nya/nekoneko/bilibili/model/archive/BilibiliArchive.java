package nya.nekoneko.bilibili.model.archive;

import lombok.Data;
import org.noear.snack.annotation.ONodeAttr;

import java.time.LocalDateTime;
import java.util.List;

/**
 * https://member.bilibili.com/x/vupre/web/archive/view
 * 稿件
 *
 * @author Ho
 */
@Data
public class BilibiliArchive {
    /**
     * 稿件aid
     */
    @ONodeAttr(name = "aid")
    private Integer aid;
    /**
     * 稿件bvid
     */
    @ONodeAttr(name = "bvid")
    private String bvid;
    /**
     * 稿件标题
     */
    @ONodeAttr(name = "title")
    private String title;
    /**
     * 稿件类型
     * 1.自制
     * 2.转载
     */
    @ONodeAttr(name = "copyright")
    private Integer copyright;
    /**
     * 分p列表
     */
    @ONodeAttr(name = "videos")
    private List<BilibiliArchiveVideo> videos;
    /**
     * 转载来源
     */
    @ONodeAttr(name = "source")
    private String source;
    /**
     * 分区id
     */
    @ONodeAttr(name = "video_type_id")
    private Integer videoTypeId;
    /**
     * 封面
     */
    @ONodeAttr(name = "cover")
    private String cover;
    /**
     * tag
     */
    @ONodeAttr(name = "tag")
    private String tag;
    /**
     *
     */
    @ONodeAttr(name = "description_format_id")
    private int descriptionFormatId;
    /**
     * 简介
     */
    @ONodeAttr(name = "description")
    private String description;
    /**
     * 粉丝动态
     */
    @ONodeAttr(name = "dynamic")
    private String dynamic;
    /**
     *
     */
    @ONodeAttr(name = "reject_reason")
    private String rejectReason;
    /**
     *
     */
    @ONodeAttr(name = "reject_reason_url")
    private String rejectReasonUrl;
    /**
     *
     */
    @ONodeAttr(name = "duration")
    private Integer duration;
    /**
     *
     */
    @ONodeAttr(name = "no_reprint")
    private Integer noReprint;
    /**
     *
     */
    @ONodeAttr(name = "attribute")
    private Integer attribute;
    /**
     * 稿件状态
     */
    @ONodeAttr(name = "state")
    private Integer state;
    /**
     * 稿件状态说明
     * 0: 审核通过
     * -30: 审核中
     * -40: 通过审核，等待发布(定时发布)
     */
    @ONodeAttr(name = "state_description")
    private String stateDescription;
    /**
     *
     */
    @ONodeAttr(name = "pass_time", format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime passTime;
    /**
     *
     */
    @ONodeAttr(name = "submit_time", format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime submitTime;
}