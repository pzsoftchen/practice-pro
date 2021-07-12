package com.chen.java.practice.pattern.be.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/06/28 3:12 下午
 */
public class ProcessorChain implements Processor{

    private final List<Processor> processorList;

    public ProcessorChain(){
        this.processorList = new ArrayList<>();
    }

    public ProcessorChain next(Processor processor){
        processorList.add(processor);
        return this;
    }

    @Override
    public void process(UserInfo userInfo) {
        processorList.forEach(processor -> processor.process(userInfo));
        System.out.println(userInfo.toString());
    }
}
