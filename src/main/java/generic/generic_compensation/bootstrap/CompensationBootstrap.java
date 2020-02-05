package generic.generic_compensation.bootstrap;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/15 10:32
 * @description 泛型中的缺陷以及补偿
 */
public class CompensationBootstrap<T> {

    private Class<T> c;

    public CompensationBootstrap(Class<T> c) {
        this.c = c;
    }


    public void ofInstance(Object object) {
        if (c.isInstance(object)) {
            System.out.println("c instanceof "+object.getClass().getTypeName());
        }
    }


    public static void main(String[] args) {
        CompensationBootstrap<Integer> compensationBootstrap = new CompensationBootstrap(Integer.class);
        Integer integer = new Integer(1);
        compensationBootstrap.ofInstance(integer);
    }

}