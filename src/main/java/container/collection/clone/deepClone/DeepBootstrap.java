package container.collection.clone.deepClone;

import container.collection.clone.Classroom;
import container.collection.clone.Student;

import java.util.ArrayList;

/**
 * @Author JoeBig7
 * @date 2021/4/9 16:35:13
 */
public class DeepBootstrap {

    public static void main(String[] args) {
        Classroom classroom = new Classroom();
        classroom.setId(1);
        classroom.setClassName("ClassA");
        classroom.setAddress("sh");

        Student s1 = new Student();
        s1.setId(1);
        s1.setClassId(1);
        s1.setName("joe");
        s1.setAge(14);

        Student s2 = new Student();
        s1.setId(2);
        s1.setClassId(1);
        s1.setName("rose");
        s1.setAge(15);

        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);

        classroom.setList(list);

        System.out.println(classroom.toString());
        Classroom classroom2 = null;
        try {
            classroom2 = (Classroom) classroom.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(classroom == classroom2);
        System.out.println(classroom.getClass() == classroom2.getClass());
        System.out.println(classroom.equals(classroom2));
        System.out.println(classroom.getList() == classroom2.getList());
        System.out.println(classroom.getList().get(0) == classroom2.getList().get(0));
    }
}
