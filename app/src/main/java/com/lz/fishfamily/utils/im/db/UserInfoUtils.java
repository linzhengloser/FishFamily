package com.lz.fishfamily.utils.im.db;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;

import java.util.Map;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/01
 *     desc   : UserInfo 工具类，管理用户昵称和用户头像与环信账号的对应关系
 *     version: 1.0
 * </pre>
 */
public class UserInfoUtils {

    private static ArrayMap<String, UserInfo> mUserInfoCache = new ArrayMap<>();

    private static UserInfoDBHelper sUserInfoDBHelper = new UserInfoDBHelper();

    private static UserInfoUtils sInstance;

    public static UserInfoUtils getInstance() {
        if (sInstance == null) {
            synchronized (UserInfoUtils.class) {
                if (sInstance == null) {
                    sInstance = new UserInfoUtils();
                }
            }
        }
        return sInstance;
    }

    /**
     * 获取 UserInfo 对象
     */
    public UserInfo getUserInfo(Map ext) {
        UserInfo userInfo = parseExtJson(ext);
        UserInfo cacheUserInfo;
        cacheUserInfo = mUserInfoCache.get(userInfo.getUserId());
        if (cacheUserInfo != null) {
            if (isShouldUpdate(cacheUserInfo, userInfo))
                cacheUserInfo = updateCache(userInfo);
        } else {
            cacheUserInfo = sUserInfoDBHelper.queryUserInfoByUserId(userInfo.getUserId());
            if (cacheUserInfo != null) {
                if (isShouldUpdate(cacheUserInfo, userInfo)) {
                    cacheUserInfo = updateCache(userInfo);
                } else {
                    cacheUserInfo = userInfo;
                }
            } else {
                insertUserInfo(userInfo);
                cacheUserInfo = userInfo;
            }
        }
        return cacheUserInfo;
    }

    /**
     * 更新本地缓存和内存缓存
     */
    public static UserInfo updateCache(UserInfo newUserInfo) {
        //更新缓存
        mUserInfoCache.put(newUserInfo.getUserId(), newUserInfo);
        sUserInfoDBHelper.updateUserInfoByUserId(newUserInfo);
        return newUserInfo;
    }

    public static UserInfo insertUserInfo(UserInfo newUserInfo) {
        //更新缓存
        mUserInfoCache.put(newUserInfo.getUserId(), newUserInfo);
        //更新数据库
        sUserInfoDBHelper.insertUserInfo(newUserInfo);
        return newUserInfo;
    }

    /**
     * 判断是否需要更新
     */
    public static boolean isShouldUpdate(UserInfo cacheUserInfo, UserInfo newUserInfo) {
        return !cacheUserInfo.equals(newUserInfo);
    }

    private static UserInfo parseExtJson(Map extJson) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId((String) extJson.get("userId"));
        userInfo.setUserNickName((String) extJson.get("userNickName"));
        userInfo.setUserAvatar((String) extJson.get("userAvatar"));
        if (TextUtils.isEmpty(userInfo.getUserAvatar())) {
            userInfo.setUserAvatar("");
        }
        if (TextUtils.isEmpty(userInfo.getUserId())) {
            userInfo.setUserId("");
        }
        if (TextUtils.isEmpty(userInfo.getUserNickName())) {
            userInfo.setUserNickName("");
        }
        return userInfo;
    }


}
