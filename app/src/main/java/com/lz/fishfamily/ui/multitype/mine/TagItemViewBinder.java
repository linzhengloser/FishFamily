package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Tag;
import com.lz.fishfamily.utils.Utils;
import com.lz.library.base.BaseViewHolder;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/17
 *     desc   : 标签 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class TagItemViewBinder extends ItemViewBinder<Tag, TagItemViewBinder.TagViewHolder> {

    @NonNull
    @Override
    protected TagViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new TagViewHolder(inflater.inflate(R.layout.item_mine_tag, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull TagViewHolder holder, @NonNull Tag item) {
        holder.tv_name.setText(item.getName());
        holder.v_delete.setVisibility(Utils.getVisibilityByBoolean(item.isShouldDelete()));
    }

    static class TagViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_name)
        TextView tv_name;

        @BindView(R.id.v_delete)
        View v_delete;

        public TagViewHolder(View itemView) {
            super(itemView);
        }
    }

}
