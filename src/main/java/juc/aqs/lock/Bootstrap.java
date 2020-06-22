package juc.aqs.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/26 16:53
 * @description ReentrantLock demo
 */
public class Bootstrap {

    private static final Lock lock = new ReentrantLock();

    private int count = 0;

    public void count() {
        try {
            lock.lock();
            count++;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {


    }
}