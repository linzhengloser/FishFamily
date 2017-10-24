package com.lz.library.utils;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ApiException extends Exception {

    private String errorMessage;

    public ApiException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ApiException setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
