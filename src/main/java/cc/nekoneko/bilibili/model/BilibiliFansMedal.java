package cc.nekoneko.bilibili.model;

import lombok.Data;

/**
 * 粉丝牌
 */
@Data
public class BilibiliFansMedal {
    private Boolean show;
    private Boolean wear;
    private BilibiliMedal medal;
}
