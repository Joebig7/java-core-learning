package generic.generice_erasure.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/14 15:59
 * @description 泛型擦除的例子
 */
public class GenericErasureBootstrap {

    public static void printGenericClass() {
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        System.out.println(stringList.getClass() == integerList.getClass());
    }

    public static void getGenericType() {
        List<String> list = new ArrayList<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
    }


    public static void main(String[] args) {
        getGenericType();
    }
}