package jvm.gc_memory_allocation;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/12/4 17:44
 * @description
 */
public class HandlePromotion {

    private static final int _1MB = 1024 * 1024;

    public static void testHandlePromotion() {
        byte[] a1, a2, a3, a4, a5, a6, a7;

        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a1 = null;
        a4 = new byte[2 * _1MB];
        a5 = new byte[2 * _1MB];
        a6 = new byte[2 * _1MB];
        a4 = null;
        a5 = null;
        a6 = null;
        a7 = new byte[2 * _1MB];
    }

    public static void main(String[] args) {
        testHandlePromotion();
    }
}