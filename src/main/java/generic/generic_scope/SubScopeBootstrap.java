package generic.generic_scope;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/15 11:42
 * @description
 */
public class SubScopeBootstrap<T> extends ScopeBootstrap {

    private T t;

    public SubScopeBootstrap(T t) {
        this.t = t;
    }

    public T getSub() {
        return t;
    }

    public static void main(String[] args) {

        SubScopeBootstrap<Integer> integerSubScopeBootstrap = new SubScopeBootstrap<>(1);
    }

}