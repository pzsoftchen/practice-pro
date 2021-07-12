package com.chen.java.practice.pattern.be.subject.jdk;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 4:02 下午
 */
public class JdkObserverTest {

    public static void main(String[] args) {

        HellObservable observable = new HellObservable();
        observable.addObserver(new HelloObserver());
        observable.setChanged();
        observable.notifyObservers("xxxxx");


    }

}
