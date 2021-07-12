package com.chen.java.practice.pattern.create.builder;

import java.io.Serializable;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 4:27 下午
 */
public class User implements Serializable {

    private String userName;
    private String password;

    public User(){}

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    static class UserBuilder{
        private String userName;
        private String password;

        public UserBuilder userName(String userName){
            this.userName = userName;
            return this;
        }
        public UserBuilder password(String password){
            this.password = password;
            return this;
        }
        public User build(){
            return new User(this.userName, this.password);
        }
    }
}
