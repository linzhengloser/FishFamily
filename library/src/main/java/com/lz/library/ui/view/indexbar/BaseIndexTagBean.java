package com.lz.library.ui.view.indexbar;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/26
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class BaseIndexTagBean {

    /**
     *  需要拼音化字段的第一个拼音
     *  比如 武汉  那值对应的就是 w
     */
    private String baseIndexTag;

    public String getBaseIndexTag() {
        return baseIndexTag;
    }

    public BaseIndexTagBean setBaseIndexTag(String baseIndexTag) {
        this.baseIndexTag = baseIndexTag;
        return this;
    }
}
