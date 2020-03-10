package concurrency.geek.demo10_atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/10 9:52
 * @description Atomic基本类型使用Demo
 */
public class AtomicLongDemo {
    private static AtomicLong count = new AtomicLong(0);

    public static Long addCount() {
        return count.incrementAndGet();
    }


    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                addCount();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                addCount();
            }
        });

        thread.start();
        thread2.start();

        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count====" + count);

    }

}