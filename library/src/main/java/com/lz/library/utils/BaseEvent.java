package com.lz.library.utils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/08
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class BaseEvent<T> {

    public static int EVENT_TYPE_SELECT_IMAGE = 2333;

    public static int EVENT_TYPE_SELECT_VIDEO = 2334;

    private int eventType;

    private T data;

    public BaseEvent(int eventType) {
        this.eventType = eventType;
    }

    public BaseEvent(T data) {
        this.data = data;
    }

    public BaseEvent(int eventType, T data) {
        this.eventType = eventType;
        this.data = data;
    }

    public int getEventType() {
        return eventType;
    }

    public BaseEvent setEventType(int eventType) {
        this.eventType = eventType;
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseEvent setData(T data) {
        this.data = data;
        return this;
    }
}
