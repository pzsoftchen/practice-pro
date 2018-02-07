package com.chen.spring.aspectj;

import org.springframework.stereotype.Component;

/**
 * AspectjServiceImpl
 *
 * @author Chenpz
 * @package com.chen.spring.aspectj
 * @date 2018/2/7/14:54
 */
@Component("aspectjBeanService")
public class AspectjServiceImpl implements AspectjBeanService {
    @Override
    public void test(String str) {
        System.out.println("hello, " + str);
    }
}
