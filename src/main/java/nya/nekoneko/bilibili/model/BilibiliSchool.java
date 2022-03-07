package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * 院校信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliSchool {
    @ONodeAttr(name = "name")
    private String name;
}
