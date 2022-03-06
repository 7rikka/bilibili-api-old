package cc.nekoneko.bilibili.model;

import lombok.Builder;
import lombok.Data;

/**
 * 成就勋章
 */
@Data
@Builder
public class BilibiliNameplate {
    private Integer nid;
    private String name;
    private String image;
    private String image_small;
    private String level;
    private String condition;

}
