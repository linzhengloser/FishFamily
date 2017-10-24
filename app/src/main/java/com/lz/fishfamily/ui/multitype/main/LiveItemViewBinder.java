package com.lz.fishfamily.ui.multitype.main;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lz.fishfamily.Constant;
import com.lz.fishfamily.R;
import com.lz.fishfamily.module.main.Live;
import com.lz.fishfamily.utils.glide.GlideApp;
import com.lz.library.base.BaseViewHolder;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/25
 *     desc   : 首页 -> 直播 LiveItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class LiveItemViewBinder extends ItemViewBinder<Live, LiveItemViewBinder.LiveViewHolder> {

    @NonNull
    @Override
    protected LiveViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new LiveViewHolder(inflater.inflate(R.layout.item_main_live, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull LiveViewHolder holder, @NonNull Live item) {
        GlideApp.with(holder.itemView.getContext()).load(Constant.TEST_IMAGE_URL).into(holder.iv_image);
    }

    static class LiveViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_image)
        ImageView iv_image;

        public LiveViewHolder(View itemView) {
            super(itemView);
        }
    }

}
