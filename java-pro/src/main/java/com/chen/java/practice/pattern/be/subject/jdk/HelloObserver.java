package com.chen.java.practice.pattern.be.subject.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 4:00 下午
 */
public class HelloObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}
