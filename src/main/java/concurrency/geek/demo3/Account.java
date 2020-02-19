package concurrency.geek.demo3;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/19 14:24
 * @description 保护没有关联关系的多个资源
 */
public class Account {
    //用来保护密码的锁
    private final Object pwLock = new Object();

    private String password;

    //用来保护余额的锁
    private final Object balLock = new Object();

    private double balance;

    //取款
    public void withdraw(double money) {
        synchronized (balLock) {
            if (this.balance > money)
                balance -= money;
        }
    }

    //查看余额
    public double getBalance() {
        synchronized (balLock) {
            return balance;
        }
    }

    //取款
    public void updatePwd(String pwd) {
        synchronized (pwLock) {
            this.password = pwd;
        }
    }

    //查看密码
    public String getPwd() {
        synchronized (pwLock) {
            return password;
        }
    }
}