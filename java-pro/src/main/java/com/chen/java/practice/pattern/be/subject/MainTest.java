package com.chen.java.practice.pattern.be.subject;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 3:55 下午
 */
public class MainTest {

    public static void main(String[] args) {
        Subject subject = new Subject();
        ObServerInt obServerInt = new HelloServerInt(subject);
        subject.setState(1);

    }
}
