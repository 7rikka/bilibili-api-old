package nya.nekoneko.bilibili.api.archive;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;
import org.noear.snack.ONode;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ArchiveApi implements IArchive{
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
    public ONode getArchivePre() {
        Map<String, String> map = new HashMap<>();
        map.put("lang", "cn");
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.ARCHIVE_PRE,map)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        System.out.println(result);
        if (result.getCode() == 0) {
//            return result.getData().get("id").getInt();
        }
        return null;
    }
}
