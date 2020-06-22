package juc.geek.demo7_semaphore;

import java.util.concurrent.Semaphore;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/5 14:21
 * @description Semaphore使用方式
 * 1. 可以实现线程的互斥
 */
public class SemaphoreDemo {


    private static Semaphore semaphore = new Semaphore(1);

    private static int count = 0;

    public static void add() throws InterruptedException {
        try {
            semaphore.acquire();
            count += 100;
            System.out.println(count);
        } finally {
            semaphore.release();
        }
    }


    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(50);
                    add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                try {
                    add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        });

        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        System.out.println("final count ===" + count);
    }


}