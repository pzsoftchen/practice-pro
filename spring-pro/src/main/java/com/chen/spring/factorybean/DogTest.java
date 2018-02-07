package com.chen.spring.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * DogTest
 *
 * @author Chenpz
 * @package com.chen.spring.factorybean
 * @date 2018/1/28/18:12
 */
public class DogTest {

    public static void main(String[] args) throws Exception{
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DogConfiguration.class);
//        Dog dog = applicationContext.getBean(Dog.class);
        Dog dog = (Dog) applicationContext.getBean("dog");
        dog.run();


    }
}
