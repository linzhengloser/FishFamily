package com.lz.fishfamily.module.main;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/24
 *     desc   : 首页分割线
 *     version: 1.0
 * </pre>
 */
public class MainDivider {

    boolean isShowMoreComment;

    public boolean isShowMoreComment() {
        return isShowMoreComment;
    }

    public MainDivider setShowMoreComment(boolean showMoreComment) {
        isShowMoreComment = showMoreComment;
        return this;
    }
}
