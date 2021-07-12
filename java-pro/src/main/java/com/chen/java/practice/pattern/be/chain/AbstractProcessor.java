package com.chen.java.practice.pattern.be.chain;

/**
 * description
 *
 * @author pengzhenchen 2021/06/28 3:05 下午
 */
public abstract  class AbstractProcessor implements Processor{

    private Processor processor;

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

}
