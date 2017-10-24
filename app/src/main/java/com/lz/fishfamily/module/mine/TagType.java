package com.lz.fishfamily.module.mine;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class TagType {

    private String name;

    public TagType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public TagType setName(String name) {
        this.name = name;
        return this;
    }
}
