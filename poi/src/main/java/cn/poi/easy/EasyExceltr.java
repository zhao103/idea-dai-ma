package cn.poi.easy;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class EasyExceltr {
    public static void main(String[] args) {
        //新建文件路径
        String path = "D:/easy.xlsx";
        List<UserDto> list = new ArrayList<UserDto>();
        for (int i = 0; i<10; i++){
            UserDto userDto = new UserDto();
            userDto.setAge(i+1+"");
            userDto.setName("王五");
            userDto.setSex("女");
            list.add(userDto);
        }
        EasyExcel.write(path,UserDto.class).sheet("第一章").doWrite(list);
    }
}
