package cc.nekoneko.bilibili.model;

import lombok.Data;

@Data
public class BilibiliLoginInfo {
    /**
     * SESSDATA
     */
    private String SESSDATA;
    /**
     * bili_jct
     */
    private String csrf;
}
