package com.lz.library.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import butterknife.ButterKnife
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.zhy.autolayout.AutoFrameLayout
import com.zhy.autolayout.AutoLinearLayout
import com.zhy.autolayout.AutoRelativeLayout

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/08/18
 * desc   : LibraryBaseActivity
 * version: 1.0
</pre> *
 */
abstract class LibraryBaseActivity : RxAppCompatActivity(), BaseView {

    protected var mProgressDialog: ProgressDialog? = null

    protected abstract val contentViewResourceID: Int

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        var view: View? = null
        if (name == LAYOUT_FRAMELAYOUT) {
            view = AutoFrameLayout(context, attrs)
        } else if (name == LAYOUT_LINEARLAYOUT) {
            view = AutoLinearLayout(context, attrs)
        } else if (name == LAYOUT_RELATIVELAYOUT) {
            view = AutoRelativeLayout(context, attrs)
        }

        return if (view != null) view else super.onCreateView(name, context, attrs)

    }
    //------------------- AutoLayout -----------------------------


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentViewResourceID)
        initViewsAndEvents()
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        ButterKnife.bind(this)
    }

    override fun showLoadingDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(this)
            mProgressDialog!!.setTitle("加载中...")
        }
        mProgressDialog!!.show()
    }

    override fun hidLoadingDialog() {
        if (mProgressDialog != null) mProgressDialog!!.dismiss()
    }

    override fun showErrorView(msg: String, clickListener: View.OnClickListener) {

    }

    protected abstract fun initViewsAndEvents()

    companion object {

        //------------------- AutoLayout -----------------------------
        private val LAYOUT_LINEARLAYOUT = "LinearLayout"
        private val LAYOUT_FRAMELAYOUT = "FrameLayout"
        private val LAYOUT_RELATIVELAYOUT = "RelativeLayout"
    }

}
