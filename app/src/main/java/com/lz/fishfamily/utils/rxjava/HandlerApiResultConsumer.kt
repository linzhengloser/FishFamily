package com.lz.fishfamily.utils.rxjava


import com.hyphenate.util.NetUtils
import com.lz.fishfamily.MyApplication
import com.lz.library.utils.ApiException
import com.lz.library.utils.ToastUtils
import io.reactivex.functions.Consumer
import java.net.UnknownHostException

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/10
 * desc   :
 * version: 1.0
</pre> *
 */
class HandlerApiResultConsumer : Consumer<Throwable> {

    @Throws(Exception::class)
    override fun accept(throwable: Throwable) {
        if (throwable is ApiException) {
            ToastUtils.showToast(throwable.errorMessage)
        } else {
            if (throwable is UnknownHostException && !NetUtils.hasNetwork(MyApplication.getInstance())) {
                ToastUtils.showNoNetWorkToast()
            } else {
                ToastUtils.showDebugToast("程序内部异常。" + throwable.message)
            }
        }
    }
}
