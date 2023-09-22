package cn.poi.text;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelReadTest {
    @Test
    public void text03() throws Exception {
        //读取流
        FileInputStream fileInputStream = new FileInputStream("D:\\zyh.xls");
        //工作簿
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        //工作表
        Sheet sheet = workbook.getSheetAt(0);
        //获取行
        Row row = sheet.getRow(6);
        //获取列
        Cell cell = row.getCell(4);
        //获取的数据
        String stringCellValue = cell.getStringCellValue();
        System.out.println(stringCellValue);
        //关闭流
        fileInputStream.close();
    }
    @Test
    public void testCellType() throws Exception {
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream("D:\\zyh.xls");
        //工作簿
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        //获取工资表
        Sheet sheetAt = workbook.getSheetAt(0);
        //读取表
        Row row = sheetAt.getRow(0);
        if (null != row){
            int physicalNumberOfCells = row.getPhysicalNumberOfCells();
            for (int i = 0 ; i<physicalNumberOfCells ; i++){
                Cell cell = row.getCell(i);
                if (null != cell){
                    String value = cell.getStringCellValue();
                    System.out.print(value + " | ");
                }
            }
        }
        System.out.println();
        fileInputStream.close();
    }
}
