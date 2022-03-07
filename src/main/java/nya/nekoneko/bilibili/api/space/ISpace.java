package nya.nekoneko.bilibili.api.space;

import nya.nekoneko.bilibili.model.BilibiliUser;

public interface ISpace {
    /**
     * 获取用户信息
     *
     * @param uid
     * @return
     */
    BilibiliUser getUserInfo(int uid);
}
