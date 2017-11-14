package com.lz.fishfamily.ui.base

import android.os.Bundle
import android.view.View

import com.lz.fishfamily.R
import com.lz.fishfamily.im.IMNotifier
import com.lz.library.base.LibraryBaseListActivity

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/06
 * desc   : BaseListActivity
 * version: 1.0
</pre> *
 */
abstract class BaseListActivity : LibraryBaseListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (findViewById<View>(R.id.back) != null)
            findViewById<View>(R.id.back).setOnClickListener { finish() }
    }

    override fun onResume() {
        super.onResume()
        IMNotifier.getInstance().reset()
    }

}
