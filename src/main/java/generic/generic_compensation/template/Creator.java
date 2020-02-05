package generic.generic_compensation.template;


/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/15 11:21
 * @description
 */
public class Creator extends GeneralFactory<Integer> {
    @Override
    public Integer create() {
        return new Integer(0);
    }
}