package com.bosssoft.hr.train.pojo.vo;

import java.io.Serializable;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-07-28
 */
public class UserLoginVo implements Serializable {
    private static final long serialVersionUID = -4844937415467796272L;
    private String username;
    private String password;

    public UserLoginVo() {
    }

    public UserLoginVo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
