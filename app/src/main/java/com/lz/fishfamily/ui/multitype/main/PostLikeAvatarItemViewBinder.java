package com.lz.fishfamily.ui.multitype.main;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.User;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/23
 *     desc   : 首页 -> 分享 -> 点赞头像 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class PostLikeAvatarItemViewBinder extends ItemViewBinder<User,PostLikeAvatarItemViewBinder.PostLikeAvatarViewHolder> {


    @NonNull
    @Override
    protected PostLikeAvatarViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new PostLikeAvatarViewHolder(inflater.inflate(R.layout.item_main_post_like_avatar,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull PostLikeAvatarViewHolder holder, @NonNull User item) {

    }

    static class PostLikeAvatarViewHolder extends BaseViewHolder{

        public PostLikeAvatarViewHolder(View itemView) {
            super(itemView);
        }
    }



}
