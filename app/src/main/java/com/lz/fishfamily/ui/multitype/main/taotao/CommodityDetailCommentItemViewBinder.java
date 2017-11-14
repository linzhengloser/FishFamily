package com.lz.fishfamily.ui.multitype.main.taotao;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.PostComment;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/25
 *     desc   : 首页 -> 商品详情评论 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class CommodityDetailCommentItemViewBinder extends ItemViewBinder<PostComment, CommodityDetailCommentItemViewBinder.CommdityDetailViewHolder> {

    @NonNull
    @Override
    protected CommdityDetailViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new CommdityDetailViewHolder(inflater.inflate(R.layout.item_main_commodity_detail_comment, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull CommdityDetailViewHolder holder, @NonNull PostComment item) {

    }

    static class CommdityDetailViewHolder extends BaseViewHolder {

        public CommdityDetailViewHolder(View itemView) {
            super(itemView);
        }

    }

}
