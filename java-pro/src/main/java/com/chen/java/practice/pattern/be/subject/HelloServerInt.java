package com.chen.java.practice.pattern.be.subject;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 3:53 下午
 */
public class HelloServerInt implements ObServerInt {

    public HelloServerInt(Subject subject){
        subject.sub(this);
    }

    @Override
    public void update(int state) {
        System.out.println(state);
    }
}
