package com.lz.fishfamily.module.main.commodity;

import com.lz.fishfamily.module.User;
import com.lz.fishfamily.module.main.Comment;
import com.lz.fishfamily.module.main.Like;

import java.util.List;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/24
 *     desc   : 商品
 *     version: 1.0
 * </pre>
 */
public class Commodity {

    /**
     * CommodityAddList : [{"CommodityAdd_ID":"aa74638b-a0b9-4a57-b0f5-7993f10def91","Commodity_ID":"d1bc874d-e099-40b1-a57a-b543a240dbc1","type":2,"FilePath":"http://fweb.whmnx.com/http://ofdvg4c5w.bkt.clouddn.com/qm.jpg","Sort":0},{"CommodityAdd_ID":"dc520600-0992-4b6e-898b-343bef088903","Commodity_ID":"d1bc874d-e099-40b1-a57a-b543a240dbc1","type":2,"FilePath":"http://fweb.whmnx.com/http://ofdvg4c5w.bkt.clouddn.com/qm.jpg","Sort":0}]
     * standardName1 : null standardName2 : null CommodityPriceList : [] Like : [] isLike : false
     * Comment : [{"Comment_ID":"6580321f-9cce-43e3-a91e-a7b928633f48","CommentParent_ID":"0","UserInfo_ID":"5acea66c-8cbe-4a76-88a7-1efbedde4d85","UserName":"大佬111","PassiveUserName":"","HeadImage":"http://fweb.whmnx.com/Resource/PhotoFile/5a630735-d046-4986-b5c7-c396010107a6.jpg","Comment_Content":"我是评论123","Other_ID":"d1bc874d-e099-40b1-a57a-b543a240dbc1","Time":"2017-11-14T21:25:35.883"}]
     * CommentCount : 1 Commodity_ID : d1bc874d-e099-40b1-a57a-b543a240dbc1 Business_ID :
     * 85ef0a20-c0af-4785-9ca3-4c0d19cd9fb3 Price : 2333 DiscountPrice : 0 Name : ThinkadPad T470P
     * Stock : 23 Sales : 0 Freight : 2333 CommodityCategory_ID : 1 ShelvesTime :
     * 2017-11-14T20:10:45.92 IsShelves : 1 Pageview : 0 LikeCount : 0 Conten : ThinkPad
     * 高端笔记本电脑,ThinkPad 高端笔记本电脑,ThinkPad 高端笔记本电脑,ThinkPad 高端笔记本电脑。 IsDiscount : 0 Sort : 9999999
     * Address : 0
     */
    private User userInfo;
    private Object standardName1;
    private Object standardName2;
    private boolean isLike;
    private String Commodity_ID;
    private String Business_ID;
    private int Price;
    private int DiscountPrice;
    private String Name;
    private int Stock;
    private int Sales;
    private int Freight;
    private String CommodityCategory_ID;
    private String ShelvesTime;
    private int IsShelves;
    private int Pageview;
    private int LikeCount;
    private int CommentCount;
    private String Conten;
    private int IsDiscount;
    private int Sort;
    private String Address;
    private List<CommodityAddListBean> CommodityAddList;
    private List<?> CommodityPriceList;
    private List<Like> Like;
    private List<com.lz.fishfamily.module.main.Comment> Comment;


    public User getUserInfo() {
        return userInfo;
    }

