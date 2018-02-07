package com.chen.spring.aop;

import org.springframework.stereotype.Component;

/**
 * AopServiceImpl
 *
 * @author Chenpz
 * @package com.chen.spring.aop
 * @date 2018/1/28/18:25
 */
@Component("aopService")
public class AopServiceImpl implements IAopService {

    @Override
    public void display(String desc) {
        System.out.println(desc);
    }
}
