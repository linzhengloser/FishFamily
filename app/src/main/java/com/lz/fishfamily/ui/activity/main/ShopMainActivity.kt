package com.lz.fishfamily.ui.activity.main

import android.content.Context
import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.Commodity
import com.lz.fishfamily.module.main.Shop
import com.lz.fishfamily.setTranslucentStatus
import com.lz.fishfamily.ui.base.BaseListActivity
import com.lz.fishfamily.ui.multitype.main.shopmain.CommodityGridItemViewBinder
import com.lz.fishfamily.ui.multitype.main.shopmain.TopItemViewBinder
import com.lz.fishfamily.utils.event.MainEvent
import kotlinx.android.synthetic.main.activity_main_shop.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/10/22
 * desc   : 首页 -> 淘淘 -> 商家店铺
 * version: 1.0
</pre> *
 */
class ShopMainActivity : BaseListActivity() {

    val mSortData: String = "sort"

    val mLinearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)

    val mGridLayoutManager: GridLayoutManager = GridLayoutManager(this, 2)

    override val contentViewResourceID: Int = R.layout.activity_main_shop

    override fun setContentView(layoutResID: Int) {
        setTranslucentStatus(true)
        super.setContentView(layoutResID)
    }

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        mGridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when(position){
                    0 -> 2
                    else -> 1
                }
            }
        }
        rv_shop.layoutManager = mGridLayoutManager

        mItems.add(Shop())

        for(i in 1..20)
            mItems.add(Commodity())

        rv_shop.adapter = mAdapter
    }

    override fun registerItemViewBinder() {
        mAdapter.register(Commodity::class.java).to(
                CommodityGridItemViewBinder()
        ).withClassLinker {
            if (rv_shop.layoutManager is GridLayoutManager)
                CommodityGridItemViewBinder::class.java else CommodityGridItemViewBinder::class.java
        }
        mAdapter.register(Shop::class.java, TopItemViewBinder())
//        mAdapter.register(String::class.java, CommoditySortItemViewBinder())
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun changeTabEvent(event: MainEvent<Int>) {
        if (event.eventType == MainEvent.EVENT_TYPE_SHOP_MAIN_CHANGE_TAB) {
            when (event.data) {
                in 1..3 -> {
                    when (event.data) {
                        1 -> {
                            mItems.add(0, mSortData)
                        }
                        else -> mItems.remove(mSortData)
                    }
                    ll_shop_main_bottom_menu.visibility = View.GONE
                }
                0 -> {
                    mItems.remove(mSortData)
                    ll_shop_main_bottom_menu.visibility = View.VISIBLE
                }
            }
            mAdapter.notifyDataSetChanged()
        }
    }


    companion object {

        fun toActivity(context: Context) {
            val intent = Intent(context, ShopMainActivity::class.java)
            context.startActivity(intent)
        }
    }

}
