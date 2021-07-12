package com.chen.java.practice.pattern.be.subject.jdk;

import java.util.Observable;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 4:20 下午
 */
public class HellObservable extends Observable {


    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}
