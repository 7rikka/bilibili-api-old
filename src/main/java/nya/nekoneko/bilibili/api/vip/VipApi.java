package nya.nekoneko.bilibili.api.vip;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.enums.VipPrivilegeType;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class VipApi implements IVip {
    private final BilibiliLoginInfo loginInfo;

    public VipApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 领取大会员权益
     *
     * @param type 领取礼包类型
     * @return 领取是否成功
     * code=69800, message=网络繁忙 请稍后再试
     * code=69801, message=你已领取过该权益
     */
    @Override
    public boolean recivePrivilege(VipPrivilegeType type) {
        //准备参数
        Map<String, String> map = new HashMap<>();
        map.put("type", String.valueOf(type.value()));
        map.put("csrf", loginInfo.getCsrf());
        //构建请求
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.RECIVE_PRIVILEGE)
                .postForm(map)
                .cookie(loginInfo)
                .buildRequest();
        //发送请求
        BiliResult result = Call.doCall(request);
        //处理返回结果
        //领取成功 OR 重复领取
        if (result.getCode() == 0 || result.getCode() == 69801) {
            log.info("领取权益: {} 成功", type.name());
            return true;
        } else {
            log.error("领取权益: {} 失败", type.name());
            return false;
        }
    }
}
