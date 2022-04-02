package nya.nekoneko.bilibili.model.upload;

import java.io.File;

/**
 * @author Ho
 */
public class KodoUploader implements Uploader {
    private static final int CHUNK_SIZE = 4 * 1024 * 1024;

    void upload(File file) {
        String fileName = file.getName();
        long fileSize = file.length();
        int chunkNum = (int)Math.ceil(1.0 * fileSize / CHUNK_SIZE);
    }
}
