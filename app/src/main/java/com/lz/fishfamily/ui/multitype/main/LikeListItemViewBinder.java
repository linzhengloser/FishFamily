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
 *     time   : 2017/09/27
 *     desc   : 首页 -> 点赞列表 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class LikeListItemViewBinder extends ItemViewBinder<User,LikeListItemViewBinder.LikeListViewHolder> {


    @NonNull
    @Override
    protected LikeListViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new LikeListViewHolder(inflater.inflate(R.layout.item_main_like_list,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull LikeListViewHolder holder, @NonNull User item) {

    }

    static class LikeListViewHolder extends BaseViewHolder{

        public LikeListViewHolder(View itemView) {
            super(itemView);
        }
    }


}
