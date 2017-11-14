package com.lz.fishfamily.utils;

import com.google.gson.Gson;

import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.ImageView;

import com.lz.fishfamily.R;
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

    private static SparseArray<Integer> sUserLevelMap = new SparseArray<>();

    static {
        sUserLevelMap.put(1, R.drawable.mine_level_one);
        sUserLevelMap.put(2, R.drawable.mine_level_two);
        sUserLevelMap.put(3, R.drawable.mine_level_three);
        sUserLevelMap.put(4, R.drawable.mine_level_four);
        sUserLevelMap.put(5, R.drawable.mine_level_five);
        sUserLevelMap.put(6, R.drawable.mine_level_six);

    }

    private static User sUser;


    public static User getUser() {
        if (sUser == null) sUser = getUserFromCache();
        return sUser;
    }

    /**
     * 是否登录
     */
    public static boolean isLogin() {
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

    /**
     * 设置鱼豆
     *
     * @param fishMoney 要增加的鱼豆
     */
    public static void setUserFishMoney(int fishMoney) {
        sUser.setUserInfo_Integer(sUser.getUserInfo_Integer() + fishMoney);
        saveUserJson(sUser);
    }

    public static void bindUserLevel(ImageView imageView, int level) {

    }

}
