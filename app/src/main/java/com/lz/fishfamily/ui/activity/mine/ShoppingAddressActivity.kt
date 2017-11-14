package com.lz.fishfamily.ui.activity.mine

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.lz.fishfamily.R
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.ShoppingAddressApi
import com.lz.fishfamily.handlerObservable
import com.lz.fishfamily.module.mine.ShoppingAddress
import com.lz.fishfamily.ui.base.BaseListActivity
import com.lz.fishfamily.ui.multitype.mine.ShoppingAddressItemViewBinder
import com.lz.fishfamily.utils.Utils
import com.lz.library.utils.BaseEvent
import com.lz.library.utils.ToastUtils
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_shopping_address.*
import kotlinx.android.synthetic.main.common_title_bar.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/15
 * desc   : 我的 -> 设置 -> 收货地址
 * version: 1.0
</pre> *
 */
class ShoppingAddressActivity : BaseListActivity() {

    override val contentViewResourceID: Int
        get() = R.layout.activity_shopping_address

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }


    override fun registerItemViewBinder() {
        mAdapter.register(ShoppingAddress::class.java, ShoppingAddressItemViewBinder())
    }

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        EventBus.getDefault().register(this)
        Utils.setTitle(this, "收货地址管理")
        Utils.setMenuText(this, "添加")
        menu_text.setOnClickListener { EditShoppingAddressActivity.toActivity(it.context, null) }
        rv_shopping_address.layoutManager = LinearLayoutManager(this)
        rv_shopping_address.adapter = mAdapter
        loadPageData()
    }

    override fun loadPageData(page: Int) {
        val getAddressList = Api.create(ShoppingAddressApi::class.java).getShoppingAddressList()
        handlerObservable(getAddressList, bindToLifecycle(), Consumer {
            mItems.addAll(it)
            mAdapter.notifyDataSetChanged()
        })
    }

    @Subscribe
    fun setDefaluEvent(event: BaseEvent<ShoppingAddress>) {
        if (event.eventType == 2335) {
            val address = event.data
            mItems.map { it as ShoppingAddress }.filter { it.address_IsDefault == 1 }.map { it.address_IsDefault = 0 }
            address.address_IsDefault = 1
            val params = mapOf(
                    "Address_ID" to address.address_ID,
                    "Address_Mobile" to address.address_Mobile,
                    "Address_Name" to address.address_Name,
                    "Address_Provice" to address.address_Provice,
                    "Address_City" to address.address_City,
                    "Address_Region" to address.address_Region,
                    "Address_Detail" to address.address_Detail,
                    "Address_IsDefault" to address.address_IsDefault.toString()
            )
            val editAddress = Api.create(ShoppingAddressApi::class.java).updateOrInsertShoppingAddress(params)
            handlerObservable(editAddress, bindToLifecycle(), Consumer {
                ToastUtils.showToast("设置成功")
                mAdapter.notifyDataSetChanged()
            })
        }
    }

    @Subscribe
    fun refreshListEvent(event: String) {
        if (event == "refreshShoppingAddressList") loadPageData()
    }

    companion object {

        fun toActivity(context: Context) {
            val intent = Intent(context, ShoppingAddressActivity::class.java)
            context.startActivity(intent)
        }
    }

}
