package com.chen.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * AopServiceBeforAdvice
 *
 * @author Chenpz
 * @package com.chen.spring.aop
 * @date 2018/1/28/18:26
 */
@Component
public class AopServiceBeforeAdvice implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        System.out.println("===========before service================");

    }
}
