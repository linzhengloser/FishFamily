package com.lz.fishfamily.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.lz.fishfamily.Constant;
import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.ui.fragment.chatfreely.ChatFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/28
 *     desc   : 聊天 Activity
 *     version: 1.0
 * </pre>
 */
public class ChatActivity extends BaseActivity {

    @BindView(R.id.title)
    TextView title;


    String mChatUserId;

    @Override
    protected void initViewsAndEvents() {
        mChatUserId = getIntent().getStringExtra(Constant.Chat.INTENT_KEY_CHAT_USER_ID);

        title.setText(mChatUserId);

        ChatFragment chatFragment = new ChatFragment();
        chatFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.fl_chat_container, chatFragment).commit();
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_caht;
    }

    @OnClick({R.id.back})
    public void back(View view) {
        finish();
    }

    public static void toActivity(Context context, int chatType, String userId) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra(Constant.Chat.INTENT_KEY_CHAT_TYPE, chatType);
        intent.putExtra(Constant.Chat.INTENT_KEY_CHAT_USER_ID, userId);
        context.startActivity(intent);
    }

    public static void toSingleChat(Context context, String userId) {
        toActivity(context, Constant.Chat.CHAT_TYPE_SINGLE, userId);
    }

    public static void toGroupChat(Context context, String userId) {
        toActivity(context, Constant.Chat.CHAT_TYPE_GROUP, userId);
    }

}
