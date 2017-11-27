package com.lz.fishfamily.module.main;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/11/14
 *     desc   : 点赞对象
 *     version: 1.0
 * </pre>
 */
public class Like implements Parcelable {


    /**
     * Other_ID : bb5332fd-3bf9-4091-a16e-55da186a48ba
     * UserInfoID : 14d24b07-8899-4971-96a2-cea033f26344
     * HeadImage : http://fweb.whmnx.com/UserFile/Image/userhead.jpg
     */

    private String Other_ID;
    private String UserInfoID;
    private String HeadImage;

    public String getOther_ID() {
        return Other_ID;
    }

    public void setOther_ID(String Other_ID) {
        this.Other_ID = Other_ID;
    }

    public String getUserInfoID() {
        return UserInfoID;
    }

    public void setUserInfoID(String UserInfoID) {
        this.UserInfoID = UserInfoID;
    }

    public String getHeadImage() {
        return HeadImage;
    }

    public void setHeadImage(String HeadImage) {
        this.HeadImage = HeadImage;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Other_ID);
        dest.writeString(this.UserInfoID);
        dest.writeString(this.HeadImage);
    }

    public Like() {
    }

    protected Like(Parcel in) {
        this.Other_ID = in.readString();
        this.UserInfoID = in.readString();
        this.HeadImage = in.readString();
    }

    public static final Parcelable.Creator<Like> CREATOR = new Parcelable.Creator<Like>() {
        @Override
        public Like createFromParcel(Parcel source) {
            return new Like(source);
        }

        @Override
        public Like[] newArray(int size) {
            return new Like[size];
        }
    };
}
