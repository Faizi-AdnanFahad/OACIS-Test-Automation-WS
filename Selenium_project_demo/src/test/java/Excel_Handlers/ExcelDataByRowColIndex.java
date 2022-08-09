package Excel_Handlers;

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

public class ExcelDataByRowColIndex {
	
	/* Given an excel filename, returns an excel sheet. */
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
	
	
	/* 
	 * Given an Excel filename that exists in the data directory, a row number and a column number, returns 
	 * the value for the intersected cell
	 */
	public static String GetDataFromExcel(String filename, int rowNum, int ColNum) {
		XSSFSheet sheet = GetExcelSheet(filename);
		DataFormatter formatter = new DataFormatter();
		String val = formatter.formatCellValue(sheet.getRow(rowNum).getCell(ColNum));
		return val;
	}
}