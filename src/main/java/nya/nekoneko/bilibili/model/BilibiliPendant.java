package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * 头像框
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliPendant {
    /**
     *
     */
    @ONodeAttr(name = "id")
    private Integer pid;
    /**
     *
     */
    @ONodeAttr(name = "name")
    private String name;
    /**
     *
     */
    @ONodeAttr(name = "image")
    private String image;
    /**
     *
     */
    @ONodeAttr(name = "expire")
    private String expire;
    /**
     *
     */
    @ONodeAttr(name = "image_enhance")
    private String imageEnhance;
    /**
     *
     */
    @ONodeAttr(name = "image_enhance_frame")
    private String imageEnhanceFrame;
}
