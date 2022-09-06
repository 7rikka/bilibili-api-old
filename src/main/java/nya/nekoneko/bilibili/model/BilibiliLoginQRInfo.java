package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * 扫码信息
 *
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliLoginQRInfo {
    @ONodeAttr(name = "url")
    private String url;
    @ONodeAttr(name = "qrcode_key")
    private String qrcodeKey;
}
