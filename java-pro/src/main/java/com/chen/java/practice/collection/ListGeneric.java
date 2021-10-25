package com.chen.java.practice.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author pengzhenchen 2021/07/14 10:34 上午
 */
public class ListGeneric {

    public static void main(String[] args) {
        List<? extends A> alist = new ArrayList<>();
        List<A> xList = new ArrayList<>();
        List<B> bList = new ArrayList<>();
        xList.add(new A());
        bList.add(new B());
        xList.addAll(alist);
        xList.addAll(bList);
    }
}

class A{

}

class B extends A{

}

class C extends A{

}
