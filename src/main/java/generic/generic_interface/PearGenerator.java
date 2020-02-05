package generic.generic_interface;

import generic.generic_interface.model.Pear;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/14 14:22
 * @description
 */
public class PearGenerator implements Generator<Pear>{

    @Override
    public Pear generate() {
        return new Pear();
    }
}