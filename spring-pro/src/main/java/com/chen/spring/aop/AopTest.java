package com.chen.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AopTest
 *
 * @author Chenpz
 * @package com.chen.spring.aop
 * @date 2018/1/28/18:38
 */
public class AopTest {

    public static void main(String[] args) throws Exception{

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfiguration.class);
        IAopService aopService = (IAopService) applicationContext.getBean("aopServiceProxy");
        aopService.display("hello");
        SelfHotSwappableTargetSource targetSource = applicationContext.getBean(SelfHotSwappableTargetSource.class);
        // 动态替换目标服务
        targetSource.swap(applicationContext.getBean("aopService2"));
        aopService = (IAopService) applicationContext.getBean("aopServiceProxy");
        aopService.display("hello");
        targetSource.swap("com.chen.spring.aop.AopServiceImpl3");
        aopService = (IAopService) applicationContext.getBean("aopServiceProxy");
        aopService.display("hello");
    }
}
