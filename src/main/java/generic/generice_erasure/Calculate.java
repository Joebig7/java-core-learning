package generic.generice_erasure;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/14 16:23
 * @description
 */
public class Calculate<T extends Computer> {

    private T t;

    public Calculate(T t) {
        this.t = t;
    }

    public void cal() {
        t.inspect();
    }

    public static void main(String[] args) {
        Calculate<Computer> calculate = new Calculate<>(new Computer());
        calculate.cal();
    }
}