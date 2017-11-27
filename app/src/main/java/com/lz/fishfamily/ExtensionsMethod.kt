package com.lz.fishfamily

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.lz.fishfamily.api.Api
import com.lz.fishfamily.api.CommonApi
import com.lz.fishfamily.api.Response
import com.lz.fishfamily.module.main.Comment
import com.lz.fishfamily.module.main.LikeList
import com.lz.fishfamily.utils.UserManager
import com.lz.fishfamily.utils.Utils
import com.lz.fishfamily.utils.glide.GlideApp
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

/**
 * 设置评论
 */
inline fun TextView.setComment(comment: Comment) {
    val commentString: String
    val commentSpannableString = if (comment.commentParent_ID == "0") {
        commentString = "${comment.userName}  :  ${comment.comment_Content}";
        Utils.setForegroundColorSpan(commentString, arrayOf(Pair(0, comment.userName.length)), "#1371C0")
    } else {
        commentString = "${comment.userName}回复${comment.passiveUserName}  :  ${comment.comment_Content}"
        Utils.setForegroundColorSpan(commentString, arrayOf(
                Pair(0, comment.userName.length),
                Pair(commentString.indexOf(comment.passiveUserName), commentString.indexOf(comment.passiveUserName) + comment.passiveUserName.length)
        ), "#1371C0")
    }
    text = commentSpannableString
}

inline fun ImageView.setLike(isLike: Boolean) = if (isLike) setImageResource(R.drawable.common_like_selected) else setImageResource(R.drawable.common_like_unselected)

inline fun ImageView.setSelectedSrc(isSelected: Boolean)
        = if (isSelected) setImageResource(R.drawable.common_selected) else setImageResource(R.drawable.common_unselected)

inline fun TextView.setAttention(isAttention: Boolean)
        = if (isAttention) setBackgroundResource(R.drawable.shape_common_unattention) else setBackgroundResource(R.drawable.shape_common_attention)

inline fun TextView.setLike(isLike: Boolean, likeCount: String) {
    val drawable = resources.getDrawable(if (isLike) R.drawable.common_like_selected else R.drawable.common_like_unselected)
    drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
    if (isLike) setCompoundDrawables(drawable, null, null, null)
    else setCompoundDrawables(drawable, null, null, null)
    text = likeCount
}

inline fun LinearLayout.setLikeList(likeList: LikeList) {
    if (likeList.likeList.isEmpty()) visibility = View.GONE
    else {
        visibility = View.VISIBLE
        var avatarImageView: ImageView
        repeat(childCount) {
            if (getChildAt(it) !is ImageView) return
            avatarImageView = getChildAt(it) as ImageView
            if (it < likeList.likeList.size) {
                avatarImageView.visibility = View.VISIBLE
                GlideApp.with(context)
                        .load(likeList.likeList[it].headImage)
                        .loadAvatar()
                        .into(avatarImageView)
            } else avatarImageView.visibility = View.GONE
        }
    }
}

inline fun ImageView.setLevel(level: Int) = UserManager.bindUserLevel(this, level)

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


