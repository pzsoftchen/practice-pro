package com.chen.spring.factorybean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.beans.Introspector;

/**
 * DogBeanRegistry
 *
 * @author Chenpz
 * @package com.chen.spring.factorybean
 * @date 2018/1/29/14:56
 */
@Component
public class DogBeanRegistry implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(DogFactoryBean.class);
            beanDefinitionRegistry.registerBeanDefinition(
                    Introspector.decapitalize(ClassUtils.getShortName(com.chen.spring.factorybean.Dog.class)),
                    beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
