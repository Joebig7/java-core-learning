package juc.geek.demo4;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/22 15:02
 * @description demo3中Account2虽然解决了同步问题，但是不能实现A转账给B,B转账给C的并行执行。这在现实中是不可取的。
 * 这个案例创建一个可以实现并行转账的Account类
 */
public class NormalAccount {

    private int balance = 100;

    /**
     * 通过给要转账和收账的两个对象同时加锁，就能确保转账的原子性并且可以实现不同账户的并行转账
     *
     * @param target
     * @param money
     */
    public void transfer(NormalAccount target, int money) {

        synchronized (this) {
            synchronized (target) {
                this.balance = balance - money;
                target.balance = target.balance + money;
            }
        }
    }


    /**
     * 通过一次性申请资源破坏掉抢占且等待的条件
     *
     * @param target
     * @param money
     */
    public void transfer2(NormalAccount target, int money) {
        Allocator allocator = new Allocator();
        while (!allocator.apply(this, target)) ;
        try {
            synchronized (this) {
                synchronized (target) {
                    this.balance = balance - money;
                    target.balance = target.balance + money;
                }
            }
        } finally {
            allocator.release(this, target);
        }
    }


    public static void main(String[] args) throws Exception {
        NormalAccount A = new NormalAccount();
        NormalAccount B = new NormalAccount();

        Thread thread1 = new Thread(() -> {
            A.transfer2(B, 50);
        });
        Thread thread2 = new Thread(() -> {
            B.transfer2(A, 50);
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(A.balance);
        System.out.println(B.balance);
    }


    //资源管理员，用来统一申请和释放资源
    class Allocator {
        List<Object> resources = Lists.newArrayList();

        public synchronized boolean apply(Object from, Object to) {
            if (resources.contains(from) || resources.contains(to)) {
                return false;
            } else {
                resources.add(from);
                resources.add(to);
                return true;
            }
        }

        public synchronized boolean release(Object from, Object to) {
            resources.remove(from);
            resources.remove(to);
            return true;
        }
    }
}