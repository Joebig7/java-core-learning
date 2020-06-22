package juc.geek.demo8_readwritelock;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/6 15:01
 * @description 读写锁的使用demo 实现基础的缓存数据加载功能
 */
public class ReadWriteLockDemo<K, V> {

    private Map<K, V> cache = Maps.newHashMap();

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private final Lock readLock = rwl.readLock();

    private final Lock writeLock = rwl.writeLock();


    //获取缓存中的数据
    public V get(K k) {
        V v = null;

        try {
            readLock.lock();
            v = cache.get(k);
        } finally {
            readLock.unlock();
        }


        if (v != null) {
            return v;
        }

        try {
            writeLock.lock();
            v = cache.get(k);
            if (v == null) {
                System.out.println("查询数据库数据并且更新缓存数据");
            }
            return v;
        } finally {
            writeLock.unlock();
        }
    }
}