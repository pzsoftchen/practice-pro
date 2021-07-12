package com.chen.java.practice.pattern.struct.adapter;

import java.io.Serializable;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 6:07 下午
 */
public class UserDto implements Serializable {
    private String name;
    private String pwd;

    public UserDto(){}
    public UserDto(String name, String pwd){
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
