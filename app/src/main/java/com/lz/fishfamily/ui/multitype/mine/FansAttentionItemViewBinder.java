package com.lz.fishfamily.ui.multitype.mine;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.fishfamily.module.mine.Fans;
import com.lz.library.base.BaseViewHolder;

import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/16
 *     desc   : 粉丝 or 关注 ItemViewBinder
 *     version: 1.0
 * </pre>
 */
public class FansAttentionItemViewBinder extends ItemViewBinder<Fans, FansAttentionItemViewBinder.FansAttentionViewHolder> {

    private int mType;


    public FansAttentionItemViewBinder(int type) {
        mType = type;
    }

    @NonNull
    @Override
    protected FansAttentionViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new FansAttentionViewHolder(inflater.inflate(R.layout.item_mine_fans, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull FansAttentionViewHolder holder, @NonNull Fans item) {

    }

    static class FansAttentionViewHolder extends BaseViewHolder {

        public FansAttentionViewHolder(View itemView) {
            super(itemView);
        }
    }

}
