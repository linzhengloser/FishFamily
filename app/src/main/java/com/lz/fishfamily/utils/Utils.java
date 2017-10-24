package com.lz.fishfamily.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lz.fishfamily.R;
import com.lz.library.utils.ToastUtils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/10
 *     desc   : 无家可归的工具方法 QAQ
 *     version: 1.0
 * </pre>
 */
public class Utils {

    /**
     * 判断一个或者多个 Editext 是否为空 并且给出响应提示
     */
    public static boolean isEmpty(String[] hintArray, EditText... editTexts) {
        boolean result = true;
        for (int i = 0; i < editTexts.length; i++) {
            if (TextUtils.isEmpty(editTexts[i].getText().toString().trim())) {
                result = false;
                ToastUtils.showToast(hintArray[i]);
                break;
            }
        }
        return result;
    }

    /**
     * true visible false gone
     */
    public static int getVisibilityByBoolean(boolean b) {
        return b ? View.VISIBLE : View.GONE;
    }


    // Title Bar 相关设置方法
    public static void setTitle(View rootView, String title) {
        if (rootView.findViewById(R.id.title) != null)
            ((TextView) rootView.findViewById(R.id.title)).setText(title);
    }

    public static void setTitle(Activity activity, String title) {
        if (activity.findViewById(R.id.title) != null)
            ((TextView) activity.findViewById(R.id.title)).setText(title);
    }

    public static void setMenuText(View rootView, String menuText) {
        if (rootView.findViewById(R.id.menu_text) != null)
            ((TextView) rootView.findViewById(R.id.menu_text)).setText(menuText);
    }

    public static void setMenuText(Activity activity, String menuText) {
        if (activity.findViewById(R.id.menu_text) != null)
            ((TextView) activity.findViewById(R.id.menu_text)).setText(menuText);
    }

    public static void goneBack(View rootView) {
        if (rootView.findViewById(R.id.back) != null)
            rootView.findViewById(R.id.back).setVisibility(View.GONE);
    }

    public static void goneBack(Activity activity) {
        if (activity.findViewById(R.id.back) != null)
            activity.findViewById(R.id.back).setVisibility(View.GONE);
    }

    public static void visibleMenuIcon(View rootView) {
        if (rootView.findViewById(R.id.menu_icon) != null)
            rootView.findViewById(R.id.menu_icon).setVisibility(View.VISIBLE);
    }

    public static void visibleMenuIcon(Activity activity) {
        if (activity.findViewById(R.id.menu_icon) != null)
            activity.findViewById(R.id.menu_icon).setVisibility(View.VISIBLE);
    }

}
