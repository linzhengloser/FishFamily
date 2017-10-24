package com.lz.fishfamily

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.WindowManager
import com.lz.library.utils.ToastUtils

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/23
 *     desc   : 方法扩展
 *     version: 1.0
 * </pre>
 */

fun <T> Activity.toActivity(context: Context, clazz:Class<T>){
    context.startActivity(Intent(context,clazz))
}

fun Context.toast(msg:String){
    ToastUtils.showToast(msg)
}

/**
 * 设置透明状态栏
 */
fun Activity.setTranslucentStatus(on:Boolean = true){
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