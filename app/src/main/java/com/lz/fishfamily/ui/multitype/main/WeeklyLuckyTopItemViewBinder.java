package com.lz.fishfamily.ui.multitype.main;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.activity.main.ToPhaseOutActivity;
import com.lz.library.base.BaseViewHolder;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/19
 *     desc   : 首页 -> 抽奖 -> 每周抽奖 TopItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class WeeklyLuckyTopItemViewBinder extends ItemViewBinder<String, WeeklyLuckyTopItemViewBinder.WeeklyLuckyTopViewHolder> {

    @NonNull
    @Override
    protected WeeklyLuckyTopViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new WeeklyLuckyTopViewHolder(inflater.inflate(R.layout.item_main_weekly_lucky_top, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull WeeklyLuckyTopViewHolder holder, @NonNull String item) {

    }

    static class WeeklyLuckyTopViewHolder extends BaseViewHolder {

        @BindView(R.id.ll_to_phase_out)
        LinearLayout ll_to_phase_out;

        public WeeklyLuckyTopViewHolder(View itemView) {
            super(itemView);
            ll_to_phase_out.setOnClickListener(v -> ToPhaseOutActivity.toActivity(v.getContext()));
        }
    }

}
