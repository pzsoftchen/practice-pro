package com.chen.java.practice.pattern.be.chain;

/**
 * description
 *
 * @author pengzhenchen 2021/06/28 3:09 下午
 */
public class ChainTest {

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        UserNameProcessor userNameProcessor = new UserNameProcessor();
        PwdProcessor passwordProcessor = new PwdProcessor();
        userNameProcessor.setProcessor(passwordProcessor);
        passwordProcessor.setProcessor(null);
        userNameProcessor.process(userInfo);

//        ProcessorChain processorChain = new ProcessorChain();
//        processorChain
//                .next(userNameProcessor)
//                .next(passwordProcessor)
//                .process(userInfo);
        userNameProcessor.process(userInfo);
        System.out.println(userInfo);

    }
}
