package nya.nekoneko.bilibili.api.upload;

import nya.nekoneko.bilibili.model.BilibiliLoginInfo;

import java.io.InputStream;

public class UploadApi implements IUpload {
    private final BilibiliLoginInfo loginInfo;

    public UploadApi(BilibiliLoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    @Override
    public String uploadCover(InputStream inputStream) {
        return null;
    }
}
