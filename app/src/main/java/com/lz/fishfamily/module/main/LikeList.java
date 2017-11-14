package com.lz.fishfamily.module.main;

import java.util.List;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/11/14
 *     desc   : 点赞集合
 *     version: 1.0
 * </pre>
 */
public class LikeList {


    private List<Like> likeList;

    public LikeList(List<Like> likeList) {
        this.likeList = likeList;
    }


    public List<Like> getLikeList() {
        return likeList;
    }

    public LikeList setLikeList(List<Like> likeList) {
        this.likeList = likeList;
        return this;
    }
}
