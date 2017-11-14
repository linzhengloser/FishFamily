package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.shop.Shop;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/14
 *     desc   : 购物车 商品 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class ShoppingCarCommodityItemViewBinder extends ItemViewBinder<Shop,ShoppingCarCommodityItemViewBinder.ShoppingCarCommodityViewHolder> {

    @NonNull
    @Override
    protected ShoppingCarCommodityViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ShoppingCarCommodityViewHolder(inflater.inflate(R.layout.item_mine_shopping_car_commodity,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ShoppingCarCommodityViewHolder holder, @NonNull Shop item) {

    }

    static class ShoppingCarCommodityViewHolder extends BaseViewHolder{

        public ShoppingCarCommodityViewHolder(View itemView) {
            super(itemView);
        }
    }

}
