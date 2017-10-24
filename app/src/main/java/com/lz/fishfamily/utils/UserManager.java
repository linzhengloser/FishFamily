package com.lz.fishfamily.utils;

import com.google.gson.Gson;

import android.text.TextUtils;
import android.widget.ImageView;

import com.lz.fishfamily.module.User;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/21
 *     desc   : 用户管理类
 *     version: 1.0
 * </pre>
 */
public class UserManager {


    private static User sUser;


    public static User getUser() {
        if (sUser == null) sUser = getUserFromCache();
        return sUser;
    }

    /**
     * 是否登录
     * @return
     */
    public static boolean isLoggin() {
        return !TextUtils.isEmpty(getUser().getUserInfo_ID());
    }


    public static User getUserFromCache() {
        User user = new User();
        String userJson = CacheUtils.getString("user_json");
        if (!TextUtils.isEmpty(userJson)) {
            user = new Gson().fromJson(userJson, User.class);
        }
        return user;
    }

    public static void saveUserJson(User user) {
        String userJson = new Gson().toJson(user);
        CacheUtils.put("user_json", userJson);
    }

    public static void clearUserJson() {
        CacheUtils.put("user_json", "");
    }

    public static void bindUserLevel(ImageView imageView, int level) {

    }

}
