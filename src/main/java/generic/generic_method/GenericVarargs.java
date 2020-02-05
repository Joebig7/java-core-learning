package generic.generic_method;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/14 14:48
 * @description 泛型方法对可变参数的支持
 */
public class GenericVarargs {

    public static <T> List<T> produceList(T... args) {
        List<T> list = Lists.newArrayList();
        for (T t : args) {
            list.add(t);
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> integerList = produceList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(integerList);
    }
}