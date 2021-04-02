package oop._01_Contructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/9 11:40
 * @description
 */
public class Person {

    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    List<? extends Number> list(String arg) throws Exception {
        ArrayList<Number> list = new ArrayList<>();
        list.add(1);
        return list;
    }


}