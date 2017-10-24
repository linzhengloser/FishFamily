package com.lz.fishfamily.ui.base

import android.content.Context
import android.os.Bundle
import android.os.SystemClock
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.view.*
import com.lz.fishfamily.R


/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/10
 * desc   : BaseDialogFragment
 * version: 1.0
</pre> *
 */
abstract class BaseDialogFragment : DialogFragment() {

    private var mWidth: Int = 0

    private var mHeight: Int = 0

    private var mHorizontalMargin: Int = 0

    private var mDimAmount: Int = 0

    private var mIsShowBottom = false

    private var mIsCancelable = true

    protected var mView: View? = null

    protected abstract val layoutResID: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.BaseDialogFramgent)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater!!.inflate(layoutResID, container, false)
        initViewsAndEvents()
        return mView
    }

    override fun onStart() {
        super.onStart()
        if (dialog.window != null) {
            setParams()
            val window = dialog.window
            val lp = window!!.attributes
            lp.dimAmount = if (mDimAmount == 0) 0.5f else mDimAmount.toFloat()
            lp.gravity = if (mIsShowBottom) Gravity.BOTTOM else Gravity.CENTER
            lp.width = if (mWidth == 0) getScreenWidth(context) - 2 * mHorizontalMargin else mWidth
            lp.height = if (mHeight == 0) WindowManager.LayoutParams.WRAP_CONTENT else mHeight
            window.setWindowAnimations(R.style.DefaultAnimation)
            window.attributes = lp
            isCancelable = mIsCancelable
        }
    }

    protected abstract fun setParams()

    protected abstract fun initViewsAndEvents()

    fun show(fragmentTransaction: FragmentManager) {
        show(fragmentTransaction, SystemClock.currentThreadTimeMillis().toString())
    }

    // ---------------- getter/setter --------------------
    fun getWidth(): Int {
        return mWidth
    }

    fun setWidth(width: Int): BaseDialogFragment {
        mWidth = width
        return this
    }

    fun getHeight(): Int {
        return mHeight
    }

    fun setHeight(height: Int): BaseDialogFragment {
        mHeight = height
        return this
    }

    fun getHorizontalMargin(): Int {
        return mHorizontalMargin
    }

    fun setHorizontalMargin(horizontalMargin: Int): BaseDialogFragment {
        mHorizontalMargin = horizontalMargin
        return this
    }

    fun getDimAmount(): Int {
        return mDimAmount
    }

    fun setDimAmount(dimAmount: Int): BaseDialogFragment {
        mDimAmount = dimAmount
        return this
    }

    fun isShowBottom(): Boolean {
        return mIsShowBottom
    }

    fun setShowBottom(showBottom: Boolean): BaseDialogFragment {
        mIsShowBottom = showBottom
        return this
    }

    override fun isCancelable(): Boolean {
        return mIsCancelable
    }

    fun setIsCancelable(cancelable: Boolean): BaseDialogFragment {
        mIsCancelable = cancelable
        return this
    }

    companion object {

        fun getScreenWidth(context: Context): Int {
            val displayMetrics = context.resources.displayMetrics
            return displayMetrics.widthPixels
        }
    }
}
