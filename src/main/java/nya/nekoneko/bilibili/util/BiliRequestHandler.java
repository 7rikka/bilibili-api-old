package nya.nekoneko.bilibili.util;

import okhttp3.Headers;

/**
 * @author Ho
 */
public class BiliRequestHandler {
    private static BiliHandler handler = headers -> {

    };

    public static void process(Headers headers) {
        handler.process(headers);
    }

    public static void setHandler(BiliHandler handler) {
        BiliRequestHandler.handler = handler;
    }
}
