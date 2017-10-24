package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Draft;
import com.lz.library.base.BaseViewHolder;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/17
 *     desc   : 草稿 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class DraftIemViewBinder extends ItemViewBinder<Draft, DraftIemViewBinder.DraftViewHolder> {


    @NonNull
    @Override
    protected DraftViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new DraftViewHolder(inflater.inflate(R.layout.item_mine_draft, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull DraftViewHolder holder, @NonNull Draft item) {
        holder.iv_item_icon.setImageResource(item.getIcon());
        holder.tv_item_title.setText(item.getTitle());
        holder.tv_item_content.setText(item.getContent());
        holder.tv_item_date.setText(item.getDate());
    }

    static class DraftViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_item_icon)
        ImageView iv_item_icon;

        @BindView(R.id.tv_item_title)
        TextView tv_item_title;

        @BindView(R.id.tv_item_content)
        TextView tv_item_content;

        @BindView(R.id.tv_item_date)
        TextView tv_item_date;

        public DraftViewHolder(View itemView) {
            super(itemView);
        }
    }

}
