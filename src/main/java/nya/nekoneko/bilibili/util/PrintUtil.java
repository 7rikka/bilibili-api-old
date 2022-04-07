package nya.nekoneko.bilibili.util;

public class PrintUtil {
    public static Printer printer = new DefaultPrinter();

    public static void info(String s) {
        printer.info(s);
    }
}
