package com.lz.fishfamily.ui.multitype.mine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lz.fishfamily.R
import com.lz.fishfamily.module.mine.Fans
import com.lz.fishfamily.utils.glide.GlideApp
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_mine_fans.view.*
import kotlinx.android.synthetic.main.item_shopping_address.view.*

import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/17
 * desc   : 黑名单 ItemViewBinder
 * version: 1.0
</pre> *
 */
class BlackListItemViewBinder : ItemViewBinder<Fans, BlackListItemViewBinder.BlackListViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): BlackListViewHolder {
        return BlackListViewHolder(inflater.inflate(R.layout.item_mine_black_list, parent, false))
    }

    override fun onBindViewHolder(holder: BlackListViewHolder, item: Fans) {
        GlideApp.with(holder.itemView.context).load(item.userInfo_HeadImg).loadAvatar().into(holder.itemView.iv_avatar)
        holder.itemView.tv_name.text = item.userInfo_NickName
        holder.itemView.tv_desc.text = item.userInfo_Describe
    }

    class BlackListViewHolder(itemView: View) : BaseViewHolder(itemView)

}
