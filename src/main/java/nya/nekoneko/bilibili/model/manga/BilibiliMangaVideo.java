package nya.nekoneko.bilibili.model.manga;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.util.List;

/**
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliMangaVideo {
    /**
     *
     */
    @ONodeAttr(name = "svid")
    private String svid;
    /**
     *
     */
    @ONodeAttr(name = "filename")
    private String filename;
    /**
     *
     */
    @ONodeAttr(name = "route")
    private String route;
    /**
     *
     */
    @ONodeAttr(name = "resource")
    private List<String> resource;
    /**
     *
     */
    @ONodeAttr(name = "raw_width")
    private String rawWidth;
    /**
     *
     */
    @ONodeAttr(name = "raw_height")
    private String rawHeight;
    /**
     *
     */
    @ONodeAttr(name = "raw_rotate")
    private String rawRotate;
    /**
     *
     */
    @ONodeAttr(name = "img_urls")
    private List<String> imgUrls;
    /**
     *
     */
    @ONodeAttr(name = "bin_url")
    private String binUrl;
    /**
     *
     */
    @ONodeAttr(name = "img_x_len")
    private int imgXLen;
    /**
     *
     */
    @ONodeAttr(name = "img_x_size")
    private int imgXSize;
    /**
     *
     */
    @ONodeAttr(name = "img_y_len")
    private int imgYLen;
    /**
     *
     */
    @ONodeAttr(name = "img_y_size")
    private int imgYSize;
}