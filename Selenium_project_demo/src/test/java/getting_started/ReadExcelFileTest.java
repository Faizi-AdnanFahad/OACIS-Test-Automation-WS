package getting_started;

import org.junit.Test;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFileTest {

	@Test
	public void test() {
		String fileName = "ClientTestData.xlsx";
		
		try {
			File excelFile = new File(System.getProperty("user.dir")+ "\\testData\\" + fileName);
			FileInputStream fileSystem = new FileInputStream(excelFile);
		    XSSFWorkbook book = new XSSFWorkbook(fileSystem);
		    XSSFSheet sheet  = book.getSheetAt(0);
		    
		    System.out.println(sheet.getRow(0).getPhysicalNumberOfCells());		
		    
		    XSSFRow tableHeader = sheet.getRow(0);
		}
		catch(Exception e) {
			System.out.println("error was: " +e.getMessage());
			
		}
		
		//fail("Not yet implemented");
	}

}
