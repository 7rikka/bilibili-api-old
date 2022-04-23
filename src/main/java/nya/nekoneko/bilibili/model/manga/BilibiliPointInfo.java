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
public class BilibiliPointInfo {
    /**
     *
     */
    @ONodeAttr(name = "point")
    private Integer point;
    /**
     *
     */
    @ONodeAttr(name = "origin_point")
    private Integer originPoint;
    /**
     *
     */
    @ONodeAttr(name = "is_activity")
    private Boolean isActivity;
    /**
     *
     */
    @ONodeAttr(name = "title")
    private String title;
}