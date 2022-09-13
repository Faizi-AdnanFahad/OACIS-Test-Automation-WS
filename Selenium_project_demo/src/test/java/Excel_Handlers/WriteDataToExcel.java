package Excel_Handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel {
	
    public static void writeToExcelFile(TreeMap<String, Object[]> stepInfo, String excelFilePath) {
		  // workbook object
		  XSSFWorkbook workbook = new XSSFWorkbook();
		  // spreadsheet object
		  XSSFSheet spreadsheet = workbook.createSheet(" Test Case Final Report ");
		  // creating a row object
		  XSSFRow row;
		
		  // This data needs to be written (Object[])
		  Map<String, Object[]> infoData = stepInfo;
		  Set<String> keyid = infoData.keySet();
		
		  int rowid = 0;
		  // writing the data into the sheets...
		  for (String key : keyid) {
		      row = spreadsheet.createRow(rowid ++);
		      
		      Object[] objectArr = infoData.get(key); // stores the test data. Each index stores a column information
		      
		      int cellid = 0;		
		      for (int i = 0; i < objectArr.length; i ++) {
		          Cell cell = row.createCell(cellid ++);
		    	  Object obj = objectArr[i];
		    	  if (key.equals("1")) {
				      cell.setCellValue((String) obj);
		    	  }
		    	  else {
		    		  if (i == 4) { // Adds the link 
			    		  String picLink = (String) obj;
			    		  String hyperlink = String.format("HYPERLINK(\"%s\", \"click here\")", picLink);
			  			  cell.setCellFormula(hyperlink);
		    		  }
		    		  else {
					      cell.setCellValue((String) obj);
		    		  }
		    	  }
		     }
			// writing the workbook into the file...
			try {
				FileOutputStream out = new FileOutputStream(new File(excelFilePath));
			      workbook.write(out);
			      out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
		}
}
    
    /* Given a row, col and a hyperlink and an Excel path, this mutator function will add it to the excel cell - Assumes that the excel file exists*/
    /* Note that this function has not been used in Regression testing and can be used individually when needed. */
    public static void addHyperLink(int rowNum, int colNum, String excelPath, String hyperlink) {
	    try {
			FileInputStream file = new FileInputStream(excelPath);
			 
			// Creating a WorkBook
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			 
			// Opening an Spreadsheet
			XSSFSheet spreadsheet = workbook.getSheetAt(0);
			 
			// Retrieving a row (Does not create a new row)
			XSSFRow row = spreadsheet.getRow(rowNum);
			// Creating a cell and put a cell index value in it.
			XSSFCell cell = row.createCell(colNum);
			 
			// Adding hyperlink along with cell value in it.
  		  	String hyperlinkFormula = String.format("HYPERLINK(\"%s\", \"click here\")", hyperlink);
			cell.setCellFormula(hyperlinkFormula);
			  
			FileOutputStream outputfile = new FileOutputStream(excelPath);
			workbook.write(outputfile);
			 
			// Closing connections using close() method
			outputfile.close();
			 
			System.out.println(excelPath + " is written successfully");
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}