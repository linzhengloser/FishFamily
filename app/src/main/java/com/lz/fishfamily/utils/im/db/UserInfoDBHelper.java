package com.lz.fishfamily.utils.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.lz.fishfamily.MyApplication;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/01
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class UserInfoDBHelper {

    MySQLiteDBHelper mSQLiteDBHelper;

    public UserInfoDBHelper() {
        mSQLiteDBHelper = new MySQLiteDBHelper(MyApplication.getInstance());
    }

    public void addOrUpdateUserInfo(UserInfo userInfo) {
        UserInfo data = queryUserInfoByUserId(userInfo.getUserId());
        if (data != null) {
            updateUserInfoByUserId(userInfo);
        } else {
            insertUserInfo(userInfo);
        }
    }

    public UserInfo queryUserInfoByUserId(String userId) {
        SQLiteDatabase database = mSQLiteDBHelper.getReadableDatabase();
        Cursor users = null;
        UserInfo userInfo = null;
        try {
            users = database.query(
                    "users",
                    new String[]{"userId", "userNickName", "userAvatar"},
                    " userId = ?",
                    new String[]{String.valueOf(userId)},
                    null, null, null
            );
            while (users.moveToNext()) {
                userInfo = new UserInfo();
                userInfo.setUserId(users.getString(users.getColumnIndex("userId")));
                userInfo.setUserNickName(users.getString(users.getColumnIndex("userNickName")));
                userInfo.setUserAvatar(users.getString(users.getColumnIndex("userAvatar")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (users != null) users.close();
            if (database != null) database.close();
        }
        return userInfo;
    }

    public void updateUserInfoByUserId(UserInfo userInfo) {
        SQLiteDatabase database = mSQLiteDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userNickName", userInfo.getUserNickName());
        contentValues.put("userAvatar", userInfo.getUserAvatar());
        database.update("users", contentValues, " userId = ? ", new String[]{String.valueOf(userInfo.getUserId())});
        database.close();
    }

    public void insertUserInfo(UserInfo userInfo) {
        SQLiteDatabase database = mSQLiteDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userId", userInfo.getUserId());
        contentValues.put("userNickName", userInfo.getUserNickName());
        contentValues.put("userAvatar", userInfo.getUserAvatar());
        database.insertOrThrow("users", null, contentValues);
        database.close();
    }

}
