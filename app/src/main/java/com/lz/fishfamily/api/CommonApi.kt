package com.lz.fishfamily.api

import com.lz.fishfamily.utils.UserManager
import io.reactivex.Observable
import retrofit2.http.*

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/10/27
 * desc   : 公共API
 * version: 1.0
</pre> *
 */
interface CommonApi {

    /**
     * 上传图片
     */
    @POST("Home/UpImg")
    @FormUrlEncoded
    fun uploadImage(@Field("") imageBase64: String): Observable<Response<String>>


    /**
     * 点赞
     */
    @GET("UserInfo/UserLike")
    fun postLike(
            @Query("ForeignKey") targetId: String,
            @Query("UserId") userId: String = UserManager.getUser().userInfo_ID
    ): Observable<Response<String>>


    /**
     * 发表评论
     */
    @POST("UserInfo/UserComment")
    @FormUrlEncoded
    fun postComment(
            @Field("Other_ID") targetId: String,
            @Field("Comment_Content") comment: String,
            @Field("CommentParent_ID") parentCommentId: String = "0",
            @Field("PassiveUserInfo_ID") parentCommentUserId: String = "0",
            @Field("UserInfo_ID") userId: String = UserManager.getUser().userInfo_ID
    ): Observable<Response<String>>

}
