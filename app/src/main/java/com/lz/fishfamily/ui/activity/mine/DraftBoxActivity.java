package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Draft;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.multitype.mine.DraftIemViewBinder;
import com.lz.fishfamily.utils.Utils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/17
 *     desc   : 我的 -> 草稿箱
 *     version: 1.0
 * </pre>
 */
public class DraftBoxActivity extends BaseListActivity {

    @BindView(R.id.rv_draft_box)
    RecyclerView rv_draft_box;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.setTitle(this, "草稿箱");
        Utils.setMenuText(this, "编辑");
        rv_draft_box.setLayoutManager(new LinearLayoutManager(this));
        getMItems().add(new Draft(R.drawable.mine_draft_micro_post, "微帖", "我养的鲨鱼不吃肉？", "2017-01-01"));
        getMItems().add(new Draft(R.drawable.mine_draft_long_post, "长帖", "我养的鲨鱼不吃肉？", "2017-01-01"));
        getMItems().add(new Draft(R.drawable.mine_draft_merchant_shop, "商家店体", "我养的鲨鱼不吃肉？", "2017-01-01"));
        getMItems().add(new Draft(R.drawable.mine_draft_fish_friend_transfer, "鱼友转让", "我养的鲨鱼不吃肉？", "2017-01-01"));
        rv_draft_box.setAdapter(getMAdapter());
    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(Draft.class, new DraftIemViewBinder());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_draft_box;
    }
    
    public static void toActivity(Context context) {
        Intent intent = new Intent(context, DraftBoxActivity.class);
        context.startActivity(intent);
    }
    
}
