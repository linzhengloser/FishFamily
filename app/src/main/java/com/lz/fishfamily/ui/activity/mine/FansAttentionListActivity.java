package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.Constant;
import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Fans;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.itemdecoration.PaddingItemDecoration;
import com.lz.fishfamily.ui.multitype.mine.FansAttentionItemViewBinder;
import com.lz.fishfamily.utils.Utils;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/16
 *     desc   : 我的 -> 粉丝 or 关注
 *     version: 1.0
 * </pre>
 */
public class FansAttentionListActivity extends BaseListActivity {

    private static final int TYPE_FANS = 1;

    private static final int TYPE_ATTENTION = 2;

    @BindView(R.id.rv_mine_fans)
    RecyclerView rv_mine_fans;

    int mType;

    String mTitles[] = {"我的粉丝", "关注的人"};

    @Override
    protected void registerItemViewBinder() {
        mType = getIntent().getIntExtra(Constant.INTENT_KEY_TYPE, 1);
        getMAdapter().register(Fans.class, new FansAttentionItemViewBinder(mType));
    }

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.setTitle(this, mTitles[mType - 1]);
        rv_mine_fans.setLayoutManager(new LinearLayoutManager(this));
        rv_mine_fans.addItemDecoration(new PaddingItemDecoration().setPadding(AutoUtils.getPercentWidthSize(30), 0));
        for (int i = 0; i < 20; i++) {
            getMItems().add(new Fans());
        }
        rv_mine_fans.setAdapter(getMAdapter());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_fans_list;
    }

    public static void toActivity(Context context, int type) {
        Intent intent = new Intent(context, FansAttentionListActivity.class);
        intent.putExtra(Constant.INTENT_KEY_TYPE, type);
        context.startActivity(intent);
    }

    public static void toFansActivity(Context context) {
        toActivity(context, TYPE_FANS);
    }

    public static void toAttentionActivity(Context context) {
        toActivity(context, TYPE_ATTENTION);
    }

}
