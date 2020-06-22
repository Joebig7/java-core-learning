package juc.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/6/8 15:45
 * @description 通过线程池来执行特定的任务
 */
public class ThreadPoolDemo {

    public static final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.AbortPolicy());

    public static AtomicInteger j = new AtomicInteger(0);

    public static void main(String[] args) {

        List<Runnable> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(() -> {
                try {
                    Thread.sleep(8000);
                    System.out.println("task" + j.incrementAndGet() + " is finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0; i < 20; i++) {
            poolExecutor.submit(list.get(i));
        }


    }

}