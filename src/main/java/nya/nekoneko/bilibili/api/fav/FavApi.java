package nya.nekoneko.bilibili.api.fav;

import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliFolder;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;
import org.noear.snack.ONode;

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
     * @param hide  是否隐藏（仅对自己可见）1: 是 0: 否
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
        if (biliResult.getCode() == 0) {
            return biliResult.getData().get("id").getInt();
        }
        return null;
    }

    @Override
    public BilibiliFolder getFavFolderInfo(int id) {
        Map<String,String> map=new HashMap<>();
        map.put("media_id", String.valueOf(id));
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.FOLDER_INFO,map)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        BiliResult biliResult = Call.doCall(request);
        System.out.println(biliResult);
        if (biliResult.getCode() == 0) {
            ONode data = biliResult.getData();
            //处理时间戳
            data.set("ctime", data.get("ctime").getLong() * 1000);
            data.set("mtime", data.get("mtime").getLong() * 1000);
            //反序列化
            BilibiliFolder folder = data.toObject(BilibiliFolder.class);
            //补充信息
            folder.setFavoriteCount(data.get("cnt_info").get("collect").getInt());
            folder.setPlayCount(data.get("cnt_info").get("play").getInt());
            folder.setLikeCount(data.get("cnt_info").get("thumb_up").getInt());
            folder.setShareCount(data.get("cnt_info").get("share").getInt());
            return folder;
        }
        return null;
    }

    @Override
    public boolean editFavFolder(BilibiliFolder folder) {
//        Map<String, String> map = new HashMap<>();
//        map.put("title", folder.getTitle());
//        map.put("intro", folder.getIntro());
////        map.put("privacy", folder. ? "1" : "0");
//        map.put("cover", folder.getCover());
//        map.put("csrf", loginInfo.getCsrf());
//        map.put("media_id", String.valueOf(folder.getId()));
//        Request request = BiliRequestFactor.getBiliRequest()
//                .url(UrlConfig.FOLDER_INFO,map)
//                .get()
//                .cookie(loginInfo)
//                .buildRequest();
        return false;
    }
}
