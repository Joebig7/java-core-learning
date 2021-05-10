package container.collection;

import java.util.ArrayDeque;

/**
 * @Author JoeBig7
 * @date 2021/4/21 18:47:40
 */
public class ArrayDequeDemo {

    private static
    ArrayDeque<String> arrayDeque = new ArrayDeque<>();


    public static void main(String[] args) {
        arrayDeque.add("a");
        arrayDeque.addFirst("b");
        arrayDeque.addLast("c");
        arrayDeque.push("d");
//        arrayDeque.push();

        System.out.println(arrayDeque.pop());
        System.out.println(arrayDeque.getFirst());
        System.out.println(arrayDeque.poll());
    }
}
