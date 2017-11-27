package com.lz.fishfamily.im.multitype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;
import com.lz.fishfamily.R;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/28
 *     desc   : 聊天界面 Text 类型 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class ChatTextItemViewBinder extends BaseChatItemViewBinder<ChatTextItemViewBinder.ChatTextViewHolder> {


    @Override
    protected ChatContentViewHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new ChatTextViewHolder(inflater.inflate(R.layout.item_chat_text, parent, false));
    }

    @Override
    protected void onBindContentViewHolder(ChatTextViewHolder holder, EMMessage itme, int position) {
        EMTextMessageBody txtBody = (EMTextMessageBody) itme.getBody();
        holder.tv_item_chat_text.setText(txtBody.getMessage());
    }

    static class ChatTextViewHolder extends BaseChatItemViewBinder.ChatContentViewHolder {

        @BindView(R.id.tv_item_chat_text)
        TextView tv_item_chat_text;

        public ChatTextViewHolder(View itemView) {
            super(itemView);
        }
    }

}
