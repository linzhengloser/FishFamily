package com.lz.fishfamily.ui.multitype;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.FishFarmCategory;
import com.lz.fishfamily.utils.event.LoginEvent;
import com.lz.library.base.BaseViewHolder;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/11
 *     desc   : 养鱼类型 or 养鱼经验 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class FishFarmCategoryItemViewBinder extends ItemViewBinder<FishFarmCategory, FishFarmCategoryItemViewBinder.FishCategoryViewHolder> {

    @NonNull
    @Override
    protected FishCategoryViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new FishCategoryViewHolder(inflater.inflate(R.layout.item_fish_farm_category, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull FishCategoryViewHolder holder, @NonNull FishFarmCategory item) {
        holder.tv_category_name.setText(item.getFishCategory_Name());
        holder.tv_category_name.setBackgroundResource(getBackgroundByIsSelected(item.isSelected()));
        holder.tv_category_name.setTextColor(getTextColorByIsSelected(holder.itemView.getContext(), item.isSelected()));
        holder.itemView.setOnClickListener(view -> {
            int eventType = item.getFishCategory_Type() == 0 ? LoginEvent.EVENT_TYPE_FISH_EXPERIENCE_SELECTED : LoginEvent.EVENT_TYPE_FISH_CATEGORY_SELECTED;
            EventBus.getDefault().post(new LoginEvent<Integer>(eventType, getPosition(holder)));
        });
    }

    private int getBackgroundByIsSelected(boolean selected) {
        if (selected)
            return R.drawable.shape_fish_category_selected;
        else
            return R.drawable.shape_fish_category_unselected;
    }

    private int getTextColorByIsSelected(Context context, boolean selected) {
        if (selected)
            return Color.WHITE;
        else
            return context.getResources().getColor(R.color.colorPrimary);
    }

    static class FishCategoryViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_category_name)
        TextView tv_category_name;

        public FishCategoryViewHolder(View itemView) {
            super(itemView);
        }
    }

}
