package Excel_Handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class CreateReport {
	@Test
	public void TestTrial() throws IOException, InvalidFormatException {
		//XSSFSheet sheet = GetExcelSheet("ClientImportTest.xlsx");
		//XSSFRow row = sheet.getRow(2);
		//System.out.println("client name is " + GetCellValue(row, "CLName"));
		Workbook book = CreateNewExcelFile("testFile");
		WriteTemplateIntoFile(book);
		OpenExcelSheet();
		
	}
	
	public static Workbook CreateNewExcelFile(String filename) {
		Workbook book1 = new XSSFWorkbook();
		try{
			
		    String safeName = WorkbookUtil.createSafeSheetName("Test Report");
		    Sheet sheet1 = book1.createSheet(safeName);//if problems, try org.apache.poi.sl.usermodel.Cell import instead of poi.ss
		    OutputStream fileOut = new FileOutputStream(filename+".xlsx") ;
		    book1.write(fileOut);
		}
		catch(Exception e) {
			
		}
		
		return book1;
	}
	
	public static void WriteTemplateIntoFile(Workbook wb) throws IOException {
		Sheet sheet = wb.getSheetAt(0);
		
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("hello");
		
		OutputStream fileOut;
		try {
			 fileOut = new FileOutputStream("testFile.xlsx"); 
			  wb.write(fileOut);
		}
		catch(Exception e) {
		}
		
		  
		
		}
	
	
	public static void 
	
	public static void OpenExcelSheet() throws InvalidFormatException, IOException {
		//OPCPackage pkg = OPCPackage.open(new File(System.getProperty("user.dir")+ "testFile.xlsx"));
		OPCPackage pkg = OPCPackage.open(new File("testFile.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(pkg);
		
		
		
	}
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
	
}
