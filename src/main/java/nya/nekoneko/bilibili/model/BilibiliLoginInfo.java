package nya.nekoneko.bilibili.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户登录信息
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
    private String SESSDATA;
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

    public String getSESSDATA() {
        return SESSDATA;
    }

    public BilibiliLoginInfo setSESSDATA(String SESSDATA) {
        this.SESSDATA = SESSDATA
                .replace(",", "%2C")
                .replace("*", "%2A");
        return this;
    }
}
