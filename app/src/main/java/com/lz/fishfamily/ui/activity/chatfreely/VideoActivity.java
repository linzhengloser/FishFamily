package com.lz.fishfamily.ui.activity.chatfreely;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/21
 *     desc   : 视屏聊天界面
 *     version: 1.0
 * </pre>
 */
public class VideoActivity extends CallActivity {

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        mCallType = 1;
    }

    @Override
    public void onCallStateChanged(CallState state, CallError error) {

    }

    @Override
    protected int getContentViewResourceID() {
        return 0;
    }
}
