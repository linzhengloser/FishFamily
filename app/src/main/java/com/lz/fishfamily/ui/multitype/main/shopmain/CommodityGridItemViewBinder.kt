package com.lz.fishfamily.ui.multitype.main.shopmain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.lz.fishfamily.Constant
import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.Commodity
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_main_shop_main_commodity_grid.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/10/24
 * desc   : 店铺首页 商品 Grid ItemViewBinder
 * version: 1.0
</pre> *
 */
class CommodityGridItemViewBinder : ItemViewBinder<Commodity, CommodityGridItemViewBinder.CommodityGridViewHolder>() {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): CommodityGridViewHolder
            = CommodityGridViewHolder(inflater.inflate(R.layout.item_main_shop_main_commodity_grid, parent, false))

    override fun onBindViewHolder(holder: CommodityGridViewHolder, item: Commodity) {
        Glide.with(holder.itemView.context).load(Constant.TEST_IMAGE_URL).into(holder.itemView.iv_image)
    }

    class CommodityGridViewHolder(itemView: View) : BaseViewHolder(itemView)

}
