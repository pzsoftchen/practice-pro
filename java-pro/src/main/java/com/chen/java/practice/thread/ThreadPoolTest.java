package com.chen.java.practice.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: practice-pro
 * @class：ThreadPoolTest
 * @description: ThreadPoolTest
 * @author: pzsoftchen
 * @create: 06/29/2020 16:51:06
 **/
public class ThreadPoolTest {

    public static void main(String[] args) throws Exception{

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        5,
                        10,
                        1L,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(10),
                        new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 0; i < 21; i++) {
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
