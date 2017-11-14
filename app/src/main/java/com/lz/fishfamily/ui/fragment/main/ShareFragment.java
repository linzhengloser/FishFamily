package com.lz.fishfamily.ui.fragment.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.Comment;
import com.lz.fishfamily.module.main.LikeList;
import com.lz.fishfamily.module.main.PostDivider;
import com.lz.fishfamily.module.mine.Post;
import com.lz.fishfamily.ui.base.BaseListFragment;
import com.lz.fishfamily.ui.multitype.main.CommentItemViewBinder;
import com.lz.fishfamily.ui.multitype.main.CommonSearchItemViewBinder;
import com.lz.fishfamily.ui.multitype.main.LikeAvatarItemViewBinder;
import com.lz.fishfamily.ui.multitype.main.post.PostDividerItemViewBinder;
import com.lz.fishfamily.ui.multitype.main.post.PostItemViewBinder;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/23
 *     desc   : 首页 -> 分享
 *     version: 1.0
 * </pre>
 */
public class ShareFragment extends BaseListFragment {

    @BindView(R.id.rv_main_share)
    RecyclerView rv_main_share;

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(Post.class, new PostItemViewBinder());
        getMAdapter().register(String.class, new CommonSearchItemViewBinder());
        getMAdapter().register(LikeList.class, new LikeAvatarItemViewBinder());
        getMAdapter().register(PostDivider.class, new PostDividerItemViewBinder());
        getMAdapter().register(Comment.class, new CommentItemViewBinder());
    }

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();

        getMItems().add("搜索");

        for (int i = 0; i < 10; i++) {
            getMItems().add(new Post());
            getMItems().add(new PostDivider());
            getMItems().add(new Post());
            getMItems().add(new PostDivider().setShowMoreComent(true));
        }

        rv_main_share.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_main_share.setAdapter(getMAdapter());
    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_main_share;
    }

    public static ShareFragment newInstance() {
        Bundle args = new Bundle();
        ShareFragment fragment = new ShareFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
