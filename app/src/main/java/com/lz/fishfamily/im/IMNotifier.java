package com.lz.fishfamily.im;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v4.util.ArrayMap;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.util.EasyUtils;
import com.lz.fishfamily.MyApplication;

import java.util.HashSet;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/05
 *     desc   : 即时通讯的消息通知管理
 *     version: 1.0
 * </pre>
 */
public class IMNotifier {

    private static final int NOTIFY_ID = 0525;

    private static final int FOREGROUND_NOTIFY_ID = 0555;

    private static ArrayMap<EMMessage.Type, String> sNotifyTextMap;

    private static String sMsgs[] = {"发来一条消息", "发来一张图片", "发来一段语音", "发来位置信息", "发来一个视频", "发来一个文件",
            "%1个联系人发来%2条消息"};

    static {
        sNotifyTextMap = new ArrayMap<>();
        sNotifyTextMap.put(EMMessage.Type.TXT, sMsgs[0]);
        sNotifyTextMap.put(EMMessage.Type.IMAGE, sMsgs[1]);
        sNotifyTextMap.put(EMMessage.Type.VOICE, sMsgs[2]);
        sNotifyTextMap.put(EMMessage.Type.LOCATION, sMsgs[3]);
        sNotifyTextMap.put(EMMessage.Type.VIDEO, sMsgs[4]);
        sNotifyTextMap.put(EMMessage.Type.FILE, sMsgs[5]);
    }

    NotificationManager mNotificationManager = null;
    AudioManager mAudioManager;
    int mNotifyNumber;

    HashSet<String> mFromUsers = new HashSet<>();

    long mLastNotifiyTime;

    Ringtone mRingtone;

    Vibrator mVibrator;

    private IMNotifier() {
        mNotificationManager = (NotificationManager) MyApplication.getInstance().getSystemService(Context.NOTIFICATION_SERVICE);
        mAudioManager = (AudioManager) MyApplication.getInstance().getSystemService(Context.AUDIO_SERVICE);
        mVibrator = (Vibrator) MyApplication.getInstance().getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void reset() {
        resetNotificationCount();
        cancelNotificaton();
    }

    public void resetNotificationCount() {
        mNotifyNumber = 0;
        mFromUsers.clear();
    }

    public void cancelNotificaton() {
        if (mNotificationManager != null)
            mNotificationManager.cancel(NOTIFY_ID);
    }

    public synchronized void onNewMsg(EMMessage message) {
        sendNotification(message, !EasyUtils.isAppRunningForeground(MyApplication.getInstance()), true);
        vibrateAndPlayTone();
    }

    private void sendNotification(EMMessage message, boolean isForeground, boolean numIncrease) {
        String userName = message.getFrom();
        StringBuffer notifyText = new StringBuffer(userName).append(" ").append(sNotifyTextMap.get(message.getType()));
        String notifyTitile = (String) MyApplication.getInstance().getPackageManager().getApplicationLabel(MyApplication.getInstance().getApplicationInfo());
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MyApplication.getInstance())
                .setSmallIcon(MyApplication.getInstance().getApplicationInfo().icon)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true);
        Intent notifyIntent = MyApplication.getInstance().getPackageManager().getLaunchIntentForPackage(MyApplication.getInstance().getApplicationInfo().packageName);
        PendingIntent pendingIntent = PendingIntent.getActivity(MyApplication.getInstance(), NOTIFY_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (numIncrease) {
            if (!isForeground) {
                mNotifyNumber++;
                mFromUsers.add(userName);
            }
        }

        String summaryBody = sMsgs[6]
                .replaceFirst("%1", String.valueOf(mFromUsers.size()))
                .replaceFirst("%2", String.valueOf(mNotifyNumber));

        mBuilder.setContentTitle(notifyTitile);
        mBuilder.setTicker(notifyText);
        mBuilder.setContentText(summaryBody);
        mBuilder.setContentIntent(pendingIntent);

        Notification notification = mBuilder.build();

        if (isForeground) {
            mNotificationManager.notify(FOREGROUND_NOTIFY_ID, notification);
            mNotificationManager.cancel(FOREGROUND_NOTIFY_ID);
        } else {
            mNotificationManager.notify(NOTIFY_ID, notification);
        }

    }

    /**
     * 震动和播放提示音
     */
    public void vibrateAndPlayTone() {
        if (System.currentTimeMillis() - mLastNotifiyTime < 1000) {
            return;
        }
        mLastNotifiyTime = System.currentTimeMillis();
        if (mAudioManager.getRingerMode() == AudioManager.RINGER_MODE_SILENT)
            return;
        long[] pattern = new long[]{0, 180, 80, 120};
        mVibrator.vibrate(pattern, -1);
        if (mRingtone == null) {
            Uri notificationUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            mRingtone = RingtoneManager.getRingtone(MyApplication.getInstance(), notificationUri);
        }
        if (!mRingtone.isPlaying()) {
            String vendor = Build.MANUFACTURER;
            mRingtone.play();
            //samsuang bug
            if (vendor != null && vendor.toLowerCase().contains("samsung")) {
                Thread ctlThread = new Thread() {
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            if (mRingtone.isPlaying()) {
                                mRingtone.stop();
                            }
                        } catch (Exception e) {
                        }
                    }
                };
                ctlThread.run();
            }
        }

    }


    public static final class SingletonHolder {
        public static final IMNotifier INSTANCE = new IMNotifier();
    }

    public static IMNotifier getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
