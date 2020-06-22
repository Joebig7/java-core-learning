package juc.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/6/14 18:58
 * @description 通过LongAdder进行计数
 */
public class LongAdderDemo {

    static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) {

        List<Thread> list = new ArrayList<>(1000);

        for (int i = 0; i < 1000; i++) {

            list.add(new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    longAdder.add(1);
                }
            }));
        }

        Long start = System.currentTimeMillis();
        list.forEach((t) -> t.start());

        list.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Long end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}