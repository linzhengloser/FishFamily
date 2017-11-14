package com.lz.fishfamily.ui.fragment.mine

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.lz.fishfamily.R
import com.lz.fishfamily.module.mine.Task
import com.lz.fishfamily.ui.base.BaseListFragment
import com.lz.fishfamily.ui.multitype.mine.TaskItemViewBinder
import com.zhy.autolayout.utils.AutoUtils
import kotlinx.android.synthetic.main.fragment_task_list.*
import java.util.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/10/12
 * desc   : 任务中心 每日任务 or 主线任务
 * version: 1.0
</pre> *
 */
class TaskListFragment : BaseListFragment() {

    override val contentViewLayoutID: Int
        get() = R.layout.fragment_task_list


    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        mItems.addAll(arguments.getParcelableArrayList("taskList"))
        rv_task_list.layoutManager = LinearLayoutManager(context)
        rv_task_list.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
                outRect.set(0, AutoUtils.getPercentHeightSize(30), 0, 0)
            }
        })
        rv_task_list.adapter = mAdapter
    }

    override fun registerItemViewBinder() {
        mAdapter.register(Task::class.java, TaskItemViewBinder())
    }

    companion object {

        fun newInstance(taskList: List<Task>): TaskListFragment {
            val args = Bundle()
            val fragment = TaskListFragment()
            args.putParcelableArrayList("taskList", taskList as ArrayList<Task>)
            fragment.arguments = args
            return fragment
        }
    }

}
