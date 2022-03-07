package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 粉丝牌
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliFansMedal {
    private Boolean show;
    private Boolean wear;
    private BilibiliMedal medal;
}
