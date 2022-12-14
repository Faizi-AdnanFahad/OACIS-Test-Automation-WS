package Regresstion_testing;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import CustomExceptions.OacisNotLaunched;
import net.bytebuddy.asm.Advice.Origin;

public class ClientDriver {
	  
	  private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  
	public ClientDriver() {
		driver = DriverFactory.CreateIEDriverManually();
		driver.manage().window().setSize(new Dimension(1920, 1080));
	    // js = (JavascriptExecutor) driver; //Required if driver is created using DriverManager
	    // vars = new HashMap<String, Object>(); //Required if driver is created using DriverManager
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void launchOACIS() throws OacisNotLaunched {
//		 System.out.println("**********************************************************");
//		 System.out.println("Launching the Oacis website...");
		 driver.get("http://intra.stage.oacis.children.gov.on.ca/Main.aspx"); // User should be able to access OACIS page
		if (!driver.getCurrentUrl().equals("http://intra.stage.oacis.children.gov.on.ca/Main.aspx")) {
			throw new OacisNotLaunched("Unable to launch OACIS.");
		}

	}
	

	public void searchForClientByLastName(String lastNameInput) {
		 driver.findElement(By.id("ctlPrimaryNav_lnkClient")).click(); // User clicks on the "Client" tab
		 driver.findElement(By.id("ctlPrimaryNav_lnkClient")).click(); // User clicks on the "Client" tab
		 driver.findElement(By.id("ctlClientSearch_txtName")).click();
		 driver.findElement(By.id("ctlClientSearch_txtName")).sendKeys(lastNameInput); // User searches for client name
		 driver.findElement(By.id("ctlClientSearch_lnkSearch")).click();	   
	}
	
	public void searchForClientThroughSideBar(String lastNameInput) {
		 driver.findElement(By.id("ctlQueryBox_txtQuery")).sendKeys(lastNameInput); // User searches for client name
		 driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[1]/div[1]/img")).click();	   
	}
	
	/* Given last name, first name and date of birth, creates a client in OACIS */
	public void createClient(String lastNameInput, String firstNameInput, String dobInput) {
	        /*
			 * Creates a client
			 */
 	 	   System.out.println("Creating new client...");
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.findElement(By.id("ctlClientContent_txtLastName")).click();
		    driver.findElement(By.id("ctlClientContent_txtLastName")).sendKeys(lastNameInput);
		    driver.findElement(By.id("ctlClientContent_txtFirstName")).sendKeys(firstNameInput);
		    driver.findElement(By.id("ctlClientContent_ctlDob_txtDate")).click();
		    driver.findElement(By.id("ctlClientContent_ctlDob_txtDate")).sendKeys(dobInput);
		    driver.findElement(By.id("ctlStandardOperations_lnkSave")).click();

			 System.out.println("Client is successfully created!");
			 System.out.println("**********************************************************");
			 // TBD Duplicate Checking Once the main objective (Regression Testing is automated)
//		     System.out.println("Performing a duplicate check...");
//			 boolean duplicateExists = duplicateExists(firstNameInput, lastNameInput, dobInput);
//		     if (!duplicateExists) {
//			 }
//			 else {
//				 // Client already exists
//				 System.out.println("Client already exists in OACIS.");
//			 }
	}
	
	public void createNewApplication() {
		System.out.println("Creating a new application...");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.findElement(By.id("ctlPageNav_lnkApplications")).click();
	    driver.findElement(By.id("ctlStandardOperations_lnkNew")).click(); // User clicks "Applications" and then "New"
	    System.out.println("New application is being created...");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void fillUpContactTab(Map<String, String> contactInfo) {
		driver.findElement(By.id("ctlAppContent_lbContactsTab")).click();
	    driver.findElement(By.id("ctlAppContent_txtApplicantLastName")).click();
	    driver.findElement(By.id("ctlAppContent_txtApplicantLastName")).sendKeys(contactInfo.get("applicantLastName"));
	    driver.findElement(By.id("ctlAppContent_txtApplicantFirstName")).click();
	    driver.findElement(By.id("ctlAppContent_txtApplicantFirstName")).sendKeys(contactInfo.get("applicantFirstName"));
	    driver.findElement(By.id("ctlAppContent_txtApplicantUnit")).click();
	    driver.findElement(By.id("ctlAppContent_txtApplicantUnit")).sendKeys(contactInfo.get("unitNum"));
	    driver.findElement(By.id("ctlAppContent_txtApplicantStreetNumber")).click();
	    driver.findElement(By.id("ctlAppContent_txtApplicantStreetNumber")).sendKeys(contactInfo.get("streetNum"));
	    driver.findElement(By.id("ctlAppContent_txtApplicantStreet")).click();
	    driver.findElement(By.id("ctlAppContent_txtApplicantStreet")).sendKeys(contactInfo.get("streetName"));
	    driver.findElement(By.id("ctlAppContent_txtApplicantCity")).click();
	    driver.findElement(By.id("ctlAppContent_txtApplicantCity")).sendKeys(contactInfo.get("city"));
	    driver.findElement(By.id("ctlAppContent_txtApplicantPostalCode")).click();
	    driver.findElement(By.id("ctlAppContent_txtApplicantPostalCode")).sendKeys(contactInfo.get("postalCode"));
	    System.out.println("All contact information was entered!");
	    System.out.println("**********************************************************");
	}
	
	  public void takeSnapShot(WebDriver webdriver,String fileWithPath) {
		  //Convert web driver object to TakeScreenshot
		  TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		  //Call getScreenshotAs method to create image file
		  File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		  //Move image file to new destination
		  File DestFile = new File(fileWithPath);
		  //Copy file at destination
		  try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	
	
	/*==============================================TBD============================================================*/
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
		/*==========================================================================================================*/

}