package com.chen.java.practice.pattern.struct.adapter;

import java.io.Serializable;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 6:07 下午
 */
public class UserBean implements Serializable {

    private String userName;
    private String password;

    public UserBean(){}
    public UserBean(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
