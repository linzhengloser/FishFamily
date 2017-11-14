package com.lz.fishfamily.api

import com.lz.fishfamily.Constant
import com.lz.fishfamily.module.main.commodity.Commodity
import com.lz.fishfamily.module.main.commodity.CommodityCategory
import io.reactivex.Observable
import retrofit2.http.*

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/10/26
 *     desc   : 商品 API
 *     version: 1.0
 * </pre>
 */
interface CommodityApi {

    /**
     * 发布商品
     */
    @POST("Commodity/ApplyCommodity")
    @FormUrlEncoded
    fun publishCommodity(
            @Field("Business_ID") shopId: String,
            @Field("Price") commodityPrice: String,
            @Field("Name") commodityName: String,
            @Field("Freight") commodityFreight: String,
            @Field("CommodityCategory_ID") commodityCategoryId: String,
            @Field("Stock") commodityStock: String,
            @Field("MainImgPath") commodityMainImgPath: String,
            @Field("Conten") commodityContent: String,
            @Field("img") commodityImg: String
    ): Observable<Response<String>>


    /**
     *  获取商品类型(万能接口)
     */
    @GET("Commodity/GetCommodityCategory")
    fun getCommodityCategory(
            @Query(Constant.SORT_FIELD_KEY) sortField: String = "CommodityCategory_ID",//排序字段
            @Query(Constant.SORT_KEY) sort: String = Constant.DEFAULT_SORT,//排序方式 desc or asc
            @Query(Constant.SCREEN_CONDITION_KEY) screenCondition: String = Constant.DEFAULT_SCREEN_CONDITION,//筛选条件
            @Query(Constant.PAGE_INDEX_KEY) pageIndex: Int = 1,
            @Query(Constant.PAGE_SIZE_KEY) pageSize: Int = Constant.PAGE_SIZE
    ): Observable<Response<List<CommodityCategory>>>


    /**
     * 获取商品(万能接口)
     */
    @GET("Commodity/GetCommodity")
    fun getCommodity(
            @Query(Constant.SORT_FIELD_KEY) sortField: String = "Commodity_ID",//排序字段
            @Query(Constant.SORT_KEY) sort: String = Constant.DEFAULT_SORT,//排序方式 desc or asc
            @Query(Constant.SCREEN_CONDITION_KEY) screenCondition: String = Constant.DEFAULT_SCREEN_CONDITION,//筛选条件
            @Query(Constant.PAGE_INDEX_KEY) pageIndex: Int = 1,
            @Query(Constant.PAGE_SIZE_KEY) pageSize: Int = Constant.PAGE_SIZE
    ):Observable<Response<List<Commodity>>>


}