package com.lz.fishfamily.ui.activity.mine

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import butterknife.OnClick
import com.lz.fishfamily.R
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.UserApi
import com.lz.fishfamily.handlerObservable
import com.lz.fishfamily.ui.base.BaseActivity
import com.lz.fishfamily.ui.fragment.mine.TaskListFragment
import com.lz.fishfamily.utils.Utils
import com.lz.library.base.BaseViewPagerAdapter
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_task_center.*
import java.util.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/10/12
 * desc   : 我的 -> 任务中心
 * version: 1.0
</pre> *
 */
class TaskCenterActivity : BaseActivity(), ViewPager.OnPageChangeListener {

    var mFragmentList: MutableList<Fragment> = ArrayList()

    override val contentViewResourceID: Int
        get() = R.layout.activity_task_center

    override fun initViewsAndEvents() {
        Utils.setTitle(this, "任务中心")
        vp_task_center.addOnPageChangeListener(this)
        val taskList = Api.create(UserApi::class.java).getTaskList()
        handlerObservable(taskList, bindToLifecycle(), Consumer {
            val dailyTaskList = it.filter { it.type == 0 }
            val mainTaskList = it.filter { it.type == 1 }
            mFragmentList.add(TaskListFragment.newInstance(dailyTaskList))
            mFragmentList.add(TaskListFragment.newInstance(mainTaskList))
            vp_task_center.adapter = BaseViewPagerAdapter(supportFragmentManager, mFragmentList)
        })

    }

    @OnClick(R.id.fl_everyday_task, R.id.fl_main_task)
    fun onClick(view: View) {
        if (view.id == R.id.fl_everyday_task) {
            changeTab(0)
        } else if (view.id == R.id.fl_main_task) {
            changeTab(1)
        }
    }

    private fun changeTab(position: Int) {
        if (position == 0) {
            tv_everyday_task.setTextColor(resources.getColor(R.color.colorPrimary))
            v_everyday_task.visibility = View.VISIBLE
            tv_main_task.setTextColor(Color.parseColor("#242424"))
            v_main_task.visibility = View.GONE
        } else {
            tv_everyday_task.setTextColor(Color.parseColor("#242424"))
            v_everyday_task.visibility = View.GONE
            tv_main_task.setTextColor(resources.getColor(R.color.colorPrimary))
            v_main_task.visibility = View.VISIBLE
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        changeTab(position)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    companion object {

        fun toActivity(context: Context) {
            val intent = Intent(context, TaskCenterActivity::class.java)
            context.startActivity(intent)
        }
    }
}
