package com.lz.library.utils;

import android.view.View;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/20
 *     desc   : 下拉刷新 or 上拉加载接口
 *     version: 1.0
 * </pre>
 */
public interface RefreshListener {

    void onRefresh(View view);

    void onLoadMore(View view);

}
