package com.chen.java.practice.interview.tx;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * <p>实现一个本地缓存，不能出现OOM</p>
 * 思路：
 *  1. 利用WeakHashMap，弱引用会被jvm回收的特性，保证不会出现oom; 缺点就是会出现缓存丢失的问题
 *  2. 利用LinkedHashMap的accessOrder特性，实现一个固定容量的LRU模型
 *
 * @author pengzhenchen 2021/06/19 7:59 下午
 */
public class LocalCache {

    public static void main(String[] args) throws Exception{
        System.out.println("test weak cache ");
        testLocalCache(new WeakLocalCache<>());
        System.out.println("test lru cache ");
        testLocalCache(new LRULocalCache<>());
    }

    private static void testLocalCache(Cache<String, String> cache) throws Exception{

        cache.put("a", "1");
        cache.put("b","2");
        cache.put("c", "3", 5000);
        cache.put("d", "4", 3000);

        System.out.println("开始。。。");
        System.out.println("a:"+cache.get("a"));
        System.out.println("b:"+cache.get("b"));
        System.out.println("c:"+cache.get("c"));
        System.out.println("d:"+cache.get("d"));

        Thread.sleep(3000);
        System.out.println("3秒后。。。");
        System.out.println("a:"+cache.get("a"));
        System.out.println("b:"+cache.get("b"));
        System.out.println("c:"+cache.get("c"));
        System.out.println("d:"+cache.get("d"));

        Thread.sleep(5000);
        System.out.println("8秒后。。。。");
        System.out.println("a:"+cache.get("a"));
        System.out.println("b:"+cache.get("b"));
        System.out.println("c:"+cache.get("c"));
        System.out.println("d:"+cache.get("d"));

        Thread.sleep(2000);
        System.out.println("10秒后。。。。");
        System.out.println("a:"+cache.get("a"));
        System.out.println("b:"+cache.get("b"));
        System.out.println("c:"+cache.get("c"));
        System.out.println("d:"+cache.get("d"));
    }
}

class WeakLocalCache<K,V> extends BaseLocalCache<K,V> {

    public WeakLocalCache() {
        // 利用 WeakHashMap的特性，让虚拟机实现自动的垃圾回收，避免OOM
        super(new WeakHashMap<>());
    }
}

@SuppressWarnings("all")
class LRULocalCache<K,V> extends BaseLocalCache<K,V>{

    public LRULocalCache(){
        // 利用LinkedHashMap的特性实现LRU算法，避免出现OOM的问题
        super(new LRUMap<>(3, 3));
    }
}

@SuppressWarnings("all")
class LRUMap<K,V> extends LinkedHashMap<K,V> {
    // 默认容量 100
    private static final int DEFAULT_MAX_CAPACITY = 100;
    private final int maxCapacity;

    public LRUMap(int initialCapacity){
        this(initialCapacity, DEFAULT_MAX_CAPACITY);
    }

    public LRUMap(int initialCapacity, int maxCapacity){
        super(initialCapacity, 0.75f, true);
        this.maxCapacity = maxCapacity;
    }

    /**
     * 重写LinkedHashMap中removeEldestEntry方法;
     * 新增元素的时候,会判断当前map大小是否超过DEFAULT_MAX_CAPACITY,超过则移除map中最老的节点;
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCapacity;
    }
}

class BaseLocalCache<K, V> implements Cache<K,V>{

    private final Map<K, CacheObject<K,V>> localCache;

    public BaseLocalCache(Map<K, CacheObject<K,V>> localCache){
        this.localCache = localCache;
    }

    @Override
    public void put(K key, V val, long expire) {
        localCache.put(key, new CacheObject<>(key, val, expire));
    }

    @Override
    public V get(K key) {
        if (isExpired(key)){
            // 过期了需要清除掉，惰性删除
            remove(key);
            return null;
        }
        return localCache.get(key).getVal();
    }

    @Override
    public void remove(K key) {
        localCache.remove(key);
    }

    @Override
    public void clean() {
        localCache.clear();
    }

    @Override
    public boolean isExpired(K key) {
        CacheObject<K,V> valObj = localCache.get(key);
        return valObj == null || valObj.getVal() == null;
    }
}

class CacheObject<K, V> implements Serializable {

    private K key;
    private V val;
    private long expire;

    public CacheObject(K key, V val, long expire){
        this.key = key;
        this.val = val;
        this.expire = System.currentTimeMillis() + expire;
    }

    public V getVal() {
        if (System.currentTimeMillis() > expire){
            return null;
        }
        return val;
    }

}

interface Cache<K,V>{
    /**
     * 放入数据
     * @param key
     * @param val
     * @param expire
     */
    void put(K key, V val, long expire);

    /**
     * 放入数据，默认有效期为：10秒
     * @param key
     * @param val
     */
    default void put(K key, V val){
        put(key, val, 10 * 1000);
    }

    /**
     * 获取缓存值
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 删除缓存
     * @param key
     */
    void remove(K key);

    /**
     * 清空缓存
     */
    void clean();

    /**
     * 判断key是否有效
     * @param key
     * @return
     */
    boolean isExpired(K key);
}

