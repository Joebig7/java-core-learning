package object_basis._04_euqals_hashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/10 14:17
 * @description
 */
public class Demo {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();

        //在重写person equals方法的时候，已经重写了hashcode方法 因此对于person1和person2来说，求到的hash值是一样的
        Person person = new Person();
        person.setAge(20);
        person.setName("joe");
        Person person2 = new Person();
        person2.setAge(20);
        person2.setName("joe");

        map.put(person, "hello");
        String s = map.get(person2);
        System.out.println(s);
    }
}