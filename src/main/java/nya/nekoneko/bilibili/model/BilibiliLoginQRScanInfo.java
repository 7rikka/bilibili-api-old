package nya.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 扫码信息
 *
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliLoginQRScanInfo {
    private int code;
    private String message;
    private String url;
    private String dedeUserId;
    private String dedeUserIdCkMd5;
    private String expires;
    private String sessData;
    private String biliJct;
    private String goUrl;
}
