package juc.geek.demo7_semaphore;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/5 14:40
 * @description 通过Semaphore还可以实现对资源池的限流
 */
public class SemaphorePool {

    private static List<Resource> pool = new Vector<>();

    private Semaphore semaphore;

    public SemaphorePool(int size) {
        for (int i = 0; i < size; i++) {
            Resource resource = new Resource(i + 1);
            pool.add(resource);
        }

        semaphore = new Semaphore(size);
    }


    public Resource get() {
        Resource resource = null;
        try {
            semaphore.acquire();
            resource = pool.remove(0);
            resource.get();
            return resource;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.add(resource);
            semaphore.release();
        }
        return null;
    }


    //资源
    class Resource {

        private int version;

        public Resource(int version) {
            this.version = version;
        }

        public synchronized Object get() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("成功获取资源" + version);
            return new Object();
        }
    }

    public static void main(String[] args) {
        SemaphorePool semaphorePool = new SemaphorePool(10);

        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(() -> {
                semaphorePool.get();
            });

            thread.start();
        }
    }

}