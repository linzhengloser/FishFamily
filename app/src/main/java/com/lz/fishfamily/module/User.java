package com.lz.fishfamily.module;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/26
 *     desc   : 用户对象
 *     version: 1.0
 * </pre>
 */
public class User implements Parcelable {

    /**
     * UserInfo_ID : 5acea66c-8cbe-4a76-88a7-1efbedde4d85 UserInfo_HeadImg :
     * http://fweb.whmnx.com/Resource/PhotoFile/5a630735-d046-4986-b5c7-c396010107a6.jpg
     * UserInfo_NickName : 大佬111 UserInfo_Pwd : FCEA920F7412B5DA7BE0CF42B8C93759 UserInfo_Mobile :
     * 13477484198 UserInfo_Sex : 1 UserInfo_Money : 0 UserInfo_Integer : 0 UserInfo_CreateTime :
     * 2017-09-10T17:14:01.167 UserInfo_State : 0 UserInfo_IsApp : 0 UserInfo_Provice : 湖北省
     * UserInfo_City : 武汉市 UserInfo_Region : 东西湖区 UserInfo_DetailAddress : UserInfo_Type : 1
     * UserInfo_ParentID : UserInfo_IdentityCard : UserInfo_RealName : UserInfo_Level : 0
     * UserInfo_FullAddress : UserInfo_TotalMoney : 0 UserInfo_Describe : 大吉大利，今晚吃鸡。
     * UserInfo_UUAccount : 13477484198 UserInfo_UUID : 63170fd0-9608-11e7-bfe8-716c9560e219
     * UserInfo_Labelling : 、 Business_ID : null ShareCount : 0 FansCount : 158 FllowCount : 300
     */

    private String UserInfo_ID;
    private String UserInfo_HeadImg;
    private String UserInfo_NickName;
    private String UserInfo_Pwd;
    private String UserInfo_Mobile;
    private int UserInfo_Sex;
    private int UserInfo_Money;
    private int UserInfo_Integer;
    private String UserInfo_CreateTime;
    private int UserInfo_State;
    private int UserInfo_IsApp;
    private String UserInfo_Provice;
    private String UserInfo_City;
    private String UserInfo_Region;
    private String UserInfo_DetailAddress;
    private int UserInfo_Type;
    private String UserInfo_ParentID;
    private String UserInfo_IdentityCard;
    private String UserInfo_RealName;
    private int UserInfo_Level;
    private String UserInfo_FullAddress;
    private int UserInfo_TotalMoney;
    private String UserInfo_Describe;
    private String UserInfo_UUAccount;
    private String UserInfo_UUID;
    private String UserInfo_Labelling;
    private String Business_ID;
    private int ShareCount;
    private int FansCount;
    private int FllowCount;

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

    public String getUserInfo_NickName() {
        return UserInfo_NickName;
    }

    public void setUserInfo_NickName(String UserInfo_NickName) {
        this.UserInfo_NickName = UserInfo_NickName;
    }

    public String getUserInfo_Pwd() {
        return UserInfo_Pwd;
    }

    public void setUserInfo_Pwd(String UserInfo_Pwd) {
        this.UserInfo_Pwd = UserInfo_Pwd;
    }

    public String getUserInfo_Mobile() {
        return UserInfo_Mobile;
    }

    public void setUserInfo_Mobile(String UserInfo_Mobile) {
        this.UserInfo_Mobile = UserInfo_Mobile;
    }

    public int getUserInfo_Sex() {
        return UserInfo_Sex;
    }

    public void setUserInfo_Sex(int UserInfo_Sex) {
        this.UserInfo_Sex = UserInfo_Sex;
    }

    public int getUserInfo_Money() {
        return UserInfo_Money;
    }

    public void setUserInfo_Money(int UserInfo_Money) {
        this.UserInfo_Money = UserInfo_Money;
    }

    public int getUserInfo_Integer() {
        return UserInfo_Integer;
    }

