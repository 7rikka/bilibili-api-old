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
public class BilibiliVipLabel {
    /**
     *
     */
    @ONodeAttr(name = "path")
    private String path;
    /**
     *
     */
    @ONodeAttr(name = "text")
    private String text;
    /**
     *
     */
    @ONodeAttr(name = "label_theme")
    private String labelTheme;
    /**
     *
     */
    @ONodeAttr(name = "text_color")
    private String textColor;
    /**
     *
     */
    @ONodeAttr(name = "bg_style")
    private String bgStyle;
    /**
     *
     */
    @ONodeAttr(name = "bg_color")
    private String bgColor;
    /**
     *
     */
    @ONodeAttr(name = "border_color")
    private String borderColor;
}