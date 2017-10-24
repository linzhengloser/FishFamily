package com.lz.fishfamily.ui.fragment.mine;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Task;
import com.lz.fishfamily.ui.base.BaseListFragment;
import com.lz.fishfamily.ui.multitype.mine.TaskItemViewBinder;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/12
 *     desc   : 任务中心 每日任务 or 主线任务
 *     version: 1.0
 * </pre>
 */
public class TaskListFragment extends BaseListFragment {


    @BindView(R.id.rv_task_list)
    RecyclerView rv_task_list;

    @Override
    protected void initViewsAndEvents() {
        super.initViewsAndEvents();
        rv_task_list.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_task_list.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0, AutoUtils.getPercentHeightSize(30),0,0);
            }
        });

        for (int i = 0; i < 10; i++) {
            getMItems().add(new Task());
        }
        rv_task_list.setAdapter(getMAdapter());
    }

    @Override
    protected void registerItemViewBinder() {

        getMAdapter().register(Task.class,new TaskItemViewBinder());

    }

    @Override
    public int getContentViewLayoutID() {
        return R.layout.fragment_task_list;
    }

    public static TaskListFragment newInstance() {
        Bundle args = new Bundle();
        TaskListFragment fragment = new TaskListFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
