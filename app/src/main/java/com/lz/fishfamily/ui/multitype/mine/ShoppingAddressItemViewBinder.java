package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.ShoppingAddress;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/15
 *     desc   : 购物车 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class ShoppingAddressItemViewBinder extends ItemViewBinder<ShoppingAddress, ShoppingAddressItemViewBinder.ShoppintAddressViewHolder> {

    @NonNull
    @Override
    protected ShoppintAddressViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ShoppintAddressViewHolder(inflater.inflate(R.layout.item_shopping_address, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ShoppintAddressViewHolder holder, @NonNull ShoppingAddress item) {

    }

    static class ShoppintAddressViewHolder extends BaseViewHolder {

        public ShoppintAddressViewHolder(View itemView) {
            super(itemView);
        }
    }

}
