package generic.generic_compensation.factory;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/15 11:11
 * @description 工厂类，用来创建对象
 */
public interface Factory<T> {

    T create();
}