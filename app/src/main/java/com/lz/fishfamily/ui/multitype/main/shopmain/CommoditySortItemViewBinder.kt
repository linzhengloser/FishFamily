package com.lz.fishfamily.ui.multitype.main.shopmain

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lz.fishfamily.R
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_main_shop_main_commodity_sort.view.*
import me.drakeet.multitype.ItemViewBinder

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/10/24
 * desc   : 店铺首页 商品排序 ItemViewBinder
 * version: 1.0
</pre> *
 */
class CommoditySortItemViewBinder : ItemViewBinder<String, CommoditySortItemViewBinder.CommoditySortViewHolder>() {

    override fun onBindViewHolder(holder: CommoditySortViewHolder, item: String) {
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): CommoditySortViewHolder
            = CommoditySortViewHolder(inflater.inflate(R.layout.item_main_shop_main_commodity_sort, parent, false))


    class CommoditySortViewHolder(itemView: View) : BaseViewHolder(itemView), View.OnClickListener {

        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.tv_tab_synthesize -> changeTab(itemView.ll_tab, 0)
                R.id.tv_tab_sales_volume -> changeTab(itemView.ll_tab, 1)
                R.id.tv_tab_new -> changeTab(itemView.ll_tab, 2)
                R.id.tv_tab_price -> changeTab(itemView.ll_tab, 3)
            }
        }

        init {
            itemView.tv_tab_synthesize.setOnClickListener(this)
            itemView.tv_tab_sales_volume.setOnClickListener(this)
            itemView.tv_tab_new.setOnClickListener(this)
            itemView.tv_tab_price.setOnClickListener(this)
        }

        private fun changeTab(tabLayout: ViewGroup, index: Int) {
            var textView: TextView
            for (i in 0 until tabLayout.childCount - 1) {
                textView = (tabLayout.getChildAt(i) as TextView)
                if (i == index)
                    textView.setTextColor(tabLayout.context.resources.getColor(R.color.colorPrimary))
                else
                    textView.setTextColor(Color.parseColor("#999999"))

            }
        }
    }
}
