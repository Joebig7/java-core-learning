package generic.demo;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/14 12:21
 * @description demo：jdk1.5之前在没有泛型之前处理参数方式
 */
public class Holder1 {
    public Object object;

    public Holder1(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public static void main(String[] args) {
        //set Customer
        Holder1 holder1 = new Holder1(new Customer());
        Customer customer = (Customer) holder1.getObject();

        //set other type
        holder1.setObject("object");
        String str = (String) holder1.getObject();

    }
}