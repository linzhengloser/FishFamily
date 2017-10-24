package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.MineDivider;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/13
 *     desc   : 我的 -> 分割线
 *     version: 1.0
 * </pre>
 */
public class MineDividerItemViewBinder extends ItemViewBinder<MineDivider,MineDividerItemViewBinder.MineDivideViewHolder> {


    @NonNull
    @Override
    protected MineDivideViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new MineDivideViewHolder(inflater.inflate(R.layout.item_mine_divider,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull MineDivideViewHolder holder, @NonNull MineDivider item) {

    }

    static class MineDivideViewHolder extends BaseViewHolder{

        public MineDivideViewHolder(View itemView) {
            super(itemView);
        }
    }

}
