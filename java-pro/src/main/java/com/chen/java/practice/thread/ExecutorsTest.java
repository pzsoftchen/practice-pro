package com.chen.java.practice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: practice-pro
 * @class：FixedThreadPoolTest
 * @description: FixedThreadPoolTest
 * @author: pzsoftchen
 * @create: 06/29/2020 16:57:41
 **/
public class ExecutorsTest {

    public static void main(String[] args) {

//        ExecutorService executor = Executors.newFixedThreadPool(10);
        ExecutorService executor = Executors.newCachedThreadPool();
//        ExecutorService executor = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 20; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            executor.execute(worker);

        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");

    }
}
