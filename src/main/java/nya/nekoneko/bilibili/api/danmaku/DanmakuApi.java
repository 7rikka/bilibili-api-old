package nya.nekoneko.bilibili.api.danmaku;

import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliDanmaku;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DanmakuApi implements IDanmaku{
    private final BilibiliLoginInfo loginInfo;

    public DanmakuApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     *
     * @param pageNum 页数
     * @param pageSize 分页大小 [1,2052]
     * @return
     */
    @Override
    public List<BilibiliDanmaku> getRecentDanmakuList(int pageNum, int pageSize) {
        //pn: 1
        //ps: 50
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.GET_RECENT_DANMAKU_LIST)
                .addParam("pn",pageNum)
                .addParam("ps",pageSize)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        System.out.println(result);
        AtomicInteger count = new AtomicInteger();
        result.getData().get("result").forEach(oNode -> {
            int andIncrement = count.incrementAndGet();
//            System.out.println(andIncrement+":"+oNode);
            System.out.println(andIncrement);
        });
        return null;
    }
}
