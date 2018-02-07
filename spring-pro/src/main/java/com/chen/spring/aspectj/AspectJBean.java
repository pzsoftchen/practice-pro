package com.chen.spring.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * AspectJBean
 *
 * @author Chenpz
 * @package com.chen.spring.aspectj
 * @date 2018/2/7/14:55
 */
@Aspect
@Component
public class AspectJBean {

    @Before("execution(* *.test(..))")
    public void beforeOpt(){
        System.out.println("before opt...");
    }
}
