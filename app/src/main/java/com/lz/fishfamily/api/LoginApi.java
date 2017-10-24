package com.lz.fishfamily.api;

import com.lz.fishfamily.module.FishCategory;
import com.lz.fishfamily.module.Login;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/07
 *     desc   : 登录注册相关API
 *     version: 1.0
 * </pre>
 */
public interface LoginApi {

    /**
     * 注册
     */
    @POST("Home/SubmitRegister")
    @Headers("token:" + Api.DEFAULT_TOKTEN)
    @FormUrlEncoded
    Flowable<Response<Login>> register(
            @Field("UserInfo_Mobile") String tel,
            @Field("UserInfo_Pwd") String pwd,
            @Field("PhoneCode") String validateCode);

    /**
     * 登录
     */
    @POST("Home/SubmitLogin")
    @Headers("token:" + Api.DEFAULT_TOKTEN)
    @FormUrlEncoded
    Flowable<Response<Login>> login(
            @Field("UserInfo_Mobile") String tel,
            @Field("UserInfo_Pwd") String pwd);

    /**
     * 找回密码
     */
    @POST("Home/SubmitFindPwd")
    @Headers("token:" + Api.DEFAULT_TOKTEN)
    @FormUrlEncoded
    Flowable<Response<String>> findPwd(
            @Field("UserInfo_Mobile") String tel,
            @Field("UserInfo_Pwd") String pwd,
            @Field("PhoneCode") String validateCode);

    /**
     * 发送验证码
     */
    @GET("Home/SendPhoneCode")
    @Headers("token:" + Api.DEFAULT_TOKTEN)
    Flowable<Response<String>> sendValidateCode(
            @Query("UserInfo_Mobile") String tel);

    /**
     * 获取养鱼种类和经验
     *
     * @param type 0 经验 1 种类
     */
    @GET("Home/GetFishCategory")
    @Headers("token:" + Api.DEFAULT_TOKTEN)
    Observable<Response<List<FishCategory>>> getFishCategoryList(
            @Query("FishCategory_Type") int type);

    /**
     * 完善用户信息
     * @param userId
     * @param userNickName
     * @param fishCategory
     * @param userAvatar
     * @return
     */
    @POST("Home/PerfectUserInfo")
    @Headers("token:" + Api.DEFAULT_TOKTEN)
    @FormUrlEncoded
    Flowable<Response<Login>> perfectUserInfo(
            @Field("UserInfo_ID") String userId,
            @Field("UserInfo_NickName") String userNickName,
            @Field("ListFishCategory") String fishCategory,
            @Field("ImgData") String userAvatar);

}
