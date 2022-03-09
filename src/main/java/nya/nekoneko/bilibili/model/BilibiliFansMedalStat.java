package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * 粉丝勋章领取数据总览
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliFansMedalStat {
    /**
     * 领取的总人数
     */
    @ONodeAttr(name = "medal_fans")
    private int ownCount;
    /**
     * 当前佩戴的人数
     */
    @ONodeAttr(name = "wear_medal_fans")
    private int wearCount;
}
