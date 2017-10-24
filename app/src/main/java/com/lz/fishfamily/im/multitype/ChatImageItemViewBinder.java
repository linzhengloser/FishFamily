package com.lz.fishfamily.im.multitype;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyphenate.chat.EMFileMessageBody;
import com.hyphenate.chat.EMImageMessageBody;
import com.hyphenate.chat.EMMessage;
import com.lz.fishfamily.R;
import com.lz.fishfamily.utils.glide.GlideApp;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/28
 *     desc   : 聊天界面 Image 类型 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class ChatImageItemViewBinder extends BaseChatItemViewBinder<ChatImageItemViewBinder.ChatImageViewHolder> {

    @Override
    protected ChatContentViewHolder onCreateContentViewHolder(LayoutInflater inflater, ViewGroup parent) {
        return new ChatImageViewHolder(inflater.inflate(R.layout.item_chat_image, parent, false));
    }

    @Override
    protected void onBindContentViewholder(ChatImageViewHolder holder, EMMessage itme,int position) {
        EMImageMessageBody imgBody = (EMImageMessageBody) itme.getBody();
        String imageUrl = null;

        holder.iv_item_chat_image.setImageResource(R.mipmap.ic_launcher);

        if (itme.direct() == EMMessage.Direct.RECEIVE) {
            if (imgBody.thumbnailDownloadStatus() == EMFileMessageBody.EMDownloadStatus.DOWNLOADING ||
                    imgBody.thumbnailDownloadStatus() == EMFileMessageBody.EMDownloadStatus.PENDING) {
                setMessageReceiveCallback(itme,position);
            } else {
                imageUrl = imgBody.thumbnailLocalPath();
            }
        } else {
            imageUrl = imgBody.getLocalUrl();
        }
        if(!TextUtils.isEmpty(imageUrl))
            GlideApp.with(holder.itemView.getContext()).load(imageUrl).into(holder.iv_item_chat_image);

    }



    static class ChatImageViewHolder extends BaseChatItemViewBinder.ChatContentViewHolder {

        @BindView(R.id.iv_item_chat_image)
        ImageView iv_item_chat_image;

        public ChatImageViewHolder(View itemView) {
            super(itemView);
        }
    }

}
