package com.lz.fishfamily.ui.activity.chatfreely;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseArray;

import com.hyphenate.EMError;
import com.hyphenate.chat.EMCallManager;
import com.hyphenate.chat.EMCallStateChangeListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.EMNoActiveCallException;
import com.hyphenate.exceptions.EMServiceNotReadyException;
import com.lz.fishfamily.Constant;
import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.library.utils.ToastUtils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/10
 *     desc   : 语音通话 or 视频通话
 *     version: 1.0
 * </pre>
 */
public abstract class CallActivity extends BaseActivity implements EMCallStateChangeListener {

    public static final int CALL_STATE_CANCELLED = 22;

    public static final int CALL_STATE_NORMAL = 23;

    public static final int CALL_STATE_REFUSED = 24;

    public static final int CALL_STATE_BE_REFUSED = 25;

    public static final int CALL_STATE_UNANSWERED = 26;

    public static final int CALL_STATE_OFFLINE = 27;

    public static final int CALL_STATE_NO_RESPONSE = 28;

    public static final int CALL_STATE_BUSY = 29;

    public static final int CALL_STATE_VERSION_NOT_SAME = 30;

    //发起视屏聊天
    protected static final int MESSAGE_WHAT_MAKE_VIDEO = 1;

    //发起语音聊天
    protected static final int MESSAGE_WHAT_MAKE_VOICE = 2;

    //接听
    protected static final int MESSAGE_WHAT_ANSWER = 3;

    //拒绝
    protected static final int MESSAGE_WHAT_REJECT = 4;

    //结束
    protected static final int MESSAGE_WHAT_END = 5;

    //释放 Handler
    protected static final int MESSAGE_WHAT_RELEASE_HANDLER = 6;

    //切换摄像头
    protected static final int MESSAGE_WHAT_SWITCH_CAMERA = 7;

    private static String sTextArray[] = {
            "已取消",//0
            "通话时长",//1
            "已拒绝",//2
            "对方已拒绝",//3
            "未接听",//4
            "对方不在线",//5
            "对方未接听",//6
            "对方正在通话中",//7
            "通话协议版本不一致",//8
            "尚未链接至服务器",//9
            "用户名不合法",//10
            "链接不到聊天服务器"//11
    };

    protected static SparseArray<String> sCallStateMap = new SparseArray<>();

    protected static SparseArray<String> sCallErrorCodeMap = new SparseArray<>();

    static {
        sCallStateMap.put(CALL_STATE_CANCELLED, sTextArray[0]);
        sCallStateMap.put(CALL_STATE_NORMAL, sTextArray[1]);
        sCallStateMap.put(CALL_STATE_REFUSED, sTextArray[2]);
        sCallStateMap.put(CALL_STATE_BE_REFUSED, sTextArray[3]);
        sCallStateMap.put(CALL_STATE_UNANSWERED, sTextArray[4]);
        sCallStateMap.put(CALL_STATE_OFFLINE, sTextArray[5]);
        sCallStateMap.put(CALL_STATE_NO_RESPONSE, sTextArray[6]);
        sCallStateMap.put(CALL_STATE_BUSY, sTextArray[7]);
        sCallStateMap.put(CALL_STATE_VERSION_NOT_SAME, sTextArray[8]);

        sCallErrorCodeMap.put(EMError.CALL_REMOTE_OFFLINE, sTextArray[5]);
        sCallErrorCodeMap.put(EMError.USER_NOT_LOGIN, sTextArray[9]);
        sCallErrorCodeMap.put(EMError.INVALID_USER_NAME, sTextArray[10]);
        sCallErrorCodeMap.put(EMError.CALL_BUSY, sTextArray[7]);
        sCallErrorCodeMap.put(EMError.NETWORK_ERROR, sTextArray[11]);

    }

    protected AudioManager mAudioManager;

    //true 呼入 false 呼出
    protected boolean mIsCall;

    //true 已接听 false 未接听
    protected boolean mIsAnswered;

