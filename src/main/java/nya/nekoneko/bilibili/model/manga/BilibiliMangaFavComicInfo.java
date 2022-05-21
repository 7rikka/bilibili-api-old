package nya.nekoneko.bilibili.model.manga;

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
public class BilibiliMangaFavComicInfo {
    /**
     *
     */
    @ONodeAttr(name = "has_fav_activity")
    private Boolean hasFavActivity;
    /**
     *
     */
    @ONodeAttr(name = "fav_free_amount")
    private Integer favFreeAmount;
    /**
     *
     */
    @ONodeAttr(name = "fav_coupon_type")
    private Integer favCouponType;


}