package demo;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/10 14:09
 * @description
 */
public class Demo {


    public static void test1() {

        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
        System.out.println(a.equals(b));

        String c = new String("abc");
        String d = new String("abc");
        System.out.println(c == a);
        System.out.println(c.equals(a));
        System.out.println(c == d);
        System.out.println(c.equals(d));

        String e = null;
        String f = null;
        System.out.println(e.equals(f));
    }

    public static void test2() {

        Integer a = new Integer(1);
        int b = 1;
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    public static void main(String[] args) {

//        test1();
        test2();


    }

}