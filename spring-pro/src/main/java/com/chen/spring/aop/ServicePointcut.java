package com.chen.spring.aop;

import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * ServicePointcut
 *
 * @author Chenpz
 * @package com.chen.spring.aop
 * @date 2018/1/28/18:29
 */
@Component
public class ServicePointcut extends NameMatchMethodPointcut {

    private static final long serialVersionUID = 3990456017285944475L;
    @Override
    public boolean matches(Method method, Class targetClass) {

        // 设置单个方法匹配
//        this.setMappedName("display");
        //也可以用“ * ” 来做匹配符号
        // this.setMappedName("get*");

        // 设置多个方法匹配
        String[] methods = { "display", "modify" };
        this.setMappedNames(methods);
        return super.matches(method, targetClass);
    }

}
