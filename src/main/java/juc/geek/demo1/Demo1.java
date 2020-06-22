package juc.geek.demo1;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/15 15:47
 * @description 可见性、原子性、有序性
 */
public class Demo1 {

    private   static int count = 0;

    private void add10K(){
        int idx = 0;
        while(idx++<10000){
            count++;
        }
    }

    /**
     * 可见性问题导致count数值不正确
     * @return
     * @throws Exception
     */
    public static int calc() throws Exception{
        final Demo1 demo1 = new Demo1();

        Thread thread1 = new Thread(() -> {
            demo1.add10K();
        });

        Thread thread2 = new Thread(() -> {
            demo1.add10K();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        return count;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(calc());
    }
}