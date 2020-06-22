package juc.geek.demo9_countdownlatch_cyclebarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/8 14:31
 * @description CycleBarrierDemo使用Demo， 当线程1和线程2都准备好以后执行某个事件
 */
public class CycleBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println("准备工作已经结束，执行具体任务");

        });

        Thread thread1 = new Thread(() -> {
            System.out.println("任务1准备");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });


        Thread thread2 = new Thread(() -> {
            System.out.println("任务2准备");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

    }
}