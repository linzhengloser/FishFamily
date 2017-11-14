package com.lz.fishfamily;

import android.app.ActivityManager;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;

import com.bilibili.boxing.BoxingCrop;
import com.bilibili.boxing.BoxingMediaLoader;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMOptions;
import com.kingja.loadsir.callback.SuccessCallback;
import com.kingja.loadsir.core.LoadSir;
import com.lz.fishfamily.im.CallReceiver;
import com.lz.fishfamily.im.IMManager;
import com.lz.fishfamily.im.IMNotifier;
import com.lz.fishfamily.utils.BoxingGlideLoader;
import com.lz.fishfamily.utils.BoxingUcrop;
import com.lz.fishfamily.utils.im.SimpleEMMEssageListListener;
import com.lz.library.LibraryApplication;
import com.lz.library.utils.loadsir.EmptyCallback;
import com.lz.library.utils.loadsir.LoadingCallback;
import com.zhy.autolayout.config.AutoLayoutConifg;

import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/18
 *     desc   : Application
 *     version: 1.0
 * </pre>
 */
public class MyApplication extends LibraryApplication {

    private boolean mIMSdkInited = false;

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
        initIM();
        initBoxing();
        initLoadSir();
    }

    /**
     * 初始化 LoadSir
     */
    private void initLoadSir(){
        LoadSir.beginBuilder()
                .addCallback(new LoadingCallback())//添加各种状态页
                .addCallback(new EmptyCallback()).setDefaultCallback(SuccessCallback.class)
                .commit();
    }

    /**
     * 初始化 Boxing
     */
    private void initBoxing() {
        BoxingMediaLoader.getInstance().init(new BoxingGlideLoader());
        BoxingCrop.getInstance().init(new BoxingUcrop());
    }

    /**
     * 初始化环信
     */
    private void initIM() {
        if (mIMSdkInited) return;
        int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);
        if (processAppName == null || !processAppName.equalsIgnoreCase(getPackageName())) {
            return;
        }
        EMOptions options = new EMOptions();
        options.setAcceptInvitationAlways(false);
        options.setRequireAck(true);
        options.setRequireDeliveryAck(false);
        EMClient.getInstance().init(this, options);
        EMClient.getInstance().setDebugMode(BuildConfig.DEBUG);
        mIMSdkInited = true;
        registerGlobalListener();
    }

    /**
     * 注册全局监听
     */
    private void registerGlobalListener() {

        EMClient.getInstance().chatManager().addMessageListener(new SimpleEMMEssageListListener() {
            @Override
            public void onMessageReceived(List<EMMessage> list) {
                for (EMMessage message : list) {
                    if (!IMManager.hasForegroundActivies()) {
                        IMNotifier.getInstance().onNewMsg(message);
                    }
                }
            }
        });

        //注册呼叫 Reciver
        IntentFilter callFilter = new IntentFilter(EMClient.getInstance().callManager().getIncomingCallBroadcastAction());
        registerReceiver(new CallReceiver(),callFilter);

    }


    private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pID) {
                    CharSequence c = pm.getApplicationLabel(pm.getApplicationInfo(info.processName, PackageManager.GET_META_DATA));
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
            }
        }
        return processName;
    }

}
