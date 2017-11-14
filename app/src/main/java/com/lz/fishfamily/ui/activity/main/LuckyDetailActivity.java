package com.lz.fishfamily.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.LuckyRecord;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.multitype.main.lucky.LuckyDetailTopItemViewBinder;
import com.lz.fishfamily.ui.multitype.main.lucky.WeeklyLuckyItemViewBinder;
import com.lz.fishfamily.utils.Utils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/21
 *     desc   : 首页 -> 抽奖 -> 每周抽奖 -> 往期回顾 -> 抽奖详情
 *     version: 1.0
 * </pre>
 */
public class LuckyDetailActivity extends BaseListActivity {

    @BindView(R.id.rv_lucky_detail)
    RecyclerView rv_lucky_detail;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.INSTANCE.setTitle(this,"每周抽奖");

        rv_lucky_detail.setLayoutManager(new LinearLayoutManager(this));

        getMItems().add("");

        for (int i = 0; i < 20; i++) {
            getMItems().add(new LuckyRecord());
        }

        rv_lucky_detail.setAdapter(getMAdapter());
    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(LuckyRecord.class,new WeeklyLuckyItemViewBinder());
        getMAdapter().register(String.class,new LuckyDetailTopItemViewBinder());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_main_lucky_detail;
    }
    
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, LuckyDetailActivity.class);
        context.startActivity(intent);
    }
    
}
