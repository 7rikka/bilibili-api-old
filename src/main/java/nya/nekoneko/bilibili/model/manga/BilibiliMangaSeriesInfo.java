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
public class BilibiliMangaSeriesInfo {
    /**
     *
     */
    @ONodeAttr(name = "id")
    private Integer id;
    /**
     *
     */
    @ONodeAttr(name = "comics")
    private List<String> comics;
}