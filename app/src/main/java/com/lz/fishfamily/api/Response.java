package com.lz.fishfamily.api;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/08/18
 *     desc   : 公共响应 Bean
 *     version: 1.0
 * </pre>
 */
public class Response<T> {

    private int type;

    private int code;

    private String message;

    private T resultdata;

    public int getType() {
        return type;
    }

    public Response setType(int type) {
        this.type = type;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Response setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getResultdata() {
        return resultdata;
    }

    public Response setResultdata(T resultdata) {
        this.resultdata = resultdata;
        return this;
    }
}
