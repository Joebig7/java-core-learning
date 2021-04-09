package container.collection.clone.shallowClone;

import container.collection.clone.Student;

/**
 * @Author JoeBig7
 * @date 2021/4/9 16:34:42
 */
public class ShallowBootstrap {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setId(1);
        s1.setClassId(1);
        s1.setName("joe");
        s1.setAge(14);
        //浅拷贝
        Student s2 = s1;

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        Object[] arr = new Object[2];
        arr[0] = s1;

        //数组默认实现了clone方法并且被标记为Cloneable
        Object[] clone = arr.clone();
        System.out.println(clone == arr);


    }
}
