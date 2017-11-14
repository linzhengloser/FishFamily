package com.lz.fishfamily.ui.activity.main

import android.content.Context
import android.content.Intent

import com.lz.fishfamily.R
import com.lz.fishfamily.ui.base.BaseActivity
import com.lz.fishfamily.utils.Utils
import kotlinx.android.synthetic.main.activity_main_publish_commodity.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/10/16
 * desc   : 首页 -> 发布 发布商品
 * version: 1.0
</pre> *
 */
class PublishCommodityActivity : BaseActivity() {

    override val contentViewResourceID: Int
        get() = R.layout.activity_main_publish_commodity

    override fun initViewsAndEvents() {
        Utils.setTitle(this, "发布商品")
        ll_category.setOnClickListener { FishCategoryActivity.toActivity(it.context) }

    }

    companion object {

        fun toActivity(context: Context) {
            val intent = Intent(context, PublishCommodityActivity::class.java)
            context.startActivity(intent)
        }
    }

}
