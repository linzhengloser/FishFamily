package com.lz.fishfamily.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bilibili.boxing.model.entity.BaseMedia;
import com.lz.fishfamily.R;
import com.lz.fishfamily.utils.event.MainEvent;
import com.lz.fishfamily.utils.glide.GlideApp;
import com.lz.library.base.BaseViewHolder;
import com.lz.library.utils.BaseEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/19
 *     desc   : 选择图片 RecyclerView Adapter
 *     version: 1.0
 * </pre>
 */
public class SelectImageRecyclerViewAdapter extends RecyclerView.Adapter<SelectImageRecyclerViewAdapter.SelectImageViewHolder> {

    private List<String> mImageList;

    public SelectImageRecyclerViewAdapter() {
        mImageList = new ArrayList<>();
    }

    @Override
    public SelectImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SelectImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_common_select_image, parent, false));
    }

    @Override
    public void onBindViewHolder(SelectImageViewHolder holder, int position) {
        if (position < mImageList.size()) {
            String url = mImageList.get(position);
            GlideApp.with(holder.itemView.getContext())
                    .load(url)
                    .into(holder.iv_image);
            holder.iv_cancle.setVisibility(View.VISIBLE);
            holder.iv_cancle.setOnClickListener(v -> {
                mImageList.remove(position);
                notifyDataSetChanged();
            });
        } else {
            holder.iv_cancle.setVisibility(View.GONE);
            holder.itemView.setOnClickListener(v -> {
                // 相册
                EventBus.getDefault().post(new MainEvent(BaseEvent.EVENT_TYPE_SELECT_IMAGE));
            });
        }
    }

    @Override
    public int getItemCount() {
        return mImageList.size() + 1;
    }

    public void addImage(String url) {
        mImageList.add(url);
        notifyDataSetChanged();
    }

    public void addImageList(List<BaseMedia> imageList) {
        ArrayList<String> list = new ArrayList<>(imageList.size());
        for (BaseMedia media : imageList) {
            list.add(media.getPath());
        }
        mImageList.addAll(list);
        notifyDataSetChanged();
    }

    public void removeImage(int position) {
        mImageList.remove(position);
        notifyDataSetChanged();
    }

    static class SelectImageViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_image)
        ImageView iv_image;

        @BindView(R.id.iv_cancle)
        ImageView iv_cancle;

        public SelectImageViewHolder(View itemView) {
            super(itemView);
        }
    }

}
