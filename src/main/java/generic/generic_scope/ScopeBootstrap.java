package generic.generic_scope;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/15 11:40
 * @description 泛型的边界
 */
public class ScopeBootstrap<T extends Number> {

    private T t;

    public ScopeBootstrap() {

    }

    public ScopeBootstrap(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        ScopeBootstrap<Integer> scopeBootstrap = new ScopeBootstrap<>(1);
        System.out.println(scopeBootstrap.get());
    }
}
