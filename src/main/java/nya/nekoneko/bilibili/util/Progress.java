package nya.nekoneko.bilibili.util;

/**
 * @author Ho
 */
public class Progress {
    /**
     * 上传开始时间
     */
    private final long start = System.currentTimeMillis();
    /**
     * 已上传大小
     */
    private long uploadedSize = 0;
    /**
     * 文件总大小
     */
    private final long fileSize;

    public Progress(long fileSize) {
        this.fileSize = fileSize;
    }

    public synchronized void add(int size, String result) {
        uploadedSize += size;
        String s;
        if (null != result) {
            //已完成,总量,进度,平均速度
            s = String.format("[%s @ %s][%s][%s][result:%s]",
                    StatUtil.convertFileSize(uploadedSize),
                    StatUtil.convertFileSize(fileSize),
                    String.format("%.2f", 1.0 * uploadedSize / fileSize * 100) + "%",
                    StatUtil.convertSpeed(start, System.currentTimeMillis(), uploadedSize),
                    result);
        } else {
            s = String.format("[%s @ %s][%s][%s]",
                    StatUtil.convertFileSize(uploadedSize),
                    StatUtil.convertFileSize(fileSize),
                    String.format("%.2f", 1.0 * uploadedSize / fileSize * 100) + "%",
                    StatUtil.convertSpeed(start, System.currentTimeMillis(), uploadedSize));
        }
        PrintUtil.info(s);
    }

    public void add(int size) {
        add(size, null);
    }
}
