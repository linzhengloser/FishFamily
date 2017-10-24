package com.lz.fishfamily.ui.multitype.main;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.LuckyRecord;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/19
 *     desc   : 首页 -> 抽奖 -> 每周抽奖 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class WeeklyLuckyItemViewBinder extends ItemViewBinder<LuckyRecord,WeeklyLuckyItemViewBinder.WeeklyLuckyViewHolder>{

    @NonNull
    @Override
    protected WeeklyLuckyViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new WeeklyLuckyViewHolder(inflater.inflate(R.layout.item_main_weekly_lucky,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull WeeklyLuckyViewHolder holder, @NonNull LuckyRecord item) {

    }

    static class WeeklyLuckyViewHolder extends BaseViewHolder{

        public WeeklyLuckyViewHolder(View itemView) {
            super(itemView);
        }
    }

}
