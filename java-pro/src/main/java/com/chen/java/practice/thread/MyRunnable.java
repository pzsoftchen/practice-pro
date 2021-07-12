package com.chen.java.practice.thread;

import java.util.Date;

/**
 * @program: practice-pro
 * @class：MyRunnable
 * @description: myrunnable
 * @author: pzsoftchen
 * @create: 06/29/2020 16:50:02
 **/
public class MyRunnable implements Runnable{


    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
