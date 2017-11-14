package com.lz.fishfamily.ui.activity.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.PostComment;
import com.lz.fishfamily.module.mine.Post;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.dialog.ShareDialogFragment;
import com.lz.fishfamily.ui.multitype.main.post.PostDetailCommentItemViewBinder;
import com.lz.fishfamily.ui.multitype.main.post.PostDetailItemViewBinder;
import com.lz.fishfamily.utils.Utils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/25
 *     desc   : 首页 -> 帖子详情
 *     version: 1.0
 * </pre>
 */
public class PostDetailActivity extends BaseListActivity {

    @BindView(R.id.rv_post_detail)
    RecyclerView rv_post_detail;

    ShareDialogFragment mShareDialogFragment;

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(Post.class, new PostDetailItemViewBinder());
        getMAdapter().register(PostComment.class, new PostDetailCommentItemViewBinder());
    }

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        Utils.INSTANCE.setTitle(this, "文章详情");
        Utils.INSTANCE.visibleMenuIcon(this);
        getMItems().add(new Post());
        for (int i = 0; i < 20; i++) {
            getMItems().add(new PostComment());
        }
        rv_post_detail.setLayoutManager(new LinearLayoutManager(this));
        rv_post_detail.setAdapter(getMAdapter());
        mShareDialogFragment = new ShareDialogFragment();
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, PostDetailActivity.class);
        context.startActivity(intent);
    }

    @OnClick({R.id.menu_icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu_icon:
                mShareDialogFragment.show(getSupportFragmentManager());
                break;
        }
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_main_post_detail;
    }
}
