package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.ShoppingAddress;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.multitype.mine.ShoppingAddressItemViewBinder;
import com.lz.fishfamily.utils.Utils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/15
 *     desc   : 我的 -> 设置 -> 收货地址
 *     version: 1.0
 * </pre>
 */
public class ShoppingAddressActivity extends BaseListActivity {

    @BindView(R.id.rv_shoppint_address)
    RecyclerView rv_shoppint_address;

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(ShoppingAddress.class,new ShoppingAddressItemViewBinder());
    }

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.setTitle(this,"收货地址管理");
        Utils.setMenuText(this,"添加");
        rv_shoppint_address.setLayoutManager(new LinearLayoutManager(this));
        rv_shoppint_address.setAdapter(getMAdapter());
        getMItems().add(new ShoppingAddress());
        getMItems().add(new ShoppingAddress());
        getMItems().add(new ShoppingAddress());
        getMItems().add(new ShoppingAddress());
        getMAdapter().notifyDataSetChanged();
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_shopping_address;
    }
    
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, ShoppingAddressActivity.class);
        context.startActivity(intent);
    }
    
}
