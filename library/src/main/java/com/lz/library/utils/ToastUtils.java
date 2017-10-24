package com.lz.library.utils;

import android.content.Context;
import android.widget.Toast;

import com.lz.library.BuildConfig;
import com.lz.library.LibraryApplication;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/18
 *     desc   : Toast Utils
 *     version: 1.0
 * </pre>
 */
public class ToastUtils {

    private static Toast sToast;

    public static void showToast(Context context, String msg) {
        if (sToast == null) {
            sToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(msg);

        }
        sToast.show();
    }

    public static void showToast(String msg) {
        showToast(LibraryApplication.getInstance(), msg);
    }


    public static void showDebugToast(String msg) {
        if (!BuildConfig.DEBUG) return;
        showToast(LibraryApplication.getInstance(), msg);
    }

    public static void showNoNetWorkToast() {
        showToast("请检查网络");
    }
}
