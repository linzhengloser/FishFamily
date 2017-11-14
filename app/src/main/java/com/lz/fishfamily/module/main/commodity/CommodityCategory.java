package com.lz.fishfamily.module.main.commodity;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/27
 *     desc   : 商品类型
 *     version: 1.0
 * </pre>
 */
public class CommodityCategory {


    /**
     * CommodityCategory_ID : 2
     * ParentID : 1
     * Name : 测试二级类别
     * OneName : 颜色
     * TwoName : 长度
     * Authentication_ID : 2
     * IsHot : 0
     */

    private String CommodityCategory_ID;
    private String ParentID;
    private String Name;
    private String OneName;
    private String TwoName;
    private String Authentication_ID;
    private int IsHot;

    public String getCommodityCategory_ID() {
        return CommodityCategory_ID;
    }

    public void setCommodityCategory_ID(String CommodityCategory_ID) {
        this.CommodityCategory_ID = CommodityCategory_ID;
    }

    public String getParentID() {
        return ParentID;
    }

    public void setParentID(String ParentID) {
        this.ParentID = ParentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getOneName() {
        return OneName;
    }

    public void setOneName(String OneName) {
        this.OneName = OneName;
    }

    public String getTwoName() {
        return TwoName;
    }

    public void setTwoName(String TwoName) {
        this.TwoName = TwoName;
    }

    public String getAuthentication_ID() {
        return Authentication_ID;
    }

    public void setAuthentication_ID(String Authentication_ID) {
        this.Authentication_ID = Authentication_ID;
    }

    public int getIsHot() {
        return IsHot;
    }

    public void setIsHot(int IsHot) {
        this.IsHot = IsHot;
    }
}
