package cn.poi.strategy;


import cn.poi.easy.UserDto;

public class NameCe<T> extends Policyinf<T> {
    //名字的校验
    public String impartial(T t) {
        String s = null;
        if (t instanceof UserDto){
            UserDto userDto = (UserDto)t;
            //获取到校验的属性
            String name = userDto.getName();
            if (name.length()>5){
                s = "名字的长度不能是5";
            }
        }
        return s;
    }
}
