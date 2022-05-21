package nya.nekoneko.bilibili.model.manga;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 漫画签到信息
 *
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliMangaImageData {
    /**
     *
     */
    @ONodeAttr(name = "path")
    private String path;
    /**
     *
     */
    @ONodeAttr(name = "images")
    private List<BilibiliMangaImage> images;
    /**
     *
     */
    @ONodeAttr(name = "last_modified")
    private LocalDateTime lastModified;
    /**
     *
     */
    @ONodeAttr(name = "host")
    private String host;
    /**
     *
     */
    private BilibiliMangaVideo video;
}
