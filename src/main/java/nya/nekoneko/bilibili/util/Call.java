package nya.nekoneko.bilibili.util;

import nya.nekoneko.bilibili.exception.RequestException;
import nya.nekoneko.bilibili.model.BiliResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.noear.snack.ONode;

import java.io.IOException;
import java.time.Duration;

/**
 * 发起网络请求
 */
public class Call {
    private static final OkHttpClient client = new OkHttpClient().newBuilder()
            .readTimeout(Duration.ofSeconds(100))
            .connectTimeout(Duration.ofSeconds(100))
            .callTimeout(Duration.ofSeconds(100))
            .build();
    private static final int SUCCESS = 200;
//    static {
//        client.dispatcher().setMaxRequestsPerHost(16);
//        client.dispatcher().setMaxRequests(16);
//    }

    public static BiliResult doCall(Request request) {
        String result = doCallGetString(request);
//        System.out.println(result);
        return ONode.deserialize(result, BiliResult.class);
    }

    public static String doCallGetString(Request request) {
        try {
            Response response = client.newCall(request).execute();
            if (SUCCESS != response.code()) {
                String body = null;
                if (null != response.body()) {
                    body = response.body().string();
                }
                throw new RequestException(request, response, "HTTP CODE: " + response.code(), body);
            }
            ResponseBody body = response.body();
            if (null == body) {
                throw new RequestException(request, response, "Body为空");
            }
            BiliRequestHandler.process(response.headers());
            return body.string().strip();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RequestException(request, null, e.getMessage());
        }
    }

    public static byte[] doCallGetBytes(Request request) {
        try {
            Response response = client.newCall(request).execute();
            if (200 != response.code()) {
                System.out.println(response.body().string());
                throw new RequestException(request, response, "HTTP CODE: " + response.code());
            }
            ResponseBody body = response.body();
            if (null == body) {
                throw new RequestException(request, response, "Body为空");
            }
            return body.bytes();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RequestException(request, null, e.getMessage());
        }
    }

    public static String doCallGetHeader(Request request, String headerName) {
        try {
            Response response = client.newCall(request).execute();
            if (200 != response.code()) {
//                System.out.println(response.body().string());
                throw new RequestException(request, response, "HTTP CODE: " + response.code());
            }
            return response.header(headerName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RequestException(request, null, e.getMessage());
        }
    }

    public static Response doCallGetResponse(Request request) {
        try {
            Response response = client.newCall(request).execute();
            if (SUCCESS != response.code()) {
                String body = null;
                if (null != response.body()) {
                    body = response.body().string();
                }
                throw new RequestException(request, response, "HTTP CODE: " + response.code(), body);
            }
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RequestException(request, null, e.getMessage());
        }
    }
}
