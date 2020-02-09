package object_basis._02_String_StringBuilder_StringBuffer;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/9 14:31
 * @description String相关知识点
 */
public class StringDemo {

    public static void test1() {

        String s = new String("1"); //这一步会在常量池中生成一个"1"的对象，然后在堆中生成一个String对象 s指向这个String对象
        s.intern();  //这一步将常量池中"1"的对象的引用返回（如果1不存在会先在常量池中创建然后返回）
        String s2 = "1";  //s2指向常量池中"1"对象
        System.out.println(s == s2); //这边s指向的是堆中的对象、s2指向的是常量池中的"1"对象因此返回false

        String s3 = new String("1") + new String("1"); //这一步最终创建了一个"1"的对象，s3指向堆中对象内容是"11"，但是常量池中没有11这个对象
        s3.intern(); //通过这个方法因为"11"在常量池中不存在，因此在池中直接保存堆中"11"这个对象的引用
        String s4 = "11"; //s4指向池中"11"的引用，因为池中现在指向的就是s3指向的那个引用，因此它们两个对象是同一个地址
        System.out.println(s3 == s4);
    }

    public static void test2() {
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();  //这一步的区别是因为上一步会在常量池中创建一个"11"的对象，因此s3这一步不会在池中继续保存堆中对象的引用
        System.out.println(s3 == s4);
    }

    public static void main(String[] args) {

        //这条语句创建了两个对象，首先是在常量池中创建了abc这个对象，然后在堆中创建了一个String对象。
        String a = new String("abc");
        test1();
        test2();

    }

}