package com.lz.fishfamily.utils.im;

import android.media.MediaRecorder;
import android.os.Handler;
import android.os.SystemClock;
import android.text.format.Time;

import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.util.EMLog;
import com.hyphenate.util.PathUtil;

import java.io.File;
import java.util.Date;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/10
 *     desc   : 录音器
 *     version: 1.0
 * </pre>
 */
public class VoiceRecorder {

    private MediaRecorder mMediaRecorder;

    private boolean mIsRecording = false;

    private long mStartTime;

    private String mVoiceFilePath;

    private String mVoiceFileName;

    private File mFile;

    private Handler mHandler;

    public VoiceRecorder(Handler handler) {
        mHandler = handler;
    }

    /**
     * 开始录制
     */
    public String startRecording() {
        mFile = null;
        try {
            if (mMediaRecorder != null) {
                mMediaRecorder.release();
                mMediaRecorder = null;
            }
            mMediaRecorder = new MediaRecorder();
            mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
            mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mMediaRecorder.setAudioChannels(1);
            mMediaRecorder.setAudioSamplingRate(8000);
            mMediaRecorder.setAudioEncodingBitRate(64);
            mVoiceFileName = getVoiceFileName(EMClient.getInstance().getCurrentUser());
            mVoiceFilePath = PathUtil.getInstance().getVoicePath() + "/" + mVoiceFileName;
            mFile = new File(mVoiceFilePath);
            mMediaRecorder.setOutputFile(mFile.getAbsolutePath());
            mMediaRecorder.prepare();
            mIsRecording = true;
            mMediaRecorder.start();
        } catch (Exception ex) {
            EMLog.e("voice", "prepare() failed");
        }

        new Thread(() -> {
            try {
                while (mIsRecording) {
                    android.os.Message msg = new android.os.Message();
                    msg.what = mMediaRecorder.getMaxAmplitude() * 13 / 0x7FFF;
                    mHandler.sendMessage(msg);
                    SystemClock.sleep(100);
                }
            } catch (Exception ex) {
                EMLog.e("voice", ex.toString());
            }
        }).start();

        mStartTime = new Date().getTime();
        return mFile == null ? null : mFile.getAbsolutePath();
    }

    /**
     * 取消录制
     */
    public void cancelRecording() {
        if (mMediaRecorder != null) {
            try {
                mMediaRecorder.stop();
                mMediaRecorder.release();
                mMediaRecorder = null;
                if (mFile != null && mFile.exists() && !mFile.isDirectory()) {
                    mFile.delete();
                }
            } catch (IllegalStateException e) {
            } catch (RuntimeException e) {
            }
            mIsRecording = false;
        }
    }

    /**
     * 停止录制
     */
    public int stopRecording() {
        if (mMediaRecorder != null) {
            mIsRecording = false;
            mMediaRecorder.stop();
            mMediaRecorder.release();
            mMediaRecorder = null;

            if (mFile == null || !mFile.exists() || !mFile.isFile()) {
                return EMError.FILE_INVALID;
            }
            if (mFile.length() == 0) {
                mFile.delete();
                return EMError.FILE_INVALID;
            }
            int seconds = (int) (new Date().getTime() - mStartTime) / 1000;
            return seconds;
        }
        return 0;
    }

    /**
     * 释放资源
     */
    protected void finalize() throws Throwable {
        super.finalize();
        if (mMediaRecorder != null) {
            mMediaRecorder.release();
        }
    }

    private String getVoiceFileName(String uid) {
        Time now = new Time();
        now.setToNow();
        return uid + now.toString().substring(0, 15) + ".amr";
    }

}
