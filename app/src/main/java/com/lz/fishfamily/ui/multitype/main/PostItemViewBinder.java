package com.lz.fishfamily.ui.multitype.main;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Post;
import com.lz.fishfamily.ui.activity.main.PostDetailActivity;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/23
 *     desc   : 首页 -> 分享 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class PostItemViewBinder extends ItemViewBinder<Post, PostItemViewBinder.PostViewHolder> {


    @NonNull
    @Override
    protected PostViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new PostViewHolder(inflater.inflate(R.layout.item_main_post, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, @NonNull Post item) {
        holder.itemView.setOnClickListener(v -> PostDetailActivity.toActivity(v.getContext()));
    }

    static class PostViewHolder extends BaseViewHolder {

        public PostViewHolder(View itemView) {
            super(itemView);
        }
    }

}
