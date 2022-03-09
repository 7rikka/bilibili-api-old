package nya.nekoneko.bilibili.model;

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
    /**
     * 图片大小
     */
    private long size;
    /**
     * 图片文件名
     */
    private String filename;
}
