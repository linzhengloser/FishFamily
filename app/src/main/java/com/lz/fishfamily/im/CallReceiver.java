package com.lz.fishfamily.im;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.hyphenate.chat.EMClient;
import com.lz.fishfamily.ui.activity.chatfreely.VoiceActivity;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/10
 *     desc   : 呼入和呼出的 Receiver
 *     version: 1.0
 * </pre>
 */
public class CallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (!EMClient.getInstance().isLoggedInBefore())
            return;
        //username
        String from = intent.getStringExtra("from");
        //call type
        String type = intent.getStringExtra("type");
        if ("video".equals(type)) {
            //视频呼入
        } else {
            //语音呼入
            VoiceActivity.toVoiceActivity(context, from, true, true);
        }
    }
}
