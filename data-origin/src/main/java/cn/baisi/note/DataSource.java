package cn.baisi.note;

import cn.baisi.enumeration.Mj;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    //定义属性
    Mj value();

}
