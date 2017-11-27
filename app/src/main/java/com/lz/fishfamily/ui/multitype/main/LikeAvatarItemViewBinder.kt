package com.lz.fishfamily.ui.multitype.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.LikeList
import com.lz.fishfamily.setLikeList
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_main_commodity_detail.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/23
 * desc   : 首页 -> 分享 -> 点赞头像 ItemViewBinder
 * version: 1.0
</pre> *
 */
class LikeAvatarItemViewBinder : ItemViewBinder<LikeList, LikeAvatarItemViewBinder.PostLikeAvatarViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): PostLikeAvatarViewHolder =
            PostLikeAvatarViewHolder(inflater.inflate(R.layout.item_main_post_like_avatar, parent, false))

    override fun onBindViewHolder(holder: PostLikeAvatarViewHolder, item: LikeList) = holder.itemView.ll_like_layout.setLikeList(item)

    class PostLikeAvatarViewHolder(itemView: View) : BaseViewHolder(itemView)

}
