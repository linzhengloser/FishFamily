package com.lz.library.utils.interceptor;

import com.hyphenate.util.NetUtils;
import com.lz.library.LibraryApplication;
import com.lz.library.utils.ToastUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/12
 *     desc   : 网络拦截器
 *     version: 1.0
 * </pre>
 */
public class NetworkInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        if (NetUtils.hasNetwork(LibraryApplication.getInstance())) {
            ToastUtils.showNoNetWorkToast();
            return null;
        } else
            return chain.proceed(chain.request());
    }
}
