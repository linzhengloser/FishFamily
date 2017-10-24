package com.lz.fishfamily.ui.multitype.main;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.Shop;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/25
 *     desc   : 首页 -> 商品详情 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class CommodityDetailItemViewBinder extends ItemViewBinder<Shop,CommodityDetailItemViewBinder.CommodityDetailViewHolder> {

    @NonNull
    @Override
    protected CommodityDetailViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new CommodityDetailViewHolder(inflater.inflate(R.layout.item_main_commodity_detail,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull CommodityDetailViewHolder holder, @NonNull Shop item) {

    }

    static class CommodityDetailViewHolder extends BaseViewHolder{

        public CommodityDetailViewHolder(View itemView) {
            super(itemView);
        }

    }

}
