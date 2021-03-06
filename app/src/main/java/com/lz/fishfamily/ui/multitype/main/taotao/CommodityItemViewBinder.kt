package com.lz.fishfamily.ui.multitype.main.taotao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.commodity.Commodity
import com.lz.fishfamily.setLevel
import com.lz.fishfamily.setLike
import com.lz.fishfamily.ui.activity.main.CommodityDetailActivity
import com.lz.fishfamily.utils.Utils
import com.lz.fishfamily.utils.glide.GlideApp
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_main_commodity.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/25
 * desc   : 商品 ItemViewBinder
 * version: 1.0
</pre> *
 */
class CommodityItemViewBinder : ItemViewBinder<Commodity, CommodityItemViewBinder.CommodityViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): CommodityViewHolder
            = CommodityViewHolder(inflater.inflate(R.layout.item_main_commodity, parent, false))

    override fun onBindViewHolder(holder: CommodityViewHolder, item: Commodity) {
        GlideApp.with(holder.itemView.context).load(item.userInfo.userInfo_HeadImg).loadAvatar().into(holder.itemView.iv_avatar)
        holder.itemView.tv_nick_name.text = item.userInfo.userInfo_NickName
        holder.itemView.tv_price.text = "¥${item.price}"
        holder.itemView.tv_date_repertory.text = "${Utils.parseDate(item.shelvesTime, "MM-dd")} 库存:${item.stock}"
        holder.itemView.tv_name.text = item.name
        holder.itemView.tv_content.text = item.conten
        holder.itemView.tv_comment_number.text = item.commentCount.toString()
        holder.itemView.tv_like_number.setLike(item.isLike, item.likeCount.toString())
        holder.itemView.iv_level.setLevel(item.userInfo.userInfo_Level)
        holder.itemView.setOnClickListener { CommodityDetailActivity.toActivity(it.context, item) }
    }

    class CommodityViewHolder(itemView: View) : BaseViewHolder(itemView)

}
