package com.chen.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * AopConfiguration
 *
 * @author Chenpz
 * @package com.chen.spring.aop
 * @date 2018/1/28/18:31
 */
@Configuration
@ComponentScan("com.chen.spring.aop")
public class AopConfiguration implements ApplicationContextAware {

    @Autowired
    private MethodBeforeAdvice aopServiceBeforeAdvice;

    @Autowired
    private ServicePointcut servicePointcut;

    @Autowired
    private IAopService aopService;

    private ApplicationContext applicationContext;

    @Bean("targetSource")
    public SelfHotSwappableTargetSource targetSource(){
        SelfHotSwappableTargetSource hotSwappableTargetSource = new SelfHotSwappableTargetSource(aopService);
        return hotSwappableTargetSource;
    }

    @Bean("defaultPointcutAdvisor")
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setPointcut(servicePointcut);
        defaultPointcutAdvisor.setAdvice(aopServiceBeforeAdvice);
        return defaultPointcutAdvisor;
    }

    @Bean("aopServiceProxy")
    public IAopService aopServicePoxy() throws Exception {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        proxyFactoryBean.setTarget(aopService);
        proxyFactoryBean.setTargetSource(targetSource());
        proxyFactoryBean.setProxyInterfaces(IAopService.class.getInterfaces());
        proxyFactoryBean.setInterceptorNames("defaultPointcutAdvisor","aopServiceAfterAdvice");
        // https://stackoverflow.com/questions/17359975/spring-framework-no-beanfactory-available-anymore-probably-due-to-serializatio
        proxyFactoryBean.setBeanFactory(applicationContext);
        return (IAopService) proxyFactoryBean.getObject();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
