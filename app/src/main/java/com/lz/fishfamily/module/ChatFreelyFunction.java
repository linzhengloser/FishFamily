package com.lz.fishfamily.module;

import android.util.SparseArray;

import com.lz.fishfamily.R;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ChatFreelyFunction {

    //加入同城群
    public static final int FUNCTION_TYPE_JOIN_SAME_GROUP = 1;

    //鱼友小助手
    public static final int FUNCTION_TYPE_FISH_FRIEND_HELPER = 2;

    //系统通知
    public static final int FUNCTION_TYPE_SYSTEM_NOTIFICATION = 3;

    //留言评论
    public static final int FUNCTION_TYPE_COMMENT = 4;

    public static SparseArray<String> sFunctionTextMap = new SparseArray<>();

    public static SparseArray<Integer> sFuncationImageMap = new SparseArray<>();

    static {
        sFunctionTextMap.put(FUNCTION_TYPE_JOIN_SAME_GROUP, "加入同城群");
        sFunctionTextMap.put(FUNCTION_TYPE_FISH_FRIEND_HELPER, "鱼友小助手");
        sFunctionTextMap.put(FUNCTION_TYPE_SYSTEM_NOTIFICATION, "系统通知");
        sFunctionTextMap.put(FUNCTION_TYPE_COMMENT, "留言评论");

        sFuncationImageMap.put(FUNCTION_TYPE_JOIN_SAME_GROUP, R.drawable.chat_freely_function_join_same_group);
        sFuncationImageMap.put(FUNCTION_TYPE_FISH_FRIEND_HELPER, R.drawable.chat_freely_function_fish_friend_helper);
        sFuncationImageMap.put(FUNCTION_TYPE_SYSTEM_NOTIFICATION, R.drawable.chat_freely_function_system_notification);
        sFuncationImageMap.put(FUNCTION_TYPE_COMMENT, R.drawable.chat_freely_function_comment);
    }

    private int imageResId;

    private String text;

    private int type;

    public ChatFreelyFunction(int type) {
        this.type = type;
        this.text = sFunctionTextMap.get(getType());
        this.imageResId = sFuncationImageMap.get(getType());
    }

    public int getImageResId() {
        return imageResId;
    }

    public ChatFreelyFunction setImageResId(int imageResId) {
        this.imageResId = imageResId;
        return this;
    }

    public String getText() {
        return text;
    }

    public int getType() {
        return type;
    }

    public ChatFreelyFunction setType(int type) {
        this.type = type;
        return this;
    }
}
