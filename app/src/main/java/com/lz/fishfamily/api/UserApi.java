package com.lz.fishfamily.api;

import com.lz.fishfamily.module.User;
import com.lz.fishfamily.module.mine.Tag;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/12
 *     desc   : 用户 Api
 *     version: 1.0
 * </pre>
 */
public interface UserApi {

    /**
     * 获取用户信息
     */
    @GET("Home/GetUserInfo")
    Flowable<Response<User>> getUserInfo(@Query("UserInfo_ID") String userId);


    /**
     * 获取用户标签列表
     */
    @GET("UserInfo/GetUserSign")
    Flowable<Response<Tag>> getUserTagList(@Query("UserInfo_ID") String userId);


    //    @Field("UserInfo_ID") String userId,
//@Field("") String imgData,
//    String nickName,
//    String sex,
//    String provice,
//    String city,
//    String region,
//    String desc
    @POST("UserInfo/SaveUserInfo")
    @FormUrlEncoded
    Flowable<Response<String>> saveUserInfo(
            @Field("UserInfo_ID") String userId,
            @FieldMap Map<String, String> userInfoMap
    );

}
