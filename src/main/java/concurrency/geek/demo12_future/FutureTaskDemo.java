package concurrency.geek.demo12_future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/11 11:29
 * @description 通过FutureTask实现烧水泡茶的案例
 */
public class FutureTaskDemo {


    public static void main(String[] args) {

        FutureTask<String> futureTask2 = new FutureTask<String>(new Task2());
        Task1 task1 = new Task1(futureTask2);
        FutureTask<Boolean> futureTask1 = new FutureTask<Boolean>(task1);


        Thread thread = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);

        thread.start();
        thread2.start();

    }


    static class Task1 implements Callable<Boolean> {

        private FutureTask<String> futureTask;

        public Task1(FutureTask<String> futureTask) {
            this.futureTask = futureTask;
        }

        @Override
        public Boolean call() throws Exception {

            System.out.println("洗水壶");
            Thread.sleep(2000);
            System.out.println("烧开水");
            Thread.sleep(15000);
            String s = futureTask.get();
            System.out.println("获取到" + s + "  开始泡茶");

            return true;
        }


    }

    static class Task2 implements Callable<String> {
        @Override
        public String call() throws Exception {
            try {
                System.out.println("洗茶壶");
                Thread.sleep(1000);
                System.out.println("洗茶杯");
                Thread.sleep(1000);
                System.out.println("拿茶叶");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "茶叶";
        }
    }


}