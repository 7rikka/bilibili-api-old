package cc.nekoneko.bilibili.api.vip;

import cc.nekoneko.bilibili.enums.VipPrivilegeEnum;
import cc.nekoneko.bilibili.model.BilibiliLoginInfo;

/**
 * 大会员相关
 */
public interface IVip {
    /**
     * 领取大会员权益
     * @return
     */
    boolean recivePrivilege(BilibiliLoginInfo loginInfo, VipPrivilegeEnum type);
}
