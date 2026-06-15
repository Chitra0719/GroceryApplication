package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {

	static FileInputStream f;// to read excel file from system
	static XSSFWorkbook w; // represents entire excel workbook
	static XSSFSheet sh; // represents a sheet from excel workbook
	 
	public static String readStringData(int row, int col, String sheet) throws IOException {
	//f = new FileInputStream("C:\\Users\\chitr\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\GroceryAppLoginData.xlsx");// open excel file from the given location
	f = new FileInputStream(Constant.TESTDATA);
	w = new XSSFWorkbook(f);// to load excel file to memory using apache poi
	sh = w.getSheet(sheet);// to select the specific sheet from excel file
	XSSFRow r = sh.getRow(row); // to get the row passed as argument
	XSSFCell c = r.getCell(col); // to get the column values passed as argument
	return c.getStringCellValue(); // to return cell value in string format

	}
	public static String readIntegerData(int row, int col , String sheet) throws IOException {
		//f = new FileInputStream("C:\\Users\\chitr\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\GroceryAppLoginData.xlsx");
		f = new FileInputStream(Constant.TESTDATA);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		int val = (int) c.getNumericCellValue(); //convert double to int using typecasting
		return String.valueOf(val); //convert int to string using valueOf() method

		}

}

