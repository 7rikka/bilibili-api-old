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
        System.err.println("错误: 请求路径:" + request.url());
    }

//    public String getExceptionInfo() throws IOException {
//        return String.format("""
//                请求地址: %s
//                请求方式: %s
//                请求体参数: %s
//                响应状态码: %s
//                响应内容: %s
//                """, request.url(), request.method(), getRequestBody(request.body()), response.code(), getResponseBody(response.body()));
//    }

//    public String getResponseBody(ResponseBody body) {
//        try {
//            if (null != body) {
//                return body.string();
//            }
//        } catch (IOException ignored) {
//
//        }
//        return null;
//
//    }

//    public String getRequestBody(RequestBody body) {
//        if (null == body) {
//            return null;
//        }
//        Buffer buffer=new Buffer();
//        try {
//            body.writeTo(buffer);
//            return buffer.readString(StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
