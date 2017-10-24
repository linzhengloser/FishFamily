package com.lz.fishfamily.ui.fragment.main;

import android.os.Bundle;
import android.view.View;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.activity.SignInActivity;
import com.lz.fishfamily.ui.activity.main.PublishCommodityActivity;
import com.lz.fishfamily.ui.activity.main.PublishLongPostActivity;
import com.lz.fishfamily.ui.activity.main.PublishPostActivity;
import com.lz.fishfamily.ui.base.BaseFragment;

import butterknife.OnClick;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/25
 *     desc   : 发布
 *     version: 1.0
 * </pre>
 */
public class PublishFragment extends BaseFragment {

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_main_publish;
    }

    @OnClick({R.id.ll_sign_in, R.id.ll_publish_commodity,R.id.ll_publish_post})
    public void onClick(View view) {
        switch (view.getId()) {
            //签到
            case R.id.ll_sign_in:
                SignInActivity.toActivity(getContext());
                break;
            //发布商品
            case R.id.ll_publish_commodity:
                PublishCommodityActivity.toActivity(view.getContext());
                break;
            //发布分享
            case R.id.ll_publish_post:
                PublishPostActivity.toActivity(getContext());
                break;
            //发布长帖
            case R.id.ll_publish_long_post:
                PublishLongPostActivity.toActivity(getContext());
                break;
        }
    }


    public static PublishFragment newInstance() {
        Bundle args = new Bundle();
        PublishFragment fragment = new PublishFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
