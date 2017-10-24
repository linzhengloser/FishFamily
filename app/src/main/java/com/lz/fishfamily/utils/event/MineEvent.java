package com.lz.fishfamily.utils.event;

import com.lz.library.utils.BaseEvent;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/15
 *     desc   : Mine Event
 *     version: 1.0
 * </pre>
 */
public class MineEvent<T> extends BaseEvent<T> {

    public MineEvent(int eventType) {
        super(eventType);
    }

    public MineEvent(T data) {
        super(data);
    }

    public MineEvent(int eventType, T data) {
        super(eventType, data);
    }

}
