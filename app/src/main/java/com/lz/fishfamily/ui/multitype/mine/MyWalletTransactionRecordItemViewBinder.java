package com.lz.fishfamily.ui.multitype.mine;

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
 *     time   : 2017/10/11
 *     desc   : 我的钱包 交易记录 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class MyWalletTransactionRecordItemViewBinder extends ItemViewBinder<TransactionRecord,MyWalletTransactionRecordItemViewBinder.MyWalletTransactionRecordViewHolder> {

    @NonNull
    @Override
    protected MyWalletTransactionRecordViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new MyWalletTransactionRecordViewHolder(inflater.inflate(R.layout.item_mine_my_wallet_transaction_record,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull MyWalletTransactionRecordViewHolder holder, @NonNull TransactionRecord item) {

    }

    static class MyWalletTransactionRecordViewHolder extends BaseViewHolder{

        public MyWalletTransactionRecordViewHolder(View itemView) {
            super(itemView);
        }
    }

}
