package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Fans;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/17
 *     desc   : 黑名单 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class BlackListItemViewBinder extends ItemViewBinder<Fans,BlackListItemViewBinder.BlackListViewHolder> {

    @NonNull
    @Override
    protected BlackListViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new BlackListViewHolder(inflater.inflate(R.layout.item_mine_black_list,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull BlackListViewHolder holder, @NonNull Fans item) {

    }

    static class BlackListViewHolder extends BaseViewHolder{

        public BlackListViewHolder(View itemView) {
            super(itemView);
        }
    }

}
