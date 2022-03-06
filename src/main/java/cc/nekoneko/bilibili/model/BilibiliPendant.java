package cc.nekoneko.bilibili.model;

import lombok.Builder;
import lombok.Data;

/**
 * 牌子
 */
@Data
@Builder
public class BilibiliPendant {
    private Integer pid;
    private String name;
    private String image;
    private String expire;
    private String image_enhance;
    private String image_enhance_frame;
}
