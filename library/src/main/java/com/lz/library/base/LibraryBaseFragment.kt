package com.lz.library.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.lz.library.utils.loadsir.LoadingCallback
import com.trello.rxlifecycle2.components.support.RxFragment



/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/08/18
 * desc   : LibraryBaseFragment
 * version: 1.0
</pre> *
 */
abstract class LibraryBaseFragment : RxFragment(),BaseView {

    private var mIsInitial = false

    abstract val contentViewLayoutID: Int

    protected var mLoadService: LoadService<Any>? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(contentViewLayoutID, container, false)
        ButterKnife.bind(this, view)
        mLoadService = LoadSir.getDefault().register(view){}
        return mLoadService?.loadLayout
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewsAndEvents()
    }

    protected abstract fun initViewsAndEvents()

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && !mIsInitial) {
            //加载数据
            loadData()
            mIsInitial = !mIsInitial
        }
    }


    override fun showLoading() {
        mLoadService?.showCallback(LoadingCallback::class.java)
    }

    override fun showSuccess() {
        mLoadService?.showSuccess()
    }

    override fun showError(msg: String, clickListener: View.OnClickListener) {
    }

    override fun showEmpty() {
    }

    open fun loadData() {}

}
