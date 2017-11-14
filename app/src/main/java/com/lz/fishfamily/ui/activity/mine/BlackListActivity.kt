package com.lz.fishfamily.ui.activity.mine

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.lz.fishfamily.R
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.UserApi
import com.lz.fishfamily.module.mine.Fans
import com.lz.fishfamily.ui.base.BaseListActivity
import com.lz.fishfamily.ui.itemdecoration.PaddingItemDecoration
import com.lz.fishfamily.ui.multitype.mine.BlackListItemViewBinder
import com.lz.fishfamily.utils.UserManager
import com.lz.fishfamily.utils.Utils
import com.zhy.autolayout.utils.AutoUtils
import kotlinx.android.synthetic.main.activity_black_list.*
import org.json.JSONObject

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/17
 * desc   : 我的 -> 设置 -> 黑名单
 * version: 1.0
</pre> *
 */
class BlackListActivity : BaseListActivity() {


    override val contentViewResourceID: Int
        get() = R.layout.activity_black_list

    override fun initViewsAndEvents() {
        super.initViewsAndEvents()
        Utils.setTitle(this, "黑名单")
        rv_mine_black_list.layoutManager = LinearLayoutManager(this)
        rv_mine_black_list.addItemDecoration(PaddingItemDecoration().setPadding(AutoUtils.getPercentWidthSize(30), 0))
        rv_mine_black_list.adapter = mAdapter
    }

    override fun loadPageData(page: Int) {
        val params = JSONObject().apply {
            put("type", 1)
            put("IsBlac", "1")
            put("UserInfoID", UserManager.getUser().userInfo_ID)
        }.toString()
        var blackList = Api.create(UserApi::class.java).getFansList()
    }

    override fun registerItemViewBinder() {
        mAdapter.register(Fans::class.java, BlackListItemViewBinder())
    }

    companion object {

        fun toActivity(context: Context) {
            val intent = Intent(context, BlackListActivity::class.java)
            context.startActivity(intent)
        }
    }

}
