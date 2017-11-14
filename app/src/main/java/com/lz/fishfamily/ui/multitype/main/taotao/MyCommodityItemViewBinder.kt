package com.lz.fishfamily.ui.multitype.main.taotao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.commodity.Commodity
import com.lz.library.base.BaseViewHolder
import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/11/02
 * desc   : 我的商品 ItemViewBinder
 * version: 1.0
</pre> *
 */
class MyCommodityItemViewBinder : ItemViewBinder<Commodity, MyCommodityItemViewBinder.MyCommodityViewHolder>() {
    override fun onBindViewHolder(holder: MyCommodityViewHolder, item: Commodity) {

    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): MyCommodityViewHolder
            = MyCommodityViewHolder(inflater.inflate(R.layout.item_main_my_commodity, parent, false))

    class MyCommodityViewHolder(itemView: View) : BaseViewHolder(itemView)

}
