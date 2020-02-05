package jvm.outofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/12/3 22:37
 * @description
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}