    //环信ID
    protected String mUserId;

    //呼叫类型 0 语音 1 视频
    protected int mCallType = 0;

    //是否挂断
    protected boolean mIsRefused;

    //通话类型
    protected int mCallState = CALL_STATE_CANCELLED;

    protected SoundPool mSoundPool;

    protected int mOutgoing;

    protected int mStreamID = -1;

    protected Ringtone mRingtone;

    EMCallManager.EMCallPushProvider mPushProvider;

    @Override
    protected void initViewsAndEvents() {

        mUserId = getIntent().getStringExtra(Constant.Chat.INTENT_KEY_CHAT_USER_ID);
        mIsCall = getIntent().getBooleanExtra(Constant.Chat.INTENT_KEY_IS_CALL, true);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        mPushProvider = new EMCallManager.EMCallPushProvider() {
            @Override
            public void onRemoteOffline(String s) {

            }
        };
        EMClient.getInstance().callManager().setPushProvider(mPushProvider);

        //初始化声音
        mSoundPool = new SoundPool(1, AudioManager.STREAM_RING, 0);
        mOutgoing = mSoundPool.load(this, R.raw.em_outgoing, 1);

        //初始化铃声
        Uri ringUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        mAudioManager.setMode(AudioManager.MODE_RINGTONE);
        mAudioManager.setSpeakerphoneOn(true);
        mRingtone = RingtoneManager.getRingtone(this, ringUri);

        EMClient.getInstance().callManager().addCallStateChangeListener(this);
    }

    @Override
    protected void onDestroy() {
        if (mSoundPool != null)
            mSoundPool.release();
        if (mRingtone != null && mRingtone.isPlaying())
            mRingtone.stop();
        mAudioManager.setMode(AudioManager.MODE_NORMAL);
        mAudioManager.setMicrophoneMute(false);

        EMClient.getInstance().callManager().removeCallStateChangeListener(this);

        if (mPushProvider != null) {
            EMClient.getInstance().callManager().setPushProvider(mPushProvider);
            mPushProvider = null;
        }
        mHandler.sendEmptyMessage(MESSAGE_WHAT_RELEASE_HANDLER);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        mHandler.sendEmptyMessage(MESSAGE_WHAT_END);
        saveCallRecord();
        finish();
        super.onBackPressed();
    }

    private HandlerThread mCallHandlerThread = new HandlerThread("callHandlerThread");

    {
        mCallHandlerThread.start();
    }

    protected Handler mHandler = new Handler(mCallHandlerThread.getLooper()) {
        @Override
        public void handleMessage(Message msg) {
            try {
                switch (msg.what) {
                    case MESSAGE_WHAT_MAKE_VIDEO:
                        EMClient.getInstance().callManager().makeVideoCall(mUserId);
                        break;
                    case MESSAGE_WHAT_MAKE_VOICE:
                        EMClient.getInstance().callManager().makeVoiceCall(mUserId);
                        break;
                    case MESSAGE_WHAT_ANSWER:
                        if (mRingtone != null) mRingtone.stop();
                        if (mIsCall) try {
                            EMClient.getInstance().callManager().answerCall();
                            mIsAnswered = true;
                        } catch (EMNoActiveCallException e) {
                            saveCallRecord();
                            finish();
                        }
                        break;
                    case MESSAGE_WHAT_REJECT:
                        if (mRingtone != null)
                            mRingtone.stop();
                        try {
                            EMClient.getInstance().callManager().rejectCall();
                        } catch (Exception e) {
                            e.printStackTrace();
                            saveCallRecord();
                            finish();
                        }
                        mCallState = CALL_STATE_REFUSED;
                        break;
                    case MESSAGE_WHAT_END:
                        if (mSoundPool != null)
                            mSoundPool.stop(mStreamID);
                        try {
                            EMClient.getInstance().callManager().endCall();
                        } catch (Exception e) {
                            saveCallRecord();
                            finish();
                        }
                        break;
                    case MESSAGE_WHAT_RELEASE_HANDLER:
                        try {
                            EMClient.getInstance().callManager().endCall();
                        } catch (Exception e) {
                        }
                        mHandler.removeCallbacks(mTimeOutHangup);
                        mHandler.removeMessages(MESSAGE_WHAT_MAKE_VIDEO);
                        mHandler.removeMessages(MESSAGE_WHAT_MAKE_VIDEO);
                        mHandler.removeMessages(MESSAGE_WHAT_ANSWER);
                        mHandler.removeMessages(MESSAGE_WHAT_REJECT);
                        mHandler.removeMessages(MESSAGE_WHAT_END);
                        mCallHandlerThread.quit();
                        break;
                    case MESSAGE_WHAT_SWITCH_CAMERA:
                        EMClient.getInstance().callManager().switchCamera();
                        break;
                }
            } catch (EMServiceNotReadyException e) {
                e.printStackTrace();
                handleCallCatch(e);
            }
        }
    };

