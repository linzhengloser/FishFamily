package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Task;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/12
 *     desc   : 任务中心 任务 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class TaskItemViewBinder extends ItemViewBinder<Task,TaskItemViewBinder.TaskViewHolder> {

    @NonNull
    @Override
    protected TaskViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new TaskViewHolder(inflater.inflate(R.layout.item_mine_task,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull TaskViewHolder holder, @NonNull Task item) {

    }

    static class TaskViewHolder extends BaseViewHolder{

        public TaskViewHolder(View itemView) {
            super(itemView);
        }
    }

}
