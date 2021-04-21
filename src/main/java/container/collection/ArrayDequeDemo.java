package container.collection;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;

/**
 * @Author JoeBig7
 * @date 2021/4/21 18:47:40
 */
public class ArrayDequeDemo {

    private  static
         ArrayDeque<String> arrayDeque = new ArrayDeque<>();


    public static void main(String[] args) {
        arrayDeque.addFirst("a");
    }
}
