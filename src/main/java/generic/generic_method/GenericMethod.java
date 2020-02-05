package generic.generic_method;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/14 14:36
 * @description 泛型方法
 */
public class GenericMethod {

    public <T> void generate(T t) {
        System.out.println(t.getClass().getName());
    }


    public static void main(String[] args) {
        GenericMethod method = new GenericMethod();
        method.generate("hello");
        method.generate(1L);
        method.generate(1);
        method.generate(true);
    }

}