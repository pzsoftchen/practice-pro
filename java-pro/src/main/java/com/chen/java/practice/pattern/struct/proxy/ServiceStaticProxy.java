package com.chen.java.practice.pattern.struct.proxy;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 6:00 下午
 */
public class ServiceStaticProxy implements UserService{
    private UserService userService;

    public ServiceStaticProxy(UserService userService){
        this.userService = userService;
    }

    @Override
    public void add(String user) {
        System.out.println("static proxy");
        userService.add(user);
    }
}
