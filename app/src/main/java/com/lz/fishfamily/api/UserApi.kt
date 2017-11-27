package com.lz.fishfamily.api

import com.lz.fishfamily.Constant
import com.lz.fishfamily.module.User
import com.lz.fishfamily.module.mine.Fans
import com.lz.fishfamily.module.mine.Tag
import com.lz.fishfamily.module.mine.Task
import com.lz.fishfamily.utils.UserManager
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/09/12
 * desc   : 用户 Api
 * version: 1.0
</pre> *
 */
interface UserApi {

    /**
     * 获取用户信息
     */
    @GET("Home/GetUserInfo")
    fun getUserInfo(@Query("UserInfo_ID") userId: String): Observable<Response<User>>


    /**
     * 获取用户标签列表
     */
    @GET("UserInfo/GetUserSign")
    fun getUserTagList(@Query("UserInfo_ID") userId: String): Observable<Response<Tag>>


    /**
     * 保存用户信息
     */
    @POST("UserInfo/SaveUserInfo")
    @FormUrlEncoded
    fun saveUserInfo(
            @Field("UserInfo_ID") userId: String,
            @FieldMap userInfoMap: Map<String, String>
    ): Flowable<Response<String>>

    /**
     * 获取任务列表
     */
    @GET("UserInfo/GetUserTask")
    fun getTaskList(@Query("UserInfoId")userId:String = UserManager.getUser().userInfo_ID):Observable<Response<List<Task>>>

    /**
     * 获取用户已签到天数
     */
    @GET("UserInfo/GetUserSignDay")
    fun getAlreadySignDay(@Query("UserInfoId")userId: String = UserManager.getUser().userInfo_ID):Observable<Response<String>>

    /**
     * 签到
     */
    @GET("UserInfo/UserSign")
    fun signToday(@Query("UserInfoId")userId:String = UserManager.getUser().userInfo_ID):Observable<Response<String>>

    /**
     * 获取粉丝，黑名单，我关注的人列表
     */
    @GET("Fans/GetFans")
    fun getFansList(
            @Query(Constant.PAGE_SIZE_KEY)pageSize:Int = Constant.PAGE_SIZE,
            @Query(Constant.PAGE_INDEX_KEY)pageIndex:Int = 1,
            @Query(Constant.SCREEN_CONDITION_KEY) screenCondition:String = Constant.DEFAULT_SCREEN_CONDITION
    ):Observable<Response<List<Fans>>>


}
