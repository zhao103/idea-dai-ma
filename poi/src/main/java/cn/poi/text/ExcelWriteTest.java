package cn.poi.text;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ExcelWriteTest {
    @Test
    public void show() throws IOException {
        //工作簿
        Workbook workbook = new HSSFWorkbook();
        //工作表
        Sheet sheet = workbook.createSheet("Sheet1");
        //创建行
        Row row = sheet.createRow(6);
        //创建列
        Cell cell = row.createCell(4);
        //添加内容
        cell.setCellValue("时代的悲哀");
        //流的对象
        String path = "D:/";
        String name = "zyh.xls";
        File file = new File(path);
        //判断路径是否存在
        if (!file.exists()){
            //创建目录
            file.mkdirs();
        }
        OutputStream outputStream = new FileOutputStream(path+name);
        //将内容输出
        workbook.write(outputStream);
        //关闭
        outputStream.close();
        System.out.println("执行完成");


    }
}
