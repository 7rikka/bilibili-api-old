package cc.nekoneko.bilibili.util;

import cc.nekoneko.bilibili.model.BilibiliLoginInfo;
import okhttp3.*;

import java.util.Map;
import java.util.Objects;

/**
 * 包装一次请求
 */
public class BilibiliRequest {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final Request.Builder builder = new Request.Builder();

    public BilibiliRequest url(String url) {
        builder.url(url);
        return this;
    }

    public BilibiliRequest url(String url, Map<String, String> params) {
        HttpUrl httpUrl = HttpUrl.parse(url);
        HttpUrl.Builder httpBuilder = Objects.requireNonNull(httpUrl).newBuilder();
        if (null != params) {
            for (Map.Entry<String, String> param : params.entrySet()) {
                httpBuilder.addQueryParameter(param.getKey(), param.getValue());
            }
        }
        builder.url(httpBuilder.build());
        return this;
    }

    public BilibiliRequest get() {
        builder.get();
        return this;
    }

    public BilibiliRequest postJson(String json) {
        RequestBody body = RequestBody.create(json, JSON);
        builder.post(body);
        return this;
    }
    public BilibiliRequest postForm(Map<String,String> form) {
        FormBody.Builder formBody = new FormBody.Builder();
        for (Map.Entry<String, String> item : form.entrySet()) {
            formBody.add(item.getKey(), item.getValue());
        }
        builder.post(formBody.build());
        return this;
    }
    public BilibiliRequest cookie(BilibiliLoginInfo loginInfo){
        String cookie = "SESSDATA="+loginInfo.getSESSDATA()+"; ";
        builder.header("Cookie", cookie);
        return this;
    }

    public Request buildRequest() {
        return builder.build();
    }


}
