package cc.nekoneko.bilibili.api.space;

import cc.nekoneko.bilibili.model.BiliResult;
import cc.nekoneko.bilibili.model.BilibiliLoginInfo;
import cc.nekoneko.bilibili.model.BilibiliUser;
import cc.nekoneko.bilibili.util.BiliRequestFactor;
import cc.nekoneko.bilibili.util.BilibiliRequest;
import cc.nekoneko.bilibili.util.Call;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.util.HashMap;
import java.util.Map;

import static cc.nekoneko.bilibili.config.UrlConfig.USER_INFO;

public class SpaceApi implements ISpace {
    /**
     * 获取用户信息（不登录状态获取）
     *
     * @param mid
     * @return
     */
    @Override
    public BilibiliUser getUserInfo(int mid) {
        return getUserInfo(mid, null);
    }

    /**
     * 获取用户信息（登录状态获取）
     *
     * @param mid
     * @return
     */
    @Override
    public BilibiliUser getUserInfo(int mid, BilibiliLoginInfo loginInfo) {
        Map<String,String> map=new HashMap<>();
        map.put("mid", String.valueOf(mid));
        BilibiliRequest bilibiliRequest = BiliRequestFactor.getBiliRequest()
                .url(USER_INFO, map)
                .get();
        if (null != loginInfo) {
            bilibiliRequest.cookie(loginInfo);
        }
        Request request = bilibiliRequest.buildRequest();
        BiliResult biliResult = Call.doCall(request);
        if (biliResult.getCode() == 0) {
            ONode node = biliResult.getData();
            BilibiliUser.builder()
                    .uid(node.get("mid").getInt())
                    .name(node.get("name").getString())
                    .build();
        } else {
            System.out.println("错误:"+biliResult);
        }
        return null;
    }
}
