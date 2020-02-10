package object_basis._05_clone;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/10 14:58
 * @description
 */
public class Student implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}