package com.lz.fishfamily.utils

import android.app.Activity
import android.graphics.Color
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.lz.fishfamily.R
import com.lz.library.utils.ToastUtils

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/10
 * desc   : 无家可归的工具方法 QAQ
 * version: 1.0
</pre> *
 */
object Utils {

    /**
     * 判断一个或者多个 Editext 是否为空 并且给出响应提示
     */
    inline fun isEmpty(hintArray: Array<String>, vararg editTexts: EditText): Boolean {
        var result = true
        for (i in editTexts.indices) {
            if (editTexts[i].text.toString().isEmpty()) {
                result = false
                ToastUtils.showToast(hintArray[i])
                break
            }
        }
        return result
    }

    inline fun setForegroundColorSpan(text: String, indexArray: Array<Pair<Int, Int>>, color: String = "#2399fd"): SpannableString {
        SpannableString(text).let {
            indexArray.forEach { index: Pair<Int, Int> ->
                it.setSpan(ForegroundColorSpan(Color.parseColor(color)), index.first, index.second, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)
            }
            return it
        }
    }

    /**
     * true visible false gone
     */
    inline fun getVisibilityByBoolean(b: Boolean): Int {
        return if (b) View.VISIBLE else View.GONE
    }

    /**
     * 获取性别字符串
     */
    inline fun getGenderStr(genderInt: Int): String {
        return if (genderInt == 0) "女" else "男"
    }


    // Title Bar 相关设置方法
    inline fun setTitle(rootView: View, title: String) {
        if (rootView.findViewById<View>(R.id.title) != null)
            (rootView.findViewById<View>(R.id.title) as TextView).text = title
    }

    inline fun setTitle(activity: Activity, title: String) {
        if (activity.findViewById<View>(R.id.title) != null)
            (activity.findViewById<View>(R.id.title) as TextView).text = title
    }

    inline fun setMenuText(rootView: View, menuText: String) {
        if (rootView.findViewById<View>(R.id.menu_text) != null)
            (rootView.findViewById<View>(R.id.menu_text) as TextView).text = menuText
    }

    inline fun setMenuText(activity: Activity, menuText: String) {
        if (activity.findViewById<View>(R.id.menu_text) != null)
            (activity.findViewById<View>(R.id.menu_text) as TextView).text = menuText
    }

    inline fun goneBack(rootView: View) {
        if (rootView.findViewById<View>(R.id.back) != null)
            rootView.findViewById<View>(R.id.back).visibility = View.GONE
    }

    inline fun goneBack(activity: Activity) {
        if (activity.findViewById<View>(R.id.back) != null)
            activity.findViewById<View>(R.id.back).visibility = View.GONE
    }

    inline fun visibleMenuIcon(rootView: View) {
        if (rootView.findViewById<View>(R.id.menu_icon) != null)
            rootView.findViewById<View>(R.id.menu_icon).visibility = View.VISIBLE
    }

    inline fun visibleMenuIcon(activity: Activity) {
        if (activity.findViewById<View>(R.id.menu_icon) != null)
            activity.findViewById<View>(R.id.menu_icon).visibility = View.VISIBLE
    }

}
