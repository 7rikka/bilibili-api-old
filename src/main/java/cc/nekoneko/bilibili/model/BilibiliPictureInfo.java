package cc.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliPictureInfo {
    /**
     * 图片高度
     */
    @ONodeAttr(name = "image_height")
    private int height;
    /**
     * 图片宽度
     */
    @ONodeAttr(name = "image_width")
    private int width;
    /**
     * 图片地址
     */
    @ONodeAttr(name = "image_url")
    private String url;
    /**
     * 图片后缀名
     */
    private String suffix;
}
