package cn.poi.easy;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Data
public class UserDto {
    @ExcelProperty(value = "用户",index = 0)
    @Length(max = 5,message = "用户超出格式")
    private String name;
    @ExcelProperty(value = "性别",index = 1)
    @Length(max = 1,message = "没有两个字的性别")
    private String sex;
    @ExcelProperty(value = "年龄",index = 2)
    @Pattern(regexp = "^[0-9]*$",message = "年龄输入错误")
    private String age;
    @ExcelIgnore //忽略字段6
    private Integer password;
}
