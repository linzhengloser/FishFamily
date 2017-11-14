package com.lz.fishfamily.module.main.shop;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/27
 *     desc   : 店铺类型
 *     version: 1.0
 * </pre>
 */
public class ShopCategory {


    /**
     * Authentication_ID : 1
     * TypeName : 淘淘
     * Price : 10
     */

    private String Authentication_ID;
    private String TypeName;
    private int Price;

    public String getAuthentication_ID() {
        return Authentication_ID;
    }

    public void setAuthentication_ID(String Authentication_ID) {
        this.Authentication_ID = Authentication_ID;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
}
