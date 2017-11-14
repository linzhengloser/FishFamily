package com.lz.fishfamily.ui.multitype.main.taotao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.shop.Shop
import com.lz.fishfamily.ui.activity.main.ShopMainActivity
import com.lz.fishfamily.utils.glide.GlideApp
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_main_fish_type.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/25
 * desc   : 淘淘店铺 ItemViewBinder
 * version: 1.0
</pre> *
 */
internal class ShopItemViewBinder : ItemViewBinder<Shop, ShopItemViewBinder.FishTypeViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): FishTypeViewHolder
            = FishTypeViewHolder(inflater.inflate(R.layout.item_main_fish_type, parent, false))

    override fun onBindViewHolder(holder: FishTypeViewHolder, item: Shop) {
        //店铺名称
        GlideApp.with(holder.itemView.context)
                .load(item.headImg)
                .circleCrop()
                .into(holder.itemView.iv_shop_image)
        //店铺头像
        holder.itemView.tv_shop_name.text = item.name
    }

    internal class FishTypeViewHolder(itemView: View) : BaseViewHolder(itemView){
        init {
            itemView.setOnClickListener{ShopMainActivity.Companion.toActivity(itemView.context)}
        }
    }

}
