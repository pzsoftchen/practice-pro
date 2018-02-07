package com.chen.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanProcessorTest
 *
 * @author Chenpz
 * @package com.chen.spring.ioc
 * @date 2018/1/28/20:48
 */
public class BeanProcessorTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        IBeanProcessorService beanProcessorService = (IBeanProcessorService) applicationContext.getBean("beanProcessorService");
        String[] strArr = applicationContext.getBeanDefinitionNames();

        for (String str: strArr){
            System.out.println("beanDefinition: "+str);
        }
        beanProcessorService.postBean("zzzzzzzzzz");
    }
}
