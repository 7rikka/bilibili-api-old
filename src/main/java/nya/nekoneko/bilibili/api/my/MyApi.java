package nya.nekoneko.bilibili.api.my;

import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliNotify;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApi implements IMy {
    private final BilibiliLoginInfo loginInfo;

    public MyApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    @Override
    public List<BilibiliNotify> getMyNotifyList() {
        return getMyNotifyList(null);
    }

    @Override
    public List<BilibiliNotify> getMyNotifyList(Long cursor) {
        return getMyNotifyList(cursor, 20);
    }

    @Override
    public List<BilibiliNotify> getMyNotifyList(int pageSize) {
        return getMyNotifyList(null, pageSize);

    }

    @Override
    public List<BilibiliNotify> getMyNotifyList(Long cursor, int pageSize) {
        Map<String, String> map = new HashMap<>();
        map.put("csrf", loginInfo.getCsrf());
        map.put("page_size", String.valueOf(pageSize));
        map.put("data_type", "1");
        if (null != cursor) {
            map.put("cursor", String.valueOf(cursor));
        }
        map.put("build", "0");
        map.put("mobi_app", "web");
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_MY_NOTITY, map)
                .cookie(loginInfo)
                .get()
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (0 == result.getCode()) {
            result.getData().forEach(node -> {
                node.rename("time_at", "recive_time");
            });
            return result.getData().toObjectList(BilibiliNotify.class);
        }
        return null;
    }


}
