package com.chen.java.practice.pattern.be.chain;

/**
 * description
 *
 * @author pengzhenchen 2021/06/28 3:04 下午
 */
public class UserNameProcessor implements Processor{

    private Processor processor;

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    @Override
    public void process(UserInfo userInfo) {
        userInfo.setUsername("张三");
        if (this.processor != null){
            processor.process(userInfo);
        }
    }
}
