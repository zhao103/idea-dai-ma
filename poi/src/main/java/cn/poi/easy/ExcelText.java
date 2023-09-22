package cn.poi.easy;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ExcelText {

    @Test
    public void show(){
        String path = "D:/easy.xlsx";
        Custom<UserDto> custom = new Custom<UserDto>(UserDto.class);
        ExcelReaderBuilder excelReaderBuilder = EasyExcel.read(path, UserDto.class,custom);
        ExcelReaderSheetBuilder sheet = excelReaderBuilder.sheet();
        sheet.doRead();


    }
}