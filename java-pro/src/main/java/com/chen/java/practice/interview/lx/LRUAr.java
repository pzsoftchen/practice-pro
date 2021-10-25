package com.chen.java.practice.interview.lx;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * description
 *
 * @author pengzhenchen 2021/07/26 3:26 下午
 */
public class LRUAr {



}


class LRU{
    private Map<String, String> map;
    private Queue<String> queue;
    private int cap;

    public LRU(int cap){
        map = new HashMap<>(cap);
        queue = new LinkedList<>();
        this.cap = cap;
    }

    public void put(String key, String val){
        if (queue.contains(key)){
            queue.remove(key);
            queue.add(key);
            map.put(key, val);
        }else if (queue.size() == cap){
            map.remove(queue.poll());
            queue.add(key);
            map.put(key, val);
        }else{
            queue.add(key);
            map.put(key, val);
        }
    }

    public String get(String key){
        if(queue.contains(key)){
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        }else{
            return null;
        }
    }
}