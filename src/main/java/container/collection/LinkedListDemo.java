package container.collection;

import java.util.LinkedList;

/**
 * @Author JoeBig7
 * @date 2021/4/15 19:02:03
 * @description LinkedList demo
 */
public class LinkedListDemo {
    static LinkedList<String> list;

    static {
        list = new LinkedList<>();
    }

    public static void add() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add(0, "d");
    }

    public static void delete() {
        list.remove(0);
        list.remove("b");
    }

    public static void update() {
        list.set(1, "z");
    }

    public static void get() {
        String s = list.get(1);
        System.out.println(s);

    }

    /**
     * 队列操作
     */
    public static void queue() {
        //队列头添加元素
        list.addFirst("aa");
        list.add("bb");
        //队列尾部添加元素
        list.addLast("cc");
        list.offer("cc");
        //删除头部元素
        list.removeFirst();
        list.remove();
        //获取并且移除第一个元素
        String e1 = list.poll();
        String e2 = list.pollFirst();
        System.out.println("e1===" + e1 + ",e2==" + e2);
        //获取第一个元素但是并不移除掉  如果集合是空的会报错
        String e3 = list.getFirst();
        String e4 = list.element();
        System.out.println("e3===" + e3 + ",e4==" + e4);
        //获取第一个元素但是并不移除掉 如果集合是空的返回null
        list.peek();
        list.peekFirst();
    }

    public static void stack(){
        //将元素压入栈中
        list.push("aaa");
        list.addFirst("bbb");

        //将元素从栈中弹出 如果没有元素会报错
        list.pop();
        list.removeFirst();

        //将元素从栈中弹出 如果没有元素返回null
        list.peek();
        list.peekFirst();


    }

    public static void main(String[] args) {

    }

}


