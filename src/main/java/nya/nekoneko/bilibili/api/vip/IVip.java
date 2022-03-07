package nya.nekoneko.bilibili.api.vip;

import nya.nekoneko.bilibili.enums.VipPrivilegeEnum;

/**
 * 大会员相关
 */
public interface IVip {
    /**
     * 领取大会员权益
     * @return
     */
    boolean recivePrivilege(VipPrivilegeEnum type);
}
