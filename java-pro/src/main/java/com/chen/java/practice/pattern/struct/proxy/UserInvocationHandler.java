package com.chen.java.practice.pattern.struct.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 5:51 下午
 */
public class UserInvocationHandler implements InvocationHandler {

    private Object target;

    public UserInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic proxy... invoke");
        return method.invoke(target, args);
    }
}
