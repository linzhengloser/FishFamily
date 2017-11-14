package com.lz.fishfamily.ui.multitype.mine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lz.fishfamily.R
import com.lz.fishfamily.module.mine.ShoppingAddress
import com.lz.fishfamily.setSelectedSrc
import com.lz.fishfamily.ui.activity.mine.EditShoppingAddressActivity
import com.lz.library.base.BaseViewHolder
import com.lz.library.utils.BaseEvent
import kotlinx.android.synthetic.main.item_shopping_address.view.*
import me.drakeet.multitype.ItemViewBinder
import org.greenrobot.eventbus.EventBus

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/15
 * desc   : 购物车 ItemViewBinder
 * version: 1.0
</pre> *
 */
class ShoppingAddressItemViewBinder : ItemViewBinder<ShoppingAddress, ShoppingAddressItemViewBinder.ShoppingAddressViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup)
            = ShoppingAddressViewHolder(inflater.inflate(R.layout.item_shopping_address, parent, false))

    override fun onBindViewHolder(holder: ShoppingAddressViewHolder, item: ShoppingAddress) {
        holder.itemView.tv_name.text = item.address_Name
        holder.itemView.tv_phone_number.text = item.address_Mobile
        holder.itemView.tv_address.text = "${item.address_Provice}省${item.address_City}市${item.address_Region}区${item.address_Detail}"
        holder.itemView.iv_is_default.setSelectedSrc(item.address_IsDefault == 1)
        holder.itemView.setOnClickListener { EditShoppingAddressActivity.toActivity(it.context, item) }
        holder.itemView.iv_is_default.setOnClickListener {
            EventBus.getDefault().post(BaseEvent<ShoppingAddress>(2335, item))
        }
    }

    class ShoppingAddressViewHolder(itemView: View) : BaseViewHolder(itemView)

}
