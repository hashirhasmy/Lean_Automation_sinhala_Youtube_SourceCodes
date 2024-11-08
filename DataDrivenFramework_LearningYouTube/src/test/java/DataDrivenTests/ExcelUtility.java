package DataDrivenTests;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet sh;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;

    String path;

    public ExcelUtility(String path){
        this.path = path;
    }

    public int getRowCount(String xlsheet) throws IOException {

        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        sh = wb.getSheet(xlsheet);
        int rowCount = sh.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    public int getColumnCount(String xlsheet, int rownum) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        sh = wb.getSheet(xlsheet);
        row = sh.getRow(rownum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public String getCellData(String xlsheet, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        sh = wb.getSheet(xlsheet);
        row = sh.getRow(rownum);
        cell = row.getCell(colnum);

        String data;
        try{
            //data = cell.toString();
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);  //returns the formated value of a cell as a String regardless of the cell type.
        }catch (Exception e){
            data = "";
        }

        wb.close();
        fi.close();
        return data;
    }



    public void setCellData(String xlsheet, int rownum, int colnum, String data) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        sh = wb.getSheet(xlsheet);
        row = sh.getRow(rownum);
        cell = row.createCell(colnum);
        cell.setCellValue(data);
        fo = new FileOutputStream(path);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }

    public void fillGreenColor(String xlsheet, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        sh = wb.getSheet(xlsheet);
        row = sh.getRow(rownum);
        cell = row.getCell(colnum);

        style = wb.createCellStyle();

        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        fo = new FileOutputStream(path);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }


    public void fillRedColor(String xlsheet, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        sh = wb.getSheet(xlsheet);
        row = sh.getRow(rownum);
        cell = row.getCell(colnum);

        style = wb.createCellStyle();

        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        fo = new FileOutputStream(path);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }

    //From Kushan way to read excel and return the cell value
    public String readExcel(int row, int col, String filePath, String sheetName) throws IOException {
        File file = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        DataFormatter dataFormatter = new DataFormatter();
        return dataFormatter.formatCellValue(sheet.getRow(row).getCell(col));
    }

 }

