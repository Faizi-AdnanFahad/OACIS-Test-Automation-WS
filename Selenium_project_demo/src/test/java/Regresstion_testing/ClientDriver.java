package Regresstion_testing;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClientDriver {
	  
	  private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  
	public ClientDriver() {
		driver = DriverFactory.CreateIEDriverManually();
	    // js = (JavascriptExecutor) driver; //Required if driver is created using DriverManager
	    // vars = new HashMap<String, Object>(); //Required if driver is created using DriverManager
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void launchOACIS() {
		 System.out.println("Launching the Oacis website...");
		 driver.get("http://intra.stage.oacis.children.gov.on.ca/Main.aspx"); // User should be able to access OACIS page
	}
	

	public void searchForClientByLastName(String lastNameInput) {
		 driver.findElement(By.id("ctlPrimaryNav_lnkClient")).click(); // User clicks on the "Client" tab
		 driver.findElement(By.id("ctlPrimaryNav_lnkClient")).click(); // User clicks on the "Client" tab
		 driver.findElement(By.id("ctlClientSearch_txtName")).click();
		 driver.findElement(By.id("ctlClientSearch_txtName")).sendKeys(lastNameInput); // User searches for client name
		 driver.findElement(By.id("ctlClientSearch_lnkSearch")).click();	   
	}
	
	public void createClient(String lastNameInput, String firstNameInput, String dobInput) {
	     System.out.println("Performing a duplicate check...");
	     boolean duplicateExists = duplicateExists(firstNameInput, lastNameInput, dobInput);
	     if (!duplicateExists) {
			 	/*
				 * Creates a client
				 */
	    	 	System.out.println("Creating new client...");

			    driver.findElement(By.id("ctlStandardOperations_lnkNew")).click(); // User clicks on "New" on the side tab
			    
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
			    driver.findElement(By.id("ctlClientContent_txtLastName")).sendKeys(lastNameInput);
			    driver.findElement(By.id("ctlClientContent_txtFirstName")).sendKeys(firstNameInput);
			    driver.findElement(By.id("ctlClientContent_ctlDob_txtDate")).click();
			    driver.findElement(By.id("ctlClientContent_ctlDob_txtDate")).sendKeys(dobInput);
			    driver.findElement(By.id("ctlStandardOperations_lnkSave")).click();
			    driver.findElement(By.id("ctlStandardOperations_lnkSave")).click();

				 System.out.println("Client is successfully created!");
		 }
		 else {
			 // Client already exists
			 System.out.println("Client already exists in OACIS.");
		 }
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
	  
	  
	  /* Helper Method for 'duplicate exists '*/
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

	  
	  /* Helper Method for 'duplicate exists '*/
	  /* Returns true if the data between OACSIS matches the data in EXCEL*/
	  public boolean dobMatches(String dobOACIS, String dobExcel) {
		  // Indexed according to this 
		  // 01-Dec.-2022
		  // 01234567891011
		  String dayExcel = ""; 
		  String monthExcel = "";
		  String yearExcel = "";
		  if (dobExcel.charAt(1) == '-') {
			  dayExcel = "0" + dobExcel.charAt(0); 
			  monthExcel = dobExcel.substring(2, 5);
			  yearExcel = dobExcel.substring(6, dobExcel.length());
		  }
		  else {
			  dayExcel = dobExcel.substring(0, 2);
			  monthExcel = dobExcel.substring(3, 6);
			  yearExcel = dobExcel.substring(9, dobExcel.length());
		  }
		  
		  String dayOACIS = dobOACIS.substring(0, 2);
		  String monthOACIS = dobOACIS.substring(3, 6);
		  String yearOACIS = dobOACIS.substring(9, dobOACIS.length());		  
		  
		  return dayExcel.equals(dayOACIS) && monthExcel.equals(monthOACIS) && yearExcel.equals(yearOACIS);
	  }
}