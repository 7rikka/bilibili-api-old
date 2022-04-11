package nya.nekoneko.bilibili.api.uploader;

import nya.nekoneko.bilibili.model.BilibiliLoginInfo;

import java.io.File;

/**
 * @author Ho
 */
public interface Uploader {
    /**
     * @param bilibiliLoginInfo
     * @param file
     * @return
     * @throws Exception
     */
    String upload(BilibiliLoginInfo bilibiliLoginInfo, File file) throws Exception;

    /**
     * @param bilibiliLoginInfo
     * @param filePath
     * @return
     * @throws Exception
     */
    default String upload(BilibiliLoginInfo bilibiliLoginInfo, String filePath) throws Exception {
        return upload(bilibiliLoginInfo, new File(filePath));
    }
}
