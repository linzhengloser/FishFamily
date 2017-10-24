package com.lz.fishfamily.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.util.VoiceRecorder;
import com.lz.library.utils.ToastUtils;


/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/10
 *     desc   : 录音 View
 *     version: 1.0
 * </pre>
 */
public class RecordVoiceView extends android.support.v7.widget.AppCompatImageView implements View.OnTouchListener {

    private PowerManager.WakeLock mWakeLock;

    private VoiceRecorder mVoiceRecorder;

    private VoiceView mVoiceView;

    private VoiceRecorderCallback mRecorderCallback;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mVoiceView.setCurrentVoiceLevel(msg.what);
        }
    };

    public RecordVoiceView(Context context) {
        super(context);
    }

    public RecordVoiceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecordVoiceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setOnTouchListener(this);
        mVoiceRecorder = new VoiceRecorder(mHandler);
        mWakeLock = ((PowerManager) getContext().getSystemService(Context.POWER_SERVICE)).newWakeLock(
                PowerManager.SCREEN_DIM_WAKE_LOCK, "RecordVoiceView");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                try {
                    v.setPressed(true);
                    startRecording();
                } catch (Exception ex) {
                    v.setPressed(false);
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                return true;
            case MotionEvent.ACTION_UP:
                v.setPressed(false);
                if (event.getY() < 0) {
                    discardRecording();
                } else {
                    // stop recording and send voice file
                    try {
                        int length = stopRecoding();
                        if (length > 0) {
                            if (mRecorderCallback != null) {
                                mRecorderCallback.onVoiceRecordComplete(mVoiceRecorder.getVoiceFilePath(), length);
                            }
                        } else if (length == EMError.FILE_INVALID) {
                            ToastUtils.showToast("无录音权限");
                        } else {
                            ToastUtils.showToast("录音时间太短");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        ToastUtils.showToast("发送失败,请检查服务器是否连接成功");
                    }
                }
                return true;
            default:
                discardRecording();
                return false;
        }
    }

    /**
     * 开始录制
     */
    private void startRecording() {
        try {
            mWakeLock.acquire();
            mVoiceRecorder.startRecording("", EMClient.getInstance().getCurrentUser(), getContext());
        } catch (Exception e) {
            e.printStackTrace();
            if (mWakeLock.isHeld())
                mWakeLock.release();
            if (mVoiceRecorder != null)
                mVoiceRecorder.discardRecording();
            ToastUtils.showToast("录音失败,请重试");
            return;
        }
    }

    /**
     * 放弃录制
     */
    private void discardRecording() {
        if (mWakeLock.isHeld())
            mWakeLock.release();
        try {
            if (mVoiceRecorder.isRecording())
                mVoiceRecorder.discardRecording();
        } catch (Exception e) {
        }
    }

    private int stopRecoding() {
        if (mWakeLock.isHeld())
            mWakeLock.release();
        return mVoiceRecorder.stopRecoding();
    }

    public RecordVoiceView setVoiceView(VoiceView voiceView) {
        mVoiceView = voiceView;
        return this;
    }

    public VoiceRecorderCallback getRecorderCallback() {
        return mRecorderCallback;
    }

    public RecordVoiceView setRecorderCallback(VoiceRecorderCallback recorderCallback) {
        mRecorderCallback = recorderCallback;
        return this;
    }

    public interface VoiceRecorderCallback {
        void onVoiceRecordComplete(String voiceFilePath, int voiceTimeLength);
    }


}
