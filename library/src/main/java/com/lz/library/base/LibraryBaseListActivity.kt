package com.lz.library.base

import android.view.View

import com.lz.library.utils.RefreshListener

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
abstract class LibraryBaseListActivity : LibraryBaseActivity(), RefreshListener {

    protected val mAdapter: MultiTypeAdapter = MultiTypeAdapter()

    protected val mItems: Items = Items()

    protected var mPage: Int = 0

    protected abstract fun registerItemViewBinder()

    override fun initViewsAndEvents() {
        registerItemViewBinder()
        mAdapter.items = mItems
    }

    override fun onRefresh(view: View) {
        mPage = 1
        mItems.clear()
        loadPageData(mPage)
    }

    override fun onLoadMore(view: View) {
        mPage++
        loadPageData(mPage)
    }

    open fun loadPageData(page:Int = 1){}
}
