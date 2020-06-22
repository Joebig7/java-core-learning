package juc.collection.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/4/8 14:18
 * @description ConcurrentHashMap使用案例
 */
public class Bootstrap {
    private static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
//    private static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 400; i++) {
                map.put(String.valueOf(i), String.valueOf(i));
            }


        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                map.put(String.valueOf(i), String.valueOf(i));
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 400; i++) {
                map.remove(String.valueOf(i));
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();


    }

}