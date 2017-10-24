package com.lz.fishfamily.im;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/06
 *     desc   : IM 管理者
 *     version: 1.0
 * </pre>
 */
public class IMManager {

    /**
     * 用来存储 Activity 但是只会添加 MainActivity 和 ChatActivity
     * 因为这两个Activity 需要让 全局的消息监听失效 从而使用其内部的消息监听器
     */
    private static List<Activity> sActivityList = new ArrayList<>();

    public static void pushActivity(Activity activity) {
        if (!sActivityList.contains(activity)) {
            sActivityList.add(0, activity);
        }
    }

    public static void popActivity(Activity activity) {
        sActivityList.remove(activity);
    }

    public static boolean hasForegroundActivies() {
        return sActivityList.size() != 0;
    }

}
