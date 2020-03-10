package demo;

import java.lang.annotation.*;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/10 20:02
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
public @interface MyAnnotation {

    String[] args = new String[]{"xxx", "vvv"};

    int value() default 1;

}