package com.lz.fishfamily.utils.rxjava

import com.lz.fishfamily.api.Response
import com.lz.library.base.BaseView
import com.lz.library.utils.ApiException
import io.reactivex.functions.Function

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/08/18
 * desc   : 处理接口返回接口 使用 RxJava map 操作符
 * version: 1.0
</pre> *
 */
class HandlerApiResultFunction<T>(private val baseView: BaseView) : Function<Response<T>, T> {

    override fun apply(t: Response<T>): T {
        if (t.type == 1) {
            if (t.resultdata is List<*> && (t.resultdata as List<*>).isEmpty()) baseView.showEmpty()
            return t.resultdata
        } else throw ApiException(t.message)
    }

}
