package cn.poi.text;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Excel {
    @Test
    public void toshow() throws IOException {
        String path = "D:\\zyh.xls";
        InputStream inputStream = new FileInputStream(path);
        //工作簿
        Workbook workbook = new HSSFWorkbook(inputStream);
        //表单页码
        Sheet sheetAt = workbook.getSheetAt(0);
        //行
        Row row = sheetAt.getRow(4);
        //获取指定行里面的单元格个数
        int physicalNumberOfCells = row.getPhysicalNumberOfCells();
        for(int i = 0 ; i < physicalNumberOfCells; i++){
            Cell cell = row.getCell(i);
            //获取单元格里面的类型
            CellType cellTypeEnum = cell.getCellTypeEnum();
            switch (cellTypeEnum){
                case _NONE:
                    System.out.println("这个单元格不存在");
                    break;
                case BLANK:
                    System.out.println("该单元格的值是空白");
                    break;
                case BOOLEAN:
                    System.out.println("这是一个布尔类型的"+cell.getBooleanCellValue());
                    break;
                case STRING:
                    System.out.println("这是一个字符串的单元格"+cell.getStringCellValue());
                    break;
                case NUMERIC:
                    //工具类判断数值是不是睡觉类型的
                    if(!HSSFDateUtil.isCellDateFormatted(cell)){
                        System.out.println("这是一个数值"+cell.getNumericCellValue());
                    }else {
                        Date dateCellValue = cell.getDateCellValue();
                        String s = new DateTime(dateCellValue).toString("yyyy-MM-dd");
                        System.out.println("这是一个日期类"+s);
                    }
                    break;
                case FORMULA:
                    HSSFFormulaEvaluator hssfFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook)workbook);
                    CellValue evaluate = hssfFormulaEvaluator.evaluate(cell);
                    String s = evaluate.formatAsString();
                    System.out.println("这是一个公式单元格"+s);
                    break;
            }
        }
        inputStream.close();
    }
    @Test
    public void toshow2() throws IOException {
        String path = "D:\\zyl.xlsx";
        InputStream inputStream = new FileInputStream(path);
        //工作簿
        Workbook workbook = new XSSFWorkbook(inputStream);
        //表单页码
        Sheet sheetAt = workbook.getSheetAt(0);
        //行
        Row row = sheetAt.getRow(4);
        //获取指定行里面的单元格个数
        int physicalNumberOfCells = row.getPhysicalNumberOfCells();
        for(int i = 0 ; i < physicalNumberOfCells; i++){
            Cell cell = row.getCell(i);
            //获取单元格里面的类型
            CellType cellTypeEnum = cell.getCellTypeEnum();
            switch (cellTypeEnum){
                case _NONE:
                    System.out.println("这个单元格不存在");
                    break;
                case BLANK:
                    System.out.println("该单元格的值是空白");
                    break;
                case BOOLEAN:
                    System.out.println("这是一个布尔类型的"+cell.getBooleanCellValue());
                    break;
                case STRING:
                    System.out.println("这是一个字符串的单元格"+cell.getStringCellValue());
                    break;
                case NUMERIC:
                    //工具类判断数值是不是日期类型的
                    if(!HSSFDateUtil.isCellDateFormatted(cell)){
                        System.out.println("这是一个数值"+cell.getNumericCellValue());
                    }else {
                        Date dateCellValue = cell.getDateCellValue();
                        String s = new DateTime(dateCellValue).toString("yyyy-MM-dd");
                        System.out.println("这是一个日期类"+s);
                    }
                    break;
                case FORMULA:

                    XSSFFormulaEvaluator hssfFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workbook);
                    CellValue evaluate = hssfFormulaEvaluator.evaluate(cell);
                    String s = evaluate.formatAsString();
                    System.out.println("这是一个公式单元格"+s);
                    break;
            }
        }
        inputStream.close();
    }
}
