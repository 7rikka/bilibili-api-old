package cc.nekoneko.bilibili.model;

import lombok.Data;

/**
 * 用户认证信息
 */
@Data
public class UserOfficialVerify {
    /**
     * -1：无
     * 0：认证
     */
    private Integer type;
    /**
     * 认证信息
     */
    private String title;
    /**
     * 认证备注
     */
    private String desc;
    /**
     * 0：无
     * 1 2 7：个人认证
     * 3 4 5 6：机构认证
     */
    private Integer role;
}
