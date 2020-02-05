package generic.generic_method;

import generic.generic_interface.Generator;
import generic.generic_interface.model.Apple;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/14 15:19
 * @description 匿名内部类支持的泛型
 */
public class GenericAnonymous {


    public static Generator<Apple> generator() {
        return new Generator<Apple>() {
            @Override
            public Apple generate() {
                return new Apple();
            }
        };
    }


    public static void main(String[] args) {
        Apple apple = GenericAnonymous.generator().generate();
    }
}