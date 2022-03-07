package nya.nekoneko.bilibili.util;

import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import okhttp3.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

/**
 * 包装一次请求
 */
public class BilibiliRequest {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final MediaType OCTET_STREAM = MediaType.parse("application/octet-stream");
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

    public BilibiliRequest postForm(Map<String, String> form) {
        FormBody.Builder formBody = new FormBody.Builder();
        for (Map.Entry<String, String> item : form.entrySet()) {
            formBody.add(item.getKey(), item.getValue());
        }
        builder.post(formBody.build());
        return this;
    }
    public BilibiliRequest uploadFile(InputStream inputStream,String fileName,Map<String, String> form) throws IOException {
        RequestBody requestBody = RequestBody.create(inputStream.readAllBytes(),OCTET_STREAM);
        MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file_up", fileName, requestBody);
        for (Map.Entry<String, String> stringStringEntry : form.entrySet()) {
            multipartBodyBuilder.addFormDataPart(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        builder.post(multipartBodyBuilder.build());
        return this;
    }

    public BilibiliRequest cookie(BilibiliLoginInfo loginInfo) {
        if (null != loginInfo) {
            String cookie = "SESSDATA=" + loginInfo.getSESSDATA() + "; ";
            builder.header("Cookie", cookie);
        }
        return this;
    }

    public Request buildRequest() {
        addHeaders();
        return builder.build();
    }

    /**
     * 添加一些通用的Header
     */
    public void addHeaders() {
        builder.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36 Edg/98.0.1108.62");
    }


}