    public void setUserInfo_Integer(int UserInfo_Integer) {
        this.UserInfo_Integer = UserInfo_Integer;
    }

    public String getUserInfo_CreateTime() {
        return UserInfo_CreateTime;
    }

    public void setUserInfo_CreateTime(String UserInfo_CreateTime) {
        this.UserInfo_CreateTime = UserInfo_CreateTime;
    }

    public int getUserInfo_State() {
        return UserInfo_State;
    }

    public void setUserInfo_State(int UserInfo_State) {
        this.UserInfo_State = UserInfo_State;
    }

    public int getUserInfo_IsApp() {
        return UserInfo_IsApp;
    }

    public void setUserInfo_IsApp(int UserInfo_IsApp) {
        this.UserInfo_IsApp = UserInfo_IsApp;
    }

    public String getUserInfo_Provice() {
        return UserInfo_Provice;
    }

    public void setUserInfo_Provice(String UserInfo_Provice) {
        this.UserInfo_Provice = UserInfo_Provice;
    }

    public String getUserInfo_City() {
        return UserInfo_City;
    }

    public void setUserInfo_City(String UserInfo_City) {
        this.UserInfo_City = UserInfo_City;
    }

    public String getUserInfo_Region() {
        return UserInfo_Region;
    }

    public void setUserInfo_Region(String UserInfo_Region) {
        this.UserInfo_Region = UserInfo_Region;
    }

    public String getUserInfo_DetailAddress() {
        return UserInfo_DetailAddress;
    }

    public void setUserInfo_DetailAddress(String UserInfo_DetailAddress) {
        this.UserInfo_DetailAddress = UserInfo_DetailAddress;
    }

    public int getUserInfo_Type() {
        return UserInfo_Type;
    }

    public void setUserInfo_Type(int UserInfo_Type) {
        this.UserInfo_Type = UserInfo_Type;
    }

    public String getUserInfo_ParentID() {
        return UserInfo_ParentID;
    }

    public void setUserInfo_ParentID(String UserInfo_ParentID) {
        this.UserInfo_ParentID = UserInfo_ParentID;
    }

    public String getUserInfo_IdentityCard() {
        return UserInfo_IdentityCard;
    }

    public void setUserInfo_IdentityCard(String UserInfo_IdentityCard) {
        this.UserInfo_IdentityCard = UserInfo_IdentityCard;
    }

    public String getUserInfo_RealName() {
        return UserInfo_RealName;
    }

    public void setUserInfo_RealName(String UserInfo_RealName) {
        this.UserInfo_RealName = UserInfo_RealName;
    }

    public int getUserInfo_Level() {
        return UserInfo_Level;
    }

    public void setUserInfo_Level(int UserInfo_Level) {
        this.UserInfo_Level = UserInfo_Level;
    }

    public String getUserInfo_FullAddress() {
        return UserInfo_FullAddress;
    }

    public void setUserInfo_FullAddress(String UserInfo_FullAddress) {
        this.UserInfo_FullAddress = UserInfo_FullAddress;
    }

    public int getUserInfo_TotalMoney() {
        return UserInfo_TotalMoney;
    }

    public void setUserInfo_TotalMoney(int UserInfo_TotalMoney) {
        this.UserInfo_TotalMoney = UserInfo_TotalMoney;
    }

    public String getUserInfo_Describe() {
        return UserInfo_Describe;
    }

    public void setUserInfo_Describe(String UserInfo_Describe) {
        this.UserInfo_Describe = UserInfo_Describe;
    }

    public String getUserInfo_UUAccount() {
        return UserInfo_UUAccount;
    }

    public void setUserInfo_UUAccount(String UserInfo_UUAccount) {
        this.UserInfo_UUAccount = UserInfo_UUAccount;
    }

    public String getUserInfo_UUID() {
        return UserInfo_UUID;
    }

    public void setUserInfo_UUID(String UserInfo_UUID) {
        this.UserInfo_UUID = UserInfo_UUID;
    }

