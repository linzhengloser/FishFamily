package com.lz.fishfamily.utils.im.db;

/**
 * <pre>
 *     author : linzheng
 *     e-mail : 1007687534@qq.com
 *     time   : 2017/09/01
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class UserInfo {

    private String userId;

    private String userNickName;

    private String userAvatar;

    public String getUserId() {
        return userId;
    }

    public UserInfo setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public UserInfo setUserNickName(String userNickName) {
        this.userNickName = userNickName;
        return this;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public UserInfo setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (!userNickName.equals(userInfo.userNickName)) return false;
        return userAvatar.equals(userInfo.userAvatar);

    }

    @Override
    public int hashCode() {
        int result = userNickName.hashCode();
        result = 31 * result + userAvatar.hashCode();
        return result;
    }
}
