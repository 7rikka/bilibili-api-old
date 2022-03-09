package nya.nekoneko.bilibili.api.upload;

import lombok.extern.slf4j.Slf4j;
import nya.nekoneko.bilibili.api.message.MessageApi;
import nya.nekoneko.bilibili.config.UrlConfig;
import nya.nekoneko.bilibili.model.BiliResult;
import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import nya.nekoneko.bilibili.model.BilibiliPictureInfo;
import nya.nekoneko.bilibili.util.Base64Util;
import nya.nekoneko.bilibili.util.BiliRequestFactor;
import nya.nekoneko.bilibili.util.Call;
import okhttp3.Request;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class UploadApi implements IUpload {
    private final BilibiliLoginInfo loginInfo;

    public UploadApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    @Override
    public String uploadCover(InputStream inputStream) {
        Map<String, String> map = new HashMap<>();
        map.put("cover", Base64Util.pictureToBase64(inputStream));
        map.put("csrf", loginInfo.getCsrf());
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.UPLOAD_COVER)
                .postForm(map)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            String url = result.getData().get("url").getString();
            log.info("上传封面成功, URL: {}", url);
            return url;
        }
        log.error("上传封面失败: {}", result);
        return null;
    }

    /**
     * 上传图片
     *
     * @param file
     * @return
     * @throws IOException
     */
    @Override
    public BilibiliPictureInfo uploadPicture(File file) throws IOException {
        if (!file.getName().contains(".")) {
            throw new RuntimeException("文件名不合法!");
        }
        String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (!MessageApi.pictureType.containsKey(suffix)) {
            throw new RuntimeException("不支持的文件格式:" + suffix + "!");
        }
        Map<String, String> map = new HashMap<>();
        map.put("biz", "im");
        map.put("csrf", loginInfo.getCsrf());
        map.put("build", "0");
        map.put("mobi_app", "web");
        Request request = BiliRequestFactor.getBiliRequest()
                .url(UrlConfig.UPLOAD_IMAGE)
                .uploadFile(new FileInputStream(file), file.getName(), map)
                .cookie(loginInfo)
                .buildRequest();
        BiliResult result = Call.doCall(request);
        if (result.getCode() == 0) {
            BilibiliPictureInfo info = result.getData().toObject(BilibiliPictureInfo.class);
            info.setSuffix(suffix);
            info.setFilename(file.getName());
            info.setSize(file.length());
            return info;
        } else {
            return null;
        }
    }
}
