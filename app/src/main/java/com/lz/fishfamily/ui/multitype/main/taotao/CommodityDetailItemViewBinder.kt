package com.lz.fishfamily.ui.multitype.main.taotao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.LikeList
import com.lz.fishfamily.module.main.commodity.Commodity
import com.lz.fishfamily.setLike
import com.lz.fishfamily.setLikeList
import com.lz.fishfamily.utils.Utils
import com.lz.fishfamily.utils.glide.GlideApp
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_main_commodity_detail.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/25
 * desc   : 首页 -> 商品详情 ItemViewBinder
 * version: 1.0
</pre> *
 */
class CommodityDetailItemViewBinder : ItemViewBinder<Commodity, CommodityDetailItemViewBinder.CommodityDetailViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): CommodityDetailViewHolder =
            CommodityDetailViewHolder(inflater.inflate(R.layout.item_main_commodity_detail, parent, false))

    override fun onBindViewHolder(holder: CommodityDetailViewHolder, item: Commodity) {
        GlideApp.with(holder.itemView.context).load(item.userInfo.userInfo_HeadImg).loadAvatar().into(holder.itemView.iv_avatar)
        holder.itemView.tv_nick_name.text = item.userInfo.userInfo_NickName
        holder.itemView.tv_price.text = "¥${item.price}"
        holder.itemView.tv_repertory.text = "库存:${item.stock}"
        holder.itemView.tv_name.text = item.name
        holder.itemView.tv_content.text = item.conten
        holder.itemView.tv_address.text = item.address
        holder.itemView.tv_comment_number.text = "共${item.commentCount}条评论"
        holder.itemView.tv_new_comment_number.text = "最新评论(${item.comment.size})"
        holder.itemView.tv_date.text = Utils.parseDate(item.shelvesTime, "MM-dd hh:mm")
        holder.itemView.tv_like_number.setLike(item.isLike, "(${item.likeCount})")
        holder.itemView.ll_like_layout.setLikeList(LikeList(item.like))
    }

    class CommodityDetailViewHolder(itemView: View) : BaseViewHolder(itemView)

}
