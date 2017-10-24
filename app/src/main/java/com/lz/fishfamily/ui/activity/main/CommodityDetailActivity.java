package com.lz.fishfamily.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.Shop;
import com.lz.fishfamily.module.main.PostComment;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.multitype.main.CommodityDetailCommentItemViewBinder;
import com.lz.fishfamily.ui.multitype.main.CommodityDetailItemViewBinder;
import com.lz.fishfamily.utils.Utils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/25
 *     desc   : 首页 -> 商品详情
 *     version: 1.0
 * </pre>
 */
public class CommodityDetailActivity extends BaseListActivity {

    @BindView(R.id.rv_commodity_detail)
    RecyclerView rv_commodity_detail;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.setTitle(this,"商品详情 ");
        rv_commodity_detail.setLayoutManager(new LinearLayoutManager(this));
        getMItems().add(new Shop());
        for (int i = 0; i < 20; i++) {
            getMItems().add(new PostComment());
        }
        rv_commodity_detail.setAdapter(getMAdapter());
    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(Shop.class,new CommodityDetailItemViewBinder());
        getMAdapter().register(PostComment.class,new CommodityDetailCommentItemViewBinder());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_main_commodity_detail;
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, CommodityDetailActivity.class);
        context.startActivity(intent);
    }
}
