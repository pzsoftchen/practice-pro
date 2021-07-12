package com.chen.java.practice.pattern.create.single;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 4:22 下午
 */
public class Singleton {

    private static volatile Singleton INSTANCE = null;

    private Singleton (){
    }

    public static Singleton getInstance(){

        if (INSTANCE == null){
            synchronized (Singleton.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton();
                    return INSTANCE;
                }
            }
        }
        return INSTANCE;
    }

}
