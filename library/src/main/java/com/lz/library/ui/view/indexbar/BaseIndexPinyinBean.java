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
public abstract class BaseIndexPinyinBean extends BaseIndexTagBean implements IIndexTargetInterface {

    /**
     * 需要转换成拼音的字段转换后的拼音
     * 比如武汉对应的值就是 wh
     * 此字段主要是用来排序
     */
    private String baseIndexPinyin;

    public String getBaseIndexPinyin() {
        return baseIndexPinyin;
    }

    public BaseIndexPinyinBean setBaseIndexPinyin(String baseIndexPinyin) {
        this.baseIndexPinyin = baseIndexPinyin;
        return this;
    }

}
