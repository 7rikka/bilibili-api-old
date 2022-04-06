package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * 系统通知
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliNotify {
    private long id;
    private long cursor;
    private int type;
    private String title;
    private String content;
    private Date time_at;
    private String publisher;
    private String source;
    private int card_type;
    private String card_brief;
    private String card_msg_brief;
    private String card_cover;
    private String card_story_title;
    private String card_link;
    private String mc;
    private int is_station;
    private int is_send;
    private int notify_cursor;
}