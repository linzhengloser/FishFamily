package com.lz.library.utils.loadsir

import com.kingja.loadsir.callback.Callback
import com.lz.library.R

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/31
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class EmptyCallback : Callback() {
    override fun onCreateView(): Int = R.layout.commom_loading_layout
}