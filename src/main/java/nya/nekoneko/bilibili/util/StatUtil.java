package nya.nekoneko.bilibili.util;

public class StatUtil {
    private static final String[] sizeUnit = {"Byte", "KB", "MB", "GB", "TB", "PB", "EB"};
    private static final String[] timeUnit = {"秒", "分钟", "小时", "天"};
    private static final String[] speedUnit = {"Byte/s", "KB/s", "MB/s", "GB/s"};

    public static void uploadInfoStat(long start, long end, long fileSize) {
        double l = 1.0 * fileSize / 1024 / 1024;
        PrintUtil.info("文件大小: " + convertFileSize(fileSize));
        PrintUtil.info("上传用时: " + convertUploadTime(start, end));
        PrintUtil.info("平均速度: " + convertSpeed(start, end, fileSize));
    }

    public static String convertFileSize(long fileSize) {
        double r = fileSize;
        int index = 0;
        while (r > 1024) {
            r = r / 1024;
            index += 1;
        }
        return String.format("%.2f", r) + sizeUnit[index];
    }

    public static String convertUploadTime(long start, long end) {
        if (start > end) {
            return "ERROR";
        }
        //用时(秒)
        double t = 1.0 * (end - start) / 1000;
        int unitIndex = 0;
        if (t > 60) {
            t /= 60;
            unitIndex++;
        }
        if (t > 60) {
            t /= 60;
            unitIndex++;
        }
        if (t > 24) {
            t /= 24;
            unitIndex++;
        }
        return String.format("%.2f", t) + timeUnit[unitIndex];
    }

    public static String convertSpeed(long start, long end, long fileSize) {
        double r = fileSize / (1.0 * (end - start) / 1000);
        int index = 0;
        while (r > 1024) {
            r = r / 1024;
            index += 1;
        }
        return String.format("%.2f", r) + speedUnit[index];
    }
}
