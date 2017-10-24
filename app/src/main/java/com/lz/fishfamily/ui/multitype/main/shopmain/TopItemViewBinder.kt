package com.lz.fishfamily.ui.multitype.main.shopmain

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.lz.fishfamily.R
import com.lz.fishfamily.module.main.Shop
import com.lz.fishfamily.utils.event.MainEvent
import com.lz.library.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_main_shop_main_top.view.*
import me.drakeet.multitype.ItemViewBinder
import org.greenrobot.eventbus.EventBus

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/10/22
 * desc   : 店铺首页 Top ItemViewBinder
 * version: 1.0
</pre> *
 */
class TopItemViewBinder : ItemViewBinder<Shop, TopItemViewBinder.TopViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): TopViewHolder {
        return TopViewHolder(inflater.inflate(R.layout.item_main_shop_main_top, parent, false))
    }

    override fun onBindViewHolder(holder: TopViewHolder, item: Shop) {
    }

    class TopViewHolder(itemView: View) : BaseViewHolder(itemView), View.OnClickListener {

        init {
            itemView.ll_tab_main.setOnClickListener(this)
            itemView.ll_tab_commodity.setOnClickListener(this)
            itemView.ll_tab_new.setOnClickListener(this)
            itemView.ll_tab_activity.setOnClickListener(this)
        }

        /**
         * 切换Tab
         */
        private fun changeTab(index: Int) {
            var tabView: ViewGroup
            var visibility: Boolean
            var textColor: Int
            var imageResId: Int
            for (i in 0 until itemView.ll_tab.childCount) {
                tabView = itemView.ll_tab.getChildAt(i) as ViewGroup
                visibility = i == index
                if (index == i) {
                    imageResId = mTabImageSelectedResIds[i]
                    textColor = itemView.context.resources.getColor(R.color.colorPrimary)
                } else {
                    imageResId = mTabImageUnSelectedResIds[i]
                    textColor = Color.parseColor("#aaaaaa")
                }

                tabView.getChildAt(tabView.childCount - 1).visibility = if (visibility) View.VISIBLE else View.GONE
                (tabView.getChildAt(1) as TextView).setTextColor(textColor)
                if (i == 1) {
                    (tabView.getChildAt(0) as TextView).setTextColor(textColor)
                } else {
                    (tabView.getChildAt(0) as ImageView).setImageResource(imageResId)
                }
            }
            //发送EventBus
            var event:MainEvent<Int> = MainEvent(MainEvent.EVENT_TYPE_SHOP_MAIN_CHANGE_TAB,index)
            EventBus.getDefault().post(event)
        }

        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.ll_tab_main -> changeTab(0)
                R.id.ll_tab_commodity -> changeTab(1)
                R.id.ll_tab_new -> changeTab(2)
                R.id.ll_tab_activity -> changeTab(3)
            }
        }

    }

    companion object {
        val mTabImageUnSelectedResIds = intArrayOf(
                R.drawable.main_shop_main_tab_main_unselected,
                0,
                R.drawable.main_shop_main_tab_new_unselected,
                R.drawable.main_shop_main_tab_activity_unselected
        )

        val mTabImageSelectedResIds = intArrayOf(
                R.drawable.main_shop_main_tab_main_selected,
                0,
                R.drawable.main_shop_main_tab_new_selected,
                R.drawable.main_shop_main_tab_activity_selected
        )
    }

}
