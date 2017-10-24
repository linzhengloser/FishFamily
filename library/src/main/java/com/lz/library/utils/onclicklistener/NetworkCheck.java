package com.lz.library.utils.onclicklistener;

import android.view.View;

import com.hyphenate.util.NetUtils;
import com.lz.library.LibraryApplication;
import com.lz.library.utils.ToastUtils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/12
 *     desc   : 网络检查
 *     version: 1.0
 * </pre>
 */
public class NetworkCheck implements Check {

    @Override
    public boolean isChechSuccess(View view) {
        return NetUtils.hasNetwork(LibraryApplication.getInstance());
    }

    @Override
    public void checkFailure(View view) {
        ToastUtils.showNoNetWorkToast();
    }
}
