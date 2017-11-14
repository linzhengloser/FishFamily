package com.lz.fishfamily.ui.multitype.mine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lz.fishfamily.R
import com.lz.fishfamily.module.mine.Task
import com.lz.fishfamily.utils.Utils
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_mine_task.view.*

import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/10/12
 * desc   : 任务中心 任务 ItemViewBinder
 * version: 1.0
</pre> *
 */
class TaskItemViewBinder : ItemViewBinder<Task, TaskItemViewBinder.TaskViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): TaskViewHolder
            = TaskViewHolder(inflater.inflate(R.layout.item_mine_task, parent, false))

    override fun onBindViewHolder(holder: TaskViewHolder, item: Task) {
        val text = "${item.name}(${if (item.state == 1) "完成" else "${item.number}/${item.totalNumber}"})"
        val awardText = "奖励:  经验值${Utils.setForegroundColorSpan("+${item.empirical}", arrayOf(Pair(0,"+${item.empirical}".length)))}点  鱼豆+${item.yuDou}点"
        holder.itemView.tv_title.text = Utils.setForegroundColorSpan(text, arrayOf(Pair(text.indexOfFirst { it == '(' }, text.length)))
        holder.itemView.tv_desc.text = item.explain
        holder.itemView.tv_award.text = Utils.setForegroundColorSpan(awardText, arrayOf(
                Pair(awardText.indexOfFirst { it == '+' }, awardText.indexOfFirst { it == '+' } + 2),
                Pair(awardText.indexOfLast { it == '+' }, awardText.indexOfLast { it == '+' } + 2)
        ))
    }

    class TaskViewHolder(itemView: View) : BaseViewHolder(itemView)

}
