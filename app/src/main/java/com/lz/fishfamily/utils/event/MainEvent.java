package com.lz.fishfamily.utils.event;

import com.lz.library.utils.BaseEvent;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/19
 *     desc   : 首页 Event
 *     version: 1.0
 * </pre>
 */
public class MainEvent<T> extends BaseEvent<T> {

    public static final int EVENT_TYPE_SHOP_MAIN_CHANGE_TAB = 2333;

    public MainEvent(int eventType) {
        super(eventType);
    }

    public MainEvent(T data) {
        super(data);
    }

    public MainEvent(int eventType, T data) {
        super(eventType, data);
    }
}
