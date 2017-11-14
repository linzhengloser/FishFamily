package com.lz.fishfamily.ui.activity.mine

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.lz.fishfamily.Constant
import com.lz.fishfamily.R
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.UserApi
import com.lz.fishfamily.handlerObservable
import com.lz.fishfamily.module.mine.Fans
import com.lz.fishfamily.ui.base.BaseListActivity
import com.lz.fishfamily.ui.itemdecoration.PaddingItemDecoration
import com.lz.fishfamily.ui.multitype.mine.FansAttentionItemViewBinder
import com.lz.fishfamily.utils.UserManager
import com.lz.fishfamily.utils.Utils
import com.zhy.autolayout.utils.AutoUtils
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_fans_list.*
import org.json.JSONObject

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/16
 * desc   : 我的 -> 粉丝 or 关注
 * version: 1.0
</pre> *
 */
class FansAttentionListActivity : BaseListActivity() {

    var mType: Int = 0

    var mTitles = arrayOf("我的粉丝", "关注的人")

    override val contentViewResourceID: Int
        get() = R.layout.activity_fans_list

    override fun registerItemViewBinder() {
        mType = intent.getIntExtra(Constant.INTENT_KEY_TYPE, 1)
        mAdapter.register(Fans::class.java, FansAttentionItemViewBinder(mType))
    }

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        Utils.setTitle(this, mTitles[mType - 1])
        rv_mine_fans.layoutManager = LinearLayoutManager(this)
        rv_mine_fans.addItemDecoration(PaddingItemDecoration().setPadding(AutoUtils.getPercentWidthSize(30), 0))
        rv_mine_fans.adapter = mAdapter
        loadPageData()
    }

    override fun loadPageData(page: Int) {
        val args = JSONObject().run {
            put("type", mType.toString())
            put("IsBlac", "0")
            put("UserInfoID", UserManager.getUser().userInfo_ID)
        }.toString()
        val getFansList = Api.create(UserApi::class.java).getFansList(screenCondition = args)
        handlerObservable(getFansList, bindToLifecycle(), Consumer {
            mItems.addAll(it)
            mAdapter.notifyDataSetChanged()
        })
    }

    companion object {

        //此参数值与服务器对应
        private val TYPE_FANS = 1
        private val TYPE_ATTENTION = 2

        fun toActivity(context: Context, type: Int) {
            val intent = Intent(context, FansAttentionListActivity::class.java)
            intent.putExtra(Constant.INTENT_KEY_TYPE, type)
            context.startActivity(intent)
        }

        fun toFansActivity(context: Context) {
            toActivity(context, TYPE_FANS)
        }

        fun toAttentionActivity(context: Context) {
            toActivity(context, TYPE_ATTENTION)
        }
    }

}
