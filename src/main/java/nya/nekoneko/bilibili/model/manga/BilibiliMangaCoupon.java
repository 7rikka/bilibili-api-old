package nya.nekoneko.bilibili.model.manga;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 漫读券
 *
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliMangaCoupon {
    /**
     *
     */
    @ONodeAttr(name = "ID")
    private Integer id;
    /**
     *
     */
    @ONodeAttr(name = "remain_amount")
    private Integer remainAmount;
    /**
     *
     */
    @ONodeAttr(name = "expire_time")
    private LocalDateTime expireTime;
    /**
     *
     */
    @ONodeAttr(name = "reason")
    private String reason;
    /**
     *
     */
    @ONodeAttr(name = "type")
    private String type;
    /**
     *
     */
    @ONodeAttr(name = "ctime")
    private LocalDateTime ctime;
    /**
     *
     */
    @ONodeAttr(name = "total_amount")
    private Integer totalAmount;
    /**
     *
     */
    @ONodeAttr(name = "limits")
    private List<String> limits;
    /**
     *
     */
    @ONodeAttr(name = "type_num")
    private Integer typeNum;
    /**
     *
     */
    @ONodeAttr(name = "will_expire")
    private Integer will_expire;
    /**
     *
     */
    @ONodeAttr(name = "discount")
    private Integer discount;
    /**
     *
     */
    @ONodeAttr(name = "discount_limit")
    private Integer discount_limit;
    /**
     *
     */
    @ONodeAttr(name = "is_from_card")
    private Integer is_from_card;
    /**
     *
     */
    @ONodeAttr(name = "valid_time")
    private String valid_time;
    /**
     *
     */
    @ONodeAttr(name = "discount_base")
    private Integer discount_base;
    /**
     *
     */
    @ONodeAttr(name = "comics_land_page")
    private String comics_land_page;
}