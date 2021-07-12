package com.chen.java.practice.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *     模仿ThreadPoolExecutor手写一个线程池
 * </p>
 *
 * @author pengzhenchen 2021/07/12 10:54 上午
 */
public class ChenThreadPool {


    public static void main(String[] args) {
        ChenExecutor executor = new ChenThreadPoolExecutor(3);
        executor.execute(() -> System.out.println(Thread.currentThread().getName()+" ----- test1"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName()+" ----- test2"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName()+" ----- test3"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName()+" ----- test4"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName()+" ----- test5"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName()+" ----- test6"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName()+" ----- test7"));
    }

}

class ChenThreadPoolExecutor implements ChenExecutor{

    private final AtomicInteger count = new AtomicInteger(-1);
    private final int poolSize;
    private final BlockingQueue<Runnable> queue;

    public ChenThreadPoolExecutor(int poolSize, BlockingQueue<Runnable> queue){
        this.poolSize = poolSize;
        this.queue = queue;
    }

    public ChenThreadPoolExecutor(int poolSize){
        this.poolSize = poolSize;
        this.queue = new LinkedBlockingQueue<>();
    }

    @Override
    public void execute(Runnable task) {
        if (poolSize > count.incrementAndGet()){
            addWorker(task);
        }else{
            queue.offer(task);
        }
    }

    private void addWorker(Runnable task){
        Worker worker = new Worker(task);
        worker.thread.start();
    }

    private void runWorker(Worker worker){
        Runnable task = worker.firstTask;
        worker.firstTask = null;
        while(task != null || (task = getTask()) != null){
            task.run();
            task = null;
        }
    }

    private Runnable getTask(){
        try {
            return queue.poll(3000, TimeUnit.MILLISECONDS);
        }catch (Exception e){
            return null;
        }
    }

    class Worker implements Runnable{

        public Thread thread;
        public Runnable firstTask;

        public Worker(Runnable task){
            this.firstTask = task;
            this.thread = new Thread(this);
        }

        @Override
        public void run() {
            runWorker(this);
        }
    }
}

interface ChenExecutor{

    /**
     * 线程池接口
     * @param task
     */
    void execute(Runnable task);
}
