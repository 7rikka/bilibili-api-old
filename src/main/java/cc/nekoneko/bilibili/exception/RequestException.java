package cc.nekoneko.bilibili.exception;

import okhttp3.Request;
import okhttp3.Response;

public class RequestException extends RuntimeException {
    private final Request request;
    private final Response response;


    public RequestException(Request request, Response response, String message) {
        super(message);
        this.request = request;
        this.response = response;
    }

    @Override
    public void printStackTrace() {
        System.err.println("错误: 请求路径:"+request.url());
    }
}
