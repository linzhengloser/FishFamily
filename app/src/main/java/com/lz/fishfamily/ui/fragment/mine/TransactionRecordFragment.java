package com.lz.fishfamily.ui.fragment.mine;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.Constant;
import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.TransactionRecord;
import com.lz.fishfamily.ui.activity.mine.TransactionRecordActivity;
import com.lz.fishfamily.ui.base.BaseListFragment;
import com.lz.fishfamily.ui.itemdecoration.TransactionRecordItemDecoration;
import com.lz.fishfamily.ui.multitype.mine.transactionrecord.BuyItemViewBinder;
import com.lz.fishfamily.ui.multitype.mine.transactionrecord.SalelItemViewBinder;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/14
 *     desc   : 我的 -> 交易记录 待付款 待发货 已发货
 *     version: 1.0
 * </pre>
 */
public class TransactionRecordFragment extends BaseListFragment {

    // 1 买入 2 卖出
    private int mType;

    @BindView(R.id.rv_transaction_record)
    RecyclerView rv_transaction_record;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        mType = getArguments().getInt(Constant.INTENT_KEY_TYPE);

        rv_transaction_record.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_transaction_record.addItemDecoration(new TransactionRecordItemDecoration());

        for (int i = 0; i < 20; i++) {
            getMItems().add(new TransactionRecord());
        }

        rv_transaction_record.setAdapter(getMAdapter());
    }

    @Override
    protected void registerItemViewBinder() {
        if(mType == TransactionRecordActivity.TYPE_BUY)
            getMAdapter().register(TransactionRecord.class,new BuyItemViewBinder());
        else
            getMAdapter().register(TransactionRecord.class,new SalelItemViewBinder());
    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_transaction_record;
    }

    public static TransactionRecordFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(Constant.INTENT_KEY_TYPE,type);
        TransactionRecordFragment fragment = new TransactionRecordFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
