package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcellReader {
	
WebDriver driver;
File file;
FileInputStream fis;
XSSFWorkbook wb;
XSSFSheet sheet;
XSSFRow row;
XSSFCell cell;
String value;

public ExcellReader(String fileName) throws IOException {
	this.file = new File(fileName);
	this.fis = new FileInputStream(file);
	this.wb = new XSSFWorkbook(fis);
}
public String textualValue(String sheetName, int rowNum, int cellNum) {
	sheet = wb.getSheet(sheetName);
	row = sheet.getRow(rowNum-1);
	cell = row.getCell(cellNum-1);
	return cell.getStringCellValue();
}
public int numericValue(String sheetName, int rowNum, int cellNum) {
	sheet = wb.getSheet(sheetName);
	row = sheet.getRow(rowNum-1);
	cell = row.getCell(cellNum-1);
	return (int) cell.getNumericCellValue();
}	

}
