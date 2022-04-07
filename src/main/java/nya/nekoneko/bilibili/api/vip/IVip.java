package nya.nekoneko.bilibili.api.vip;

import nya.nekoneko.bilibili.enums.VipPrivilegeEnum;

/**
 * 大会员相关
 */
public interface IVip {
    /**
     * 领取大会员权益
     *
     * @param type 兑换类型
     * @return 领取是否成功
     */
    boolean recivePrivilege(VipPrivilegeEnum type);
}
