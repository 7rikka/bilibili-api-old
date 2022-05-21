package nya.nekoneko.bilibili.model.manga;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliMangaImage {
    /**
     *
     */
    @ONodeAttr(name = "path")
    private String path;
    /**
     *
     */
    @ONodeAttr(name = "x")
    private int x;
    /**
     *
     */
    @ONodeAttr(name = "y")
    private int y;
    /**
     *
     */
    @ONodeAttr(name = "video_path")
    private String videoPath;
    /**
     *
     */
    @ONodeAttr(name = "video_size")
    private String videoSize;
}
