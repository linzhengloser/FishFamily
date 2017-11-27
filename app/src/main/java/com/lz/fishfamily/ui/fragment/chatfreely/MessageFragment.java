package com.lz.fishfamily.ui.fragment.chatfreely;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hyphenate.EMConnectionListener;
import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.lz.fishfamily.R;
import com.lz.fishfamily.module.ChatFreelyFunction;
import com.lz.fishfamily.ui.itemdecoration.PaddingItemDecoration;
import com.lz.fishfamily.ui.multitype.ChatFreelyFunctionItemViewBinder;
import com.lz.fishfamily.ui.multitype.ConversationItemViewBinder;
import com.lz.fishfamily.utils.event.ChatEvent;
import com.lz.library.base.LibraryBaseListFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/23
 *     desc   : 畅聊 -> 消息
 *     version: 1.0
 * </pre>
 */
public class MessageFragment extends LibraryBaseListFragment {

    private static final int MSG_WHAT_REFRESH = 1;

    @BindView(R.id.rv_message)
    RecyclerView rv_message;

    boolean isConflict;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MSG_WHAT_REFRESH) {
                ArrayList needRemoveList = new ArrayList();
                for (Object item : getMItems()) {
                    if (item instanceof EMConversation) needRemoveList.add(item);
                }
                getMItems().removeAll(needRemoveList);
                getMItems().addAll(loadConversationList());
                getMAdapter().notifyDataSetChanged();
            }
        }
    };

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        getMItems().add(new ChatFreelyFunction(ChatFreelyFunction.FUNCTION_TYPE_JOIN_SAME_GROUP));
        getMItems().add(new ChatFreelyFunction(ChatFreelyFunction.FUNCTION_TYPE_FISH_FRIEND_HELPER));
        getMItems().add(new ChatFreelyFunction(ChatFreelyFunction.FUNCTION_TYPE_SYSTEM_NOTIFICATION));
        getMItems().add(new ChatFreelyFunction(ChatFreelyFunction.FUNCTION_TYPE_COMMENT));
        rv_message.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_message.addItemDecoration(new PaddingItemDecoration().setPadding(130, 0));
        rv_message.setAdapter(getMAdapter());
        getMAdapter().notifyDataSetChanged();

        EMClient.getInstance().addConnectionListener(mConnectionListener);

    }


    /**
     * 加载会话列表
     */
    private List<EMConversation> loadConversationList() {
        Map<String, EMConversation> conversationMap = EMClient.getInstance().chatManager().getAllConversations();
        List<EMConversation> conversationList = new ArrayList<>();
        //将空会话移除
        synchronized (conversationMap) {
            for (EMConversation conversation : conversationMap.values()) {
                if (conversation.getAllMessages().size() != 0) {
                    conversationList.add(conversation);
                }
            }
        }

        //对会话列表按照时间顺序排序
        Collections.sort(conversationList, (conversation1, conversation2) -> {
            Long conversation1LastMsgTime = conversation1.getLastMessage().getMsgTime();
            Long conversation2LastMsgTime = conversation2.getLastMessage().getMsgTime();
            if (conversation1LastMsgTime.equals(conversation2LastMsgTime)) {
                return 0;
            } else if (conversation1LastMsgTime > conversation2LastMsgTime) {
                return 1;
            } else {
                return -1;
            }
        });

        return conversationList;
    }

    private void refresh() {
        if (!mHandler.hasMessages(MSG_WHAT_REFRESH)) {
            mHandler.sendEmptyMessage(MSG_WHAT_REFRESH);
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        refresh();
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EMClient.getInstance().removeConnectionListener(mConnectionListener);
    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(ChatFreelyFunction.class, new ChatFreelyFunctionItemViewBinder());
        getMAdapter().register(EMConversation.class, new ConversationItemViewBinder());
    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_message;
    }

    public static MessageFragment newInstance() {
        Bundle args = new Bundle();
        MessageFragment fragment = new MessageFragment();
        fragment.setArguments(args);
        return fragment;
    }


    /**
     * 环信链接回调
     */
    EMConnectionListener mConnectionListener = new EMConnectionListener() {
        @Override
        public void onConnected() {

        }

        @Override
        public void onDisconnected(int error) {
            if (error == EMError.USER_REMOVED || error == EMError.USER_LOGIN_ANOTHER_DEVICE || error == EMError.SERVER_SERVICE_RESTRICTED
                    || error == EMError.USER_KICKED_BY_CHANGE_PASSWORD || error == EMError.USER_KICKED_BY_OTHER_DEVICE) {
                isConflict = true;
            }
        }
    };

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRefreshConversationEvent(ChatEvent event) {
        if (event.getEventType() == ChatEvent.EVENT_TYPE_REFRESH_CONVERSATION) {
            refresh();
        }
    }

}
