package com.lz.fishfamily.ui.multitype.main.taotao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.Comment
import com.lz.fishfamily.utils.Utils
import com.lz.fishfamily.utils.glide.GlideApp
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_main_commodity_detail_comment.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/25
 * desc   : 首页 -> 商品详情评论 ItemViewBinder
 * version: 1.0
</pre> *
 */
class CommodityDetailCommentItemViewBinder : ItemViewBinder<Comment, CommodityDetailCommentItemViewBinder.CommodityDetailViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): CommodityDetailViewHolder =
            CommodityDetailViewHolder(inflater.inflate(R.layout.item_main_commodity_detail_comment, parent, false))

    override fun onBindViewHolder(holder: CommodityDetailViewHolder, item: Comment) {
        GlideApp.with(holder.itemView.context)
                .load(item.headImage)
                .loadAvatar()
                .into(holder.itemView.iv_avatar)
        holder.itemView.tv_nick_name.text = item.userName
        val commentSpannableString = if (item.commentParent_ID == "0") item.comment_Content
        else {
            val commentString = "回复${item.passiveUserName}  :  ${item.comment_Content}"
            Utils.setForegroundColorSpan(commentString, arrayOf(
                    Pair(commentString.indexOf(item.passiveUserName), commentString.indexOf(item.passiveUserName) + item.passiveUserName.length)
            ), "#1371C0")
        }
        holder.itemView.tv_content.text = commentSpannableString
    }

    class CommodityDetailViewHolder(itemView: View) : BaseViewHolder(itemView)

}
