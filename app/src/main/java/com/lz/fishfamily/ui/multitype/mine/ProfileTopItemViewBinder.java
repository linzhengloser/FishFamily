package com.lz.fishfamily.ui.multitype.mine;

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
 *     time   : 2017/09/20
 *     desc   : 用户资料 顶部 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class ProfileTopItemViewBinder extends ItemViewBinder<User,ProfileTopItemViewBinder.ProfileTopViewHolder> {

    @NonNull
    @Override
    protected ProfileTopViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ProfileTopViewHolder(inflater.inflate(R.layout.item_mine_profile_top,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ProfileTopViewHolder holder, @NonNull User item) {

    }

    static class ProfileTopViewHolder extends BaseViewHolder{

        public ProfileTopViewHolder(View itemView) {
            super(itemView);
        }
    }



}
