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
public class BilibiliProfession {
    /**
     *
     */
    @ONodeAttr(name = "name")
    private String name;
    /**
     *
     */
    @ONodeAttr(name = "department")
    private String department;
    /**
     *
     */
    @ONodeAttr(name = "title")
    private String title;
    /**
     *
     */
    @ONodeAttr(name = "is_show")
    private Integer isShow;
}
