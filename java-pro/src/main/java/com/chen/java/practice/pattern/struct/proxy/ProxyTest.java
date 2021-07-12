package com.chen.java.practice.pattern.struct.proxy;

import java.lang.reflect.Proxy;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 5:53 下午
 */
public class ProxyTest {

    public static void main(String[] args) {

        UserService target = new UserServiceImpl();
        UserService userService = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(), new UserInvocationHandler(target));
        userService.add("dynamic hello");

        UserService serviceProxy = new ServiceStaticProxy(target);
        serviceProxy.add("static hello");

    }

}
