package com.chen.spring.aspectj;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AspectJConfiguration
 *
 * @author Chenpz
 * @package com.chen.spring.aspectj
 * @date 2018/2/7/14:56
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.chen.spring.aspectj")
public class AspectJConfiguration {
}
