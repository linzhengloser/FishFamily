package com.lz.library.base

import me.drakeet.multitype.Items
import me.drakeet.multitype.MultiTypeAdapter

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/08/20
 * desc   :
 * version: 1.0
</pre> *
 */
abstract class LibraryBaseListFragment : LibraryBaseFragment() {

    protected var mAdapter: MultiTypeAdapter? = null

    protected var mItems: Items? = null

    protected abstract fun registerItemViewBinder()

    override fun initViewsAndEvents() {
        mAdapter = MultiTypeAdapter()
        mItems = Items()
        registerItemViewBinder()
        mAdapter!!.items = mItems
    }
}
