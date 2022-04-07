package nya.nekoneko.bilibili.enums;

/**
 * 大会员权益类别
 */
public enum VipPrivilegeEnum {
    B_COIN_TICKET("5.0B币券", 1),
    SHOPPING_TICKET("年度专享会员购优惠券", 2),
    MANGA_PACKAGE("大会员专享漫画礼包", 3),
    FREIGHT_TICKET("大会员专享漫画礼包", 4);
    private final String name;
    private final int value;

    VipPrivilegeEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int value() {
        return value;
    }
}
