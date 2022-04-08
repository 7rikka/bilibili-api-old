package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.util.Date;

/**
 * 系统通知
 *
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliNotify {
    /**
     *
     */
    @ONodeAttr(name = "id")
    private Long id;
    /**
     *
     */
    @ONodeAttr(name = "cursor")
    private Long cursor;
    /**
     *
     */
    @ONodeAttr(name = "type")
    private Integer type;
    /**
     *
     */
    @ONodeAttr(name = "title")
    private String title;
    /**
     *
     */
    @ONodeAttr(name = "content")
    private String content;
    /**
     *
     */
    @ONodeAttr(name = "time_at")
    private Date timeAt;
    /**
     *
     */
    @ONodeAttr(name = "publisher")
    private String publisher;
    /**
     *
     */
    @ONodeAttr(name = "source")
    private String source;
    /**
     *
     */
    @ONodeAttr(name = "card_type")
    private Integer cardType;
    /**
     *
     */
    @ONodeAttr(name = "card_brief")
    private String cardBrief;
    /**
     *
     */
    @ONodeAttr(name = "card_msg_brief")
    private String cardMsgBrief;
    /**
     *
     */
    @ONodeAttr(name = "card_cover")
    private String cardCover;
    /**
     *
     */
    @ONodeAttr(name = "card_story_title")
    private String cardStoryTitle;
    /**
     *
     */
    @ONodeAttr(name = "card_link")
    private String cardLink;
    /**
     *
     */
    @ONodeAttr(name = "mc")
    private String mc;
    /**
     *
     */
    @ONodeAttr(name = "is_station")
    private Integer isStation;
    /**
     *
     */
    @ONodeAttr(name = "is_send")
    private Integer isSend;
    /**
     *
     */
    @ONodeAttr(name = "notify_cursor")
    private Integer notifyCursor;
}