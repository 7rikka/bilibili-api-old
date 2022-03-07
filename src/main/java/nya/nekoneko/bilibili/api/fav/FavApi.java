package nya.nekoneko.bilibili.api.fav;

import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;

import java.util.HashMap;
import java.util.Map;

import static nya.nekoneko.bilibili.config.UrlConfig.ADD_FAV_FOLDER;
import static nya.nekoneko.bilibili.util.CheckUtil.checkNotEmpty;

public class FavApi implements IFav {
    private final BilibiliLoginInfo loginInfo;

    public FavApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * @param title 收藏夹名称
     * @param desc  收藏夹简介
     * @param hide  是否隐藏（仅对自己可见）
     * @param cover 收藏夹封面
     * @return 收藏夹id
     */
    @Override
    public Integer newFavFolder(String title, String desc, boolean hide, String cover) {
        checkNotEmpty(title, "收藏夹标题不得为空");
        Map<String, String> map = new HashMap<>();
        map.put("title", title);
        map.put("intro", desc);
        map.put("privacy", hide ? "1" : "0");
        map.put("cover", cover);
        map.put("csrf", loginInfo.getCsrf());
        Request request = BiliRequestFactor.getBiliRequest()
                .url(ADD_FAV_FOLDER)
                .postForm(map)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult biliResult = Call.doCall(request);
        System.out.println(biliResult);
        if (biliResult.getCode() == 0) {
            return biliResult.getData().get("id").getInt();
        }
        return null;
    }

    @Override
    public void getFolderInfo(int id) {

    }
}
