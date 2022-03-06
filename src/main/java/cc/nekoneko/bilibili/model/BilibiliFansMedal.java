package cc.nekoneko.bilibili.model;

import lombok.Builder;
import lombok.Data;

/**
 * 粉丝牌
 */
@Data
@Builder
public class BilibiliFansMedal {
    private Boolean show;
    private Boolean wear;
    private BilibiliMedal medal;
}
