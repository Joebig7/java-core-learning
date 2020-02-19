package concurrency.geek.demo3;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/19 14:36
 * @description 保护有关联关系的多个资源
 */
public class Account2 {

    private double balance;

    //转账
    public void transfer(Account2 target, double money) {
        synchronized (Account2.class) {
            this.balance -= money;
            target.balance += money;
        }
    }
}