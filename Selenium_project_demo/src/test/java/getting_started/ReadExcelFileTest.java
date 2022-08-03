package getting_started;

import org.junit.Test;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ReadExcelFileTest{

	private static XSSFSheet sheet;
	@Test
	public void test() {
		String fileName = "ClientTestData.xlsx";
		try {
			File excelFile = new File(System.getProperty("user.dir")+ "\\testData\\" + fileName);
			FileInputStream fileSystem = new FileInputStream(excelFile);
			XSSFWorkbook book = new XSSFWorkbook(fileSystem);
		    sheet  = book.getSheetAt(0);
		
		    for( Iterator<Row> i = sheet.iterator(); i.hasNext();) {//perform this action for every row
				Row iRow = i.next();
				String cellValueAtCol = GetCellByHeader(iRow,"ClientLastName").getStringCellValue();//to attain value for passing to driver.findelement().sendkeys() for specified column name
				System.out.println(cellValueAtCol);
		    }
		}
		catch(Exception e) {
			System.out.println("error was: " +e.getMessage());
		}
		//fail("Not yet implemented");
	}
	
	//public static void GetRowByValueAtColumn(string headerValue, string)
	
	public static Cell GetCellByHeader(Row thisRow,String headerValue) {
		return thisRow.getCell(GetHeaderColNum(headerValue));
	}
	
	public static Integer GetHeaderColNum(String searchString) {
		Row headerRow = sheet.getRow(0);
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
	

	
	
	
	

