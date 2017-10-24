package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.MineSimpleItem;
import com.lz.fishfamily.utils.Utils;
import com.lz.fishfamily.utils.event.LoginEvent;
import com.lz.library.base.BaseViewHolder;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/13
 *     desc   : 我的 -> 普通 Item
 *     version: 1.0
 * </pre>
 */
public class MineSimpleItemViewBinder extends ItemViewBinder<MineSimpleItem, MineSimpleItemViewBinder.MineSimpleViewHolder> {

    @NonNull
    @Override
    protected MineSimpleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new MineSimpleViewHolder(inflater.inflate(R.layout.item_mine_simple_item, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull MineSimpleViewHolder holder, @NonNull MineSimpleItem item) {
        holder.iv_item_mine_simple_item_icon.setImageResource(item.getIcon());
        holder.tv_item_mine_simple_item_desc.setText(item.getDesc());
        holder.tv_item_mine_simple_item_notification_number.setVisibility(Utils.getVisibilityByBoolean(item.isNeedNotificationNumber()));
        holder.tv_item_mine_simple_item_arrows.setVisibility(Utils.getVisibilityByBoolean(item.isNeedArrows()));
        holder.v_item_mine_simple_item_line.setVisibility(Utils.getVisibilityByBoolean(item.isNeedLine()));
        holder.itemView.setOnClickListener(view -> EventBus.getDefault().post(new LoginEvent(item.getType())));
    }

    static class MineSimpleViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_item_mine_simple_item_icon)
        ImageView iv_item_mine_simple_item_icon;

        @BindView(R.id.tv_item_mine_simple_item_desc)
        TextView tv_item_mine_simple_item_desc;

        @BindView(R.id.tv_item_mine_simple_item_notification_number)
        TextView tv_item_mine_simple_item_notification_number;

        @BindView(R.id.tv_item_mine_simple_item_arrows)
        ImageView tv_item_mine_simple_item_arrows;

        @BindView(R.id.v_item_mine_simple_item_line)
        View v_item_mine_simple_item_line;

        public MineSimpleViewHolder(View itemView) {
            super(itemView);
        }
    }

}
