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
public class BilibiliLiveRoomWatchedShow {
    /**
     *
     */
    @ONodeAttr(name = "switch")
    private Boolean switch1;
    /**
     *
     */
    @ONodeAttr(name = "num")
    private Integer num;
    /**
     *
     */
    @ONodeAttr(name = "text_small")
    private String textSmall;
    /**
     *
     */
    @ONodeAttr(name = "text_large")
    private String textLarge;
    /**
     *
     */
    @ONodeAttr(name = "icon")
    private String icon;
    /**
     *
     */
    @ONodeAttr(name = "icon_location")
    private String iconLocation;
    /**
     *
     */
    @ONodeAttr(name = "icon_web")
    private String iconWeb;
}
