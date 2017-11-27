package com.lz.fishfamily.ui.fragment.main

import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.lz.fishfamily.Constant
import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.commodity.Commodity
import com.lz.fishfamily.ui.base.BaseListFragment
import com.lz.fishfamily.ui.multitype.main.taotao.MyCommodityItemViewBinder
import kotlinx.android.synthetic.main.fragment_main_my_commodity.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/11/02
 * desc   : 我的商品 Fragment
 * version: 1.0
</pre> *
 */
class MyCommodityFragment : BaseListFragment() {

    private var mType = 0

    override fun registerItemViewBinder() {
        mAdapter.register(Commodity::class.java, MyCommodityItemViewBinder())
    }

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        mType = arguments.getInt(Constant.INTENT_KEY_TYPE)
        rv_my_commodity.layoutManager = LinearLayoutManager(context)
        rv_my_commodity.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
                outRect?.bottom = 30
            }
        })
        for (i in 1..20) {
            mItems.add(Commodity())
        }
        rv_my_commodity.adapter = mAdapter
    }

    override val contentViewLayoutID: Int
        get() = R.layout.fragment_main_my_commodity


    companion object {

        //上架中
        val TYPE_SELL:Int = 1

        //已下架
        val TYPE_SOLD_OUT = 2

        fun newInstance(type:Int): MyCommodityFragment {
            val args = Bundle()
            args.putInt(Constant.INTENT_KEY_TYPE,type)
            val fragment = MyCommodityFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
