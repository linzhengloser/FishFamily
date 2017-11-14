package com.lz.fishfamily.ui.fragment.mine

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import butterknife.OnClick
import com.lz.fishfamily.R
import com.lz.fishfamily.module.User
import com.lz.fishfamily.module.mine.MineDivider
import com.lz.fishfamily.module.mine.MineSimpleItem
import com.lz.fishfamily.ui.activity.LoginActivity
import com.lz.fishfamily.ui.activity.mine.*
import com.lz.fishfamily.ui.base.BaseListFragment
import com.lz.fishfamily.ui.multitype.mine.MineDividerItemViewBinder
import com.lz.fishfamily.ui.multitype.mine.MineProfileItemViewBinder
import com.lz.fishfamily.ui.multitype.mine.MineSimpleItemViewBinder
import com.lz.fishfamily.utils.UserManager
import com.lz.fishfamily.utils.Utils
import com.lz.fishfamily.utils.event.LoginEvent
import kotlinx.android.synthetic.main.fragment_mine.*
import me.drakeet.multitype.Items
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/08/23
 * desc   : 首页 -> 我的
 * version: 1.0
</pre> *
 */
class MineFragment : BaseListFragment() {

    override val contentViewLayoutID: Int
        get() = R.layout.fragment_mine

    override fun registerItemViewBinder() {
        EventBus.getDefault().register(this)
        mAdapter.register(User::class.java, MineProfileItemViewBinder())
        mAdapter.register(MineSimpleItem::class.java, MineSimpleItemViewBinder())
        mAdapter.register(MineDivider::class.java, MineDividerItemViewBinder())
    }

    override fun onResume() {
        super.onResume()
        mItems[1] = UserManager.getUser()
        mAdapter.notifyDataSetChanged()
    }

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        Utils.goneBack(view!!)
        Utils.setTitle(view!!, "我的")
        mItems.add(MineDivider())
        mItems.add(User())
        mItems.add(MineDivider())
        mItems.addAll(initSimpleItem())
        rv_mine.adapter = mAdapter
        rv_mine.layoutManager = LinearLayoutManager(context)
    }

    private fun initSimpleItem(): Items {
        val simpleItems = Items()
        simpleItems.add(MineSimpleItem(R.drawable.mine_simple_item_wallet, "我的钱包"))
        simpleItems.add(MineSimpleItem(R.drawable.mine_simple_item_transaction_record, "交易记录"))
        if (UserManager.getUser().userInfo_Type == 1) simpleItems.add(MineSimpleItem(R.drawable.mine_simple_item_shop_order, "我的商品订单"))
        simpleItems.add(MineSimpleItem(R.drawable.mine_simple_item_shopping_cart, "我的购物车").setNeedLine(false))
        simpleItems.add(MineDivider())
        simpleItems.add(MineSimpleItem(R.drawable.mine_simple_item_task_center, "任务中心"))
        simpleItems.add(MineSimpleItem(R.drawable.mine_simple_item_draft_box, "草稿箱"))
        simpleItems.add(MineSimpleItem(R.drawable.mine_simple_item_share, "向朋友推荐鱼友之家").setNeedLine(false))
        simpleItems.add(MineDivider())
        simpleItems.add(MineSimpleItem(R.drawable.mine_simple_item_feedback, "意见反馈"))
        simpleItems.add(MineSimpleItem(R.drawable.mine_simple_item_setting, "设置"))
        simpleItems.add(MineSimpleItem(R.drawable.mine_simple_item_merchant_enter, "商家入驻").setNeedLine(false))
        return simpleItems
    }


    @OnClick(R.id.btn_login)
    fun login(view: View) {
        LoginActivity.toActivity(view.context)
    }


    @Subscribe
    fun onClickEvent(event: LoginEvent<*>) {
        when (event.eventType) {
            MineSimpleItem.TYPE_FEEDBACK -> SubmitTextActivity.toFeedBackActivity(context)
            MineSimpleItem.TYPE_SETTING -> SettingActivity.toActivity(context)
            MineSimpleItem.TYPE_MERCHANT_ENTER -> MerchantEnterActivity.toActivity(context)
            MineSimpleItem.TYPE_DRAFT_BOX -> DraftBoxActivity.toActivity(context)
            MineSimpleItem.TYPE_MY_WALLET -> MyWalletActivity.toActivity(context)
            MineSimpleItem.TYPE_TASK_CENTER -> TaskCenterActivity.toActivity(context)
            MineSimpleItem.TYPE_MY_SHOPPING_CAR -> ShoppingCarActivity.toActivity(context)
            MineSimpleItem.TYPE_TRANSACTION_RECORD -> TransactionRecordActivity.toBuy(context)
        }
    }

    companion object {

        fun newInstance(): MineFragment {
            val args = Bundle()
            val fragment = MineFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
