package generic.demo;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/14 12:30
 * @description 通过泛型来解决参数类型的问题
 */
public class Holder2<T> {

    public T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }


    public static void main(String[] args) {
        //set Customer
        Holder2<Customer> holder2 = new Holder2();
        holder2.setT(new Customer());
        //set String
        Holder2<String> holder21 = new Holder2<>();
        holder21.setT("object");
    }
}