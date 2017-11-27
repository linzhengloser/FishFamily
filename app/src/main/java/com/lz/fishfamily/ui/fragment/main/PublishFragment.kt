package com.lz.fishfamily.ui.fragment.main

import android.os.Bundle
import android.view.View
import butterknife.OnClick
import com.lz.fishfamily.R
import com.lz.fishfamily.ui.activity.SignInActivity
import com.lz.fishfamily.ui.activity.main.MyCommodityActivity
import com.lz.fishfamily.ui.activity.main.PublishCommodityActivity
import com.lz.fishfamily.ui.activity.main.PublishLongPostActivity
import com.lz.fishfamily.ui.activity.main.PublishPostActivity
import com.lz.fishfamily.ui.base.BaseFragment

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/25
 * desc   : 发布
 * version: 1.0
</pre> *
 */
class PublishFragment : BaseFragment() {

    override val contentViewLayoutID: Int
        get() = R.layout.fragment_main_publish

    override fun initViewsAndEvents() {

    }

    @OnClick(R.id.ll_sign_in, R.id.ll_publish_commodity, R.id.ll_publish_post, R.id.ll_publish_long_post)
    fun onClick(view: View) {
        when (view.id) {
            R.id.ll_sign_in -> SignInActivity.toActivity(context)
            R.id.ll_publish_commodity -> PublishCommodityActivity.toActivity(view.context)
            R.id.ll_publish_post -> PublishPostActivity.toActivity(context)
            R.id.ll_publish_long_post -> PublishLongPostActivity.toActivity(context)
            R.id.ll_merchant_living -> MyCommodityActivity.toActivity(context)
        }
    }

    companion object {


        fun newInstance(): PublishFragment {
            val args = Bundle()
            val fragment = PublishFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
