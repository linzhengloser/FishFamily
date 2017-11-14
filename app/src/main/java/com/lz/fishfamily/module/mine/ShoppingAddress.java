package com.lz.fishfamily.module.mine;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/15
 *     desc   : 收获地址
 *     version: 1.0
 * </pre>
 */
public class ShoppingAddress implements Parcelable {


    /**
     * Address_ID : 6a560de1-9d64-45aa-9230-52ac17657cf3
     * Address_Mobile : 13477484198
     * Address_Name : 家
     * Address_Provice : 湖北
     * Address_City : 武汉
     * Address_Region : 东西湖区
     * Address_Detail : 美联奥林匹克花园1期
     * Address_CreateTime : 2017-11-11T15:39:21.59
     * UserInfo_ID : 5acea66c-8cbe-4a76-88a7-1efbedde4d85
     * Address_IsDefault : 0
     */

    private String Address_ID;
    private String Address_Mobile;
    private String Address_Name;
    private String Address_Provice;
    private String Address_City;
    private String Address_Region;
    private String Address_Detail;
    private String Address_CreateTime;
    private String UserInfo_ID;
    private int Address_IsDefault;

    public String getAddress_ID() {
        return Address_ID;
    }

    public void setAddress_ID(String Address_ID) {
        this.Address_ID = Address_ID;
    }

    public String getAddress_Mobile() {
        return Address_Mobile;
    }

    public void setAddress_Mobile(String Address_Mobile) {
        this.Address_Mobile = Address_Mobile;
    }

    public String getAddress_Name() {
        return Address_Name;
    }

    public void setAddress_Name(String Address_Name) {
        this.Address_Name = Address_Name;
    }

    public String getAddress_Provice() {
        return Address_Provice;
    }

    public void setAddress_Provice(String Address_Provice) {
        this.Address_Provice = Address_Provice;
    }

    public String getAddress_City() {
        return Address_City;
    }

    public void setAddress_City(String Address_City) {
        this.Address_City = Address_City;
    }

    public String getAddress_Region() {
        return Address_Region;
    }

    public void setAddress_Region(String Address_Region) {
        this.Address_Region = Address_Region;
    }

    public String getAddress_Detail() {
        return Address_Detail;
    }

    public void setAddress_Detail(String Address_Detail) {
        this.Address_Detail = Address_Detail;
    }

    public String getAddress_CreateTime() {
        return Address_CreateTime;
    }

    public void setAddress_CreateTime(String Address_CreateTime) {
        this.Address_CreateTime = Address_CreateTime;
    }

    public String getUserInfo_ID() {
        return UserInfo_ID;
    }

    public void setUserInfo_ID(String UserInfo_ID) {
        this.UserInfo_ID = UserInfo_ID;
    }

    public int getAddress_IsDefault() {
        return Address_IsDefault;
    }

    public void setAddress_IsDefault(int Address_IsDefault) {
        this.Address_IsDefault = Address_IsDefault;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Address_ID);
        dest.writeString(this.Address_Mobile);
        dest.writeString(this.Address_Name);
        dest.writeString(this.Address_Provice);
        dest.writeString(this.Address_City);
        dest.writeString(this.Address_Region);
        dest.writeString(this.Address_Detail);
        dest.writeString(this.Address_CreateTime);
        dest.writeString(this.UserInfo_ID);
        dest.writeInt(this.Address_IsDefault);
    }

    public ShoppingAddress() {
    }

    protected ShoppingAddress(Parcel in) {
        this.Address_ID = in.readString();
        this.Address_Mobile = in.readString();
        this.Address_Name = in.readString();
        this.Address_Provice = in.readString();
        this.Address_City = in.readString();
        this.Address_Region = in.readString();
        this.Address_Detail = in.readString();
        this.Address_CreateTime = in.readString();
        this.UserInfo_ID = in.readString();
        this.Address_IsDefault = in.readInt();
    }

    public static final Parcelable.Creator<ShoppingAddress> CREATOR = new Parcelable.Creator<ShoppingAddress>() {
        @Override
        public ShoppingAddress createFromParcel(Parcel source) {
            return new ShoppingAddress(source);
        }

        @Override
        public ShoppingAddress[] newArray(int size) {
            return new ShoppingAddress[size];
        }
    };
}
