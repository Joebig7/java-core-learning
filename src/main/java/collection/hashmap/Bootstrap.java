package collection.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/24 11:17
 * @description HashMap使用案例
 */
public class Bootstrap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "joe");

        Float a = 10.00001F;
        Float b = 1111.000001F;

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

    }



}