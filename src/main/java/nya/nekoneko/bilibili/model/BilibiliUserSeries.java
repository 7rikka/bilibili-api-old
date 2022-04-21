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
public class BilibiliUserSeries {
    /**
     *
     */
    @ONodeAttr(name = "user_upgrade_status")
    private Integer userUpgradeStatus;
    /**
     *
     */
    @ONodeAttr(name = "show_upgrade_window")
    private Boolean showUpgradeWindow;

}
