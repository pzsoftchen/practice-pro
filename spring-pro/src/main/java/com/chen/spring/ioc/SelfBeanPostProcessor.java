package com.chen.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * SelfBeanPostProcessor
 *
 * @author Chenpz
 * @package com.chen.spring.ioc
 * @date 2018/1/28/20:45
 */
@Component
public class SelfBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (o instanceof IBeanProcessorService){
            System.out.println("s: "+s);
            System.out.println("xxxxxxxxxxxxxxxxxx");
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (o instanceof IBeanProcessorService){
            System.out.println("s: "+s);
            System.out.println("yyyyyyyyyyyyyyyyyyy");
        }
        return o;
    }
}
