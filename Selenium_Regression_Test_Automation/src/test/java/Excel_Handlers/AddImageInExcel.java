package Excel_Handlers;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.util.IOUtils;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddImageInExcel {
	public static void main(String[] args) {
		try {
		       FileInputStream file = new FileInputStream("C:\\Users\\FaiziAd\\OneDrive - Government of Ontario\\Desktop\\OAP-2139\\output.xlsx");

		       XSSFWorkbook workbook = new XSSFWorkbook(file);
				  XSSFSheet screenShotSheet = workbook.getSheet("Screenshot Sheet");
				  addImageToACell(workbook, screenShotSheet);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String excelFilePath = "C:\\Users\\FaiziAd\\OneDrive - Government of Ontario\\Desktop\\OAP-2139\\report.xlsx";
//		 FileInputStream file;
//		try {
//			file = new FileInputStream(excelFilePath);
//		     XSSFWorkbook wb = new XSSFWorkbook(file);
//		     Sheet screenShotSheet = wb.createSheet("Screenshot Sheets");
//		     Cell cell = null;
//			addHyperLinkToACellTest(excelFilePath, wb, screenShotSheet, cell);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	
	public static void addHyperLinkToACellTest(String excelFilePath, XSSFWorkbook wb, Sheet screenShotSheet, Cell cell) {
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
		     screenShotSheet.createRow(0).createCell(0).setCellValue("Target Cell"); // the pic will go here
		     
		     cell.setCellValue("Worksheet Link");
		     Hyperlink link2 = createHelper.createHyperlink(HyperlinkType.DOCUMENT);
		     link2.setAddress("'Target Sheet'!A1");
		     cell.setHyperlink(link2);
		     cell.setCellStyle(hlink_style);
		     
		     
			   FileOutputStream fileOut = null;
			   fileOut = new FileOutputStream("C:\\Users\\FaiziAd\\OneDrive - Government of Ontario\\Desktop\\OAP-2139\\report.xlsx");
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
	
	public static void addHyperLinkToACell(String excelFilePath) {
	       try {
			 FileInputStream file = new FileInputStream(excelFilePath);
		     XSSFWorkbook wb = new XSSFWorkbook(file);
		     CreationHelper createHelper = wb.getCreationHelper();
		       
		     // Cell Style for hyperlink - Make it underlined Blue
		     CellStyle hlink_style = wb.createCellStyle();
		     Font hlink_font = wb.createFont();
		     hlink_font.setUnderline(Font.U_SINGLE);
		     hlink_font.setColor(IndexedColors.BLUE.getIndex());
		     hlink_style.setFont(hlink_font);
		     
		     Cell cell;
		     //link to a place in this workbook
		     //create a target sheet and cell
		     Sheet screenShotSheet = wb.createSheet("Screenshot Sheets");
		     screenShotSheet.createRow(0).createCell(0).setCellValue("Target Cell"); // the pic will go here
		     
		     cell = screenShotSheet.createRow(3).createCell(4); // the link to the cell will go here.
		     cell.setCellValue("Worksheet Link");
		     Hyperlink link2 = createHelper.createHyperlink(HyperlinkType.DOCUMENT);
		     link2.setAddress("'Target Sheet'!A1");
		     cell.setHyperlink(link2);
		     cell.setCellStyle(hlink_style);
		     
		     
			   FileOutputStream fileOut = null;
			   fileOut = new FileOutputStream("C:\\Users\\FaiziAd\\OneDrive - Government of Ontario\\Desktop\\OAP-2139\\report.xlsx");
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
	
	public static void addImageToACell(XSSFWorkbook wb, XSSFSheet newSheet) {
		try {

			   //FileInputStream obtains input bytes from the image file
			   InputStream inputStream = new FileInputStream(new File("C:\\Users\\FaiziAd\\OneDrive - Government of Ontario\\Desktop\\OAP-2139\\1.png"));
			   //Get the contents of an InputStream as a byte[].
			   byte[] bytes = IOUtils.toByteArray(inputStream);
			   //Adds a picture to the workbook
			   int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
			   //close the input stream
			   inputStream.close();
			   //Returns an object that handles instantiating concrete classes
			   CreationHelper helper = wb.getCreationHelper();
			   //Creates the top-level drawing patriarch.
			   Drawing drawing = newSheet.createDrawingPatriarch();

			   //Create an anchor that is attached to the worksheet
			   ClientAnchor anchor = helper.createClientAnchor();

			   anchor.setCol1(0); //Column B
			   anchor.setRow1(7); //Row 3
			   anchor.setCol2(6); //Column C
			   anchor.setRow2(12); //Row 4
			   
			   //Creates a picture
			   Picture pict = drawing.createPicture(anchor, pictureIdx);

			   //Reset the image to the original size
			   //pict.resize(); //don't do that. Let the anchor resize the image!

			   //Create the Cell B3
			   XSSFRow row = newSheet.createRow(1);
			   Cell cell = row.createCell(1);

			   //set width to n character widths = count characters * 256
			   //int widthUnits = 20*256;
			   //sheet.setColumnWidth(1, widthUnits);

			   //set height to n points in twips = n * 20
			   //short heightUnits = 60*20;
			   //cell.getRow().setHeight(heightUnits);

			   //Write the Excel file
			   FileOutputStream fileOut = null;
			   fileOut = new FileOutputStream("C:\\Users\\FaiziAd\\OneDrive - Government of Ontario\\Desktop\\OAP-2139\\output.xlsx");
			   wb.write(fileOut);
			   fileOut.close();
			   System.out.println("DONE");
			  } 
			  catch (IOException ioex) {
			  }
	}
	
}
