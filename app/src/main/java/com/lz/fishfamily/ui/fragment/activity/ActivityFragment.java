package com.lz.fishfamily.ui.fragment.activity;

import android.os.Bundle;

import com.lz.fishfamily.R;
import com.lz.fishfamily.utils.Utils;
import com.lz.library.base.LibraryBaseFragment;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/23
 *     desc   : 活动 Fragment
 *     version: 1.0
 * </pre>
 */
public class ActivityFragment extends LibraryBaseFragment {
    @Override
    protected void initViewsAndEvents() {
        Utils.setTitle(getView(), "最新活动");
    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_activity;
    }

    public static ActivityFragment newInstance() {
        Bundle args = new Bundle();
        ActivityFragment fragment = new ActivityFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
