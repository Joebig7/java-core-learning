package juc.geek.demo5_wait_notify;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/22 15:02
 * @description 本例通过改造demo4的transfer2方法，通过等待/通知的机制来实现，
 * 通过这种方式解决在循环等待时间很长的情况下造成的cpu浪费现象
 */
public class NormalAccount {

    private int balance = 100;

    /**
     * 通过一次性申请资源破坏掉抢占且等待的条件
     *
     * @param target
     * @param money
     */
    public void transfer2(NormalAccount target, int money) {
        Allocator allocator = new Allocator();
        allocator.apply(this, target);
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

    }


    //资源管理员，用来统一申请和释放资源
    class Allocator {
        List<Object> resources = Lists.newArrayList();

        public synchronized void apply(Object from, Object to) {
            while (resources.contains(from) || resources.contains(to)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            resources.add(from);
            resources.add(to);
        }

        public synchronized void release(Object from, Object to) {
            resources.remove(from);
            resources.remove(to);
            notifyAll();
        }
    }
}