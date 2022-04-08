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
public class BilibiliLevelInfo {
    @ONodeAttr(name = "current_level")
    private Integer currentLevel;
    @ONodeAttr(name = "current_min")
    private Integer currentMin;
    @ONodeAttr(name = "current_exp")
    private Integer currentExp;
    @ONodeAttr(name = "next_exp")
    private Integer nextExp;
}
