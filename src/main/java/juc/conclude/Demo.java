package juc.conclude;

import java.util.Random;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/24 9:52
 * @description
 */
public class Demo {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        for (int i = 0; i < 10000000; i++) {
            try {
                threadLocal.set(new Random().nextInt(100));
                new Demo().finalize();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        System.out.println(threadLocal.get());

    }


}