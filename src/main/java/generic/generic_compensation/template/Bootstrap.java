package generic.generic_compensation.template;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/15 11:24
 * @description
 */
public class Bootstrap {

    public static void main(String[] args) {
        Creator creator = new Creator();
        Integer integer = creator.create();
        System.out.println(integer);
    }
}