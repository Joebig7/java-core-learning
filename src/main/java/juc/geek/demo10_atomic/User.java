package juc.geek.demo10_atomic;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/10 10:00
 * @description
 */
public class User {

    private String name;
    private Long age;

    public User(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}