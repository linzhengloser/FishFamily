package com.lz.fishfamily.ui.multitype.main;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lz.fishfamily.Constant;
import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.Shop;
import com.lz.fishfamily.ui.activity.main.CommodityDetailActivity;
import com.lz.fishfamily.utils.glide.GlideApp;
import com.lz.library.base.BaseViewHolder;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/25
 *     desc   : 商家活体 -> 商品 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class CommodityItemViewBinder extends ItemViewBinder<Shop, CommodityItemViewBinder.CommodityViewHolder> {

    @NonNull
    @Override
    protected CommodityViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new CommodityViewHolder(inflater.inflate(R.layout.item_main_commodity, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull CommodityViewHolder holder, @NonNull Shop item) {
        GlideApp.with(holder.itemView.getContext()).load(Constant.TEST_IMAGE_URL).into(holder.iv_image);
        holder.itemView.setOnClickListener(view -> CommodityDetailActivity.toActivity(view.getContext()));
    }

    static class CommodityViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_image)
        ImageView iv_image;

        public CommodityViewHolder(View itemView) {
            super(itemView);
        }

    }

}
