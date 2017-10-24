package com.lz.fishfamily.utils.rxjava;


import com.hyphenate.util.NetUtils;
import com.lz.fishfamily.MyApplication;
import com.lz.library.utils.ToastUtils;
import com.lz.library.utils.ApiException;

import java.net.UnknownHostException;

import io.reactivex.functions.Consumer;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class HandlerApiResultCosumer implements Consumer<Throwable> {

    @Override
    public void accept(Throwable throwable) throws Exception {
        if (throwable instanceof ApiException) {
            ToastUtils.showToast(((ApiException) throwable).getErrorMessage());
        } else {
            if (throwable instanceof UnknownHostException && !NetUtils.hasNetwork(MyApplication.getInstance())) {
                ToastUtils.showNoNetWorkToast();
            } else {
                ToastUtils.showDebugToast("程序内部异常。" + throwable.getMessage());
            }
        }
    }
}
