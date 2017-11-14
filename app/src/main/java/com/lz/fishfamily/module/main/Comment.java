package com.lz.fishfamily.module.main;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/11/14
 *     desc   : 评论
 *     version: 1.0
 * </pre>
 */
public class Comment {


    /**
     * Comment_ID : 6580321f-9cce-43e3-a91e-a7b928633f48
     * CommentParent_ID : 0
     * UserInfo_ID : 5acea66c-8cbe-4a76-88a7-1efbedde4d85
     * UserName : 大佬111
     * PassiveUserName :
     * HeadImage : http://fweb.whmnx.com/Resource/PhotoFile/5a630735-d046-4986-b5c7-c396010107a6.jpg
     * Comment_Content : 我是评论123
     * Other_ID : d1bc874d-e099-40b1-a57a-b543a240dbc1
     * Time : 2017-11-14T21:25:35.883
     */

    private String Comment_ID;
    private String CommentParent_ID;
    private String UserInfo_ID;
    private String UserName;
    private String PassiveUserName;
    private String HeadImage;
    private String Comment_Content;
    private String Other_ID;
    private String Time;

    public String getComment_ID() {
        return Comment_ID;
    }

    public void setComment_ID(String Comment_ID) {
        this.Comment_ID = Comment_ID;
    }

    public String getCommentParent_ID() {
        return CommentParent_ID;
    }

    public void setCommentParent_ID(String CommentParent_ID) {
        this.CommentParent_ID = CommentParent_ID;
    }

    public String getUserInfo_ID() {
        return UserInfo_ID;
    }

    public void setUserInfo_ID(String UserInfo_ID) {
        this.UserInfo_ID = UserInfo_ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassiveUserName() {
        return PassiveUserName;
    }

    public void setPassiveUserName(String PassiveUserName) {
        this.PassiveUserName = PassiveUserName;
    }

    public String getHeadImage() {
        return HeadImage;
    }

    public void setHeadImage(String HeadImage) {
        this.HeadImage = HeadImage;
    }

    public String getComment_Content() {
        return Comment_Content;
    }

    public void setComment_Content(String Comment_Content) {
        this.Comment_Content = Comment_Content;
    }

    public String getOther_ID() {
        return Other_ID;
    }

    public void setOther_ID(String Other_ID) {
        this.Other_ID = Other_ID;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
}
