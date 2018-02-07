package com.chen.spring.aop;

import org.springframework.aop.target.HotSwappableTargetSource;

/**
 * SelfHotSwappableTargetSource
 *
 * @author Chenpz
 * @package com.chen.spring.aop
 * @date 2018/1/28/20:35
 */
public class SelfHotSwappableTargetSource extends HotSwappableTargetSource implements ISelfTargetSource{

    public SelfHotSwappableTargetSource(Object initialTarget) {
        super(initialTarget);
    }

    @Override
    public Object swap(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object instance = Class.forName(clazzName).newInstance();
        return swap(instance);
    }
}
