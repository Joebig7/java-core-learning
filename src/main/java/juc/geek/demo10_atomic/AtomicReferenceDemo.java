package juc.geek.demo10_atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/10 9:57
 * @description Atomic引用类型使用Demo AtomicStampedReference 和 AtomicMarkableReference同样也可以实现，不过他们还解决了ABA问题（通过版本号的控制）
 */
public class AtomicReferenceDemo {

    private static AtomicReference<User> atomicReference = new AtomicReference<>();

    /**
     * 原子性修改
     */
    public void update() {
        atomicReference.getAndSet(new User("joe", 24L));
        atomicReference.accumulateAndGet(new User("s", 23L), (u1, u2) -> {
            u2.setAge(u1.getAge());
            return u2;
        });
    }
}