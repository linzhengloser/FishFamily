package com.lz.fishfamily.ui.multitype.main.live

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.LikeList
import com.lz.library.base.BaseViewHolder

import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/27
 * desc   : 首页 -> 点赞列表 ItemViewBinder
 * version: 1.0
</pre> *
 */
class LikeListItemViewBinder : ItemViewBinder<LikeList, LikeListItemViewBinder.LikeListViewHolder>() {


    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): LikeListViewHolder {
        return LikeListViewHolder(inflater.inflate(R.layout.item_main_like_list, parent, false))
    }

    override fun onBindViewHolder(holder: LikeListViewHolder, item: LikeList) {

    }

    class LikeListViewHolder(itemView: View) : BaseViewHolder(itemView)

}
