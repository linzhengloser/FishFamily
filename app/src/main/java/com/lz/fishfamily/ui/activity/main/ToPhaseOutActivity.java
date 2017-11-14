package com.lz.fishfamily.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.ToPhaseOut;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.multitype.main.lucky.LuckyToPhaseOutItemViewBinder;
import com.lz.fishfamily.utils.Utils;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/21
 *     desc   : 首页 -> 抽奖 -> 每周抽奖 -> 往期揭晓
 *     version: 1.0
 * </pre>
 */
public class ToPhaseOutActivity extends BaseListActivity {

    @BindView(R.id.rv_to_phase_out)
    RecyclerView rv_to_phase_out;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.INSTANCE.setTitle(this, "往期揭晓");
        rv_to_phase_out.setLayoutManager(new LinearLayoutManager(this));
        rv_to_phase_out.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int padding = AutoUtils.getPercentWidthSize(20);
                outRect.set(padding, padding, padding, 0);
            }
        });

        for (int i = 0; i < 20; i++) {
            getMItems().add(new ToPhaseOut());
        }
        rv_to_phase_out.setAdapter(getMAdapter());

    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(ToPhaseOut.class, new LuckyToPhaseOutItemViewBinder());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_main_lucky_to_phase_out;
    }
    
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, ToPhaseOutActivity.class);
        context.startActivity(intent);
    }
    
}
