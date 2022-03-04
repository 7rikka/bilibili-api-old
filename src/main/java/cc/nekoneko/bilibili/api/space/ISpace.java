package cc.nekoneko.bilibili.api.space;

import cc.nekoneko.bilibili.model.BilibiliLoginInfo;
import cc.nekoneko.bilibili.model.BilibiliUser;

public interface ISpace {
    /**
     * 获取用户信息（不登录状态获取）
     *
     * @param mid
     * @return
     */
    BilibiliUser getUserInfo(int mid);

    /**
     * 获取用户信息（登录状态获取）
     *
     * @param mid
     * @return
     */
    BilibiliUser getUserInfo(int mid, BilibiliLoginInfo loginInfo);
}
