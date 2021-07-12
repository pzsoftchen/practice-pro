package com.chen.java.practice.pattern.be.chain;

/**
 * description
 *
 * @author pengzhenchen 2021/06/28 3:09 下午
 */
public class PwdProcessor implements Processor{

    private Processor processor;

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    @Override
    public void process(UserInfo userInfo) {
        userInfo.setPassword("!234556");
        if (processor!=null){
            processor.process(userInfo);
        }
    }
}
