package concurrency.geek.demo9_countdownlatch_cyclebarrier;

import java.util.concurrent.CountDownLatch;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/8 14:22
 * @description CountDownLatch使用 Demo  如果有一个需求线程3在线程1和线程2准备好以后才能启动
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread1 = new Thread(() -> {
            System.out.println("执行任务1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("执行任务2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            countDownLatch.countDown();
        });


        thread1.start();
        thread2.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread3 = new Thread(() -> {
            System.out.println("开始执行任务。。");
        });


        thread3.start();
    }
}