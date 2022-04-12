package nya.nekoneko.bilibili.api.user;

import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import nya.nekoneko.bilibili.util.PrintUtil;
import okhttp3.Request;

/**
 * @author Ho
 */
public class UserApi implements IUser {
    private final BilibiliLoginInfo loginInfo;

    public UserApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 检查名字是否可用
     *
     * @param name 名称 长度范围 [2,16]
     * @return true: 可用 false: 不可用
     */
    @Override
    public boolean checkNameAvailable(String name) {
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.CHECK_NAME_AVAILABLE)
                .addParam("nickName", name)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        Integer code = result.getCode();
        if (0 == code) {
            return true;
        }
        PrintUtil.info("昵称: " + name + " 不可用, 原因: " + result.getMessage() + ".");
        return false;
    }
}
