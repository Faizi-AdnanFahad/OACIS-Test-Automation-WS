package Regresstion_testing;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelHandler {
	
	public static XSSFSheet GetExcelSheet(String fileName) {
		XSSFSheet sheet=null;
		try {
			File excelFile = new File(System.getProperty("user.dir")+ "\\data\\" + fileName);
			FileInputStream fileSystem = new FileInputStream(excelFile);
			XSSFWorkbook book = new XSSFWorkbook(fileSystem);
		    sheet  = book.getSheetAt(0);
		}catch(Exception e) {
			System.out.println("Sheet named " + fileName + " could not be found.");
			System.out.println(e.getMessage());
		}
		return sheet;
	}
	
	
//	@Test
//	public void TestTrial() {
//		XSSFSheet sheet = GetExcelSheet("ClientImportTest.xlsx");
//		XSSFRow row = sheet.getRow(2);
//		System.out.println("client name is "+this.GetCellValue(row, "CLName"));
//		
//	}
	
	
	public static String GetDataFromExcel(String filename, int rowNum, int ColNum) {
		XSSFSheet sheet = GetExcelSheet(filename);
		DataFormatter formatter = new DataFormatter();
		String val = formatter.formatCellValue(sheet.getRow(rowNum).getCell(ColNum));
		return val;
	}
	
	public static String GetCellValue(XSSFRow inRow, String atColumnHeader) {
		String cellValueAtCol = null;
		try {
		   // for( Iterator<Row> i = sheet.iterator(); i.hasNext();) {//perform this action for every row
			//	Row iRow = i.next();
				cellValueAtCol = GetCellByHeader(inRow,atColumnHeader).getStringCellValue();//to attain value for passing to driver.findelement().sendkeys() for specified column name
		    //}
		}
		catch(Exception e) {
			System.out.println("Error retrieving value from row " + inRow.getRowNum() + " at column " + atColumnHeader);
			System.out.println(e.getMessage());
		}
		return cellValueAtCol;
	}
	
	//public static void GetRowByValueAtColumn(string headerValue, string)//Not implemented yet
	
	private static XSSFCell GetCellByHeader(XSSFRow thisRow,String headerValue) {
		return thisRow.getCell(GetHeaderColNum(thisRow.getSheet(),headerValue));
	}
	
	private static Integer GetHeaderColNum(XSSFSheet sheet,String searchString) {
		XSSFRow headerRow = sheet.getRow(0);
		Integer colNum=null;
	    	 for( Iterator<Cell> j = headerRow.iterator(); j.hasNext();) {
		    	Cell iCell = j.next();
	    		if(iCell.getStringCellValue().equals(searchString)) {
		    		colNum = iCell.getColumnIndex();
		    		break;		
		    	 }
	    	 }
	    	if(colNum.equals(null))
	    		System.out.println("No match found for " + searchString);
	   return colNum;
	}
}