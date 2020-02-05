package generic.generic_compensation.factory;

import generic.generic_compensation.factory.Factory;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/15 11:13
 * @description
 */
public class IntegerFactory implements Factory<Integer> {
    @Override
    public Integer create() {
        return new Integer(0);
    }
}