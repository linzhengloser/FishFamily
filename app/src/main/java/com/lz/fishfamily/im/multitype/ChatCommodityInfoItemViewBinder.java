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
 *     desc   : 聊天界面 商品信息 ViewBinder
 *     version: 1.0
 * </pre>
 */
public class ChatCommodityInfoItemViewBinder extends BaseChatItemViewBinder<ChatCommodityInfoItemViewBinder.ChatCommodityInfoViewHolder> {


    @Override
    protected ChatContentViewHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new ChatCommodityInfoViewHolder(inflater.inflate(R.layout.item_chat_commodity_info,parent,false));
    }

    @Override
    protected void onBindContentViewholder(ChatCommodityInfoViewHolder holder, EMMessage itme, int position) {

    }

    static class ChatCommodityInfoViewHolder extends BaseChatItemViewBinder.ChatContentViewHolder{

        public ChatCommodityInfoViewHolder(View itemView) {
            super(itemView);
        }
    }

}
