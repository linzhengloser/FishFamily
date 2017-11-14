package com.lz.fishfamily.ui.activity.chatfreely

import android.os.SystemClock
import android.view.View
import butterknife.OnClick
import com.hyphenate.chat.EMCallStateChangeListener
import com.lz.fishfamily.R
import kotlinx.android.synthetic.main.activity_chat_voice.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/10
 * desc   : 语音聊天界面
 * version: 1.0
</pre> *
 */
class VoiceActivity : CallActivity(), EMCallStateChangeListener {

    //是否是免提
    private val mIsHandsFreeState: Boolean = false


    override val contentViewResourceID: Int
        get() = R.layout.activity_chat_voice

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        mCallType = 0
        if (mIsCall) {
            //呼入
            inComingCall()
            mRingtone.play()
        } else {
            //呼出
            callOut()
            mHandler.sendEmptyMessage(MESSAGE_WHAT_MAKE_VOICE)
            //播放声音
            mHandler.postDelayed({ mStreamID = playMakeCallSounds() }, 300)
        }
    }

    /**
     * 状态变化监听
     */
    override fun onCallStateChanged(state: EMCallStateChangeListener.CallState, error: EMCallStateChangeListener.CallError) {
        when (state) {
            EMCallStateChangeListener.CallState.CONNECTING -> runOnUiThread {
                //链接中
            }
            EMCallStateChangeListener.CallState.CONNECTED -> runOnUiThread {
                //已经和对方建立连接
            }
            EMCallStateChangeListener.CallState.ACCEPTED -> {
                //对方接受语音
                mHandler.removeCallbacks(mTimeOutHangup)
                runOnUiThread {
                    if (mSoundPool != null)
                        mSoundPool.stop(mStreamID)
                    answer()
                }
            }
            EMCallStateChangeListener.CallState.NETWORK_UNSTABLE -> runOnUiThread {
                //网络不稳定
            }
            EMCallStateChangeListener.CallState.NETWORK_NORMAL -> runOnUiThread {
                //网络正常
            }
            EMCallStateChangeListener.CallState.VOICE_PAUSE -> runOnUiThread {
                //语音暂停
            }
            EMCallStateChangeListener.CallState.VOICE_RESUME -> runOnUiThread {
                //语音继续 与上个方法相呼应
            }
            EMCallStateChangeListener.CallState.DISCONNECTED -> {
                //断开
                mHandler.removeCallbacks(mTimeOutHangup)
                runOnUiThread {
                    var text: String? = null
                    if (error == EMCallStateChangeListener.CallError.REJECTED) {
                        mCallState = CallActivity.CALL_STATE_BE_REFUSED
                    } else if (error == EMCallStateChangeListener.CallError.ERROR_TRANSPORT) {
                        text = "建立连接失败"
                    } else if (error == EMCallStateChangeListener.CallError.ERROR_UNAVAILABLE) {
                        mCallState = CallActivity.CALL_STATE_OFFLINE
                    } else if (error == EMCallStateChangeListener.CallError.ERROR_BUSY) {
                        mCallState = CallActivity.CALL_STATE_BUSY
                    } else if (error == EMCallStateChangeListener.CallError.ERROR_NORESPONSE) {
                        mCallState = CallActivity.CALL_STATE_NO_RESPONSE
                    } else if (error == EMCallStateChangeListener.CallError.ERROR_LOCAL_SDK_VERSION_OUTDATED || error == EMCallStateChangeListener.CallError.ERROR_REMOTE_SDK_VERSION_OUTDATED) {
                        mCallState = CallActivity.CALL_STATE_VERSION_NOT_SAME
                    } else {
                        if (mIsRefused) {
                            mCallState = CallActivity.CALL_STATE_REFUSED
                        } else if (mIsAnswered) {
                            mCallState = CallActivity.CALL_STATE_NORMAL
                            text = "对方已经挂断"
                        } else {
                            if (mIsCall) {
                                mCallState = CallActivity.CALL_STATE_UNANSWERED
                            } else {
                                if (mCallState != CallActivity.CALL_STATE_NORMAL) {
                                    mCallState = CallActivity.CALL_STATE_CANCELLED
                                } else {
                                    text = "挂断"
                                }
                            }
                        }
                    }
                    postDelayedCloseMsg()
                }
            }
        }
    }

    /**
     * 呼入 未接听
     */
    fun inComingCall() {
        tv_hint.text = "正在等待对方接受邀请"
        ll_answer.visibility = View.VISIBLE
        ll_hangup.visibility = View.VISIBLE
    }

    /**
     *  呼出
     */
    fun callOut() {
        tv_hint.text = "正在等待对方接受邀请"
        ll_hangup.visibility = View.VISIBLE
    }

    /**
     * 接听
     */
    private fun answer() {
        //暂停铃声
        try {
            if (mSoundPool != null)
                mSoundPool.stop(mStreamID)
        } catch (e: Exception) {
        }
        tv_hint.visibility = View.GONE
        ll_answer.visibility = View.GONE
        tv_time.visibility = View.VISIBLE
        ll_mute.visibility = View.VISIBLE
        ll_hands_free.visibility = View.VISIBLE
        //开始计时
        tv_time.base = SystemClock.elapsedRealtime()
        tv_time.start()
        mCallState = CALL_STATE_NORMAL
    }


    private fun postDelayedCloseMsg() {
        mHandler.postDelayed({
            runOnUiThread {
                saveCallRecord()
                finish()
            }
        }, 200)
    }


    @OnClick(R.id.tv_hangup, R.id.ll_answer,R.id.ll_mute,R.id.ll_hands_free)
    fun onClick(view: View) {
        when (view.id) {
            R.id.tv_hangup -> {
                //挂断
                view.isEnabled = false
                tv_time.stop()
                mHandler.sendEmptyMessage(MESSAGE_WHAT_END)
            }

            R.id.ll_answer -> {
                closeSpeakerOn()
                mHandler.sendEmptyMessage(MESSAGE_WHAT_ANSWER)
            }
        }
    }
}
