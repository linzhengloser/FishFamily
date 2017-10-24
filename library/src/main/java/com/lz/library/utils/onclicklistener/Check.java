package com.lz.library.utils.onclicklistener;

import android.view.View;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/12
 *     desc   : 检查条件
 *     version: 1.0
 * </pre>
 */
public interface Check {

    boolean isChechSuccess(View view);

    void checkFailure(View view);

}
