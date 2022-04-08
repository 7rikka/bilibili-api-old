package nya.nekoneko.bilibili.util;

public class DefaultPrinter implements Printer {
    @Override
    public void info(String s) {
        System.out.println(s);
    }

    @Override
    public void error(String s) {
        System.err.println(s);
    }
}
