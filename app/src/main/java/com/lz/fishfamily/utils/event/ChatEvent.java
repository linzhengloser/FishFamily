package com.lz.fishfamily.utils.event;

import com.lz.library.utils.BaseEvent;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/08
 *     desc   : 聊天 Event
 *     version: 1.0
 * </pre>
 */
public class ChatEvent<T> extends BaseEvent<T> {

    public static final int EVENT_TYPE_RFRESH_SINGLE_ITEM = 1;

    public static final int EVENT_TYPE_REFRESH_CONVERSATION = 2;

    public ChatEvent(int eventType, T data) {
        super(eventType, data);
    }

    public ChatEvent(int eventType) {
        super(eventType);
    }
}
