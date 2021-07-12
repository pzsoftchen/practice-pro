package com.chen.java.practice.pattern.be.chain;

/**
 * description
 *
 * @author pengzhenchen 2021/06/28 3:04 下午
 */
public class UserInfo {

    private String username;
    private String password;


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
