package com.lz.fishfamily.api

import com.lz.fishfamily.Constant
import com.lz.fishfamily.module.main.shop.Shop
import com.lz.fishfamily.module.main.shop.ShopCategory
import io.reactivex.Observable
import retrofit2.http.*

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/27
 *     desc   : 店铺 API
 *     version: 1.0
 * </pre>
 */
interface ShopApi {

    /**
     * 商家入驻
     */
    @POST("Business/ApplyBusiness")
    @FormUrlEncoded
    fun applyShop(
            @Field("UserInfo_ID")userId:String,
            @Field("UserInfo_NickName")nickName:String,
            @Field("UserInfo_Name")realName:String,
            @Field("UserInfo_IDCard")idCard:String,
            @Field("UserInfo_Phone")phoneNumber:String,
            @Field("Authentication_ID")shopCategoryId:String,
            @FieldMap qualification:Map<String,String?>
    ):Observable<Response<String>>


    /**
     * 获取店铺类型 淘淘 or 鱼友
     */
    @GET("Business/GetAuthentication")
    fun getShopCategory():Observable<Response<List<ShopCategory>>>


    /**
     * 获取店铺
     */
    @GET("Business/GetBusiness")
    fun getShop(
            @Query(Constant.SORT_FIELD_KEY) sortField: String = "Business_ID",//排序字段
            @Query(Constant.SORT_KEY) sort: String = Constant.DEFAULT_SORT,//排序方式 desc or asc
            @Query(Constant.SCREEN_CONDITION_KEY) screenCondition: String = Constant.DEFAULT_SCREEN_CONDITION,//筛选条件
            @Query(Constant.PAGE_INDEX_KEY) pageIndex: Int = 1,
            @Query(Constant.PAGE_SIZE_KEY) pageSize: Int = Constant.PAGE_SIZE
    ):Observable<Response<List<Shop>>>

}