package container.collection;

import java.util.*;

/**
 * @Author JoeBig7
 * @date 2021/4/8 17:30:50
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("apple");
        list.add("pineapple");
        list.add("watermelon");
        list.add(2, "banana");
        list.add("elephant");

        list.remove("elephant");
        list.remove(0);


        list.set(0,"orange");
        System.out.println("-------------------------------------");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("-------------------------------------");
        for(String f: list){
            System.out.println(f);
        }
        System.out.println("-------------------------------------");

//        Iterator<String> iterator = list.iterator();
        //jdk1.8 新提供 遍历
//        iterator.forEachRemaining(s-> System.out.println(s));
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        list.forEach(a-> System.out.println(a));

        ListIterator<String> listIterator = list.listIterator();

        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

        listIterator.add("grapes");
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }


    }
}
