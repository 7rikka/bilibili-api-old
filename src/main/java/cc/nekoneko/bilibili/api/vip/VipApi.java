package cc.nekoneko.bilibili.api.vip;

import cc.nekoneko.bilibili.enums.VipPrivilegeEnum;
import cc.nekoneko.bilibili.model.BiliResult;
import cc.nekoneko.bilibili.model.BilibiliLoginInfo;
import cc.nekoneko.bilibili.util.BiliRequestFactor;
import cc.nekoneko.bilibili.util.Call;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;

import java.util.HashMap;
import java.util.Map;

import static cc.nekoneko.bilibili.config.UrlConfig.RECIVE_PRIVILEGE;

@Slf4j
public class VipApi implements IVip {

    /**
     * 领取大会员权益
     *
     * @param loginInfo 登录信息
     * @param type      领取礼包类型
     * @return code=69800, message=网络繁忙 请稍后再试
     * code=69801, message=你已领取过该权益
     */
    @Override
    public boolean recivePrivilege(BilibiliLoginInfo loginInfo, VipPrivilegeEnum type) {
        Map<String, String> map = new HashMap<>();
        map.put("type", String.valueOf(type.value()));
        map.put("csrf", loginInfo.getCsrf());
        Request request = BiliRequestFactor.getBiliRequest()
                .url(RECIVE_PRIVILEGE)
                .postForm(map)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        System.out.println(result);
        if (result.getCode() == 0 || result.getCode() == 69801) {
            //领取成功
            return true;
        } else {
            log.error("领取权益: {} 失败",type.name());
            return false;
        }
    }
}
