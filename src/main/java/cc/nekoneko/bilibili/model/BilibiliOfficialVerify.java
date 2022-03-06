package cc.nekoneko.bilibili.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.noear.snack.annotation.ONodeAttr;

/**
 * 用户认证信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BilibiliOfficialVerify {
    /**
     * -1：无
     * 0：认证
     */
    @ONodeAttr(name = "type")
    private Integer type;
    /**
     * 认证信息
     */
    @ONodeAttr(name = "title")
    private String title;
    /**
     * 认证备注
     */
    @ONodeAttr(name = "desc")
    private String desc;
    /**
     * 0：无
     * 1 2 7：个人认证
     * 3 4 5 6：机构认证
     */
    @ONodeAttr(name = "role")
    private Integer role;
}
