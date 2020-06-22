package juc.aqs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/6/14 22:31
 * @description 使用CountDownLatch实现线程等待，然后同时执行接下来的任务
 */
public class CountDownLatchDemo {

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) {

        List<Thread> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            int count = i + 1;
            list.add(new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务执行成功" + count);

                countDownLatch.countDown();
            }));
        }


        list.forEach((t) -> t.start());

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("准备完毕，继续进行");

    }
}