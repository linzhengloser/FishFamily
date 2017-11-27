package com.lz.fishfamily.ui.activity.main

import android.content.Context
import android.content.Intent
import com.lz.fishfamily.R
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.CommodityApi
import com.lz.fishfamily.handlerObservable
import com.lz.fishfamily.module.main.commodity.Commodity
import com.lz.fishfamily.ui.base.BaseListActivity
import com.lz.fishfamily.ui.multitype.main.taotao.CommodityItemViewBinder
import com.lz.fishfamily.utils.UserManager
import com.lz.fishfamily.utils.Utils
import io.reactivex.functions.Consumer
import org.json.JSONObject

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/11/19
 * desc   : 商品列表
 * version: 1.0
</pre> *
 */
class CommodityListActivity : BaseListActivity() {

    lateinit var mShopId: String

    override fun loadPageData(page: Int) {
        val params = JSONObject().apply {
            put("UserInfo_ID", UserManager.getUser().userInfo_ID)
            put("Business_ID", mShopId)
        }.toString()
        val commodityList = Api.create(CommodityApi::class.java).getCommodity(screenCondition = params)
        handlerObservable(commodityList, bindToLifecycle(), Consumer {
            mItems.addAll(it)
            mAdapter.notifyDataSetChanged()
        })
    }

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        Utils.setTitle(this,"商品列表")
        mShopId = intent.getStringExtra("shopId")
        loadPageData()
    }

    override fun registerItemViewBinder() = mAdapter.register(Commodity::class.java, CommodityItemViewBinder())

    override val contentViewResourceID: Int = R.layout.activity_main_commodity_list

    companion object {

        fun toActivity(context: Context, shopId: String) {
            val intent = Intent(context, CommodityListActivity::class.java)
            intent.putExtra("shopId", shopId)
            context.startActivity(intent)
        }
    }

}
