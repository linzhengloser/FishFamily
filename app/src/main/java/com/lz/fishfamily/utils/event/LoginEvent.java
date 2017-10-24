package com.lz.fishfamily.utils.event;

import com.lz.library.utils.BaseEvent;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/12
 *     desc   : Login Evnet
 *     version: 1.0
 * </pre>
 */
public class LoginEvent<T> extends BaseEvent<T> {

    public static final int EVENT_TYPE_GET_USER_INFO = 1;

    public static final int EVENT_TYPE_FISH_EXPERIENCE_SELECTED = 2;

    public static final int EVENT_TYPE_FISH_CATEGORY_SELECTED = 3;

    public LoginEvent(int eventType) {
        super(eventType);
    }

    public LoginEvent(T data) {
        super(data);
    }

    public LoginEvent(int eventType, T data) {
        super(eventType, data);
    }
}
