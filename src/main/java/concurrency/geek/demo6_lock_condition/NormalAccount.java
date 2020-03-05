package concurrency.geek.demo6_lock_condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/2 14:31
 * @description
 */
public class NormalAccount {

    public static final Lock ltr = new ReentrantLock();

    private static final Condition done = ltr.newCondition();

    private int balance = 100;

    /**
     * 通过一次性申请资源破坏掉抢占且等待的条件
     *
     * @param target
     * @param money
     */
    public void transfer2(NormalAccount target, int money) {
        try {
            this.ltr.tryLock();
            try {
                target.ltr.tryLock();
                while (balance < money) {
                    try {
                        done.await(1L, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.balance = balance - money;
                target.balance = target.balance + money;
                System.out.println("转账成功+余额===" + balance);
            } finally {
                target.ltr.unlock();
            }
        } finally {
            this.ltr.unlock();
        }
    }

    public void recharge(int money) {
        try {
            this.ltr.tryLock();
            balance += money;
            System.out.println("余额====" + balance);
            done.signal();
        } finally {
            this.ltr.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        NormalAccount A = new NormalAccount();
        NormalAccount B = new NormalAccount();
        Thread t1 = new Thread(() -> {
            A.transfer2(B, 200);
        });

        //充值
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            A.recharge(200);
        });
        t1.start();
        t2.start();

    }
}