package nya.nekoneko.bilibili.api.archive;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliActivity;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliVideoType;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ArchiveApi implements IArchive {
    private final BilibiliLoginInfo loginInfo;

    public ArchiveApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 获取原始信息
     *
     * @return
     */
    @Override
    public BiliResult getArchivePre() {
        Map<String, String> map = new HashMap<>();
        map.put("lang", "cn");
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.ARCHIVE_PRE, map)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        return Call.doCall(request);
    }

    /**
     * 获取可参加活动列表
     *
     * @return 可参加活动列表
     */
    @Override
    public List<BilibiliActivity> getAvaliableActivity() {
        BiliResult result = getArchivePre();
        if (result.getCode() == 0) {
            ONode node = result.getData().get("activities");
            node.forEach(oNode -> {
                oNode.set("stime",oNode.get("stime").getLong() * 1000);
                oNode.set("etime",oNode.get("etime").getLong() * 1000);
            });
            return node.toObjectList(BilibiliActivity.class);
        }
        return null;
    }

    /**
     * 获取分区列表
     *
     * @return
     */
    @Override
    public List<BilibiliVideoType> getVideoTypeList() {
        BiliResult result = getArchivePre();
        if (result.getCode() == 0) {
            return result.getData().get("typelist").toObjectList(BilibiliVideoType.class);
        }
        return null;
    }
}