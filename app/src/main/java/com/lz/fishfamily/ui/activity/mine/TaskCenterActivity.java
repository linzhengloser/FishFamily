package com.lz.fishfamily.ui.activity.mine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.ui.base.BaseActivity;
import com.lz.fishfamily.ui.fragment.mine.TaskListFragment;
import com.lz.fishfamily.utils.Utils;
import com.lz.library.base.BaseViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/12
 *     desc   : 我的 -> 任务中心
 *     version: 1.0
 * </pre>
 */
public class TaskCenterActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.vp_task_center)
    ViewPager vp_task_center;

    @BindView(R.id.tv_everyday_task)
    TextView tv_everyday_task;

    @BindView(R.id.v_everyday_task)
    View v_everyday_task;

    @BindView(R.id.tv_main_task)
    TextView tv_main_task;

    @BindView(R.id.v_main_task)
    View v_main_task;

    List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void initViewsAndEvents() {
        Utils.setTitle(this, "任务中心");
        mFragmentList.add(TaskListFragment.newInstance());
        mFragmentList.add(TaskListFragment.newInstance());
        vp_task_center.setAdapter(new BaseViewPagerAdapter(getSupportFragmentManager(), mFragmentList));
        vp_task_center.addOnPageChangeListener(this);
    }

    @Override
    protected int getContentViewResourceID() {
        return R.layout.activity_task_center;
    }

    @OnClick({R.id.fl_everyday_task, R.id.fl_main_task})
    public void onClick(View view) {
        if (view.getId() == R.id.fl_everyday_task) {
            changeTab(0);
        } else if(view.getId() == R.id.fl_main_task) {
            changeTab(1);
        }
    }

    private void changeTab(int position) {
        if (position == 0) {
            tv_everyday_task.setTextColor(getResources().getColor(R.color.colorPrimary));
            v_everyday_task.setVisibility(View.VISIBLE);
            tv_main_task.setTextColor(Color.parseColor("#242424"));
            v_main_task.setVisibility(View.GONE);
        } else {
            tv_everyday_task.setTextColor(Color.parseColor("#242424"));
            v_everyday_task.setVisibility(View.GONE);
            tv_main_task.setTextColor(getResources().getColor(R.color.colorPrimary));
            v_main_task.setVisibility(View.VISIBLE);
        }
    }

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, TaskCenterActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changeTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
