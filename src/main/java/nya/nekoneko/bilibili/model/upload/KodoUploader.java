package nya.nekoneko.bilibili.model.upload;

import nya.nekoneko.bilibili.model.BilibiliLoginInfo;

import java.io.File;

/**
 * @author Ho
 */
public class KodoUploader implements Uploader {
    private static final int CHUNK_SIZE = 4 * 1024 * 1024;

    public String upload(BilibiliLoginInfo bilibiliLoginInfo,File file) throws Exception{
        String fileName = file.getName();
        long fileSize = file.length();
        int chunkNum = (int)Math.ceil(1.0 * fileSize / CHUNK_SIZE);
        return null;
    }
}
