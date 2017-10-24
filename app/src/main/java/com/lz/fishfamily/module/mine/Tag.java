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
public class Tag {

    private boolean isShouldDelete;

    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public boolean isShouldDelete() {
        return isShouldDelete;
    }

    public Tag setShouldDelete(boolean shouldDelete) {
        isShouldDelete = shouldDelete;
        return this;
    }

    public String getName() {
        return name;
    }

    public Tag setName(String name) {
        this.name = name;
        return this;
    }
}
