package com.chen.java.practice.pattern.struct.proxy;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 5:50 下午
 */
public class UserServiceImpl implements UserService{

    @Override
    public void add(String user) {
        System.out.println("add user: " + user);
    }
}
