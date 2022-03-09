package nya.nekoneko.bilibili.api.upload;

import nya.nekoneko.bilibili.model.BilibiliPictureInfo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 上传相关
 */
public interface IUpload {
    /**
     * 上传封面
     *
     * @param inputStream
     * @return
     */
    String uploadCover(InputStream inputStream);

    /**
     * 私信上传图片
     *
     * @param file
     * @return
     * @throws IOException
     */
    BilibiliPictureInfo uploadPicture(File file) throws IOException;
}
