package com.chen.spring.ioc;

import org.springframework.stereotype.Component;

/**
 * BeanProcessorServiceImpl
 *
 * @author Chenpz
 * @package com.chen.spring.ioc
 * @date 2018/1/28/20:44
 */
@Component("beanProcessorService")
public class BeanProcessorServiceImpl implements IBeanProcessorService {
    @Override
    public void postBean(String postDesc) {
        System.out.println("hello, "+ postDesc);
    }
}
