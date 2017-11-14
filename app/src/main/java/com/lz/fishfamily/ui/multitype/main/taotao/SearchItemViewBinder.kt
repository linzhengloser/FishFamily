package com.lz.fishfamily.ui.multitype.main.taotao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lz.fishfamily.R
import com.lz.fishfamily.ui.activity.main.FishCategoryActivity
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_main_taotao_search.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/23
 * desc   : 首页 -> 淘淘 -> 搜索 ItemViewBinder
 * version: 1.0
</pre> *
 */
class SearchItemViewBinder : ItemViewBinder<String, SearchItemViewBinder.SearchViewHolder>() {


    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): SearchViewHolder {
        return SearchViewHolder(inflater.inflate(R.layout.item_main_taotao_search, parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, item: String) {
        holder.itemView.tv_category.setOnClickListener{FishCategoryActivity.toActivity(it.context)}
    }

    class SearchViewHolder(itemView: View) : BaseViewHolder(itemView)

}
