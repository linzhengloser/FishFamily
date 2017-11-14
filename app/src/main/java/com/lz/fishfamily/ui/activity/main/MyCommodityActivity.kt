package com.lz.fishfamily.ui.activity.main

import android.support.v4.app.Fragment
import com.lz.fishfamily.R
import com.lz.fishfamily.ui.base.BaseActivity
import com.lz.fishfamily.ui.fragment.main.MyCommodityFragment
import com.lz.fishfamily.utils.Utils
import com.lz.library.base.BaseViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main_taotao_my_commodity.*

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/11/02
 *     desc   : 我的商品 Activity
 *     version: 1.0
 * </pre>
 */

class MyCommodityActivity : BaseActivity(){

    val mFragmentList = mutableListOf<Fragment>()

    override fun initViewsAndEvents() {
        Utils.setTitle(this,"我的商品")
        mFragmentList.add(MyCommodityFragment.newInstance())
        mFragmentList.add(MyCommodityFragment.newInstance())
        vp_my_commodity.adapter = BaseViewPagerAdapter(supportFragmentManager,mFragmentList)
    }

    override val contentViewResourceID: Int
        get() = R.layout.activity_main_taotao_my_commodity

}