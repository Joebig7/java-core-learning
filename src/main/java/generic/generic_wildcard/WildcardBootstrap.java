package generic.generic_wildcard;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/15 12:13
 * @description
 */
public class WildcardBootstrap {

    public static void main(String[] args) {
        List<? extends Fruit> list = new ArrayList<Apple>();
        List<Apple> apples = Lists.newArrayList();
        Apple apple = new Apple();
        apples.add(apple);
        list = apples;
        boolean isContain = apples.contains(apple);
        int index = apples.indexOf(apple);
        System.out.println((Apple) list.get(0));
        System.out.println("iscontain = " + isContain);
        System.out.println("index = " + index);

        //super
        List<Apple> appleList = new ArrayList<>();
        List<Fruit> fruitList = new ArrayList<>();
        addFruit(appleList, new Apple());
        addFruit(fruitList, new Fruit());


    }


    public static <T> void addFruit(List<? super T> list, T item) {
        list.add(item);
    }
}