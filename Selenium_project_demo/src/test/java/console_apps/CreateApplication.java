package console_apps;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Excel_Handlers.ExcelDataByRowColIndex;
import Regresstion_testing.ClientDriver;

public class CreateApplication {

	public static void main(String[] args) {
		  String input = "";
		 
		  ClientDriver client = new ClientDriver();
		  client.launchOACIS();

		  while(!input.toUpperCase().equals("E") || !input.toUpperCase().equals("C")) {
			  Scanner reader = new Scanner(System.in);
			  System.out.println("How do you want to enter the client information? (E for EXCEL or C for CONSOLE)");
			  input = reader.nextLine();
			  if (input.toUpperCase().equals("E")) {
					 /* Reading from an Excel file */
				  
				  System.out.println("Enter the Excel fileName you want to read from: ");
				  String excelFileName = reader.nextLine();
				  excelFileName += ".xlsx";
				  // TBD: Implement a loop to enter all client information
				  
				  int rowNum = 1;
				  String clientLastName = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 0);

				  while (!clientLastName.equals("DONE")) {
					  clientLastName = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 0);
					  client.searchForClientThroughSideBar(clientLastName);
					  client.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
					  client.getDriver().findElement(By.className("GridRow1")).click(); // clicks the first client that appears
					  
					  String applicantFN = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 1);
					  String applicantLN = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 2);
					  String dob = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 3);
					  String unitNum = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 4);
					  String streetNum = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 5);
					  String streetName = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 6);
					  String city = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 7);
					  String postalCode = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 8);
					  String intakeProcess = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 9);
					  String applicantType = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 10);

					  client.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					  client.createNewApplication();
					  Map<String, String> contactObj = new HashMap<String, String>();
					  contactObj.put("applicantFirstName", applicantFN);
					  contactObj.put("applicantLastName", applicantLN);
					  contactObj.put("unitNum", unitNum);
					  contactObj.put("streetNum", streetNum);
					  contactObj.put("streetName", streetName);
					  contactObj.put("city", city);
					  contactObj.put("postalCode", postalCode);
					  
					  client.fillUpContactTab(contactObj);
					  
					// Select the intake process
					  client.getDriver().findElement(By.id("ctlAppContent_lbIntakeTab")).click();
					  client.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					  WebElement intakeProcessDropdown = client.getDriver().findElement(By.id("ctlAppContent_ddlIntakeProcess")); // Intake process
					  String originalWindow = client.getDriver().getWindowHandle();
					  SelectOption(intakeProcess, intakeProcessDropdown, originalWindow, client.getDriver());

					  // Select the applicant type
					  client.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					  WebElement appTypeDropdown = client.getDriver().findElement(By.cssSelector("#ctlAppContent_panelIntakeSection1 table #ctlAppContent_ddlAppType")); // Intake process	  
					  SelectOption(applicantType, appTypeDropdown, originalWindow, client.getDriver());
					  client.getDriver().findElement(By.id("ctlStandardOperations_lnkSave")).click();
					  
					  rowNum ++;
					  clientLastName = ExcelDataByRowColIndex.GetDataFromExcel(excelFileName, rowNum, 0);
				  	}
			      System.out.println("===========>>>>>> ALL APPLICATIONS WERE SUCCESSFULLY CREATED!!!");
				  reader.close();
				  break;
			  }
			  else if (input.toUpperCase().equals("C")) {
				  
				  System.out.println("Enter the Client's Last Name: ");
				  String clientLastName = reader.nextLine();
				  
				  client.searchForClientByLastName(clientLastName); 
				  client.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
				  client.getDriver().findElement(By.className("GridRow1")).click(); // clicks the first client that appears
				  
				  	/* Getting inputs from console. */
				  System.out.println("Applicant Last Name: ");
				  String lastNameInput = reader.nextLine();
				  
				  System.out.println("Applicant First Name: ");
				  String firstNameInput = reader.nextLine();
				  
				  System.out.println("Now please enter the *Home Address* if necessary.");
				  System.out.println("Unit Number: ");
				  String unitNum = reader.nextLine();
				  
				  
				  System.out.println("Street Number: ");
				  String streetNum = reader.nextLine();
				  
				  System.out.println("Street Name: ");
				  String streetName = reader.nextLine();
				  
				  System.out.println("City: ");
				  String city = reader.nextLine();
				  
				  System.out.println("Postal Code: ");
				  String postalCode = reader.nextLine();
				    
				  client.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				    
				    // 4. User clicks "Applications" and then "New"
			      client.createNewApplication();
				  
				  Map<String, String> contactObj = new HashMap<String, String>();
				  contactObj.put("applicantFirstName", firstNameInput);
				  contactObj.put("applicantLastName", lastNameInput);
				  contactObj.put("unitNum", unitNum);
				  contactObj.put("streetNum", streetNum);
				  contactObj.put("streetName", streetName);
				  contactObj.put("city", city);
				  contactObj.put("postalCode", postalCode);
				  
				  client.fillUpContactTab(contactObj);
				  
				  
				  // Select the intake process
				  client.getDriver().findElement(By.id("ctlAppContent_lbIntakeTab")).click();
				  client.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				  WebElement intakeProcessDropdown = client.getDriver().findElement(By.id("ctlAppContent_ddlIntakeProcess")); // Intake process
				  String originalWindow = client.getDriver().getWindowHandle();
				  System.out.println("Intake Process:");
				  String intakeProccess = reader.nextLine();
				  SelectOption(intakeProccess, intakeProcessDropdown, originalWindow, client.getDriver());

				  // Select the applicant type
				  client.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				  WebElement appTypeDropdown = client.getDriver().findElement(By.cssSelector("#ctlAppContent_panelIntakeSection1 table #ctlAppContent_ddlAppType")); // Intake process
				  System.out.println("Applicant Type:");
				  String applicantType = reader.nextLine();				  
				  SelectOption(applicantType, appTypeDropdown, originalWindow, client.getDriver());
				  client.getDriver().findElement(By.id("ctlStandardOperations_lnkSave")).click();
				  reader.close();
				  
				  System.out.println("The application was succeffully created for " + clientLastName);
				  break;
			  }
		  }
	}
	
	/* Helper method */
	/* Given a drop-down web-element with a text option, it selects the option in the drop-down */
	public static void SelectOption(String optionText, WebElement selectElement, String originalWindow, WebDriver driver) {
		Actions action = new Actions(driver);//Create an object to store a chain of keypresses
		selectElement.click();//cause the select element to be highlighted
		Select foundSelect = new Select(selectElement);//convert webelement to select element

		List<WebElement> selectOptions = foundSelect.getOptions();//get select options
		String iOptionValue;
		for (int i = 0; i < selectOptions.size(); i++) {//cycle through all the options in the dropdown, compare them to desired value
		
			iOptionValue = selectOptions.get(i).getText();
			if (!iOptionValue.equals(optionText)) {
				action.sendKeys(Keys.DOWN);//if not matching, add a 'arrow down' keypress to the chain of key presses to cause the next option to be highlighted
			}
			else {
				action.sendKeys(Keys.TAB);//if matching, tab out of the select element, to allow the curerntly highlighted option to be the selected option
				break;
			}
		}
		action.build().perform();//perform the chain of keypresses

		driver.switchTo().window(originalWindow);  //selecting an option causes focus to be lost from the current window - must switch focus back to browser window
									//Requires having already saved the browser window handle somewhere after browser window is initialized - found using driver.CurrentWindowHandle 
	}
}