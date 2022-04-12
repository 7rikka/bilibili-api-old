package nya.nekoneko.bilibili.util;

/**
 * @author Ho
 */
public class PrintUtil {
    public static Printer printer = new DefaultPrinter();

    public static void info(String s) {
        printer.info(s);
    }

    public static void error(String s) {
        printer.error(s);
    }
}
