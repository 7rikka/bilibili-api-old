package cc.nekoneko.bilibili;

import cc.nekoneko.bilibili.api.member.IMember;
import cc.nekoneko.bilibili.api.member.MemberApi;
import cc.nekoneko.bilibili.api.message.IMessage;
import cc.nekoneko.bilibili.api.message.MessageApi;
import cc.nekoneko.bilibili.api.space.ISpace;
import cc.nekoneko.bilibili.api.space.SpaceApi;
import cc.nekoneko.bilibili.api.vip.IVip;
import cc.nekoneko.bilibili.api.vip.VipApi;
import cc.nekoneko.bilibili.model.BilibiliLoginInfo;

public class BilibiliClient {
    /**
     * 登录凭证
     */
    public final BilibiliLoginInfo loginInfo;
    public IMember member;
    public IMessage message;
    public ISpace space;
    public IVip vip;

    public BilibiliClient() {
        this.loginInfo = new BilibiliLoginInfo();
        refreshModules();
    }

    public BilibiliClient(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
        refreshModules();
    }

    /**
     * 登陆状态传递
     */
    private void refreshModules() {
        this.member = new MemberApi(loginInfo);
        this.message = new MessageApi(loginInfo);
        this.space = new SpaceApi(loginInfo);
        this.vip = new VipApi(loginInfo);
    }
}
