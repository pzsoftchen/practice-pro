package com.chen.java.practice.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 生产者消费者模型
 *
 * @author pengzhenchen 2021/07/12 11:24 上午
 */
public class ProducerAndConsumer {


    public static void main(String[] args) {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

}

class Producer implements Runnable{

    private final Resource resource;

    public Producer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                resource.add(i+"");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Resource {

    private final Queue<String> resource = new LinkedList<>();
    private final int cap = 3;

    public synchronized void add(String val) throws InterruptedException {
        if (resource.size() > cap){
            wait();
        }
        resource.add(val);
        notify();
    }

    public synchronized String get() throws InterruptedException {
        if (resource.size() == 0){
            wait();
        }
        String val = resource.poll();
        notify();
        return val;
    }

}


class Consumer implements Runnable{

    private final Resource resource;

    public Consumer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName()+": "+resource.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



