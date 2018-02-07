package com.chen.spring.aop;

import org.springframework.stereotype.Component;

/**
 * AopServiceImpl2
 *
 * @author Chenpz
 * @package com.chen.spring.aop
 * @date 2018/1/28/20:04
 */
@Component("aopService2")
public class AopServiceImpl2 implements IAopService {
    @Override
    public void display(String desc) {
        System.out.println("hello, "+desc);
    }
}
