package com.lz.fishfamily.ui.activity.mine

import android.content.Context
import android.content.Intent
import com.lz.fishfamily.R
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.ShoppingAddressApi
import com.lz.fishfamily.handlerObservable
import com.lz.fishfamily.module.mine.ShoppingAddress
import com.lz.fishfamily.setSelectedSrc
import com.lz.fishfamily.ui.base.BaseActivity
import com.lz.fishfamily.utils.Utils
import com.lz.library.utils.ToastUtils
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_edit_shopping_address.*
import kotlinx.android.synthetic.main.common_title_bar.*
import org.greenrobot.eventbus.EventBus

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/16
 * desc   : 我的 -> 设置 -> 收货地址 -> 新增 or 修改
 * version: 1.0
</pre> *
 */
class EditShoppingAddressActivity : BaseActivity() {

    private var mAddress: ShoppingAddress? = null

    private var mIsDefalut: Boolean = false

    override val contentViewResourceID: Int
        get() = R.layout.activity_edit_shopping_address

    override fun initViewsAndEvents() {
        mAddress = intent.getParcelableExtra(INTENT_KEY_ADDRESS)
        Utils.setTitle(this, if (mAddress == null) "新增收获地址" else "修改收货地址")
        Utils.setMenuText(this, "完成")

        if (mAddress != null) {
            et_name.setText(mAddress?.address_Name)
            et_phone_number.setText(mAddress?.address_Mobile)
            et_province.setText(mAddress?.address_Provice)
            et_city.setText(mAddress?.address_City)
            et_region.setText(mAddress?.address_Region)
            et_detail_address.setText(mAddress?.address_Detail)
            mIsDefalut = mAddress?.address_IsDefault == 1
            iv_is_default.setSelectedSrc(mIsDefalut)
        }

        menu_text.setOnClickListener {
            if (validate()) updateOrInsert()
        }

        iv_is_default.setOnClickListener {
            mIsDefalut = !mIsDefalut
            iv_is_default.setSelectedSrc(mIsDefalut)
        }
    }

    private fun updateOrInsert() {
        val params: Map<String, String?>
        params = mutableMapOf(
                "Address_Mobile" to et_phone_number.text.toString().trim(),
                "Address_Name" to et_name.text.toString().trim(),
                "Address_Provice" to et_province.text.toString().trim(),
                "Address_City" to et_city.text.toString().trim(),
                "Address_Region" to et_region.text.toString().trim(),
                "Address_Detail" to et_detail_address.text.toString().trim(),
                "Address_IsDefault" to if (mIsDefalut) "1" else "0"
        )
        if (mAddress != null) params.put("Address_ID", mAddress?.address_ID as String)
        val editAddress = Api.create(ShoppingAddressApi::class.java).updateOrInsertShoppingAddress(params)
        handlerObservable(editAddress, bindToLifecycle(), Consumer {
            ToastUtils.showToast("${if (mAddress == null) "添加" else "修改"}成功")
            if(mAddress==null)EventBus.getDefault().post("refreshShoppingAddressList")
        })
    }

    fun validate(): Boolean = Utils.isEmpty(
            arrayOf(
                    "收货人姓名不能为空",
                    "手机号码不能为空",
                    "省份不能为空",
                    "城市不能为空",
                    "区县不能为空",
                    "街道地址不能为空"
            )
            , et_name, et_phone_number, et_province, et_city, et_region, et_detail_address)

    companion object {

        private val INTENT_KEY_ADDRESS: String = "intent_key_address"

        fun toActivity(context: Context, address: ShoppingAddress?) {
            val intent = Intent(context, EditShoppingAddressActivity::class.java)
            if (address != null) intent.putExtra(INTENT_KEY_ADDRESS, address)
            context.startActivity(intent)
        }
    }

}
