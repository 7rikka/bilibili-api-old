package nya.nekoneko.bilibili.model.upload;

import nya.nekoneko.bilibili.model.BilibiliLoginInfo;

import java.io.File;

/**
 * @author Ho
 */
public interface Uploader {
    String upload(BilibiliLoginInfo bilibiliLoginInfo, File file) throws Exception;
}
