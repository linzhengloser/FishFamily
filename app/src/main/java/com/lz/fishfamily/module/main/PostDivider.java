package com.lz.fishfamily.module.main;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/24
 *     desc   : 帖子分割线
 *     version: 1.0
 * </pre>
 */
public class PostDivider {

    boolean isShowMoreComent;

    public boolean isShowMoreComent() {
        return isShowMoreComent;
    }

    public PostDivider setShowMoreComent(boolean showMoreComent) {
        isShowMoreComent = showMoreComent;
        return this;
    }
}
