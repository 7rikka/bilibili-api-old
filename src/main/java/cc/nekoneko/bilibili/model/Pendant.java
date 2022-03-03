package cc.nekoneko.bilibili.model;

import lombok.Data;

/**
 * 牌子
 */
@Data
public class Pendant {
    private Integer pid;
    private String name;
    private String image;
    private String expire;
    private String image_enhance;
    private String image_enhance_frame;
}