    public Commodity setUserInfo(User userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    public boolean isLike() {
        return isLike;
    }

    public Commodity setLike(boolean like) {
        isLike = like;
        return this;
    }



    public Object getStandardName1() {
        return standardName1;
    }

    public void setStandardName1(Object standardName1) {
        this.standardName1 = standardName1;
    }

    public Object getStandardName2() {
        return standardName2;
    }

    public void setStandardName2(Object standardName2) {
        this.standardName2 = standardName2;
    }

    public boolean isIsLike() {
        return isLike;
    }

    public void setIsLike(boolean isLike) {
        this.isLike = isLike;
    }

    public int getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(int CommentCount) {
        this.CommentCount = CommentCount;
    }

    public String getCommodity_ID() {
        return Commodity_ID;
    }

    public void setCommodity_ID(String Commodity_ID) {
        this.Commodity_ID = Commodity_ID;
    }

    public String getBusiness_ID() {
        return Business_ID;
    }

    public void setBusiness_ID(String Business_ID) {
        this.Business_ID = Business_ID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getDiscountPrice() {
        return DiscountPrice;
    }

    public void setDiscountPrice(int DiscountPrice) {
        this.DiscountPrice = DiscountPrice;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getSales() {
        return Sales;
    }

    public void setSales(int Sales) {
        this.Sales = Sales;
    }

    public int getFreight() {
        return Freight;
    }

    public void setFreight(int Freight) {
        this.Freight = Freight;
    }

    public String getCommodityCategory_ID() {
        return CommodityCategory_ID;
    }

    public void setCommodityCategory_ID(String CommodityCategory_ID) {
        this.CommodityCategory_ID = CommodityCategory_ID;
    }

    public String getShelvesTime() {
        return ShelvesTime;
    }

    public void setShelvesTime(String ShelvesTime) {
        this.ShelvesTime = ShelvesTime;
    }

    public int getIsShelves() {
        return IsShelves;
    }

    public void setIsShelves(int IsShelves) {
        this.IsShelves = IsShelves;
    }

    public int getPageview() {
        return Pageview;
    }

    public void setPageview(int Pageview) {
        this.Pageview = Pageview;
    }

    public int getLikeCount() {
        return LikeCount;
    }

    public void setLikeCount(int LikeCount) {
        this.LikeCount = LikeCount;
    }

    public String getConten() {
        return Conten;
    }

    public void setConten(String Conten) {
        this.Conten = Conten;
    }

    public int getIsDiscount() {
        return IsDiscount;
    }

    public void setIsDiscount(int IsDiscount) {
        this.IsDiscount = IsDiscount;
    }

    public int getSort() {
        return Sort;
    }

    public void setSort(int Sort) {
        this.Sort = Sort;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public List<CommodityAddListBean> getCommodityAddList() {
        return CommodityAddList;
    }

    public void setCommodityAddList(List<CommodityAddListBean> CommodityAddList) {
        this.CommodityAddList = CommodityAddList;
    }

    public List<?> getCommodityPriceList() {
        return CommodityPriceList;
    }

    public void setCommodityPriceList(List<?> CommodityPriceList) {
        this.CommodityPriceList = CommodityPriceList;
    }

    public List<Like> getLike() {
        return Like;
    }

    public void setLike(List<Like> Like) {
        this.Like = Like;
    }

    public List<Comment> getComment() {
        return Comment;
    }

    public void setComment(List<Comment> Comment) {
        this.Comment = Comment;
    }

    public static class CommodityAddListBean {
        /**
         * CommodityAdd_ID : aa74638b-a0b9-4a57-b0f5-7993f10def91
         * Commodity_ID : d1bc874d-e099-40b1-a57a-b543a240dbc1
         * type : 2
         * FilePath : http://fweb.whmnx.com/http://ofdvg4c5w.bkt.clouddn.com/qm.jpg
         * Sort : 0
         */

        private String CommodityAdd_ID;
        private String Commodity_ID;
        private int type;
        private String FilePath;
        private int Sort;

        public String getCommodityAdd_ID() {
            return CommodityAdd_ID;
        }

        public void setCommodityAdd_ID(String CommodityAdd_ID) {
            this.CommodityAdd_ID = CommodityAdd_ID;
        }

        public String getCommodity_ID() {
            return Commodity_ID;
        }

        public void setCommodity_ID(String Commodity_ID) {
            this.Commodity_ID = Commodity_ID;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getFilePath() {
            return FilePath;
        }

        public void setFilePath(String FilePath) {
            this.FilePath = FilePath;
        }

        public int getSort() {
            return Sort;
        }

        public void setSort(int Sort) {
            this.Sort = Sort;
        }
    }

}
