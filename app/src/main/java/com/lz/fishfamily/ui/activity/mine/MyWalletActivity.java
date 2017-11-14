package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.TransactionRecord;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.itemdecoration.PaddingItemDecoration;
import com.lz.fishfamily.ui.multitype.mine.MyWalletTopItemViewBinder;
import com.lz.fishfamily.ui.multitype.mine.MyWalletTransactionRecordItemViewBinder;
import com.lz.fishfamily.utils.Utils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/11
 *     desc   : 我的 -> 我的钱包
 *     version: 1.0
 * </pre>
 */
public class MyWalletActivity extends BaseListActivity {

    @BindView(R.id.rv_my_wallet)
    RecyclerView rv_my_wallet;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.INSTANCE.setTitle(this, "我的钱包");
        Utils.INSTANCE.setMenuText(this, "帮助");

        rv_my_wallet.setLayoutManager(new LinearLayoutManager(this));
        rv_my_wallet.addItemDecoration(new PaddingItemDecoration().setPadding(30, 30));

        getMItems().add("");
        for (int i = 0; i < 10; i++) {
            getMItems().add(new TransactionRecord());
        }

        rv_my_wallet.setAdapter(getMAdapter());

    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(String.class, new MyWalletTopItemViewBinder());
        getMAdapter().register(TransactionRecord.class, new MyWalletTransactionRecordItemViewBinder());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_my_wallet;
    }
    
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, MyWalletActivity.class);
        context.startActivity(intent);
    }
    
}
