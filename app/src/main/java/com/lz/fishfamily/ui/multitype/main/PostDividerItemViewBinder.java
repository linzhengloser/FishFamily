package com.lz.fishfamily.ui.multitype.main;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.PostDivider;
import com.lz.fishfamily.utils.Utils;
import com.lz.library.base.BaseViewHolder;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/24
 *     desc   : 首页 -> 分享帖子分割线
 *     version: 1.0
 * </pre>
 */
public class PostDividerItemViewBinder extends ItemViewBinder<PostDivider, PostDividerItemViewBinder.PostDividerViewHolder> {


    @NonNull
    @Override
    protected PostDividerViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new PostDividerViewHolder(inflater.inflate(R.layout.item_main_post_divider, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull PostDividerViewHolder holder, @NonNull PostDivider item) {
        holder.tv_more_comment.setVisibility(Utils.getVisibilityByBoolean(item.isShowMoreComent()));
    }

    static class PostDividerViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_more_comment)
        TextView tv_more_comment;

        public PostDividerViewHolder(View itemView) {
            super(itemView);
        }
    }

}
