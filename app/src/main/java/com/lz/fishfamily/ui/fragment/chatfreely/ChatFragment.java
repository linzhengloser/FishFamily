package com.lz.fishfamily.ui.fragment.chatfreely;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bilibili.boxing.Boxing;
import com.bilibili.boxing.model.config.BoxingConfig;
import com.bilibili.boxing.model.entity.BaseMedia;
import com.bilibili.boxing_impl.ui.BoxingActivity;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.lz.fishfamily.Constant;
import com.lz.fishfamily.R;
import com.lz.fishfamily.im.IMManager;
import com.lz.fishfamily.im.IMNotifier;
import com.lz.fishfamily.im.multitype.ChatImageItemViewBinder;
import com.lz.fishfamily.im.multitype.ChatTextItemViewBinder;
import com.lz.fishfamily.im.multitype.ChatUnknowTypeItemViewBinder;
import com.lz.fishfamily.im.multitype.ChatVoiceItemViewBinder;
import com.lz.fishfamily.ui.view.RecordVoiceView;
import com.lz.fishfamily.ui.view.VoiceView;
import com.lz.fishfamily.utils.event.ChatEvent;
import com.lz.fishfamily.utils.im.MessageUtils;
import com.lz.fishfamily.utils.im.SimpleEMMEssageListListener;
import com.lz.library.base.LibraryBaseListFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/03
 *     desc   : 聊天界面
 *     version: 1.0
 * </pre>
 */
public class ChatFragment extends LibraryBaseListFragment implements SwipeRefreshLayout.OnRefreshListener {

    private static final int PAGE_SIZE = 20;

    private static final int HANDLER_WHAT_REFRESH_LIST = 1;

    private static final int HANDLER_WHAT_SELECT_LAST = 2;

    private static final int REQUEST_CODE_BOXING = 3;

    @BindView(R.id.srl_chat)
    SwipeRefreshLayout srl_chat;

    @BindView(R.id.rv_chat)
    RecyclerView rv_chat;

    @BindView(R.id.ll_menu)
    LinearLayout ll_menu;

    @BindView(R.id.iv_expression)
    ImageView iv_expression;

    @BindView(R.id.et_input_content)
    EditText et_input_content;

    //录音相关控件
    @BindView(R.id.iv_record_vocie)
    RecordVoiceView iv_record_vocie;

    @BindView(R.id.tv_record_voice_time)
    TextView tv_record_voice_time;

    @BindView(R.id.vv_voice_level)
    VoiceView vv_voice_level;

    @BindView(R.id.ll_record_voice)
    LinearLayout ll_record_voice;

    //聊天类型
    int mChatType = Constant.Chat.CHAT_TYPE_SINGLE;

    //聊天对象的环信ID
    String mChatUserId;

    //会话对象
    EMConversation mConversation;

