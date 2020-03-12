package concurrency.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/12 10:35
 * @description
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "a");
        map.put("b", "b");
    }

}