package nya.nekoneko.bilibili.api.fav;

import lombok.extern.slf4j.Slf4j;
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
import java.util.StringJoiner;

import static nya.nekoneko.bilibili.util.CheckUtil.checkNotEmpty;

@Slf4j
public class FavApi implements IFav {
    private final BilibiliLoginInfo loginInfo;

    public FavApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * 创建收藏夹
     *
     * @param title 收藏夹名称
     * @param desc  收藏夹简介
     * @param hide  是否隐藏（仅对自己可见）1: 是 0: 否
     * @param cover 收藏夹封面
     * @return 收藏夹id
     */
    @Override
    public Integer addFavFolder(String title, String desc, boolean hide, String cover) {
        checkNotEmpty(title, "收藏夹标题不得为空");
        Map<String, String> map = new HashMap<>();
        map.put("title", title);
        map.put("intro", desc);
        map.put("privacy", hide ? "1" : "0");
        map.put("cover", cover);
        map.put("csrf", loginInfo.getCsrf());
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.ADD_FAV_FOLDER)
                .postForm(map)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            return result.getData().get("id").getInt();
        }
        log.error("创建收藏夹失败: {}", result);
        return null;
    }

    /**
     * 获取收藏夹信息
     *
     * @param id 收藏夹id
     * @return 收藏夹信息
     */
    @Override
    public BilibiliFolder getFavFolderInfo(int id) {
        Map<String, String> map = new HashMap<>();
        map.put("media_id", String.valueOf(id));
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.FOLDER_INFO, map)
                .get()
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            ONode data = result.getData();
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
        log.error("获取收藏夹信息失败: {}", result);
        return null;
    }

    /**
     * 编辑收藏夹信息
     *
     * @param folder 收藏夹信息
     * @return 修改是否成功
     */
    @Override
    public boolean editFavFolder(BilibiliFolder folder) {
        return editFavFolder(folder, null);
    }

    /**
     * 编辑收藏夹信息
     *
     * @param folder 收藏夹信息
     * @param isHide 是否隐藏（仅对自己可见）1: 是 0: 否
     * @return 修改是否成功
     */
    @Override
    public boolean editFavFolder(BilibiliFolder folder, Boolean isHide) {
        checkNotEmpty(folder.getTitle(), "收藏夹标题不得为空");
        Map<String, String> map = new HashMap<>();
        map.put("title", folder.getTitle());
        map.put("intro", folder.getIntro());
        map.put("cover", folder.getCover());
        map.put("csrf", loginInfo.getCsrf());
        map.put("media_id", String.valueOf(folder.getId()));
        if (null != isHide) {
            map.put("privacy", isHide ? "1" : "0");
        }
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.EDIT_FAV_FOLDER)
                .postForm(map)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            return true;
        }
        log.error("编辑收藏夹失败: {}", result);
        return false;
    }

    /**
     * 删除收藏夹
     *
     * @param id
     * @return
     */
    @Override
    public boolean delFavFolder(int id) {
        Map<String, String> map = new HashMap<>();
        map.put("media_ids", String.valueOf(id));
        map.put("csrf", loginInfo.getCsrf());
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.DEL_FAV_FOLDER)
                .postForm(map)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            return true;
        }
        log.error("删除收藏夹失败: {}", result);
        return false;
    }

    @Override
    public boolean delFavFolder(int[] ids) {
        StringJoiner sj=new StringJoiner(",");
        for (int id : ids) {
            sj.add(String.valueOf(id));
        }
        String idString = sj.toString();
        Map<String, String> map = new HashMap<>();
        map.put("media_ids", idString);
        map.put("csrf", loginInfo.getCsrf());
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.DEL_FAV_FOLDER)
                .postForm(map)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            return true;
        }
        log.error("批量删除收藏夹失败: {}", result);
        return false;
    }
}
