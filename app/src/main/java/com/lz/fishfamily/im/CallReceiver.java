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
//            context.startActivity(new Intent(context, .class).
//                    putExtra("username", from).putExtra("isComingCall", true).
//                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } else {
            VoiceActivity.toActivity(context, from, true, true);
        }
    }
}