    //当前消息列表是否初始化
    boolean mIsMessageListInited;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case HANDLER_WHAT_REFRESH_LIST:
                    refreshList();
                    break;
                case HANDLER_WHAT_SELECT_LAST:
                    if (getMItems().isEmpty()) return;
                    rv_chat.scrollToPosition(getMItems().size() - 1);
                    break;
            }

        }
    };

    /**
     * 消息监听
     */
    EMMessageListener mMessageListener = new SimpleEMMEssageListListener() {
        @Override
        public void onMessageReceived(List<EMMessage> list) {
            for (EMMessage message : list) {
                String username;
                if (message.getChatType() == EMMessage.ChatType.GroupChat || message.getChatType() == EMMessage.ChatType.ChatRoom) {
                    username = message.getTo();
                } else {
                    username = message.getFrom();
                }
                if (username.equals(mChatUserId) || message.getTo().equals(mChatUserId) || message.conversationId().equals(mChatUserId)) {
                    sendRefreshAndSelectLastMessage();
                    mConversation.markMessageAsRead(message.getMsgId());
                    IMNotifier.getInstance().vibrateAndPlayTone();
                } else {
                    IMNotifier.getInstance().onNewMsg(message);
                }
            }
        }
    };

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(EMMessage.class)
                .to(new ChatTextItemViewBinder(), new ChatImageItemViewBinder(),new ChatVoiceItemViewBinder() ,new ChatUnknowTypeItemViewBinder())
                .withClassLinker(message -> {
                    if (message.getType() == EMMessage.Type.TXT) {
                        return ChatTextItemViewBinder.class;
                    } else if (message.getType() == EMMessage.Type.IMAGE) {
                        return ChatImageItemViewBinder.class;
                    }else if(message.getType() == EMMessage.Type.VOICE){
                        return ChatVoiceItemViewBinder.class;
                    }
                    return ChatUnknowTypeItemViewBinder.class;
                });

        rv_chat.setAdapter(getMAdapter());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        rv_chat.setLayoutManager(linearLayoutManager);
        //events
        srl_chat.setOnRefreshListener(this);
    }

    @Override
    protected void initViewsAndEvents() {
        mChatType = getArguments().getInt(Constant.Chat.INTENT_KEY_CHAT_TYPE);
        mChatUserId = getArguments().getString(Constant.Chat.INTENT_KEY_CHAT_USER_ID);
        super.initViewsAndEvents();
        //加载会话
        mConversation = EMClient.getInstance().chatManager().getConversation(mChatUserId, MessageUtils.chatType2ConverstationType(mChatType), true);
        mConversation.markAllMessagesAsRead();

        //初始化消息列表
        messageListInitial();
        sendRefreshAndSelectLastMessage();

        //初始化录音器
        //TODO 录音计时功能还未实现
        iv_record_vocie.setRecorderCallback((voiceFilePath, voiceTimeLength) -> {
            //录音完成
            sendMessage(MessageUtils.createVoiceMessage(voiceFilePath, voiceTimeLength, mChatUserId));

        }).setVoiceView(vv_voice_level);


    }


    @Override
    public void onResume() {
        super.onResume();
        if (mIsMessageListInited) sendRefreshMessage();
        IMManager.pushActivity(getActivity());
        EMClient.getInstance().chatManager().addMessageListener(mMessageListener);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        IMManager.popActivity(getActivity());
        EMClient.getInstance().chatManager().removeMessageListener(mMessageListener);
        EventBus.getDefault().unregister(this);
    }

    /**
     * 消息列表初始化
     */
    private void messageListInitial() {
        List<EMMessage> msgs = mConversation.getAllMessages();
        int msgCount = msgs != null ? msgs.size() : 0;
        if (msgCount < mConversation.getAllMsgCount() && msgCount < PAGE_SIZE) {
            String msgId = null;
            if (msgs != null && msgs.size() > 0) {
                msgId = msgs.get(0).getMsgId();
            }
            int loadPageSize = PAGE_SIZE - msgCount;
            mConversation.loadMoreMsgFromDB(msgId, PAGE_SIZE - msgCount);
            //测试代码
            List<EMMessage> lsit = mConversation.getAllMessages();
            int count = mConversation.getAllMsgCount();
            System.out.println("1111");
        }
        mIsMessageListInited = true;
    }

    /**
     * 刷新列表 并标记消息已读
     */
    private void refreshList() {
        getMItems().clear();
        List<EMMessage> list = mConversation .getAllMessages();
        getMItems().addAll(list);
        getMAdapter().notifyDataSetChanged();
        mConversation.markAllMessagesAsRead();
    }

    /**
     * 发出刷新列表的 Message
     */
    private void sendRefreshMessage() {
        if (mHandler.hasMessages(HANDLER_WHAT_REFRESH_LIST)) return;
        mHandler.sendEmptyMessage(HANDLER_WHAT_REFRESH_LIST);
    }

    /**
     * 刷新列表，并选中最后一个Item
     */
    private void sendRefreshAndSelectLastMessage() {
        mHandler.removeMessages(HANDLER_WHAT_REFRESH_LIST);
        mHandler.removeMessages(HANDLER_WHAT_SELECT_LAST);
        mHandler.sendEmptyMessageDelayed(HANDLER_WHAT_REFRESH_LIST, 100);
        mHandler.sendEmptyMessageDelayed(HANDLER_WHAT_SELECT_LAST, 100);
    }

    /**
     * 显示菜单布局
     */
    private void showMenuLayout() {
        if (ll_menu.getVisibility() == View.GONE)
            ll_menu.setVisibility(View.VISIBLE);
        else
            ll_menu.setVisibility(View.GONE);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRefrshSingleItemEvent(ChatEvent<Integer> event) {
        if (event.getEventType() == ChatEvent.EVENT_TYPE_RFRESH_SINGLE_ITEM) {
            getMAdapter().notifyItemChanged(event.getData());
        }
    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_chat;
    }

    @Override
    public void onRefresh() {

    }

    @OnClick({R.id.iv_menu, R.id.iv_expression, R.id.ll_photo, R.id.iv_voice})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_menu:
                showMenuLayout();
                break;
            case R.id.iv_expression:
                et_input_content.setText("");
                break;
            //照片
            case R.id.ll_photo:
                BoxingConfig config = new BoxingConfig(BoxingConfig.Mode.SINGLE_IMG);
                Boxing.of(config).withIntent(getContext(), BoxingActivity.class).start(this, REQUEST_CODE_BOXING);
                break;
            //语音的打开与关闭
            case R.id.iv_voice:
                ll_record_voice.setVisibility(ll_record_voice.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                ((ImageView) view).setImageResource(ll_record_voice.getVisibility() == View.VISIBLE ? R.drawable.chat_voice_selected : R.drawable.chat_voice_unselected);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Boxing 选择图片返回
        if (requestCode == REQUEST_CODE_BOXING) {
            List<BaseMedia> medias = Boxing.getResult(data);
            if (!medias.isEmpty()) {
                sendMessage(MessageUtils.createImageMessage(medias.get(0).getPath(), mChatUserId));
            }
        }
    }

    /**
     * 无论发送什么类型的方法，都要走次此方法
     */
    public void sendMessage(EMMessage message) {
        EMClient.getInstance().chatManager().sendMessage(message);
        sendRefreshAndSelectLastMessage();
    }
}
