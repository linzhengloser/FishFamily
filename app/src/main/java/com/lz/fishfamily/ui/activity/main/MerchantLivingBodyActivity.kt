package com.lz.fishfamily.ui.activity.main

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.FishType
import com.lz.fishfamily.module.main.Shop
import com.lz.fishfamily.ui.base.BaseListActivity
import com.lz.fishfamily.ui.multitype.main.CommodityItemViewBinder
import com.lz.fishfamily.ui.multitype.main.FishTypeItemViewBinder
import com.lz.fishfamily.ui.multitype.main.SearchItemViewBinder
import com.lz.fishfamily.utils.Utils
import com.zhy.autolayout.utils.AutoUtils
import kotlinx.android.synthetic.main.activity_merchant_living_body.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/25
 * desc   : 首页 -> 商家活体
 * version: 1.0
</pre> *
 */
class MerchantLivingBodyActivity : BaseListActivity() {

    override val contentViewResourceID: Int = R.layout.activity_merchant_living_body

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        Utils.setTitle(this, "商家活体")
        Utils.setMenuText(this, "同城")

        val gridLayoutManager = GridLayoutManager(this, 10)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when {
                    mItems[position] is String -> 10
                    mItems[position] is Shop -> 5
                    else -> 2
                }
            }
        }
        rv_merchant_living_body.addItemDecoration(object : RecyclerView.ItemDecoration() {

            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
                val position = parent.getChildLayoutPosition(view)
                val spanSize = gridLayoutManager.spanSizeLookup.getSpanSize(position)
                if (spanSize != 5) return
                if (position % 2 == 0) {
                    outRect.set(0, 0, 0, AutoUtils.getPercentWidthSize(10))
                } else {
                    outRect.set(0, 0, AutoUtils.getPercentWidthSize(10), AutoUtils.getPercentWidthSize(10))
                }
            }
        })
        rv_merchant_living_body.layoutManager = gridLayoutManager

        mItems.add("商家活体搜索")
        for (i in 0..9) {
            mItems.add(FishType())
        }
        for (i in 0..19) {
            mItems.add(Shop())
        }

        rv_merchant_living_body.adapter = mAdapter
    }

    override fun registerItemViewBinder() {
        mAdapter.register(String::class.java, SearchItemViewBinder())
        mAdapter.register(FishType::class.java, FishTypeItemViewBinder())
        mAdapter.register(Shop::class.java, CommodityItemViewBinder())
    }

    companion object {

        fun toActivity(context: Context) {
            val intent = Intent(context, MerchantLivingBodyActivity::class.java)
            context.startActivity(intent)
        }
    }

}
