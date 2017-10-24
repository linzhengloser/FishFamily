package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.TagType;
import com.lz.library.base.BaseViewHolder;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/17
 *     desc   : 标签类型 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class TagTypeItemViewBinder extends ItemViewBinder<TagType, TagTypeItemViewBinder.TagTypeViewHolder> {

    @NonNull
    @Override
    protected TagTypeViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new TagTypeViewHolder(inflater.inflate(R.layout.item_mine_tag_type, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull TagTypeViewHolder holder, @NonNull TagType item) {
        holder.tv_name.setText(item.getName());
    }

    static class TagTypeViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_name)
        TextView tv_name;

        public TagTypeViewHolder(View itemView) {
            super(itemView);
        }

    }

}
