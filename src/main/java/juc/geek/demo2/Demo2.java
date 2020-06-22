package juc.geek.demo2;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/18 11:11
 * @description  Happen-Before规则  join()规则
 */
public class Demo2 {

    public static  int a = 10;

    public static void main(String[] args) throws Exception{

        //B子线程修改a的值
        Thread B = new Thread(()->{
                a= 100;
        });

        //此处修改a的值
        a=50;

        B.start();
        B.join();
        System.out.println(a);
    }
}