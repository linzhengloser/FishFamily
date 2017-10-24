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
 *     time   : 2017/10/22
 *     desc   : 抽奖详情 Top ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class LuckyDetailTopItemViewBinder extends ItemViewBinder<String,LuckyDetailTopItemViewBinder.LuckyDetailTopViewHolder> {


    @NonNull
    @Override
    protected LuckyDetailTopViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new LuckyDetailTopViewHolder(inflater.inflate(R.layout.item_main_lucky_detail_top,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull LuckyDetailTopViewHolder holder, @NonNull String item) {

    }

    static class LuckyDetailTopViewHolder extends BaseViewHolder{

        public LuckyDetailTopViewHolder(View itemView) {
            super(itemView);
        }
    }

}
