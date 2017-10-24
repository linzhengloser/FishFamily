package com.lz.fishfamily.ui.fragment.mine;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.User;
import com.lz.fishfamily.module.mine.MineDivider;
import com.lz.fishfamily.module.mine.MineSimpleItem;
import com.lz.fishfamily.ui.activity.LoginActivity;
import com.lz.fishfamily.ui.activity.mine.DraftBoxActivity;
import com.lz.fishfamily.ui.activity.mine.MerchantEnterActivity;
import com.lz.fishfamily.ui.activity.mine.MyWalletActivity;
import com.lz.fishfamily.ui.activity.mine.SettingActivity;
import com.lz.fishfamily.ui.activity.mine.ShoppingCarActivity;
import com.lz.fishfamily.ui.activity.mine.SubmitTextActivity;
import com.lz.fishfamily.ui.activity.mine.TaskCenterActivity;
import com.lz.fishfamily.ui.multitype.mine.MineDividerItemViewBinder;
import com.lz.fishfamily.ui.multitype.mine.MineProfileItemViewBinder;
import com.lz.fishfamily.ui.multitype.mine.MineSimpleItemViewBinder;
import com.lz.fishfamily.ui.activity.mine.TransactionRecordActivity;
import com.lz.fishfamily.utils.UserManager;
import com.lz.fishfamily.utils.Utils;
import com.lz.fishfamily.utils.event.LoginEvent;
import com.lz.library.base.LibraryBaseListFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/23
 *     desc   : 首页 -> 我的
 *     version: 1.0
 * </pre>
 */
public class MineFragment extends LibraryBaseListFragment {


    @BindView(R.id.rv_mine)
    RecyclerView rv_mine;

    @Override
    protected void registerItemViewBinder() {
        EventBus.getDefault().register(this);
        getMAdapter().register(User.class, new MineProfileItemViewBinder());
        getMAdapter().register(MineSimpleItem.class, new MineSimpleItemViewBinder());
        getMAdapter().register(MineDivider.class, new MineDividerItemViewBinder());
    }

    @Override
    public void onResume() {
        super.onResume();
        getMItems().set(1, UserManager.getUser());
        getMAdapter().notifyDataSetChanged();
    }

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.goneBack(getView());
        Utils.setTitle(getView(), "我的");
        getMItems().add(new MineDivider());
        getMItems().add(new User());
        getMItems().add(new MineDivider());
        getMItems().addAll(initSimpleItem());
        rv_mine.setAdapter(getMAdapter());
        rv_mine.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private List initSimpleItem() {
        ArrayList simpleItems = new ArrayList();
        simpleItems.add(new MineSimpleItem(R.drawable.mine_simple_item_wallet, "我的钱包"));
        simpleItems.add(new MineSimpleItem(R.drawable.mine_simple_item_transaction_record, "交易记录"));
        simpleItems.add(new MineSimpleItem(R.drawable.mine_simple_item_shopping_cart, "我的购物车").setNeedLine(false));
        simpleItems.add(new MineDivider());
        simpleItems.add(new MineSimpleItem(R.drawable.mine_simple_item_task_center, "任务中心"));
        simpleItems.add(new MineSimpleItem(R.drawable.mine_simple_item_draft_box, "草稿箱"));
        simpleItems.add(new MineSimpleItem(R.drawable.mine_simple_item_share, "向朋友推荐鱼友之家").setNeedLine(false));
        simpleItems.add(new MineDivider());
        simpleItems.add(new MineSimpleItem(R.drawable.mine_simple_item_feedback, "意见反馈"));
        simpleItems.add(new MineSimpleItem(R.drawable.mine_simple_item_setting, "设置"));
        simpleItems.add(new MineSimpleItem(R.drawable.mine_simple_item_merchant_enter, "商家入驻").setNeedLine(false));
        return simpleItems;
    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_mine;
    }


    @OnClick({R.id.btn_login})
    public void login(View view) {
        LoginActivity.toActivity(view.getContext());
    }

    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Subscribe
    public void onClickEvent(LoginEvent event) {
        switch (event.getEventType()) {
            case MineSimpleItem.TYPE_FEEDBACK:
                SubmitTextActivity.toFeedBackActivity(getContext());
                break;
            case MineSimpleItem.TYPE_SETTING:
                SettingActivity.toActivity(getContext());
                break;
            case MineSimpleItem.TYPE_MERCHANT_ENTER:
                MerchantEnterActivity.toActivity(getContext());
                break;
            case MineSimpleItem.TYPE_DRAFT_BOX:
                DraftBoxActivity.toActivity(getContext());
                break;
            case MineSimpleItem.TYPE_MY_WALLET:
                MyWalletActivity.toActivity(getContext());
                break;
            case MineSimpleItem.TYPE_TASK_CENTER:
                TaskCenterActivity.toActivity(getContext());
                break;
            case MineSimpleItem.TYPE_MY_SHOPPINT_CAR:
                ShoppingCarActivity.toActivity(getContext());
                break;
            case MineSimpleItem.TYPE_TRANSACTION_RECORD:
                TransactionRecordActivity.toBuy(getContext());
                break;
        }
    }

}
