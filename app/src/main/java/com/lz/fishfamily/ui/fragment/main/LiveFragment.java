package com.lz.fishfamily.ui.fragment.main;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.Live;
import com.lz.fishfamily.ui.base.BaseListFragment;
import com.lz.fishfamily.ui.multitype.main.live.LiveItemViewBinder;
import com.lz.fishfamily.ui.multitype.main.live.LiveTopItemViewBinder;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/25
 *     desc   : 首页 -> 直播
 *     version: 1.0
 * </pre>
 */
public class LiveFragment extends BaseListFragment {

    @BindView(R.id.rv_live)
    RecyclerView rv_live;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return getMItems().get(position) instanceof String ? 2 : 1;
            }
        });
        rv_live.setLayoutManager(gridLayoutManager);
        rv_live.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildLayoutPosition(view);
                int spanSize = gridLayoutManager.getSpanSizeLookup().getSpanSize(position);
                if (spanSize != 1) return;
                if (position % 2 != 0) {
                    outRect.set(0, 0, AutoUtils.getPercentWidthSize(18), AutoUtils.getPercentWidthSize(18));
                } else {
                    outRect.set(0, 0, 0, AutoUtils.getPercentWidthSize(18));
                }
            }
        });

        getMItems().add("直播间权限申请");
        for (int i = 0; i < 20; i++) {
            getMItems().add(new Live());
        }
        rv_live.setAdapter(getMAdapter());
    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(String.class, new LiveTopItemViewBinder());
        getMAdapter().register(Live.class, new LiveItemViewBinder());
    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_main_live;
    }

    public static LiveFragment newInstance() {
        Bundle args = new Bundle();
        LiveFragment fragment = new LiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
