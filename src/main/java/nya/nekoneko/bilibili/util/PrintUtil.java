package nya.nekoneko.bilibili.util;

/**
 * @author Ho
 */
public class PrintUtil {
    public static Printer printer = new DefaultPrinter();
    private static final String PREFIX = "[Bilibili Api] ";
    public static void info(String s) {
        printer.info(PREFIX + s);
    }

    public static void error(String s) {
        printer.error(PREFIX + s);
    }
}
