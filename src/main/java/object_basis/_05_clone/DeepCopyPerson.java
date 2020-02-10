package object_basis._05_clone;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/10 15:01
 * @description
 */
public class DeepCopyPerson implements Cloneable {
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

    @Override
    public Object clone() {

        DeepCopyPerson deepCopyPerson = null;
        try {
            deepCopyPerson = (DeepCopyPerson) super.clone();
            deepCopyPerson.student = (Student) student.clone();
            return deepCopyPerson;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}