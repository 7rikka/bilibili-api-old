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
public class BilibiliUserSailing {
    @ONodeAttr(name = "pendant")
    private String pendant;
    @ONodeAttr(name = "cardbg")
    private String cardbg;
    @ONodeAttr(name = "cardbg_with_focus")
    private String cardbgWithFocus;
}
