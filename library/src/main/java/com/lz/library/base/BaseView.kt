package com.lz.library.base

import android.view.View

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/10
 * desc   : BaseView
 * version: 1.0
</pre> *
 */
interface BaseView {

    fun showLoadingDialog()

    fun hidLoadingDialog()

    fun showErrorView(msg: String, clickListener: View.OnClickListener)

}
