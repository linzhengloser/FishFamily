package com.lz.fishfamily.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/18
 *     desc   : Api
 *     version: 1.0
 * </pre>
 */
public class Api {

    public static final String BASE_URL = "http://fapi.whmnx.com/api/";

    public static final String DEFAULT_TOKEN = "88888888888888888888888888888888";

    private static Retrofit sRetrofit;

    private static OkHttpClient sOkHttpClient;

    private static Gson sGson;

    /**
     * 创建 API
     */
    public static <T> T create(Class<T> clazz) {

        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(buildOkHttpClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(GsonConverterFactory.create(buildGson()))
                    .build();
        }

        return sRetrofit.create(clazz);
    }

    private static Gson buildGson() {
        if (sGson == null) {
            sGson = new GsonBuilder()
                    .create();
        }
        return sGson;
    }

    private static OkHttpClient buildOkHttpClient() {
        if (sOkHttpClient == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            sOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .addInterceptor(logging)
                    .build();
//            .addInterceptor(new TokenInterceptor())
        }
        return sOkHttpClient;
    }

}
