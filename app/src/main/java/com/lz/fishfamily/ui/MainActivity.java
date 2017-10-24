package com.lz.fishfamily.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyphenate.EMCallBack;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.lz.fishfamily.R;
import com.lz.fishfamily.api.Api;
import com.lz.fishfamily.api.UserApi;
import com.lz.fishfamily.im.IMManager;
import com.lz.fishfamily.im.IMNotifier;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.ui.fragment.activity.ActivityFragment;
import com.lz.fishfamily.ui.fragment.chatfreely.ChatFreelyFragment;
import com.lz.fishfamily.ui.fragment.main.MainFragment;
import com.lz.fishfamily.ui.fragment.mine.MineFragment;
import com.lz.fishfamily.utils.CacheUtils;
import com.lz.fishfamily.utils.UserManager;
import com.lz.fishfamily.utils.event.ChatEvent;
import com.lz.fishfamily.utils.event.LoginEvent;
import com.lz.fishfamily.utils.im.SimpleEMMEssageListListener;
import com.lz.fishfamily.utils.rxjava.HandlerApiResultCosumer;
import com.lz.fishfamily.utils.rxjava.HandlerApiResultFunction;
import com.lz.library.base.BaseViewPagerAdapter;
import com.lz.library.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;


/**
 * 首页
 */
public class MainActivity extends BaseActivity {

    //底部5个选项卡
//    @BindViews({R.id.ll_main, R.id.ll_chat_freely, R.id.ll_fish_friend_shop, R.id.ll_activity, R.id.ll_mine})
//    LinearLayout ll_main, ll_chat_freely, ll_fish_friend_shop, ll_activity, ll_mine;

    //底部布局
    @BindView(R.id.ll_main_bottom)
    LinearLayout ll_main_bottom;

    //首页 ViewPag
    @BindView(R.id.vp_main)
    ViewPager vp_main;

    int[] tabSelectedImageResIds = {
            R.drawable.tab_main_selected,
            R.drawable.tab_chat_freely_selected,
            R.drawable.tab_activity_selected,
            R.drawable.tab_mine_selected
    };

    int[] tabUnSelectedImageResIds = {
            R.drawable.tab_main_unselected,
            R.drawable.tab_chat_freely_unselected,
            R.drawable.tab_activity_unselected,
            R.drawable.tab_mine_unselected
    };

    List<Fragment> mFragmentList = new ArrayList<>(4);

    EMMessageListener mMessageListener = new SimpleEMMEssageListListener() {
        @Override
        public void onMessageReceived(List<EMMessage> list) {
            for (EMMessage message : list) {
                IMNotifier.getInstance().onNewMsg(message);
            }
            EventBus.getDefault().post(new ChatEvent(ChatEvent.EVENT_TYPE_REFRESH_CONVERSATION));
        }
    };

    @Override
    protected void initViewsAndEvents() {
        EventBus.getDefault().register(this);
        mFragmentList.add(MainFragment.newInstance());
        mFragmentList.add(ChatFreelyFragment.newInstance());
        mFragmentList.add(ActivityFragment.newInstance());
        mFragmentList.add(MineFragment.newInstance());
        vp_main.setOffscreenPageLimit(mFragmentList.size());
        vp_main.setAdapter(new BaseViewPagerAdapter(getSupportFragmentManager(), mFragmentList));
        changeTab(0);


        //登录环信
        if (!EMClient.getInstance().isLoggedInBefore()) {
            EMClient.getInstance().login("linzheng", "123456", new EMCallBack() {//回调
                @Override
                public void onSuccess() {
                    runOnUiThread(() -> ToastUtils.showToast("登录成功"));
                    EMClient.getInstance().groupManager().loadAllGroups();
                    EMClient.getInstance().chatManager().loadAllConversations();
                }

                @Override
                public void onProgress(int progress, String status) {
                }

                @Override
                public void onError(int code, String message) {
                    runOnUiThread(() -> ToastUtils.showToast("登录失败"));
                }
            });
        } else {
            EMClient.getInstance().groupManager().loadAllGroups();
            EMClient.getInstance().chatManager().loadAllConversations();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_main;
    }

    private void changeTab(int position) {
        ViewGroup viewGroup;
        int imageResId;
        int textColor;
        for (int i = 0; i < ll_main_bottom.getChildCount(); i++) {
            viewGroup = (ViewGroup) ll_main_bottom.getChildAt(i);
            if (i == 2) continue;
            if (i == position) {
                imageResId = i > 2 ? tabSelectedImageResIds[i - 1] : tabSelectedImageResIds[i];
                textColor = getResources().getColor(R.color.colorPrimary);
            } else {
                imageResId = i > 2 ? tabUnSelectedImageResIds[i - 1] : tabUnSelectedImageResIds[i];
                textColor = getResources().getColor(R.color.tab_unselected_text_color);
            }
            ((ImageView) viewGroup.getChildAt(0)).setImageResource(imageResId);
            ((TextView) viewGroup.getChildAt(1)).setTextColor(textColor);
        }
        vp_main.setCurrentItem(position > 2 ? position - 1 : position);
    }

    @OnClick({R.id.ll_main, R.id.ll_chat_freely, R.id.ll_activity, R.id.ll_mine})
    public void onTabClick(View view) {
        for (int i = 0; i < ll_main_bottom.getChildCount(); i++) {
            if (ll_main_bottom.getChildAt(i).getId() == view.getId()) {
                changeTab(i);
                break;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        IMManager.pushActivity(this);
        EMClient.getInstance().chatManager().addMessageListener(mMessageListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        IMManager.popActivity(this);
        EMClient.getInstance().chatManager().removeMessageListener(mMessageListener);
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Subscribe
    public void onGetUserInfo(LoginEvent event) {
        if (event.getEventType() == LoginEvent.EVENT_TYPE_GET_USER_INFO) {
            Api.create(UserApi.class).getUserInfo(CacheUtils.getUserId())
                    .compose(bindToLifecycle())
                    .map(new HandlerApiResultFunction<>())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(user -> UserManager.saveUserJson(user), new HandlerApiResultCosumer());

        }
    }

}
