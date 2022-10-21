package nya.nekoneko.bilibili.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户登录信息
 *
 * @author Ho
 */
@Data
public class BilibiliLoginInfo {
    /**
     * 用户UID (DedeUserID)
     */
    private Integer uid;
    /**
     * DedeUserID__ckMd5
     */
    private String uidCkMd5;
    /**
     * SESSDATA
     */
    private String sessData;
    /**
     * csrf (bili_jct)
     */
    private String csrf;
    /**
     * App端access_key
     */
    private String accessKey;
    /**
     * 登录状态可用性
     */
    private Boolean isAvailable;
    /**
     * 过期时间
     */
    private LocalDateTime expiresTime;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public String getSessData() {
        return sessData;
    }

    public BilibiliLoginInfo setSessData(String sessData) {
        if (null != sessData) {
            this.sessData = sessData
                    .replace(",", "%2C")
                    .replace("*", "%2A");
        }
        return this;
    }
}
