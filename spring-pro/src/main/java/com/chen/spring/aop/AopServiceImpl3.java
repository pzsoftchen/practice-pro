package com.chen.spring.aop;

/**
 * AopServiceImpl3
 *
 * @author Chenpz
 * @package com.chen.spring.aop
 * @date 2018/1/28/20:38
 */
public class AopServiceImpl3 implements IAopService {
    @Override
    public void display(String desc) {
        System.out.println("reflect, "+desc);
    }
}
