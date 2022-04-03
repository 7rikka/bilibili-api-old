package nya.nekoneko.bilibili.util;

public class Progress {
    private final long start = System.currentTimeMillis();
    private long uploadedSize = 0;
    private final long fileSize;

    public Progress(long fileSize) {
        this.fileSize = fileSize;
    }

    public synchronized void add(int size, String result) {
        uploadedSize += size;
        //已完成,总量,进度,平均速度
        String s = String.format("[%s @ %s][%s][%s][result:%s]",
                StatUtil.convertFileSize(uploadedSize),
                StatUtil.convertFileSize(fileSize),
                String.format("%.2f", 1.0 * uploadedSize / fileSize * 100) + "%",
                StatUtil.convertSpeed(start, System.currentTimeMillis(), uploadedSize),
                result
        );
        PrintUtil.info(s);
    }
}
