package nya.nekoneko.bilibili.util;

import nya.nekoneko.bilibili.model.BilibiliLoginInfo;
import okhttp3.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static nya.nekoneko.bilibili.util.AppUtil.getSign;

/**
 * 包装一次请求
 */
public class BiliRequest {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final MediaType XML = MediaType.parse("application/xml");
    private static final MediaType OCTET_STREAM = MediaType.parse("application/octet-stream");
    private final Request.Builder builder = new Request.Builder();
    private String url;
    private final Map<String, String> paramMap = new HashMap<>();

    public BiliRequest url(String url) {
//        builder.url(url);
        this.url = url;
        return this;
    }

    public BiliRequest addParam(String key, Object value) {
        if (null != value) {
            paramMap.put(key, String.valueOf(value));
        }
        return this;
    }

    public BiliRequest url(String url, Map<String, String> params) {
        this.url = url;
        if (null != params) {
            for (Map.Entry<String, String> param : params.entrySet()) {
                this.paramMap.put(param.getKey(), param.getValue());
            }
        }
        return this;
    }

    private BiliRequest url1(String url, Map<String, String> params) {
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

    public BiliRequest get() {
        builder.get();
        return this;
    }

    public BiliRequest postJson(String json) {
        RequestBody body = RequestBody.create(json, JSON);
        builder.post(body);
        return this;
    }

    public BiliRequest postXml(String xml) {
        RequestBody body = RequestBody.create(xml, XML);
        builder.post(body);
        return this;
    }

    public BiliRequest postForm(Map<String, ?> form) {
        FormBody.Builder formBody = new FormBody.Builder();
        for (Map.Entry<String, ?> item : form.entrySet()) {
            if (null == item.getValue()) {
                continue;
            }
            formBody.add(item.getKey(), item.getValue().toString());
        }
        builder.post(formBody.build());
        return this;
    }

    public BiliRequest uploadFile(InputStream inputStream, String fileName, Map<String, String> form) throws IOException {
        RequestBody requestBody = RequestBody.create(inputStream.readAllBytes(), OCTET_STREAM);
        MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file_up", fileName, requestBody);
        for (Map.Entry<String, String> stringStringEntry : form.entrySet()) {
            multipartBodyBuilder.addFormDataPart(stringStringEntry.getKey(), stringStringEntry.getValue());
        }
        builder.post(multipartBodyBuilder.build());
        return this;
    }

    public BiliRequest post(byte[] b) {
        builder.post(RequestBody.create(b, OCTET_STREAM));
        return this;
    }

    public BiliRequest put(byte[] b) {
        builder.put(RequestBody.create(b, OCTET_STREAM));
        return this;
    }

    public BiliRequest cookie(BilibiliLoginInfo loginInfo) {
        if (null != loginInfo) {
            String cookie = "SESSDATA=" + loginInfo.getSESSDATA() + "; ";
            builder.header("Cookie", cookie);
        }
        return this;
    }

    public BiliRequest appSign(BilibiliLoginInfo loginInfo) {
        if (null != loginInfo) {
            String sign = getSign(paramMap, "560c52ccd288fed045859ed18bffd973");
            addParam("sign", sign);
        }
        return this;
    }

    public Request buildRequest() {
        url1(this.url, this.paramMap);
        addHeaders();
        return builder.build();
    }

    /**
     * 添加一些通用的Header
     */
    private void addHeaders() {
        builder.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36 Edg/98.0.1108.62");
    }

    /**
     * 添加Header
     */
    public BiliRequest header(String name, String value) {
        builder.header(name, value);
        return this;
    }
}
