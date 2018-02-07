package com.chen.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * DogFactoryBean
 *
 * @author Chenpz
 * @package com.chen.spring.factorybean
 * @date 2018/1/28/18:10
 */
public class DogFactoryBean implements FactoryBean<Dog> {

    @Override
    public Dog getObject() throws Exception {
        return new Dog("DogFactoryBean.run");
    }

    @Override
    public Class<?> getObjectType() {
        return DogFactoryBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}