    public String getUserInfo_Labelling() {
        return UserInfo_Labelling;
    }

    public void setUserInfo_Labelling(String UserInfo_Labelling) {
        this.UserInfo_Labelling = UserInfo_Labelling;
    }

    public Object getBusiness_ID() {
        return Business_ID;
    }

    public void setBusiness_ID(String Business_ID) {
        this.Business_ID = Business_ID;
    }

    public int getShareCount() {
        return ShareCount;
    }

    public void setShareCount(int ShareCount) {
        this.ShareCount = ShareCount;
    }

    public int getFansCount() {
        return FansCount;
    }

    public void setFansCount(int FansCount) {
        this.FansCount = FansCount;
    }

    public int getFllowCount() {
        return FllowCount;
    }

    public void setFllowCount(int FllowCount) {
        this.FllowCount = FllowCount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.UserInfo_ID);
        dest.writeString(this.UserInfo_HeadImg);
        dest.writeString(this.UserInfo_NickName);
        dest.writeString(this.UserInfo_Pwd);
        dest.writeString(this.UserInfo_Mobile);
        dest.writeInt(this.UserInfo_Sex);
        dest.writeInt(this.UserInfo_Money);
        dest.writeInt(this.UserInfo_Integer);
        dest.writeString(this.UserInfo_CreateTime);
        dest.writeInt(this.UserInfo_State);
        dest.writeInt(this.UserInfo_IsApp);
        dest.writeString(this.UserInfo_Provice);
        dest.writeString(this.UserInfo_City);
        dest.writeString(this.UserInfo_Region);
        dest.writeString(this.UserInfo_DetailAddress);
        dest.writeInt(this.UserInfo_Type);
        dest.writeString(this.UserInfo_ParentID);
        dest.writeString(this.UserInfo_IdentityCard);
        dest.writeString(this.UserInfo_RealName);
        dest.writeInt(this.UserInfo_Level);
        dest.writeString(this.UserInfo_FullAddress);
        dest.writeInt(this.UserInfo_TotalMoney);
        dest.writeString(this.UserInfo_Describe);
        dest.writeString(this.UserInfo_UUAccount);
        dest.writeString(this.UserInfo_UUID);
        dest.writeString(this.UserInfo_Labelling);
        dest.writeString(this.Business_ID);
        dest.writeInt(this.ShareCount);
        dest.writeInt(this.FansCount);
        dest.writeInt(this.FllowCount);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.UserInfo_ID = in.readString();
        this.UserInfo_HeadImg = in.readString();
        this.UserInfo_NickName = in.readString();
        this.UserInfo_Pwd = in.readString();
        this.UserInfo_Mobile = in.readString();
        this.UserInfo_Sex = in.readInt();
        this.UserInfo_Money = in.readInt();
        this.UserInfo_Integer = in.readInt();
        this.UserInfo_CreateTime = in.readString();
        this.UserInfo_State = in.readInt();
        this.UserInfo_IsApp = in.readInt();
        this.UserInfo_Provice = in.readString();
        this.UserInfo_City = in.readString();
        this.UserInfo_Region = in.readString();
        this.UserInfo_DetailAddress = in.readString();
        this.UserInfo_Type = in.readInt();
        this.UserInfo_ParentID = in.readString();
        this.UserInfo_IdentityCard = in.readString();
        this.UserInfo_RealName = in.readString();
        this.UserInfo_Level = in.readInt();
        this.UserInfo_FullAddress = in.readString();
        this.UserInfo_TotalMoney = in.readInt();
        this.UserInfo_Describe = in.readString();
        this.UserInfo_UUAccount = in.readString();
        this.UserInfo_UUID = in.readString();
        this.UserInfo_Labelling = in.readString();
        this.Business_ID = in.readString();
        this.ShareCount = in.readInt();
        this.FansCount = in.readInt();
        this.FllowCount = in.readInt();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
