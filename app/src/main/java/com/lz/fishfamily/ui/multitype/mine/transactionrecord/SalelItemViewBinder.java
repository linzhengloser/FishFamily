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
 *     desc   : 我的 交易记录 我卖出的 待付款 待发货 已发货 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class SalelItemViewBinder extends ItemViewBinder<TransactionRecord,SalelItemViewBinder.SaleViewHolder> {


    @NonNull
    @Override
    protected SaleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new SaleViewHolder(inflater.inflate(R.layout.item_mine_transaction_record_sale,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull SaleViewHolder holder, @NonNull TransactionRecord item) {

    }

    static class SaleViewHolder extends BaseViewHolder{

        public SaleViewHolder(View itemView) {
            super(itemView);
        }
    }


}
