package com.lz.fishfamily.ui.multitype;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.util.DateUtils;
import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.activity.ChatActivity;
import com.lz.fishfamily.utils.glide.GlideApp;
import com.lz.fishfamily.utils.im.MessageUtils;
import com.lz.fishfamily.utils.im.db.UserInfoUtils;
import com.lz.library.base.BaseViewHolder;

import java.util.Date;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/27
 *     desc   : 畅聊 -> 消息 -> 会话
 *     version: 1.0
 * </pre>
 */
public class ConversationItemViewBinder extends ItemViewBinder<EMConversation, ConversationItemViewBinder.ConversationViewHolder> {

    @NonNull
    @Override
    protected ConversationViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ConversationViewHolder(inflater.inflate(R.layout.item_conversation, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ConversationViewHolder holder, @NonNull EMConversation item) {

        EMMessage lastMessage = item.getLastMessage();

        if (item.getUnreadMsgCount() > 0) {
            holder.tv_item_conversation_unread_msg_count.setVisibility(View.VISIBLE);
            holder.tv_item_conversation_unread_msg_count.setText(item.getUnreadMsgCount() > 99 ? "99+" : String.valueOf(item.getUnreadMsgCount()));
        } else {
            holder.tv_item_conversation_unread_msg_count.setVisibility(View.GONE);
        }


        GlideApp.with(holder.itemView.getContext()).load(UserInfoUtils.getInstance().getUserInfo(item.getLatestMessageFromOthers().ext()).getUserAvatar()).into(holder.iv_item_conversation_avatar);

        //昵称
        holder.tv_item_conversation_user_nick_name.setText(item.conversationId());
        //消息内容
        holder.tv_item_conversation_last_msg_content.setText(MessageUtils.getMessageDigest(lastMessage));
        //最后一条消息的时间
        holder.tv_item_conversation_last_msg_time.setText(DateUtils.getTimestampString(new Date(lastMessage.getMsgTime())));

        //跳转聊天界面
        holder.itemView.setOnClickListener(view ->
                ChatActivity.toActivity(view.getContext(), MessageUtils.converstationType2ChatType(item.getType()), item.conversationId())
        );

    }

    static class ConversationViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_item_conversation_avatar)
        ImageView iv_item_conversation_avatar;

        @BindView(R.id.tv_item_conversation_unread_msg_count)
        TextView tv_item_conversation_unread_msg_count;

        @BindView(R.id.tv_item_conversation_user_nick_name)
        TextView tv_item_conversation_user_nick_name;

        @BindView(R.id.tv_item_conversation_last_msg_content)
        TextView tv_item_conversation_last_msg_content;

        @BindView(R.id.tv_item_conversation_last_msg_time)
        TextView tv_item_conversation_last_msg_time;

        public ConversationViewHolder(View itemView) {
            super(itemView);
        }
    }

}
