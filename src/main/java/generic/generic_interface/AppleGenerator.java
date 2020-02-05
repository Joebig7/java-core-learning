package generic.generic_interface;

import generic.generic_interface.model.Apple;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/14 14:21
 * @description
 */
public class AppleGenerator implements Generator<Apple> {
    @Override
    public Apple generate() {
        return new Apple();
    }
}