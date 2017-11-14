package com.lz.fishfamily.api

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * <pre>
 * author : linzheng
 * e-mail : 1007687534@qq.com
 * time   : 2017/10/27
 * desc   : 公共API
 * version: 1.0
</pre> *
 */
interface CommonApi{

    /**
     * 上传图片
     */
    @POST("Home/UpImg")
    @FormUrlEncoded
    fun uploadImage(@Field("")imageBase64:String):Observable<Response<String>>

}
