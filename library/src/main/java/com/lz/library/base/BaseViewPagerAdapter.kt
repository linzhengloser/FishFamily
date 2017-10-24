package com.lz.library.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/08/23
 * desc   : BaseViewPagerAdapter
 * version: 1.0
</pre> *
 */
class BaseViewPagerAdapter(fragmentManager: FragmentManager, protected var mFragmentList: List<Fragment>) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }
}
