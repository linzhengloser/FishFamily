package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Shop;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/14
 *     desc   : 购物车 商店 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class ShoppingCarShopItemViewBinder extends ItemViewBinder<Shop,ShoppingCarShopItemViewBinder.ShoppingCarShopViewHolder> {

    @NonNull
    @Override
    protected ShoppingCarShopViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ShoppingCarShopViewHolder(inflater.inflate(R.layout.item_mine_shopping_car_shop,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ShoppingCarShopViewHolder holder, @NonNull Shop item) {

    }

    static class ShoppingCarShopViewHolder extends BaseViewHolder{

        public ShoppingCarShopViewHolder(View itemView) {
            super(itemView);
        }

    }

}
