package com.lz.fishfamily.utils.im.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/01
 *     desc   : SQLiteHelper
 *     version: 1.0
 * </pre>
 */
public class MySQLiteDBHelper extends SQLiteOpenHelper {

    public MySQLiteDBHelper(Context context) {
        super(context, "FishFamily.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE IF NOT EXISTS Users ( id integer primary key, userId text, userNickName text, userAvatar text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + "FishFamily.db");
        onCreate(db);
    }
}
