package concurrency.geek.demo11_threadpool;

import java.util.concurrent.*;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/10 11:14
 * @description 线程池使用案例
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {


        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("test");
                return thread;
            }
        };

        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                Thread thread = new Thread(r);
                thread.start();
            }
        };

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(15));


        for (int i = 0; i < 100; i++) {

            poolExecutor.execute(() -> {
                int count = 0;
                System.out.println("执行线程" + ++count);
            });
        }


    }

}