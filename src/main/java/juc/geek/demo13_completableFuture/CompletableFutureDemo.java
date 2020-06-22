package juc.geek.demo13_completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/12 17:27
 * @description 使用CompletableFutureDemo可以实现异步编程
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {

            System.out.println("T1: 洗水壶...");
            sleep(1, TimeUnit.SECONDS);

            System.out.println("T1: 烧开水...");
            sleep(15, TimeUnit.SECONDS);
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2: 洗茶壶...");
            sleep(1, TimeUnit.SECONDS);

            System.out.println("T2: 洗茶杯...");
            sleep(2, TimeUnit.SECONDS);

            System.out.println("T2: 拿茶叶...");
            sleep(1, TimeUnit.SECONDS);
            return " 龙井 ";
        });


        CompletableFuture<String> f3 = f1.thenCombine(f2, (none, tf) -> {
            System.out.println("T1: 拿到茶叶:" + tf);
            System.out.println("T1: 泡茶...");
            return " 上茶:" + tf;
        });

        System.out.println(f3.join());

    }


    static void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch (InterruptedException e) {
        }
    }
}