package com.lz.fishfamily.module;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/10
 *     desc   : 登录成功后返回的结果
 *     version: 1.0
 * </pre>
 */
public class Login {


    /**
     * Token : 99B10B4434446DDF152545F7083D111498210744F62B358A92A7584CF2A2B2855E70CF43EE38654D
     * UserInfo_ID : 1f08e503-60f4-47c2-823b-1dbe91d6a8b3
     */

    private String Token;
    private String UserInfo_ID;

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getUserInfo_ID() {
        return UserInfo_ID;
    }

    public void setUserInfo_ID(String UserInfo_ID) {
        this.UserInfo_ID = UserInfo_ID;
    }
}
