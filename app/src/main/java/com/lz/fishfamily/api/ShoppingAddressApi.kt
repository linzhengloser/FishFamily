package com.lz.fishfamily.api

import com.lz.fishfamily.module.mine.ShoppingAddress
import com.lz.fishfamily.utils.UserManager
import io.reactivex.Observable
import retrofit2.http.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/11/08
 * desc   : 收获地址 API
 * version: 1.0
</pre> *
 */
interface ShoppingAddressApi {

    /**
     * 获取收获地址
     */
    @GET("Address/GetAddressList")
    fun getShoppingAddressList(@Query("UserInfo_ID") userId: String = UserManager.getUser().userInfo_ID): Observable<Response<List<ShoppingAddress>>>

    /**
     * 删除收货地址
     */
    @GET("Address/AddressDelete")
    fun deleteShoppingAddress(@Query("Address_ID") addressId: String): Observable<Response<String>>

    /**
     * 修改/删除 收货地址
     */
    @POST("Address/AddressOperation")
    @FormUrlEncoded
    fun updateOrInsertShoppingAddress(
           @FieldMap params:Map<String,String?>, @Field("UserInfo_ID")userId: String = UserManager.getUser().userInfo_ID
    ): Observable<Response<String>>

}
