package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/11
 *     desc   : 我的钱包 顶部 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class MyWalletTopItemViewBinder extends ItemViewBinder<String,MyWalletTopItemViewBinder.MyWalletTopViewHolder> {


    @NonNull
    @Override
    protected MyWalletTopViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new MyWalletTopViewHolder(inflater.inflate(R.layout.item_mine_my_wallet_top,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull MyWalletTopViewHolder holder, @NonNull String item) {

    }

    static class MyWalletTopViewHolder extends BaseViewHolder{

        public MyWalletTopViewHolder(View itemView) {
            super(itemView);
        }
    }

}
