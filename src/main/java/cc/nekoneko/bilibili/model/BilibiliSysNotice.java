package cc.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * example:
 * {
 * "id": 11,
 * "content": "该账号涉及合约争议，暂冻结其账号功能使用。详见公告->",
 * "url": "https://t.bilibili.com/400708281078241381",
 * "notice_type": 1,
 * "icon": "https://i0.hdslb.com/bfs/space/7a89f7ed04b98458b23863846bd2539a90ff1153.png",
 * "text_color": "#FFB112",
 * "bg_color": "#FFF3DB"
 * }
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliSysNotice {
    /**
     *
     */
    @ONodeAttr(name = "id")
    private Integer id;
    /**
     *
     */
    @ONodeAttr(name = "content")
    private String content;
    /**
     * 跳转URL
     */
    @ONodeAttr(name = "url")
    private String url;
    /**
     *
     */
    @ONodeAttr(name = "notice_type")
    private Integer noticeType;
    /**
     *
     */
    @ONodeAttr(name = "icon")
    private String icon;
    /**
     *
     */
    @ONodeAttr(name = "text_color")
    private String textColor;
    /**
     *
     */
    @ONodeAttr(name = "bg_color")
    private String bgColor;
}
