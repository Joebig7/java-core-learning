package oop._05_clone;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/10 14:58
 * @description
 */
public class Person implements Cloneable {

    private String name;
    private Student student;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    //浅拷贝实现
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}