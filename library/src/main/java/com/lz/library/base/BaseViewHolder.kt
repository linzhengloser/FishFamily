package com.lz.library.base

import android.support.v7.widget.RecyclerView
import android.view.View
import butterknife.ButterKnife
import com.zhy.autolayout.utils.AutoUtils

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/08/18
 * desc   : BaseViewHolder
 * version: 1.0
</pre> *
 */
open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {
        AutoUtils.auto(itemView)
        ButterKnife.bind(this, itemView)
    }

}
