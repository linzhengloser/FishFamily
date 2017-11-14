package com.lz.fishfamily.ui.multitype.main.lucky;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.ToPhaseOut;
import com.lz.fishfamily.ui.activity.main.LuckyDetailActivity;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/21
 *     desc   : 抽奖 -> 往期揭晓
 *     version: 1.0
 * </pre>
 */
public class LuckyToPhaseOutItemViewBinder extends ItemViewBinder<ToPhaseOut, LuckyToPhaseOutItemViewBinder.LuckyToPhaseOutViewHolder> {

    @NonNull
    @Override
    protected LuckyToPhaseOutViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new LuckyToPhaseOutViewHolder(inflater.inflate(R.layout.item_main_luck_to_phase_out, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull LuckyToPhaseOutViewHolder holder, @NonNull ToPhaseOut item) {

    }

    static class LuckyToPhaseOutViewHolder extends BaseViewHolder {

        public LuckyToPhaseOutViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(v -> LuckyDetailActivity.toActivity(v.getContext()));
        }
    }

}
