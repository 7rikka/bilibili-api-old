package nya.nekoneko.bilibili.api.user;

/**
 * @author Ho
 */
public interface IUser {
    /**
     * 检查名字是否可用
     *
     * @param name 名称 长度范围 [2,16]
     * @return true: 可用 false: 不可用
     */
    boolean checkNameAvailable(String name);
}
