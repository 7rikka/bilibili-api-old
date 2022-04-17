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
     *
     */
    @ONodeAttr(name = "title")
    private String title;
    /**
     *
     */
    @ONodeAttr(name = "desc")
    private String desc;
    /**
     *
     */
    @ONodeAttr(name = "filename")
    private String filename;
    /**
     * 上传时的biz_id
     */
    @ONodeAttr(name = "cid")
    private Long cid;
    /**
     *
     */
    @ONodeAttr(name = "duration")
    private Integer duration;
    /**
     *
     */
    @ONodeAttr(name = "index")
    private Integer index;
    /**
     *
     */
    @ONodeAttr(name = "status")
    private Integer status;
    /**
     *
     */
    @ONodeAttr(name = "status_desc")
    private String statusDesc;
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
    @ONodeAttr(name = "xcode_state")
    private Integer xcodeState;
    /**
     *
     */
    @ONodeAttr(name = "ctime")
    private LocalDateTime ctime;
//    private BilibiliArchiveEditor editor;
    /**
     * 是否包含动态卡片（投稿时用）
     */
//    private Boolean pre_command;
}