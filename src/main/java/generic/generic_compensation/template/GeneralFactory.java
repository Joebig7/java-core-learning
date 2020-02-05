package generic.generic_compensation.template;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/15 11:20
 * @description
 */
public abstract class GeneralFactory<T> {

    final T element;

    public GeneralFactory() {
        element = create();
    }

    public abstract T create();
}