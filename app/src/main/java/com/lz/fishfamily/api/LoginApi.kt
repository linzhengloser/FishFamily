package com.lz.fishfamily.api

import com.lz.fishfamily.module.FishFarmCategory
import com.lz.fishfamily.module.Login
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/07
 * desc   : 登录注册相关API
 * version: 1.0
</pre> *
 */
interface LoginApi {

    /**
     * 注册
     */
    @POST("Home/SubmitRegister")
    @Headers("token:" + Api.DEFAULT_TOKEN)
    @FormUrlEncoded
    fun register(
            @Field("UserInfo_Mobile") tel: String,
            @Field("UserInfo_Pwd") pwd: String,
            @Field("PhoneCode") validateCode: String): Flowable<Response<Login>>

    /**
     * 登录
     */
    @POST("Home/SubmitLogin")
    @Headers("token:" + Api.DEFAULT_TOKEN)
    @FormUrlEncoded
    fun login(
            @Field("UserInfo_Mobile") tel: String,
            @Field("UserInfo_Pwd") pwd: String): Flowable<Response<Login>>

    /**
     * 找回密码
     */
    @POST("Home/SubmitFindPwd")
    @Headers("token:" + Api.DEFAULT_TOKEN)
    @FormUrlEncoded
    fun findPwd(
            @Field("UserInfo_Mobile") tel: String,
            @Field("UserInfo_Pwd") pwd: String,
            @Field("PhoneCode") validateCode: String): Flowable<Response<String>>

    /**
     * 发送验证码
     */
    @GET("Home/SendPhoneCode")
    @Headers("token:" + Api.DEFAULT_TOKEN)
    fun sendValidateCode(
            @Query("UserInfo_Mobile") tel: String): Flowable<Response<String>>

    /**
     * 获取养鱼种类和经验
     *
     * @param type 0 经验 1 种类
     */
    @GET("Home/GetFishCategory")
    @Headers("token:" + Api.DEFAULT_TOKEN)
    fun getFishCategoryList(
            @Query("FishCategory_Type") type: Int): Observable<Response<List<FishFarmCategory>>>

    /**
     * 完善用户信息
     * @param userId
     * @param userNickName
     * @param fishCategory
     * @param userAvatar
     * @return
     */
    @POST("Home/PerfectUserInfo")
    @Headers("token:" + Api.DEFAULT_TOKEN)
    @FormUrlEncoded
    fun perfectUserInfo(
            @Field("UserInfo_ID") userId: String,
            @Field("UserInfo_NickName") userNickName: String,
            @Field("ListFishCategory") fishCategory: String,
            @Field("ImgData") userAvatar: String): Flowable<Response<Login>>

}
