package com.lz.fishfamily.api.interceptor;

import android.text.TextUtils;

import com.lz.fishfamily.utils.CacheUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/12
 *     desc   : 用来处理 Token 的 Interceptor
 *     version: 1.0
 * </pre>
 */
public class TokenInterceptor implements Interceptor {

    private static final String GET_TOKEN_URL = "http://fapi.whmnx.com/api/Home/GetToken?UserInfo_ID=" + CacheUtils.getUserId();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (TextUtils.isEmpty(request.header("token")))
            request = request.newBuilder().addHeader("token", CacheUtils.getToken()).build();
        Response response = chain.proceed(request);
        if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            String token = getToken();
            response = chain.proceed(request.newBuilder().addHeader("token", token).build());
        }
        return response;
    }

    public String getToken() {
        try {
            Response response = new OkHttpClient.Builder().build().newCall(new Request.Builder().url(GET_TOKEN_URL).build()).execute();
            return new JSONObject(response.body().toString()).getString("resultdata");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }
}
