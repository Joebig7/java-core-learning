package oop._04_euqals_hashcode;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/10 11:15
 * @description
 */
public class Person {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        return age.equals(person.age);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    public static void main(String[] args) {
        Person person = new Person();
        Person person2 = new Person();
        System.out.println(person.equals(person2));
    }
}