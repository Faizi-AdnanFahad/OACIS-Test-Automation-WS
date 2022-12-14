// Generated by Selenium IDE
package backups;
// testr
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.internal.Console;

import Excel_Handlers.ExcelDataByRowColIndex;
import Regresstion_testing.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CreateNewClient {
  
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  String lastNameInput;
  String firstNameInput;
  String dobInput;
  
  @Before
  public void setUp() {
	driver = DriverFactory.CreateIEDriverManually();
    // js = (JavascriptExecutor) driver; //Required if driver is created using DriverManager
    // vars = new HashMap<String, Object>(); //Required if driver is created using DriverManager
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	  
  }
  
  @After
  public void tearDown() {
//    driver.quit();
  }
  
  @Test
  public void oAP2041() {
	 
	  this.setInputOption();
	  

     System.out.println("Launching the Oacis website...");
     driver.get("http://intra.stage.oacis.children.gov.on.ca/Main.aspx"); // User should be able to access OACIS page
     driver.findElement(By.id("ctlPrimaryNav_lnkClient")).click(); // User clicks the "client" page 
     driver.findElement(By.id("ctlClientSearch_txtName")).click();
     driver.findElement(By.id("ctlClientSearch_txtName")).sendKeys(this.lastNameInput); // User searches for client name
     driver.findElement(By.id("ctlClientSearch_lnkSearch")).click();	    
     
     System.out.println("Performing a duplicate check...");
     boolean duplicateExists = duplicateExists(this.firstNameInput, this.lastNameInput, dobInput);
     System.out.println("Duplicate exists? -->" +duplicateExists);
	 if (!duplicateExists) {
		 	/*
			 * Creates a client
			 */
    	 	System.out.println("Creating new client...");

		    driver.findElement(By.id("ctlStandardOperations_lnkNew")).click();
		    
		    WebElement transitionCode = driver.findElement(By.id("ctlClientContent_txtIIO_TransitionCode"));
		    WebElement regDate = driver.findElement(By.id("ctlClientContent_txtRegistrationDate"));
		    WebElement lastName = driver.findElement(By.id("ctlClientContent_txtLastName"));
		    WebElement firstName = driver.findElement(By.id("ctlClientContent_txtFirstName"));
		    WebElement middleName = driver.findElement(By.id("ctlClientContent_txtMiddleName"));
		    WebElement dob = driver.findElement(By.id("ctlClientContent_ctlDob_txtDate"));
		    WebElement donID = driver.findElement(By.id("ctlClientContent_ctlDoNInvitationDate_txtDate"));
		    WebElement iioInvitationSentDate = driver.findElement(By.id("ctlClientContent_txtIIO_InvitationSentDate"));
		    WebElement iioDosierDate = driver.findElement(By.id("ctlClientContent_txtIIO_DossierSentDate"));
		    WebElement consentProviderName = driver.findElement(By.id("ctlClientContent_txtConsentProviderName"));
		    WebElement cftDeclinedDate = driver.findElement(By.id("ctlClientContent_DateFieldNoTransferConfirmedDate_txtDate"));
		    WebElement comment = driver.findElement(By.id("ctlClientContent_txtComment"));

		    WebElement[] webpageElements = {transitionCode, regDate, lastName, firstName, middleName, dob, donID, iioInvitationSentDate, iioDosierDate, consentProviderName, cftDeclinedDate,
		    		comment};
		    
		    // Checks that when creating a new client, all fields in the form are empty. (User should be able to see a blank client page form to fill out)
		    for (int i = 0; i < webpageElements.length; i ++) {
		    	WebElement webElement = webpageElements[i];
		    	assertTrue(webElement.getAttribute("value") == ""); // User should be able to see a blank client page form to fill out
		    }

		    
		    // User should be able to fill out the requested fields on client page.
	    	System.out.println("Entering client's information in OACIS...");
		    driver.findElement(By.id("ctlClientContent_txtLastName")).click();
		    driver.findElement(By.id("ctlClientContent_txtLastName")).sendKeys(this.lastNameInput);
		    driver.findElement(By.id("ctlClientContent_txtFirstName")).sendKeys(this.firstNameInput);
		    driver.findElement(By.id("ctlClientContent_ctlDob_txtDate")).click();
		    driver.findElement(By.id("ctlClientContent_ctlDob_txtDate")).sendKeys(this.dobInput);
		    driver.findElement(By.id("ctlStandardOperations_lnkSave")).click();
		    
		    // User should be able to view the saved client information with the updated time at the bottom
		    WebElement updatedLabel = driver.findElement(By.id("ctlClientContent_lblUpdated"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	  
//		    assertTrue(updatedLabel.isDisplayed());
			 System.out.println("Client is successfully created!");
	 }
	 else {
		 // Client already exists
		 System.out.println("Client already exists in OACIS.");
	 }
  }
  
  /* Gives the client two option to enter data. Excel or manually from console. */
  public void setInputOption() {
	  String input = "";
	  while(!input.toUpperCase().equals("E") || !input.toUpperCase().equals("C")) {
		  Scanner reader = new Scanner(System.in);
		  System.out.println("How do you want to enter the client information? (E for EXCEL or C for CONSOLE)");
		  input = reader.nextLine();
		  if (input.toUpperCase().equals("E")) {
				 /* Reading from an Excel file */
			  this.lastNameInput = ExcelDataByRowColIndex.GetDataFromExcel("ClientListDemo.xlsx", 1, 0);
			  this.firstNameInput = ExcelDataByRowColIndex.GetDataFromExcel("ClientListDemo.xlsx", 1, 1);
			  this.dobInput = ExcelDataByRowColIndex.GetDataFromExcel("ClientListDemo.xlsx", 1, 2); // The format should be DD-MM-YYYY
			  reader.close();
			  break;
		  }
		  else if (input.toUpperCase().equals("C")) {
			  	/* Getting inputs from console. */
			  System.out.println("Client Last Name: ");
			  this.lastNameInput = reader.nextLine();
			  
			  System.out.println("Client First Name: ");
			  this.firstNameInput = reader.nextLine();
			  
			  System.out.println("Client DOB: ");
			  this.dobInput = reader.nextLine();
			  reader.close();
			  break;
		  }
	  }
  }
  
  /* Parses a full-name to get the index of comma. Useful for extracting first name and last name from full name. */
  public int getCommaIndex(String fullName) {
	  int commaIndex = -1;
	  for (int i = 0; i < fullName.length(); i ++) {
		  char letter = fullName.charAt(i);
		  if (letter == ',') {
			  commaIndex = i;
			  break;
		  }
	  }
	  return commaIndex;
  }
  
  /* returns true if a proposed client's first name, last name and DOB matches one in OACIS. */
  public boolean duplicateExists(String firstNameExcel, String lastNameExcel, String dobExcel) {
	  boolean atLeastOneResultFound = !driver.findElements(By.className("GridHeader")).isEmpty();
	     boolean nameAndDOBMatches = false;
	     
	     if (atLeastOneResultFound) {
	    	 WebElement resultFullName = driver.findElement(By.cssSelector(".GridRow1 td:first-child span")); // contains both first and last names. Needs to be parsed
	    	 WebElement dob = driver.findElement(By.cssSelector(".GridRow1 td:nth-child(4) span")); // contains Date of birth
	    	 
	    	 boolean doesDOBMatches = dobMatches(dob.getText(), dobExcel);
	    	 
	    	 int commaIndex =  getCommaIndex(resultFullName.getText());
	    	 String resultsLastname = resultFullName.getText().substring(0, commaIndex);
	    	 String resultsFirstname = resultFullName.getText().substring(commaIndex + 2, resultFullName.getText().length());
	    	 
	    	 nameAndDOBMatches = resultsLastname.equals(lastNameExcel) && resultsFirstname.equals(firstNameExcel) && doesDOBMatches;
	     }
	     
	     boolean duplicateExists = atLeastOneResultFound && nameAndDOBMatches;
	     return duplicateExists;
  }
  
  /* Returns true if the data between OACSIS matches the data in EXCEL*/
  public boolean dobMatches(String dobOACIS, String dobExcel) {
	  // Indexed according to this
	  // 01-Dec.-2022
	  // 01234567891011
	  String dayExcel = dobExcel.substring(0, 2);  
	  String monthExcel = dobExcel.substring(3, 6);
	  String yearExcel = dobExcel.substring(8, dobExcel.length());
	  
	  String dayOACIS = dobOACIS.substring(0, 2);
	  String monthOACIS = dobOACIS.substring(3, 6);
	  String yearOACIS = dobOACIS.substring(7, dobOACIS.length());		  
	  
	  return dayExcel.equals(dayOACIS) && monthExcel.equals(monthOACIS) && yearExcel.equals(yearOACIS);
  }
}
