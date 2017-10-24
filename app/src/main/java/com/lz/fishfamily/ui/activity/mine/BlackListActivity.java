package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Fans;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.itemdecoration.PaddingItemDecoration;
import com.lz.fishfamily.ui.multitype.mine.BlackListItemViewBinder;
import com.lz.fishfamily.utils.Utils;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/17
 *     desc   : 我的 -> 设置 -> 黑名单
 *     version: 1.0
 * </pre>
 */
public class BlackListActivity extends BaseListActivity {

    @BindView(R.id.rv_mine_black_list)
    RecyclerView rv_mine_black_list;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.setTitle(this, "黑名单");
        rv_mine_black_list.setLayoutManager(new LinearLayoutManager(this));
        rv_mine_black_list.addItemDecoration(new PaddingItemDecoration().setPadding(AutoUtils.getPercentWidthSize(30), 0));
        for (int i = 0; i < 20; i++) {
            getMItems().add(new Fans());
        }
        rv_mine_black_list.setAdapter(getMAdapter());
    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(Fans.class, new BlackListItemViewBinder());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_black_list;
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, BlackListActivity.class);
        context.startActivity(intent);
    }

}
