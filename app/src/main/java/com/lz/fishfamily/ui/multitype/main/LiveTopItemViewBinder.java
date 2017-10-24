package com.lz.fishfamily.ui.multitype.main;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/25
 *     desc   : 首页 -> 直播 TopItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class LiveTopItemViewBinder extends ItemViewBinder<String, LiveTopItemViewBinder.LiveTopViewHolder> {

    @NonNull
    @Override
    protected LiveTopViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new LiveTopViewHolder(inflater.inflate(R.layout.item_main_live_top, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull LiveTopViewHolder holder, @NonNull String item) {
        holder.itemView.setOnClickListener(v -> LivePermissionApplyActivity.toActivity(holder.itemView.getContext()));
    }

    static class LiveTopViewHolder extends BaseViewHolder {

        public LiveTopViewHolder(View itemView) {
            super(itemView);
        }

    }

}
