package com.lz.fishfamily.module.main.commodity;

import android.os.Parcel;
import android.os.Parcelable;

import com.lz.fishfamily.module.User;
import com.lz.fishfamily.module.main.Comment;
import com.lz.fishfamily.module.main.Like;

import java.util.ArrayList;
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
public class Commodity implements Parcelable {

    private User userInfo;
    private String standardName1;
    private String standardName2;
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
    private List<CommodityPriceListBean> CommodityPriceList;
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

    public void setIsLike(boolean isLike) {
        this.isLike = isLike;
    }

    public String getStandardName1() {
        return standardName1;
    }

    public void setStandardName1(String standardName1) {
        this.standardName1 = standardName1;
    }

    public String getStandardName2() {
        return standardName2;
    }

    public void setStandardName2(String standardName2) {
        this.standardName2 = standardName2;
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

    public void setCommodityPriceList(List<CommodityPriceListBean> CommodityPriceList) {
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

    public static class CommodityPriceListBean implements Parcelable {

        /**
         * CommodityPrice_ID : 1
         * Commodity_ID : 95c643fd-99c8-4647-8392-14d97240954f
         * Name : 红色
         * Price : 0
         * Stock : 0
         * Parent_ID : null
         */

        private String CommodityPrice_ID;
        private String Commodity_ID;
        private String Name;
        private int Price;
        private int Stock;
        private int Parent_ID;

        public String getCommodityPrice_ID() {
            return CommodityPrice_ID;
        }

        public void setCommodityPrice_ID(String CommodityPrice_ID) {
            this.CommodityPrice_ID = CommodityPrice_ID;
        }

        public String getCommodity_ID() {
            return Commodity_ID;
        }

        public void setCommodity_ID(String Commodity_ID) {
            this.Commodity_ID = Commodity_ID;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public int getStock() {
            return Stock;
        }

        public void setStock(int Stock) {
            this.Stock = Stock;
        }

        public Object getParent_ID() {
            return Parent_ID;
        }

        public void setParent_ID(int Parent_ID) {
            this.Parent_ID = Parent_ID;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.CommodityPrice_ID);
            dest.writeString(this.Commodity_ID);
            dest.writeString(this.Name);
            dest.writeInt(this.Price);
            dest.writeInt(this.Stock);
            dest.writeInt(this.Parent_ID);
        }

        public CommodityPriceListBean() {
        }

        protected CommodityPriceListBean(Parcel in) {
            this.CommodityPrice_ID = in.readString();
            this.Commodity_ID = in.readString();
            this.Name = in.readString();
            this.Price = in.readInt();
            this.Stock = in.readInt();
            this.Parent_ID = in.readInt();
        }

        public static final Creator<CommodityPriceListBean> CREATOR = new Creator<CommodityPriceListBean>() {
            @Override
            public CommodityPriceListBean createFromParcel(Parcel source) {
                return new CommodityPriceListBean(source);
            }

            @Override
            public CommodityPriceListBean[] newArray(int size) {
                return new CommodityPriceListBean[size];
            }
        };
    }

    public static class CommodityAddListBean implements Parcelable {
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


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.CommodityAdd_ID);
            dest.writeString(this.Commodity_ID);
            dest.writeInt(this.type);
            dest.writeString(this.FilePath);
            dest.writeInt(this.Sort);
        }

        public CommodityAddListBean() {
        }

        protected CommodityAddListBean(Parcel in) {
            this.CommodityAdd_ID = in.readString();
            this.Commodity_ID = in.readString();
            this.type = in.readInt();
            this.FilePath = in.readString();
            this.Sort = in.readInt();
        }

        public static final Creator<CommodityAddListBean> CREATOR = new Creator<CommodityAddListBean>() {
            @Override
            public CommodityAddListBean createFromParcel(Parcel source) {
                return new CommodityAddListBean(source);
            }

            @Override
            public CommodityAddListBean[] newArray(int size) {
                return new CommodityAddListBean[size];
            }
        };
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.userInfo, flags);
        dest.writeString(this.standardName1);
        dest.writeString(this.standardName2);
        dest.writeByte(this.isLike ? (byte) 1 : (byte) 0);
        dest.writeString(this.Commodity_ID);
        dest.writeString(this.Business_ID);
        dest.writeInt(this.Price);
        dest.writeInt(this.DiscountPrice);
        dest.writeString(this.Name);
        dest.writeInt(this.Stock);
        dest.writeInt(this.Sales);
        dest.writeInt(this.Freight);
        dest.writeString(this.CommodityCategory_ID);
        dest.writeString(this.ShelvesTime);
        dest.writeInt(this.IsShelves);
        dest.writeInt(this.Pageview);
        dest.writeInt(this.LikeCount);
        dest.writeInt(this.CommentCount);
        dest.writeString(this.Conten);
        dest.writeInt(this.IsDiscount);
        dest.writeInt(this.Sort);
        dest.writeString(this.Address);
        dest.writeList(this.CommodityAddList);
        dest.writeList(this.CommodityPriceList);
        dest.writeList(this.Like);
        dest.writeList(this.Comment);
    }

    public Commodity() {
    }

    protected Commodity(Parcel in) {
        this.userInfo = in.readParcelable(User.class.getClassLoader());
        this.standardName1 = in.readString();
        this.standardName2 = in.readString();
        this.isLike = in.readByte() != 0;
        this.Commodity_ID = in.readString();
        this.Business_ID = in.readString();
        this.Price = in.readInt();
        this.DiscountPrice = in.readInt();
        this.Name = in.readString();
        this.Stock = in.readInt();
        this.Sales = in.readInt();
        this.Freight = in.readInt();
        this.CommodityCategory_ID = in.readString();
        this.ShelvesTime = in.readString();
        this.IsShelves = in.readInt();
        this.Pageview = in.readInt();
        this.LikeCount = in.readInt();
        this.CommentCount = in.readInt();
        this.Conten = in.readString();
        this.IsDiscount = in.readInt();
        this.Sort = in.readInt();
        this.Address = in.readString();
        this.CommodityAddList = new ArrayList<>();
        in.readList(this.CommodityAddList, CommodityAddListBean.class.getClassLoader());
        this.CommodityPriceList = new ArrayList<>();
        in.readList(this.CommodityPriceList, CommodityPriceListBean.class.getClassLoader());
        this.Like = new ArrayList<>();
        in.readList(this.Like, com.lz.fishfamily.module.main.Like.class.getClassLoader());
        this.Comment = new ArrayList<>();
        in.readList(this.Comment, com.lz.fishfamily.module.main.Comment.class.getClassLoader());
    }

    public static final Creator<Commodity> CREATOR = new Creator<Commodity>() {
        @Override
        public Commodity createFromParcel(Parcel source) {
            return new Commodity(source);
        }

        @Override
        public Commodity[] newArray(int size) {
            return new Commodity[size];
        }
    };
}
