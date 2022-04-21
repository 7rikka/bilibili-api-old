package nya.nekoneko.bilibili.model;

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
public class BilibiliUserLevelInfo {
    @ONodeAttr(name = "uid")
    private Integer uid;
    @ONodeAttr(name = "current_level")
    private Integer currentLevel;
    @ONodeAttr(name = "current_min")
    private Integer currentMin;
    @ONodeAttr(name = "current_exp")
    private Integer currentExp;
    @ONodeAttr(name = "next_exp")
    private Integer nextExp;
}
