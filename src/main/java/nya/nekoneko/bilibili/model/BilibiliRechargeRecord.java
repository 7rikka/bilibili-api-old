package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.time.LocalDateTime;

/**
 * 充电记录
 *
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliRechargeRecord {
    /**
     * 充电人uid
     */
    @ONodeAttr(name = "uid")
    private Integer uid;
    /**
     * 原始充电B币
     */
    @ONodeAttr(name = "original_third_coin")
    private Double originalThirdCoin;
    /**
     * 实际到手贝壳
     */
    @ONodeAttr(name = "brokerage")
    private Double brokerage;
    /**
     * 充电渠道
     */
    @ONodeAttr(name = "remark")
    private String remark;
    /**
     * 充电时间
     */
    @ONodeAttr(name = "ctime")
    private LocalDateTime ctime;
    /**
     * 用户信息
     */
    @ONodeAttr(name = "user")
    private BilibiliUser user;
}
