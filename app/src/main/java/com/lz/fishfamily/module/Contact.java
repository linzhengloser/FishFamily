package com.lz.fishfamily.module;

import com.lz.library.ui.view.indexbar.BaseIndexPinyinBean;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/12
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Contact extends BaseIndexPinyinBean {

    private String name;

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }


    @Override
    public String getTarget() {
        return getName();
    }
}
