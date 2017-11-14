package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Post;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.itemdecoration.PostItemDecoration;
import com.lz.fishfamily.ui.multitype.mine.PostItemViewBinder;
import com.lz.fishfamily.utils.Utils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/20
 *     desc   : 我的 -> 分享
 *     version: 1.0
 * </pre>
 */
public class ShareListActivity extends BaseListActivity {


    @BindView(R.id.rv_share_list)
    RecyclerView rv_share_list;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.INSTANCE.setTitle(this, "我的分享");

        rv_share_list.setLayoutManager(new LinearLayoutManager(this));
        rv_share_list.addItemDecoration(new PostItemDecoration());

        getMItems().add(new Post());
        getMItems().add(new Post());

        rv_share_list.setAdapter(getMAdapter());

    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(Post.class, new PostItemViewBinder());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_share_list;
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, ShareListActivity.class);
        context.startActivity(intent);
    }

}
