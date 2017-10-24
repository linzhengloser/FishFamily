package com.lz.fishfamily.ui.activity.mine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.User;
import com.lz.fishfamily.module.mine.Post;
import com.lz.fishfamily.ui.base.BaseListActivity;
import com.lz.fishfamily.ui.multitype.mine.PostItemViewBinder;
import com.lz.fishfamily.ui.multitype.mine.ProfileTopItemViewBinder;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/20
 *     desc   : 用户详细详细列表展示
 *     version: 1.0
 * </pre>
 */
public class ProfileListActivity extends BaseListActivity {

    @BindView(R.id.rv_profile_list)
    RecyclerView rv_profile_list;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        rv_profile_list.setLayoutManager(new LinearLayoutManager(this));

        getMItems().add(new User());
        getMItems().add(new Post());
        getMItems().add(new Post());
        getMItems().add(new Post());
        getMItems().add(new Post());
        getMItems().add(new Post());
        getMItems().add(new Post());

        rv_profile_list.setAdapter(getMAdapter());
    }

    @Override
    protected void registerItemViewBinder() {
        getMAdapter().register(User.class, new ProfileTopItemViewBinder());
        getMAdapter().register(Post.class, new PostItemViewBinder());
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_profile_list;
    }
}
