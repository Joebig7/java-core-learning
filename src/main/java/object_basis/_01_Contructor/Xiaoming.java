package object_basis._01_Contructor;

import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/9 11:40
 * @description 对于构造方法是可以重载的，但是对于构造方法不能进行重写
 */
public class Xiaoming extends Person {

    private Integer age;

//    @Override
//    public Person(){
//
//    }

    public Xiaoming() {

    }

    public Xiaoming(Integer age) {
        this.age = age;
    }

    public String report(String report) {
        System.out.println(report);

        return report;
    }

    public int report(int report) {
        System.out.println(report);

        return report;
    }

    @Override
    public List<Integer> list(String arg) throws IOException {
        try {
            List<? extends Number> ss = super.list("ss");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        return list;
    }

}