    protected Runnable mTimeOutHangup = () -> mHandler.sendEmptyMessage(MESSAGE_WHAT_END);


    /**
     * 处理呼叫异常
     */
    private void handleCallCatch(EMServiceNotReadyException e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(sCallErrorCodeMap.get(e.getErrorCode()) != null ? sCallErrorCodeMap.get(e.getErrorCode()) : e.getMessage());
                finish();
            }
        });
    }


    /**
     * 播放来电铃声
     */
    protected int playMakeCallSounds() {
        try {
            mAudioManager.setMode(AudioManager.MODE_RINGTONE);
            mAudioManager.setSpeakerphoneOn(true);
            // play
            int id = mSoundPool.play(mOutgoing, // sound resource
                    0.3f, // left volume
                    0.3f, // right volume
                    1,    // priority
                    -1,   // loop，0 is no loop，-1 is loop forever
                    1);   // playback rate (1.0 = normal playback, range 0.5 to 2.0)
            return id;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 开启扬声器
     */
    protected void openSpeakerOn() {
        try {
            if (!mAudioManager.isSpeakerphoneOn())
                mAudioManager.setSpeakerphoneOn(true);
            mAudioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭扬声器
     */
    protected void closeSpeakerOn() {
        try {
            if (mAudioManager != null) {
                if (mAudioManager.isSpeakerphoneOn())
                    mAudioManager.setSpeakerphoneOn(false);
                mAudioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 保存呼叫记录消息
     */
    protected void saveCallRecord() {
//        EMMessage message = null;
//        EMTextMessageBody txtBody = null;
//        if (!mIsCall) { // outgoing call
//            message = EMMessage.createSendMessage(EMMessage.Type.TXT);
//            message.setTo(mUserId);
//        } else {
//            message = EMMessage.createReceiveMessage(EMMessage.Type.TXT);
//            message.setFrom(mUserId);
//        }
//
//        if (mCallType == 0)
//            message.setAttribute("is_voice_call", true);
//        else
//            message.setAttribute("is_video_call", true);
//
//        message.addBody(txtBody);
//        message.setMsgId(UUID.randomUUID().toString());
//        message.setStatus(EMMessage.Status.SUCCESS);
//
//        EMClient.getInstance().chatManager().saveMessage(message);
    }

    private static void toActivity(Context context, Class clazz, String userId, boolean isCall, boolean isNewTask) {
        Intent intent = new Intent(context, clazz);
        intent.putExtra(Constant.Chat.INTENT_KEY_CHAT_USER_ID, userId);
        intent.putExtra(Constant.Chat.INTENT_KEY_IS_CALL, isCall);
        if (isNewTask) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void toVoiceActivity(Context context, String userId, boolean isCall, boolean isNewTask) {
        toActivity(context, VoiceActivity.class, userId, isCall, isNewTask);
    }

    public static void toVideoActivity(Context context, String userId, boolean isCall, boolean isNewTask) {
        toActivity(context, VideoActivity.class, userId, isCall, isNewTask);
    }

}
