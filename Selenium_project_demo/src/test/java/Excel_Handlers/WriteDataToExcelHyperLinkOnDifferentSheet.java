package Excel_Handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcelHyperLinkOnDifferentSheet {
	private static int rowMod = 1;
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
    
    public static void writeToExcelFileTest(TreeMap<String, Object[]> stepInfo, String excelFilePath) {
		  // workbook object
		  XSSFWorkbook workbook = new XSSFWorkbook();
		  // spreadsheet object
		  XSSFSheet spreadsheet = workbook.createSheet("Test Case Final Report");
		  
		  Sheet screenShotSheet = workbook.createSheet("Screenshot Sheet");

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
		    			  // pass the workbook, create a sheet for screenshots
			    		  String picLink = (String) obj;

			    		  addHyperLinkToACellTest(excelFilePath, workbook, screenShotSheet, cell, rowid, picLink);
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
    
    public static void addHyperLinkToACellTest(String excelFilePath, XSSFWorkbook wb, Sheet screenShotSheet, Cell cell, int rowNum, String picPath) {
	    int rowNumberUpdate = rowNum - 2; // making rowNumberUpdate 0
    	try {
		     CreationHelper createHelper = wb.getCreationHelper();
		       
		     // Cell Style for hyperlink - Make it underlined Blue
		     CellStyle hlink_style = wb.createCellStyle();
		     Font hlink_font = wb.createFont();
		     hlink_font.setUnderline(Font.U_SINGLE);
		     hlink_font.setColor(IndexedColors.BLUE.getIndex());
		     hlink_style.setFont(hlink_font);
		     
		     //link to a place in this workbook
		     //create a target sheet and cell
//		     screenShotSheet.createRow(rowNumberUpdate).createCell(0).setCellValue("Target Cell"); // the pic will go here
		     addImageToACell(excelFilePath, wb, screenShotSheet, rowNumberUpdate, picPath);
		     // Setting the hyperlink address
		     cell.setCellValue("Click Here!");
		     Hyperlink link2 = createHelper.createHyperlink(HyperlinkType.DOCUMENT);
		     link2.setAddress("'Screenshot Sheet'!G" + (WriteDataToExcelHyperLinkOnDifferentSheet.rowMod + 20)); 
		     cell.setHyperlink(link2);
		     cell.setCellStyle(hlink_style);
		     WriteDataToExcelHyperLinkOnDifferentSheet.rowMod += 21;
		     // writing to the file
			 FileOutputStream fileOut = null;
			 fileOut = new FileOutputStream(excelFilePath);
			 wb.write(fileOut);
			 fileOut.close();

	       } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	       } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static void addImageToACell(String excelPath, XSSFWorkbook wb, Sheet screenShotSheet, int rowNum, String picPath) {
		try {
		       FileInputStream file = new FileInputStream(excelPath);

			   //FileInputStream obtains input bytes from the image file
			   InputStream inputStream = new FileInputStream(new File(picPath));
			   //Get the contents of an InputStream as a byte[].
			   byte[] bytes = IOUtils.toByteArray(inputStream);
			   //Adds a picture to the workbook
			   int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
			   //close the input stream
			   inputStream.close();
			   //Returns an object that handles instantiating concrete classes
			   CreationHelper helper = wb.getCreationHelper();
			   //Creates the top-level drawing patriarch.
			   Drawing drawing = screenShotSheet.createDrawingPatriarch();

			   //Create an anchor that is attached to the worksheet
			   ClientAnchor anchor = helper.createClientAnchor();

			   anchor.setCol1(0); //Column B
			   anchor.setRow1(WriteDataToExcelHyperLinkOnDifferentSheet.rowMod); //Row 3
			   anchor.setCol2(13); //Column C
			   anchor.setRow2(22 + WriteDataToExcelHyperLinkOnDifferentSheet.rowMod); //Row 4
			   
			   //Creates a picture
			   Picture pict = drawing.createPicture(anchor, pictureIdx);

			   //Reset the image to the original size
			   //pict.resize(); //don't do that. Let the anchor resize the image!

			   //Create the Cell B3
			   Cell cell = screenShotSheet.createRow(rowNum).createCell(1);

			   //set width to n character widths = count characters * 256
			   //int widthUnits = 20*256;
			   //sheet.setColumnWidth(1, widthUnits);

			   //set height to n points in twips = n * 20
			   //short heightUnits = 60*20;
			   //cell.getRow().setHeight(heightUnits);

			   //Write the Excel file
			   FileOutputStream fileOut = null;
			   fileOut = new FileOutputStream(excelPath);
			   wb.write(fileOut);
			   fileOut.close();
			   System.out.println("DONE");
			  } 
			  catch (IOException ioex) {
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