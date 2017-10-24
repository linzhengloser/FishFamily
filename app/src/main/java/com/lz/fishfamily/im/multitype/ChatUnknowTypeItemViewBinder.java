package com.lz.fishfamily.im.multitype;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyphenate.chat.EMMessage;
import com.lz.fishfamily.R;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/28
 *     desc   : 聊天界面未知类型的消息
 *     version: 1.0
 * </pre>
 */
public class ChatUnknowTypeItemViewBinder extends ItemViewBinder<EMMessage, ChatUnknowTypeItemViewBinder.UnknowTypeViewHolder> {

    @NonNull
    @Override
    protected UnknowTypeViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new UnknowTypeViewHolder(inflater.inflate(R.layout.item_chat_unknow_type, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull UnknowTypeViewHolder holder, @NonNull EMMessage item) {

    }

    static class UnknowTypeViewHolder extends BaseViewHolder {

        public UnknowTypeViewHolder(View itemView) {
            super(itemView);
        }
    }

}
