package com.lz.fishfamily.ui.fragment.main;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.User;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.multitype.main.LikeListItemViewBinder;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/27
 *     desc   : 首页 -> 点赞列表
 *     version: 1.0
 * </pre>
 */
public class LikeListActivity extends BaseListActivity {

    @BindView(R.id.rv_like_list)
    RecyclerView rv_like_list;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        rv_like_list.setLayoutManager(new LinearLayoutManager(this));
        rv_like_list.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0, 0, 0, AutoUtils.getPercentHeightSize(1));
            }
        });
        for (int i = 0; i < 20; i++) {
            getMItems().add(new User());
        }
        rv_like_list.setAdapter(getMAdapter());
    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(User.class, new LikeListItemViewBinder());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_like_list;
    }
}
