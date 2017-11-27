package com.lz.fishfamily.ui.multitype.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.MainDivider
import com.lz.fishfamily.utils.Utils
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_main_post_divider.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/24
 * desc   : 首页 -> 分享帖子分割线
 * version: 1.0
</pre> *
 */
class MainDividerItemViewBinder : ItemViewBinder<MainDivider, MainDividerItemViewBinder.MainDividerViewHolder>() {


    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): MainDividerViewHolder =
            MainDividerViewHolder(inflater.inflate(R.layout.item_main_post_divider, parent, false))

    override fun onBindViewHolder(holder: MainDividerViewHolder, item: MainDivider) {
        holder.itemView.tv_more_comment.visibility = Utils.getVisibilityByBoolean(item.isShowMoreComment)
    }

    class MainDividerViewHolder(itemView: View) : BaseViewHolder(itemView)

}
