package container.collection.clone;

import java.util.ArrayList;

/**
 * @Author JoeBig7
 * @date 2021/4/9 15:52:11
 * @description
 */
public class Classroom implements Cloneable {

    private Integer id;

    private String className;

    private String address;

    private ArrayList<Student> list;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }

    /**
     * 深拷贝实现
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Classroom classroom = (Classroom) super.clone();
        ArrayList<Student> oldList = classroom.getList();
        //深拷贝ArrayList列表，ArrayList默认的拷贝只是浅拷贝
        ArrayList<Student> list = new ArrayList<>(oldList.size());
        for (Student s : oldList) {
            list.add((Student) s.clone());
        }

        classroom.setList(list);
        return classroom;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", address='" + address + '\'' +
                ", list=" + list.toString() +
                '}';
    }
}
