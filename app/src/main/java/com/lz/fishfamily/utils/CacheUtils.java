package com.lz.fishfamily.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.lz.fishfamily.MyApplication;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class CacheUtils {

    private static final SharedPreferences CACHE_SHARED_PREFERENCES;

    private static final String KEY_TOKEN = "token";

    private static final String KEY_USER_ID = "";

    private static final String KEY_IM_USER_ID = "";

    static {
        CACHE_SHARED_PREFERENCES = MyApplication.getInstance().getSharedPreferences("cache", Context.MODE_PRIVATE);
    }

    public static void put(String key, Object value) {
        SharedPreferences.Editor editor = CACHE_SHARED_PREFERENCES.edit();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        }
        editor.apply();
    }

    public static String getString(String key) {
        return CACHE_SHARED_PREFERENCES.getString(key, "");
    }

    public static boolean getBoolean(String key) {
        return CACHE_SHARED_PREFERENCES.getBoolean(key, false);
    }

    public static int getInteger(String key) {
        return CACHE_SHARED_PREFERENCES.getInt(key, 0);
    }

    public static void saveToken(String token) {
        put(KEY_TOKEN, token);
    }

    public static void clearToken() {
        put(KEY_TOKEN, "");
    }

    public static String getToken() {
        return getString(KEY_TOKEN);
    }

    public static void saveUserId(String userId) {
        put(KEY_USER_ID, userId);
    }

    public static void clearUserId() {
        put(KEY_USER_ID, "");
    }

    public static String getUserId() {
        return getString(KEY_USER_ID);
    }


}
