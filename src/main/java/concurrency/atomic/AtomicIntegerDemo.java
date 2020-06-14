package concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/6/14 18:40
 * @description AtomicInteger实现Integer的原子性++
 */
public class AtomicIntegerDemo {

    private static AtomicInteger count = new AtomicInteger(0);

    int m() {
        return count.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println("count==" + new AtomicIntegerDemo().m());

            }).start();
        }

    }
}