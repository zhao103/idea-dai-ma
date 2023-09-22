package cn.poi.easy;

import com.alibaba.excel.annotation.ExcelProperty;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InspectorDto {
    //校验器工厂
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    //将工具类私有
    private InspectorDto(){}
    public static <T> List<String> bonding(T t) throws NoSuchFieldException {
        List<String> list = new ArrayList<String>();
        Set<ConstraintViolation<T>> validate = validator.validate(t,Default.class);
        if (null != validate){
            //遍历集合获取报错的属性和和里面的message
            for (ConstraintViolation<T> tCons : validate) {
                // 拿到报错属性
                String s = tCons.getPropertyPath().toString();
                Field field = t.getClass().getDeclaredField(s);
                //拿到属性的注解
                ExcelProperty annotation = field.getAnnotation(ExcelProperty.class);
                //拼接一下错误信息
                String s1 = annotation.value()[0]+tCons.getMessage();
                list.add(s1);
            }
        }
        return list;
    }


}
