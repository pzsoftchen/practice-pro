package com.chen.spring.aop;

/**
 * Created by Administrator on 2018/1/28.
 */
public interface ISelfTargetSource {

    Object swap(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException;
}
