package nya.nekoneko.bilibili.util;

import lombok.Data;
import nya.nekoneko.bilibili.exception.RequestException;
import nya.nekoneko.bilibili.model.BiliResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.noear.snack.ONode;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.time.Duration;

/**
 * 发起网络请求
 */
@Data
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
    private static ProxyProvider proxyProvider;

    public static void setProxyProvider(ProxyProvider proxyProvider) {
        Call.proxyProvider = proxyProvider;
    }

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
            if (200 != response.code() && 206 != response.code()) {
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

    public static InputStream doCallGetInputStream(Request request) {
        try {
            Response response = client.newCall(request).execute();
            if (200 != response.code() && 206 != response.code()) {
                System.out.println(response.body().string());
                throw new RequestException(request, response, "HTTP CODE: " + response.code());
            }
            ResponseBody body = response.body();
            if (null == body) {
                throw new RequestException(request, response, "Body为空");
            }
            return body.byteStream();
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

    public static BiliResult doCallWithProxy(Request request) {
        String proxy = proxyProvider.getProxy();
        String[] split = proxy.split(":");
        String ip = split[0];
        Integer port = Integer.valueOf(split[1]);

        OkHttpClient client = new OkHttpClient().newBuilder()
                .readTimeout(Duration.ofSeconds(100))
                .connectTimeout(Duration.ofSeconds(100))
                .callTimeout(Duration.ofSeconds(100))
                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip,port)))
                .build();
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
            return ONode.deserialize(body.string().strip(), BiliResult.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RequestException(request, null, e.getMessage());
        }
    }
}
