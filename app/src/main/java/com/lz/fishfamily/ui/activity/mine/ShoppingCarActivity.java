package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.Shop;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.multitype.mine.ShoppingCarCommodityItemViewBinder;
import com.lz.fishfamily.ui.multitype.mine.ShoppingCarShopItemViewBinder;
import com.lz.fishfamily.utils.Utils;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/14
 *     desc   : 我的 -> 购物车
 *     version: 1.0
 * </pre>
 */
public class ShoppingCarActivity extends BaseListActivity {

    @BindView(R.id.rv_shopping_car)
    RecyclerView rv_shopping_car;


    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.setTitle(this, "购物车");
        Utils.setMenuText(this, "编辑");
        rv_shopping_car.setLayoutManager(new LinearLayoutManager(this));
        rv_shopping_car.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = parent.getChildAdapterPosition(view);
                Object data = getMItems().get(position);
                if (position > 0 && data instanceof com.lz.fishfamily.module.mine.Shop)
                    outRect.set(0, AutoUtils.getPercentHeightSize(20), 0, 0);
            }
        });


        for (int i = 0; i < 5; i++) {
            getMItems().add(new com.lz.fishfamily.module.mine.Shop());
            for (int n = 0; n < 3; n++) {
                getMItems().add(new Shop());
            }
        }

        rv_shopping_car.setAdapter(getMAdapter());

    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(com.lz.fishfamily.module.mine.Shop.class, new ShoppingCarShopItemViewBinder());
        getMAdapter().register(Shop.class, new ShoppingCarCommodityItemViewBinder());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_shopping_car;
    }
    
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, ShoppingCarActivity.class);
        context.startActivity(intent);
    }
    
}
