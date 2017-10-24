package com.lz.fishfamily.im.multitype;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMVoiceMessageBody;
import com.lz.fishfamily.R;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/11
 *     desc   : 聊天界面 Voice 类型 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class ChatVoiceItemViewBinder extends BaseChatItemViewBinder<ChatVoiceItemViewBinder.ChatVoiceViewHolder> {


    @Override
    protected ChatContentViewHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new ChatVoiceViewHolder(inflater.inflate(R.layout.item_chat_voice,parent,false));
    }

    @Override
    protected void onBindContentViewholder(ChatVoiceViewHolder holder, EMMessage itme, int position) {
        EMVoiceMessageBody voiceBody = (EMVoiceMessageBody) itme.getBody();
        if (itme.direct() == EMMessage.Direct.RECEIVE) {
            holder.tv_void_time.setTextColor(Color.parseColor("#999999"));
            holder.iv_voice.setImageResource(R.drawable.chat_voice_receive_1);
        }else{
            holder.iv_voice.setImageResource(R.drawable.chat_voice_sent_1);
            holder.tv_void_time.setTextColor(Color.WHITE);
        }
        holder.tv_void_time.setText(voiceBody.getLength()+"\"");
    }

    static class ChatVoiceViewHolder extends BaseChatItemViewBinder.ChatContentViewHolder{

        @BindView(R.id.iv_voice)
        ImageView iv_voice;

        @BindView(R.id.tv_void_time)
        TextView tv_void_time;

        public ChatVoiceViewHolder(View itemView) {
            super(itemView);
        }
    }

}
