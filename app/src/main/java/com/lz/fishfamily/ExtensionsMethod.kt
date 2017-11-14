package com.lz.fishfamily

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Build
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.CommonApi
import com.lz.fishfamily.api.Response
import com.lz.fishfamily.utils.rxjava.HandlerApiResultConsumer
import com.lz.fishfamily.utils.rxjava.HandlerApiResultFunction
import com.lz.library.base.BaseView
import com.lz.library.utils.BitmapUtils
import com.trello.rxlifecycle2.LifecycleTransformer
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/23
 *     desc   : Kotlin 方法扩展
 *     version: 1.0
 * </pre>
 */


/**
 * 设置透明状态栏
 */
fun Activity.setTranslucentStatus(on: Boolean = true) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        val win = window
        val winParams = win.attributes
        val bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
}

inline fun ImageView.setSelectedSrc(isSelected: Boolean)
        = if (isSelected) setImageResource(R.drawable.common_selected) else setImageResource(R.drawable.common_unselected)

inline fun TextView.setAttention(isAttention: Boolean)
        = if (isAttention) setBackgroundResource(R.drawable.shape_common_unattention) else setBackgroundResource(R.drawable.shape_common_attention)

inline fun TextView.setLike(isLike: Boolean)
        = if (isLike) setCompoundDrawables(resources.getDrawable(R.drawable.common_like_selected), null, null, null)
else setCompoundDrawables(resources.getDrawable(R.drawable.common_like_unselected), null, null, null)

fun Activity.uploadImage(lifecycleTransformer: LifecycleTransformer<Response<String>>, baseView: BaseView, path: String?, callBack: (serverPath: String) -> Any) {
    baseView.showLoading()
    val base64 = BitmapUtils.bitmapToBase64(BitmapFactory.decodeFile(path))
    Api.create(CommonApi::class.java)
            .uploadImage(base64)
            .compose(lifecycleTransformer)
            .map(HandlerApiResultFunction(baseView))
            .doFinally { baseView.showSuccess() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer { callBack(it) }, HandlerApiResultConsumer())
}

/**
 * 处理 RxJava 的 Observable
 */
fun <T> BaseView.handlerObservable(observable: Observable<Response<T>>, lifecycleTransformer: LifecycleTransformer<Response<T>>, consumer: Consumer<T>) {
    showLoading()
    observable.compose(lifecycleTransformer)
            .map(HandlerApiResultFunction(this))
            .doFinally { showSuccess() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(consumer, HandlerApiResultConsumer())
}

fun <T> BaseView.handlerObservable(observable: Observable<Response<T>>, baseView: BaseView, lifecycleTransformer: LifecycleTransformer<Response<T>>, consumer: (T) -> Any) {
    baseView.showLoading()
    observable.compose(lifecycleTransformer)
            .map(HandlerApiResultFunction(this))
            .doFinally { baseView.showSuccess() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer { consumer(it) }, HandlerApiResultConsumer())
}


