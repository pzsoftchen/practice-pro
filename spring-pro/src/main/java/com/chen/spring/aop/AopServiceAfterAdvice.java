package com.chen.spring.aop;


import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * AopServiceAfterAdvice
 *
 * @author Chenpz
 * @package com.chen.spring.aop
 * @date 2018/1/28/19:39
 */
@Component
public class AopServiceAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("afterReturning...");
    }
}
