package nya.nekoneko.bilibili.model.archive;

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
public class BilibiliArchiveVideo {
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
     * 分p标题
     */
    @ONodeAttr(name = "title")
    private String title;
    /**
     * 分p简介
     */
    @ONodeAttr(name = "description")
    private String description;
    /**
     *
     */
    @ONodeAttr(name = "filename")
    private String filename;
    /**
     * (上传时的biz_id)
     */
    @ONodeAttr(name = "cid")
    private Long cid;
    /**
     * 分p时长
     */
    @ONodeAttr(name = "duration")
    private Integer duration;
    /**
     * 排序序号
     */
    @ONodeAttr(name = "index")
    private Integer index;
    /**
     * 分p状态
     * -30:
     */
    @ONodeAttr(name = "status")
    private Integer status;
    /**
     *
     */
    @ONodeAttr(name = "status_description")
    private String statusDescription;
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
    @ONodeAttr(name = "fail_code")
    private Integer failCode;
    /**
     *
     */
    @ONodeAttr(name = "fail_description")
    private String failDescription;
    /**
     *
     */
    @ONodeAttr(name = "xcode_state")
    private Integer xcodeState;
    /**
     *
     */
    @ONodeAttr(name = "submit_time", format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime submitTime;
}