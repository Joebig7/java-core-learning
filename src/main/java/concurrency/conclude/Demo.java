package concurrency.conclude;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/24 9:52
 * @description
 */
public class Demo {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("xxxx");
    }

}