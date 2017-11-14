package com.lz.fishfamily.ui.multitype.main;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lz.fishfamily.R;
import com.lz.library.base.BaseViewHolder;

import butterknife.BindView;
import me.drakeet.multitype.ItemViewBinder;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/23
 *     desc   : 首页 -> 搜索 ItemViewBInder
 *     version: 1.0
 * </pre>
 */
public class CommonSearchItemViewBinder extends ItemViewBinder<String, CommonSearchItemViewBinder.SearchViewHolder> {


    @NonNull
    @Override
    protected SearchViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new SearchViewHolder(inflater.inflate(R.layout.item_common_search, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull SearchViewHolder holder, @NonNull String item) {
        if(item.equals("商家活体搜索")){
            holder.v_divider.setVisibility(View.VISIBLE);
        }
    }

    static class SearchViewHolder extends BaseViewHolder {


        @BindView(R.id.v_divider)
        View v_divider;

        public SearchViewHolder(View itemView) {
            super(itemView);
        }
    }

}
