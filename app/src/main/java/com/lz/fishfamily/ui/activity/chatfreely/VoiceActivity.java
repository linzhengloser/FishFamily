package com.lz.fishfamily.ui.activity.chatfreely;

import com.hyphenate.chat.EMCallStateChangeListener;
import com.lz.fishfamily.R;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/10
 *     desc   : 语音聊天界面
 *     version: 1.0
 * </pre>
 */
public class VoiceActivity extends CallActivity implements EMCallStateChangeListener {

    private boolean mIsHandsfreeState;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        mCallType = 0;
    }


    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_chat_voice;
    }


    @Override
    public void onCallStateChanged(CallState state, CallError error) {
        switch (state) {

            case CONNECTING:
                runOnUiThread(() -> {
                    //链接中
                });
                break;
            case CONNECTED:
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        //已经和对方建立连接
                    }
                });
                break;

            case ACCEPTED:
                mHandler.removeCallbacks(mTimeOutHangup);
                runOnUiThread(() -> {
                    try {
                        if (mSoundPool != null)
                            mSoundPool.stop(mStreamID);
                    } catch (Exception e) {
                    }
                    if (!mIsHandsfreeState)
                        closeSpeakerOn();
                    //show relay or direct call, for testing purpose
//                                ((TextView) findViewById(R.id.tv_is_p2p)).setText(EMClient.getInstance().callManager().isDirectCall()
//                                        ? R.string.direct_call : R.string.relay_call);
//                                chronometer.setVisibility(View.VISIBLE);
//                                chronometer.setBase(SystemClock.elapsedRealtime());
//                                chronometer.start();
//                                callStateTextView.setText(str4); 通话中
                    mCallState = CALL_STATE_NORMAL;
                });
                break;
            case NETWORK_UNSTABLE:
                runOnUiThread(() -> {
                    //网络连接错误
//                                netwrokStatusVeiw.setVisibility(View.VISIBLE);
//                                if (error == CallError.ERROR_NO_DATA) {
//                                    netwrokStatusVeiw.setText(R.string.no_call_data);
//                                } else {
//                                    netwrokStatusVeiw.setText(R.string.network_unstable);
//                                }
                });
                break;
            case NETWORK_NORMAL:
                runOnUiThread(new Runnable() {
                    public void run() {
                        //网络正常
//                                netwrokStatusVeiw.setVisibility(View.INVISIBLE);
                    }
                });
                break;
            case VOICE_PAUSE:
                runOnUiThread(() -> {
                    //语音暂停
                });
                break;
            case VOICE_RESUME:
                runOnUiThread(new Runnable() {
                    public void run() {
                        //语音继续 与上个方法相呼应
                    }
                });
                break;
            case DISCONNECTED:
                mHandler.removeCallbacks(mTimeOutHangup);
                final CallError fError = error;
                runOnUiThread(new Runnable() {
                    private void postDelayedCloseMsg() {
                        mHandler.postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        saveCallRecord();
                                        finish();
                                    }
                                });
                            }
                        }, 200);
                    }

                    @Override
                    public void run() {
//                                chronometer.stop();
//                                callDruationText = chronometer.getText().toString();
                        String text = null;
                        if (fError == CallError.REJECTED) {
                            mCallState = CALL_STATE_BEREFUSED;
                        } else if (fError == CallError.ERROR_TRANSPORT) {
                            text = "建立连接失败";
                        } else if (fError == CallError.ERROR_UNAVAILABLE) {
                            mCallState = CALL_STATE_OFFLINE;
                        } else if (fError == CallError.ERROR_BUSY) {
                            mCallState = CALL_STATE_BUSY;
                        } else if (fError == CallError.ERROR_NORESPONSE) {
                            mCallState = CALL_STATE_NO_RESPONSE;
                        } else if (fError == CallError.ERROR_LOCAL_SDK_VERSION_OUTDATED || fError == CallError.ERROR_REMOTE_SDK_VERSION_OUTDATED) {
                            mCallState = CALL_STATE_VERSION_NOT_SAME;
                        } else {
                            if (mIsRefused) {
                                mCallState = CALL_STATE_REFUSED;
                            } else if (mIsAnswered) {
                                mCallState = CALL_STATE_NORMAL;
                                text = "对方已经挂断";
//                                        if (endCallTriggerByMe) {
////                                        callStateTextView.setText(st7);
//                                        } else {
//                                            callStateTextView.setText(st8);
//                                        }
                            } else {
                                if (mIsCall) {
                                    mCallState = CALL_STATE_UNANSWERED;
                                } else {
                                    if (mCallState != CALL_STATE_NORMAL) {
                                        mCallState = CALL_STATE_CANCELLED;
                                    } else {
                                        text = "挂断";
                                    }
                                }
                            }
                        }
                        postDelayedCloseMsg();
                    }

                });

                break;

            default:
                break;
        }
    }

}
