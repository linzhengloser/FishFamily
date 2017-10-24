package com.lz.fishfamily.ui.multitype.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.FishType
import com.lz.fishfamily.ui.activity.main.ShopMainActivity
import com.lz.library.base.BaseViewHolder

import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/25
 * desc   : 鱼类型 ItemViewBinder
 * version: 1.0
</pre> *
 */
internal class FishTypeItemViewBinder : ItemViewBinder<FishType, FishTypeItemViewBinder.FishTypeViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): FishTypeViewHolder
            = FishTypeViewHolder(inflater.inflate(R.layout.item_main_fish_type, parent, false))

    override fun onBindViewHolder(holder: FishTypeViewHolder, item: FishType) {

    }

    internal class FishTypeViewHolder(itemView: View) : BaseViewHolder(itemView){
        init {
            itemView.setOnClickListener{ShopMainActivity.Companion.toActivity(itemView.context)}
        }
    }

}
