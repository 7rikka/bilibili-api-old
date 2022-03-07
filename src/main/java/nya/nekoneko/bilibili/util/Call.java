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
            .readTimeout(Duration.ofSeconds(30))
            .connectTimeout(Duration.ofSeconds(30))
            .callTimeout(Duration.ofSeconds(30))
            .build();

    public static BiliResult doCall(Request request) {
        try {
            Response response = client.newCall(request).execute();
            if (200 != response.code()) {
                throw new RequestException(request, response, "HTTP CODE: " + response.code());
            }
            ResponseBody body = response.body();
            if (null == body) {
                throw new RequestException(request, response, "Body为空");
            }
            return ONode.deserialize(body.string(), BiliResult.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RequestException(request, null, e.getMessage());
        }
    }
}
