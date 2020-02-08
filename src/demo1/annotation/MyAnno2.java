package demo1.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})//表示该MyAnno2注解只能作用于类上
@Documented
@Inherited
public @interface MyAnno2 {

}
