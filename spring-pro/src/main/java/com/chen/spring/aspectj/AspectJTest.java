package com.chen.spring.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * AspectJTest
 *
 * @author Chenpz
 * @package com.chen.spring.aspectj
 * @date 2018/2/7/17:24
 */
public class AspectJTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AspectJConfiguration.class);
        AspectjBeanService aspectjBeanService =  applicationContext.getBean(AspectjBeanService.class);
        aspectjBeanService.test("aspectj");

    }

}
