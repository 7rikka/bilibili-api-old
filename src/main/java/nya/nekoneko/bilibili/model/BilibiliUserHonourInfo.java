package nya.nekoneko.bilibili.model;

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
public class BilibiliUserHonourInfo {
    /**
     *
     */
    @ONodeAttr(name = "mid")
    private Integer mid;
    /**
     *
     */
    @ONodeAttr(name = "colour")
    private String colour;
    /**
     *
     */
    @ONodeAttr(name = "tags")
    private List<String> tags;

}
