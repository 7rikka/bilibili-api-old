package nya.nekoneko.bilibili.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户登录信息
 */
@Data
public class BilibiliLoginInfo {
    /**
     * 用户UID
     */
    private Integer uid;
    /**
     * SESSDATA
     */
    private String SESSDATA;
    /**
     * bili_jct
     */
    private String csrf;
    /**
     * 登录状态可用性
     */
    private Boolean isAvailable;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
