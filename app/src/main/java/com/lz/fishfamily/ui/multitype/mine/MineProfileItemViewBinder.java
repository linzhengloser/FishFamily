package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.User;
import com.lz.fishfamily.ui.activity.LoginActivity;
import com.lz.fishfamily.ui.activity.mine.FansAttentionListActivity;
import com.lz.fishfamily.ui.activity.mine.ProfileActivity;
import com.lz.fishfamily.ui.activity.mine.ShareListActivity;
import com.lz.fishfamily.utils.UserManager;
import com.lz.fishfamily.utils.glide.GlideApp;
import com.lz.library.base.BaseViewHolder;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/13
 *     desc   : 我的 -> 用户消息
 *     version: 1.0
 * </pre>
 */
public class MineProfileItemViewBinder extends ItemViewBinder<User, MineProfileItemViewBinder.MineProfileViewHolder> {


    @NonNull
    @Override
    protected MineProfileViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new MineProfileViewHolder(inflater.inflate(R.layout.item_mine_profile, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull MineProfileViewHolder holder, @NonNull User item) {
        if (UserManager.isLoggin()) {
            holder.ll_login_layout.setVisibility(View.VISIBLE);
            holder.tv_no_login.setVisibility(View.GONE);
            GlideApp.with(holder.itemView.getContext()).load(item.getUserInfo_HeadImg()).loadAvatar().into(holder.iv_avatar);
            holder.tv_nick_name.setText(item.getUserInfo_NickName());
            holder.tv_share.setText(String.valueOf(item.getShareCount()));
            holder.tv_attention.setText(String.valueOf(item.getFllowCount()));
            holder.tv_fans.setText(String.valueOf(item.getFansCount()));
            holder.tv_fish_bean.setText(String.valueOf(item.getUserInfo_Money()));
            UserManager.bindUserLevel(holder.iv_level, item.getUserInfo_Level());
            holder.ll_fans.setOnClickListener(view -> FansAttentionListActivity.toFansActivity(holder.itemView.getContext()));
            holder.ll_attention.setOnClickListener(view -> FansAttentionListActivity.toAttentionActivity(holder.itemView.getContext()));
            holder.ll_share.setOnClickListener(view -> ShareListActivity.toActivity(holder.itemView.getContext()));
        } else {
            holder.tv_no_login.setVisibility(View.VISIBLE);
            holder.ll_login_layout.setVisibility(View.GONE);
        }

        holder.ll_profile.setOnClickListener(view -> {
            if (UserManager.isLoggin())
                ProfileActivity.toActivity(view.getContext());
            else
                LoginActivity.toActivity(view.getContext());
        });

    }

    static class MineProfileViewHolder extends BaseViewHolder {

        @BindView(R.id.ll_fans)
        LinearLayout ll_fans;

        @BindView(R.id.ll_attention)
        LinearLayout ll_attention;

        @BindView(R.id.ll_profile)
        LinearLayout ll_profile;

        @BindView(R.id.ll_share)
        LinearLayout ll_share;

        @BindView(R.id.iv_avatar)
        ImageView iv_avatar;

        @BindView(R.id.iv_level)
        ImageView iv_level;

        @BindView(R.id.tv_nick_name)
        TextView tv_nick_name;

        @BindView(R.id.tv_fish_bean)
        TextView tv_fish_bean;

        @BindView(R.id.tv_share)
        TextView tv_share;

        @BindView(R.id.tv_fans)
        TextView tv_fans;

        @BindView(R.id.tv_attention)
        TextView tv_attention;

        @BindView(R.id.ll_login_layout)
        LinearLayout ll_login_layout;

        @BindView(R.id.tv_no_login)
        TextView tv_no_login;

        public MineProfileViewHolder(View itemView) {
            super(itemView);
        }
    }


}
