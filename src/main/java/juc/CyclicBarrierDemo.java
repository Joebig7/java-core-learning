package juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/6/14 22:55
 * @description 使用CyclicBarrier实现栅栏循环等待，满足条件后出发事件
 */
public class CyclicBarrierDemo {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
        System.out.println("文件准备完毕，进行备份");
    });

    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(() -> {
                System.out.println("准备文件");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }));
        }

        list.forEach((t) -> t.start());
    }


}