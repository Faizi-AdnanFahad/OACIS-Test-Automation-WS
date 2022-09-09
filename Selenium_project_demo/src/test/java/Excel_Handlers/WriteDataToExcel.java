package Excel_Handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel {
	
    public static void writeToExcelFile(TreeMap<String, Object[]> errorPassMsgs) {
      // workbook object
      XSSFWorkbook workbook = new XSSFWorkbook();
      // spreadsheet object
      XSSFSheet spreadsheet = workbook.createSheet(" Student Data ");
      // creating a row object
      XSSFRow row;

      // This data needs to be written (Object[])
      Map<String, Object[]> studentData = errorPassMsgs;
      Set<String> keyid = studentData.keySet();

      int rowid = 0;
      // writing the data into the sheets...
      for (String key : keyid) {

          row = spreadsheet.createRow(rowid ++);
          Object[] objectArr = studentData.get(key);
          int cellid = 0;

          for (Object obj : objectArr) {
              Cell cell = row.createCell(cellid ++);
              cell.setCellValue((String)obj);
          }
      }

      
    // writing the workbook into the file...
	try {
		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\FaiziAd\\OneDrive - Government of Ontario\\Desktop\\OAP-2139\\test.xlsx"));
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
    
//    public static void writeToExcelFile(String stepNum, String expectedResult, String testResult, String errorMsg) {
//    	 // workbook object
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        // spreadsheet object
//        XSSFSheet spreadsheet = workbook.createSheet(" Student Data ");
//        // creating a row object
//        
//        if (rowNum == 0) {
//        	// Setting up the first row: Titles
//        	ArrayList<String> titles = new ArrayList<String>();
//            XSSFRow firstRow = spreadsheet.createRow(rowNum);
//            titles.add("Step No."); titles.add("Expected Outcome"); titles.add("Test Result"); titles.add("Error Message");
//        	for (int i = 0; i < titles.size(); i ++) {
//                Cell cell = firstRow.createCell(i);
//                cell.setCellValue(titles.get(i));
//            }
//        	rowNum = 1;
//        }
//        ArrayList<String> data = new ArrayList<String>();
//        data.add(stepNum); data.add(expectedResult); data.add(testResult); data.add(errorMsg);
//        XSSFRow row = spreadsheet.createRow(rowNum);
//
//        for (int i = 0; i < data.size(); i ++) {
//            Cell cell = row.createCell(i);
//            cell.setCellValue(data.get(i));
//        }
//        try {
//        	if (rowNum == 1) {
//    			FileOutputStream out = new FileOutputStream(new File("C:\\Users\\FaiziAd\\OneDrive - Government of Ontario\\Desktop\\OAP-2139\\test.xlsx"));
//
//    	        workbook.write(out);
//    	        out.close();
//        	}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        rowNum ++;
//    }
    
}