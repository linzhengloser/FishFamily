package com.lz.fishfamily.ui.multitype.main.post;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Post;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/25
 *     desc   : 首页 -> 帖子详情 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class PostDetailItemViewBinder extends ItemViewBinder<Post, PostDetailItemViewBinder.PostDetailViewHolder> {

    @NonNull
    @Override
    protected PostDetailViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new PostDetailViewHolder(inflater.inflate(R.layout.item_main_post_detail, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull PostDetailViewHolder holder, @NonNull Post item) {

    }

    static class PostDetailViewHolder extends BaseViewHolder {

        public PostDetailViewHolder(View itemView) {
            super(itemView);
        }

    }

}
