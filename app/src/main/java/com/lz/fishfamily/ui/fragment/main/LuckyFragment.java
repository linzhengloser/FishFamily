package com.lz.fishfamily.ui.fragment.main;

import android.os.Bundle;
import android.view.View;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.activity.main.WeeklyLuckyActivity;
import com.lz.fishfamily.ui.base.BaseFragment;

import butterknife.OnClick;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/24
 *     desc   : 首页 -> 抽奖
 *     version: 1.0
 * </pre>
 */
public class LuckyFragment extends BaseFragment {

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_main_lucky;
    }


    @OnClick({R.id.ll_weekly_lucky})
    public void onClick(View view) {
        if (view.getId() == R.id.ll_weekly_lucky) {
            WeeklyLuckyActivity.toActivity(view.getContext());
        }
    }

    public static LuckyFragment newInstance() {
        Bundle args = new Bundle();
        LuckyFragment fragment = new LuckyFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
