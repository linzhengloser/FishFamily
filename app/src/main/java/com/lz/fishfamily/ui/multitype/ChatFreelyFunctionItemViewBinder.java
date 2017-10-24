package com.lz.fishfamily.ui.multitype;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.ChatFreelyFunction;
import com.lz.library.base.BaseViewHolder;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/23
 *     desc   : 畅聊 "功能" ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class ChatFreelyFunctionItemViewBinder extends ItemViewBinder<ChatFreelyFunction, ChatFreelyFunctionItemViewBinder.ChatFreelyFunctionViewHolder> {

    @NonNull
    @Override
    protected ChatFreelyFunctionViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ChatFreelyFunctionViewHolder(inflater.inflate(R.layout.item_chat_freely_function, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ChatFreelyFunctionViewHolder holder, @NonNull ChatFreelyFunction item) {

        holder.iv_chat_freely_function_icon.setImageResource(item.getImageResId());
        holder.tv_chat_freely_function_text.setText(item.getText());
        holder.itemView.setOnClickListener(v -> {

        });
    }

    static class ChatFreelyFunctionViewHolder extends BaseViewHolder {

        //功能图标
        @BindView(R.id.iv_chat_freely_function_icon)
        ImageView iv_chat_freely_function_icon;

        //功能文字
        @BindView(R.id.tv_chat_freely_function_text)
        TextView tv_chat_freely_function_text;

        public ChatFreelyFunctionViewHolder(View itemView) {
            super(itemView);
        }
    }

}
