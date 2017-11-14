package com.lz.fishfamily.module.mine;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/16
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Fans {


    /**
     * UserInfo_NickName : dwqdwqdw
     * UserInfo_ID : 1e8b074f-1dd7-48db-8ed0-f19eda8afc0c
     * UserInfo_HeadImg : http://fweb.whmnx.com/UserFile/Image/userhead.jpg
     * UserInfo_Describe : 这家伙很懒，什么都没有留下。
     * MutualConcern : false
     */

    private String UserInfo_NickName;
    private String UserInfo_ID;
    private String UserInfo_HeadImg;
    private String UserInfo_Describe;
    private boolean MutualConcern;

    public String getUserInfo_NickName() {
        return UserInfo_NickName;
    }

    public void setUserInfo_NickName(String UserInfo_NickName) {
        this.UserInfo_NickName = UserInfo_NickName;
    }

    public String getUserInfo_ID() {
        return UserInfo_ID;
    }

    public void setUserInfo_ID(String UserInfo_ID) {
        this.UserInfo_ID = UserInfo_ID;
    }

    public String getUserInfo_HeadImg() {
        return UserInfo_HeadImg;
    }

    public void setUserInfo_HeadImg(String UserInfo_HeadImg) {
        this.UserInfo_HeadImg = UserInfo_HeadImg;
    }

    public String getUserInfo_Describe() {
        return UserInfo_Describe;
    }

    public void setUserInfo_Describe(String UserInfo_Describe) {
        this.UserInfo_Describe = UserInfo_Describe;
    }

    public boolean isMutualConcern() {
        return MutualConcern;
    }

    public void setMutualConcern(boolean MutualConcern) {
        this.MutualConcern = MutualConcern;
    }
}
