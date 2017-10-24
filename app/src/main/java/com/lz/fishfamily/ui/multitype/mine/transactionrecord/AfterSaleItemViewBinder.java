package com.lz.fishfamily.ui.multitype.mine.transactionrecord;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.TransactionRecord;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/14
 *     desc   : 我的 交易中心 售后/退货
 *     version: 1.0
 * </pre>
 */
public class AfterSaleItemViewBinder extends ItemViewBinder<TransactionRecord, AfterSaleItemViewBinder.AfterSaleViewHolder> {


    @NonNull
    @Override
    protected AfterSaleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new AfterSaleViewHolder(inflater.inflate(R.layout.item_mine_transaction_record_after_sale, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull AfterSaleViewHolder holder, @NonNull TransactionRecord item) {

    }

    static class AfterSaleViewHolder extends BaseViewHolder {

        public AfterSaleViewHolder(View itemView) {
            super(itemView);
        }
    }

}
