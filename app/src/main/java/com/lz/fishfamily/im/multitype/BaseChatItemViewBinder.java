package com.lz.fishfamily.im.multitype;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.exceptions.HyphenateException;
import com.lz.fishfamily.R;
import com.lz.fishfamily.utils.event.ChatEvent;
import com.lz.fishfamily.utils.glide.GlideApp;
import com.lz.fishfamily.utils.im.db.UserInfoUtils;
import com.lz.library.base.BaseViewHolder;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/28
 *     desc   : 聊天界面 BaseItemViewBinder
 *     version: 1.0
 * </pre>
 */
public abstract class BaseChatItemViewBinder<VH extends BaseChatItemViewBinder.ChatContentViewHolder> extends ItemViewBinder<EMMessage, BaseChatItemViewBinder.ChatViewHolder> {

    protected abstract ChatContentViewHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent);

    protected abstract void onBindContentViewHolder(VH holder, EMMessage itme, int position);

    @NonNull
    @Override
    protected ChatViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        ChatContentViewHolder contentViewHolder = onCreateContentViewHolder(inflater, parent);
        View root = inflater.inflate(R.layout.item_base_chat, parent, false);
        return new ChatViewHolder(root, contentViewHolder);
    }

    @Override
    protected void onBindViewHolder(@NonNull ChatViewHolder holder, @NonNull EMMessage item) {

        holder.fl_item_chat_receive_container.removeAllViews();
        holder.fl_item_chat_sent_container.removeAllViews();

        onBindContentViewHolder((VH) holder.chatContentViewHolder, item, getPosition(holder));

        handleMessageAcked(item);

        if (item.direct() == EMMessage.Direct.SEND) {
            //发送
            GlideApp.with(holder.itemView.getContext()).load(UserInfoUtils.getInstance().getUserInfo(item.ext()).getUserAvatar()).into(holder.iv_item_chat_sent_avatar);
            holder.ll_item_chat_sent.setVisibility(View.VISIBLE);
            holder.ll_item_chat_receive.setVisibility(View.GONE);
            holder.fl_item_chat_sent_container.addView(((VH) holder.chatContentViewHolder).itemView);
        } else {
            //接收
            GlideApp.with(holder.itemView.getContext()).load(UserInfoUtils.getInstance().getUserInfo(item.ext()).getUserAvatar()).into(holder.iv_item_chat_receive_avatar);
            holder.ll_item_chat_sent.setVisibility(View.GONE);
            holder.ll_item_chat_receive.setVisibility(View.VISIBLE);
            holder.fl_item_chat_receive_container.addView(((VH) holder.chatContentViewHolder).itemView);
        }
    }


    /**
     * 处理消息的已读抓曝光台
     */
    protected void handleMessageAcked(EMMessage message) {
        if (!message.isAcked() && message.getChatType() == EMMessage.ChatType.Chat) {
            try {
                EMClient.getInstance().chatManager().ackMessageRead(message.getFrom(), message.getMsgId());
            } catch (HyphenateException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 设置消息的接收回调
     */
    protected void setMessageReceiveCallback(EMMessage message, final int postion) {
        message.setMessageStatusCallback(new EMCallBack() {
            @Override
            public void onSuccess() {
                sendRefreshSingleItemEvent(postion);
            }

            @Override
            public void onError(int i, String s) {
                sendRefreshSingleItemEvent(postion);
            }

            @Override
            public void onProgress(int i, String s) {
            }
        });
    }

    protected void sendRefreshSingleItemEvent(int position) {
        EventBus.getDefault().post(new ChatEvent<Integer>(ChatEvent.EVENT_TYPE_RFRESH_SINGLE_ITEM, position));
    }

    /**
     * 聊天界面 ContentViewHolder
     */
    public static class ChatContentViewHolder extends BaseViewHolder {

        public ChatContentViewHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 聊天界面ViewHolder
     */
    public static class ChatViewHolder extends BaseViewHolder {

        @BindView(R.id.ll_item_chat_receive)
        LinearLayout ll_item_chat_receive;

        @BindView(R.id.ll_item_chat_sent)
        LinearLayout ll_item_chat_sent;

        @BindView(R.id.fl_item_chat_receive_container)
        FrameLayout fl_item_chat_receive_container;

        @BindView(R.id.fl_item_chat_sent_container)
        FrameLayout fl_item_chat_sent_container;

        @BindView(R.id.iv_item_chat_receive_avatar)
        ImageView iv_item_chat_receive_avatar;

        @BindView(R.id.iv_item_chat_sent_avatar)
        ImageView iv_item_chat_sent_avatar;

        ChatContentViewHolder chatContentViewHolder;

        public ChatViewHolder(View itemView, ChatContentViewHolder chatContentViewHolder) {
            super(itemView);
            this.chatContentViewHolder = chatContentViewHolder;
        }
    }


}
