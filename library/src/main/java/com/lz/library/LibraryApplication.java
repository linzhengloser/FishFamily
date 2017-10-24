package com.lz.library;

import android.app.Application;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/12
 *     desc   : MyApplication
 *     version: 1.0
 * </pre>
 */
public class LibraryApplication extends Application {

    private static Application sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static Application getInstance() {
        return sInstance;
    }
}
