package concurrency.collection.concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/4/8 14:18
 * @description ConcurrentHashMap使用案例
 */
public class Bootstrap {


    private static ConcurrentHashMap<Integer, Student> map = new ConcurrentHashMap<>(12);
//    private static HashMap<Integer, Student> map = new HashMap<>();


    public static void main(String[] args) {

        Student stu1 = new Student("stu1", 25);
        Student stu2 = new Student("stu2", 22);
        Student stu3 = new Student("stu3", 26);

        map.put(1, stu1);
        map.put(2, stu2);
        map.put(3, stu3);


        Thread thread1 = new Thread(() -> {
            for (Map.Entry<Integer, Student> entry : map.entrySet()) {
                System.out.println("id:" + entry.getKey() + "----" + "age:" + entry.getValue().getName());
            }
        });


        Thread thread2 = new Thread(() -> {
            int age = 21;
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put(i + 4, new Student("stu" + (i + 4), age));
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finish");

        for (Map.Entry<Integer, Student> entry : map.entrySet()) {
            System.out.println("id:" + entry.getKey() + "----" + "name:" + entry.getValue().getName());
        }

    }

}