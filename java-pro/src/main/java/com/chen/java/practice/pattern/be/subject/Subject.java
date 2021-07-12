package com.chen.java.practice.pattern.be.subject;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 3:50 下午
 */
public class Subject {

    private List<ObServerInt> obServerIntList;
    private int state;

    public Subject(){
        this.obServerIntList = new ArrayList<>();
    }

    public void sub(ObServerInt obServerInt){
        obServerIntList.add(obServerInt);
    }

    public void setState(int state){
        this.state = state;
        notifyAllObservers();
    }

    public void notifyAllObservers(){
        for (ObServerInt obServerInt : obServerIntList){
            obServerInt.update(state);
        }
    }

}
