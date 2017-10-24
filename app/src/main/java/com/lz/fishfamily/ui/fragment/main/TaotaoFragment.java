package com.lz.fishfamily.ui.fragment.main;

import android.os.Bundle;
import android.view.View;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.activity.main.MerchantLivingBodyActivity;
import com.lz.fishfamily.ui.base.BaseFragment;

import butterknife.OnClick;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/24
 *     desc   : 首页 -> 淘淘
 *     version: 1.0
 * </pre>
 */
public class TaotaoFragment extends BaseFragment {
    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_main_lucky;
    }

    public static TaotaoFragment newInstance() {
        Bundle args = new Bundle();
        TaotaoFragment fragment = new TaotaoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({R.id.ll_merchant_living_body})
    public void onClick(View view) {
        if (view.getId() == R.id.ll_merchant_living_body) {
            MerchantLivingBodyActivity.Companion.toActivity(getContext());
        }
    }

}
