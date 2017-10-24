package com.lz.fishfamily.ui.multitype.main;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.PostComment;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/25
 *     desc   : 首页 -> 帖子详情 评论 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class PostDetailCommentItemViewBinder extends ItemViewBinder<PostComment, PostDetailCommentItemViewBinder.PostDetailCommentViewHolder> {

    @NonNull
    @Override
    protected PostDetailCommentViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new PostDetailCommentViewHolder(inflater.inflate(R.layout.item_main_post_detail_comment, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull PostDetailCommentViewHolder holder, @NonNull PostComment item) {

    }

    static class PostDetailCommentViewHolder extends BaseViewHolder {

        public PostDetailCommentViewHolder(View itemView) {
            super(itemView);
        }
    }

}
