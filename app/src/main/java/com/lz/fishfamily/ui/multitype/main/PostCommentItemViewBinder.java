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
 *     time   : 2017/09/24
 *     desc   : 首页 -> 分享 帖子评论 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class PostCommentItemViewBinder extends ItemViewBinder<PostComment,PostCommentItemViewBinder.PostCommentViewHolder>{

    @NonNull
    @Override
    protected PostCommentViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new PostCommentViewHolder(inflater.inflate(R.layout.item_main_post_comment,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull PostCommentViewHolder holder, @NonNull PostComment item) {

    }

    static class PostCommentViewHolder extends BaseViewHolder{

        public PostCommentViewHolder(View itemView) {
            super(itemView);
        }
    }

}
