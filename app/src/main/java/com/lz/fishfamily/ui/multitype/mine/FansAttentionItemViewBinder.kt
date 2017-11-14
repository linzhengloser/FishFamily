package com.lz.fishfamily.ui.multitype.mine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lz.fishfamily.R
import com.lz.fishfamily.module.mine.Fans
import com.lz.fishfamily.setAttention
import com.lz.fishfamily.utils.glide.GlideApp
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_mine_fans.view.*

import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/16
 * desc   : 粉丝 or 关注 ItemViewBinder
 * version: 1.0
</pre> *
 */
class FansAttentionItemViewBinder(private val mType: Int) : ItemViewBinder<Fans, FansAttentionItemViewBinder.FansAttentionViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): FansAttentionViewHolder {
        return FansAttentionViewHolder(inflater.inflate(R.layout.item_mine_fans, parent, false))
    }

    override fun onBindViewHolder(holder: FansAttentionViewHolder, item: Fans) {
        GlideApp.with(holder.itemView.context).load(item.userInfo_HeadImg).loadAvatar().into(holder.itemView.iv_avatar)
        holder.itemView.tv_nick_name.text = item.userInfo_NickName
        holder.itemView.tv_desc.text = item.userInfo_Describe
        holder.itemView.tv_attention.setAttention(item.isMutualConcern)
    }

    class FansAttentionViewHolder(itemView: View) : BaseViewHolder(itemView)

}
