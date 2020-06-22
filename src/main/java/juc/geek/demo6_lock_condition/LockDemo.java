package juc.geek.demo6_lock_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/2 11:41
 * @description 通过ReentrantLock来实现互斥
 */
public class LockDemo {

    public static final Lock rtl = new ReentrantLock();

    public static final Condition condition = rtl.newCondition();

    private static int count = 0;


    public static void incr() {
        try {
            rtl.lock();
            count += 1;

        } finally {
            rtl.unlock();
        }
    }

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                incr();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                incr();
            }
        });


        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);


    }


}