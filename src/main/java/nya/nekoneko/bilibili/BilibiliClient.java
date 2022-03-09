package nya.nekoneko.bilibili;

import nya.nekoneko.bilibili.api.fav.FavApi;
import nya.nekoneko.bilibili.api.fav.IFav;
import nya.nekoneko.bilibili.api.medal.IMedal;
import nya.nekoneko.bilibili.api.medal.MedalApi;
import nya.nekoneko.bilibili.api.member.IMember;
import nya.nekoneko.bilibili.api.member.MemberApi;
import nya.nekoneko.bilibili.api.message.IMessage;
import nya.nekoneko.bilibili.api.message.MessageApi;
import nya.nekoneko.bilibili.api.space.ISpace;
import nya.nekoneko.bilibili.api.space.SpaceApi;
import nya.nekoneko.bilibili.api.upload.IUpload;
import nya.nekoneko.bilibili.api.upload.UploadApi;
import nya.nekoneko.bilibili.api.vip.IVip;
import nya.nekoneko.bilibili.api.vip.VipApi;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;

public class BilibiliClient {
    /**
     * 登录凭证
     */
    public final BilibiliLoginInfo loginInfo;
    public IMember member;
    public IMessage message;
    public ISpace space;
    public IVip vip;
    public IFav fav;
    public IUpload upload;
    public IMedal medal;

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
        this.fav = new FavApi(loginInfo);
        this.upload = new UploadApi(loginInfo);
        this.medal = new MedalApi(loginInfo);
    }
}
