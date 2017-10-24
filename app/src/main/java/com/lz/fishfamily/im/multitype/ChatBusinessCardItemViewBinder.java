package com.lz.fishfamily.im.multitype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyphenate.chat.EMMessage;
import com.lz.fishfamily.R;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/11
 *     desc   : 聊天界面 名片 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class ChatBusinessCardItemViewBinder extends BaseChatItemViewBinder<ChatBusinessCardItemViewBinder.ChatBusinessCardViewHolder> {

    @Override
    protected ChatContentViewHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new ChatBusinessCardViewHolder(inflater.inflate(R.layout.item_chat_business_card,parent,false));
    }

    @Override
    protected void onBindContentViewholder(ChatBusinessCardViewHolder holder, EMMessage itme, int position) {

    }

    static class ChatBusinessCardViewHolder extends BaseChatItemViewBinder.ChatContentViewHolder{
        public ChatBusinessCardViewHolder(View itemView) {
            super(itemView);
        }
    }

}
