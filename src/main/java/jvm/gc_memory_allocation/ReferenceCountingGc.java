package jvm.gc_memory_allocation;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/12/4 14:45
 * @description
 */
public class ReferenceCountingGc {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }


    public static void main(String[] args) {
        testGC();
    }

}