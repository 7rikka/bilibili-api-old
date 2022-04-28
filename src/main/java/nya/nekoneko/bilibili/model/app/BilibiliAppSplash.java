package nya.nekoneko.bilibili.model.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * 开屏图片
 *
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliAppSplash {
    /**
     *
     */
    @ONodeAttr(name = "id")
    private Integer id;
    /**
     *
     */
    @ONodeAttr(name = "thumb")
    private String thumb;
    /**
     *
     */
    @ONodeAttr(name = "logo_url")
    private String logoUrl;
    /**
     *
     */
    @ONodeAttr(name = "mode")
    private String mode;
}