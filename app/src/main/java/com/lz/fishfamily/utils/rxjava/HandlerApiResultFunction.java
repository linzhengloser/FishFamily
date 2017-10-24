package com.lz.fishfamily.utils.rxjava;

import com.lz.fishfamily.api.Response;
import com.lz.library.utils.ApiException;

import io.reactivex.functions.Function;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/18
 *     desc   : 处理接口返回接口 使用 RxJava map 操作符
 *     version: 1.0
 * </pre>
 */
public class HandlerApiResultFunction<T extends Response<R>, R> implements Function<T, R> {

    @Override
    public R apply(T t) throws Exception {
        if (t.getType() == 0) {
            throw new ApiException(t.getMessage());
        } else if (t.getResultdata() == null) {
            return (R) "";
        }
        return t.getResultdata();
    }
}
