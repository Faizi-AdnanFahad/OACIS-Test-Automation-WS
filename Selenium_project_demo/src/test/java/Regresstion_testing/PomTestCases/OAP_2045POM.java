package Regresstion_testing.PomTestCases;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Regresstion_testing.ClientDriver;
import Regresstion_testing.PageObjectModels.ClientPageModel;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.BankingTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.BudgetTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.ContactTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.IntakeTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.PriorityServiceTab;

public class OAP_2045POM {
	  private WebDriver driver;
	  private String originalWindow;  // stores the original window. Useful to shift back to it when changing the focus of the window to drop-down list or similar things.
	  private ClientDriver cd;
	  
	@Before
	public void setUp() {
		cd = new ClientDriver();
		driver = cd.getDriver();
		originalWindow = driver.getWindowHandle();
	}
	
	@Test
	public void test() { // TBD - Home and Mailing Address Condition
		final String SCREENSHOTPATH = System.getProperty("user.dir") + "\\Screenshots\\OAP_2045\\"; // use 'Temp' directory if you do not want to override the old screenshots
		String clientLastName = "ashley jj";
		
		// Contact Tab
		// Applicant Information
		String applicantLastName = "Amanda";
		String applicantFirstName = "Martinez";
		String applicantDOB = "04-Apr-1970";
		String refNum = "54223";
		// Home Address
		String unitNum = "20";
		String streetNum = "100";
		String streetName = "Main Street";
		String city = "Toronto";
		String province = "Ontario";
		String postalCode = "M3K 3H5";
		
		// Intakes Tab
		String intakeProccess = "Determination of Needs";
		String applicantType = "Pilot";
		// Set 'authorization to true, if the authorization is required and assign values to the authorization related field accordingly.'
		String appRecievedDate = "04-Jun-2019";
		String informationLetterDate = "05-Mar-2019";
		String proofOfAge = "Passport";
		String proofOfResidency = "Ontario Driver License";
		String consentProvidedBy = "Both";
		String dateOfConsent = "06-Nov-2019";
		String appCompletedDate = "25-Feb-2020";
		
		// 1. User navigates to OACIS --> User should be able to access OACIS page
		cd.launchOACIS();
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_1.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to access OACIS page \u2713");
		System.out.println("-----------------------------------");
		
		// 2. User clicks the "client" page --> User should be able to view client search page
		ClientPageModel clientPage = new ClientPageModel(driver);
		clientPage.ClickClientLnk();
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_2.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to view client search page \u2713");
		System.out.println("-----------------------------------");
		
		// 3. User searches for client name --> User should be able to enter keywords to find a matching record
		clientPage.FillNameTxtFld(clientLastName);
		clientPage.GetSearchLnk().click();
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_3.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to enter keywords to find a matching record \u2713");
		System.out.println("-----------------------------------");

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    // 4. User clicks on the client --> User should see the client page with their details
	    driver.findElement(By.className("GridRow1")).click(); 
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_4.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to see the client page with their details \u2713");
		System.out.println("-----------------------------------");

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    // 5. User clicks "Applications" and then "New" --> User should be able to see the application and all the tabs
	    cd.createNewApplication();
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_5.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to see the application and all the tabs \u2713");
		System.out.println("-----------------------------------");

//	     Clicks on Contacts tab
		driver.findElement(By.id("ctlAppContent_lbContactsTab")).click();
		
	    // 6. User inputs all required fields in "Contacts" tab and clicks "Save" --> User should be able to successfully save after completing fields in "Contacts" tab
		ContactTab contactTab = new ContactTab(driver);
		contactTab.FillApplicantLastNameTxtFld(applicantLastName);
		contactTab.FillApplicantFirstNameTxtFld(applicantFirstName);
		contactTab.FillApplicantDob_txtDateTxtFld(applicantDOB);
		contactTab.FillApplicantUnitTxtFld(unitNum);
		contactTab.FillApplicantStreetNumberTxtFld(streetNum);
		contactTab.FillApplicantStreetTxtFld(streetName);
		contactTab.FillApplicantCityTxtFld(city);
		contactTab.SelectOptionApplicantProvinceSelect(driver, this.originalWindow, province);
		contactTab.FillApplicantPostalCodeTxtFld(postalCode);
		contactTab.FillReferenceNumberTxtFld(refNum);
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_6.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to successfully save after completing fields in \"Contacts\" tab \u2713");
		System.out.println("-----------------------------------");
		
		// clicks on intake tab
	    driver.findElement(By.id("ctlAppContent_lbIntakeTab")).click();
	    // 7. User inputs all required fields in "Intake" tab and clicks "Save" --> User should be able to confirm that "Intake" tab matches 
	    IntakeTab intakeTab = new IntakeTab(driver);
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_7p1.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to confirm that \"Intake\" tab matches  \u2713");
		System.out.println("-----------------------------------");

	    // 8. User clicks on the "Intake Process" dropdown --> User confirms "Determination of Needs Pilot" is selected in the dropdow
	    // 9. User clicks on "Determination of Needs" as Intake Process --> User successfully selects "Determination of Needs Pilot" as Intake Process
	    intakeTab.SelectOptionIntakeProcessSelect(driver, this.originalWindow, intakeProccess);
	    
	    // 10. User clicks on the "Applicant Type" dropdown --> Confirm "Pilot" is added in the dropdown
	    // 11. User clicks on "Pilot" as Applicant Type --> User successfully selects "Pilot" as Applicant Type
	    intakeTab.SelectOptionAppTypeSelect(driver, this.originalWindow, applicantType);
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_8-11.png");
		System.out.println("-----------------------------------");
		System.out.println("\"Determination of Needs Pilot\" is selected in the dropdow  \u2713");
		System.out.println("\"Pilot\" is added in the dropdow  \u2713");
		System.out.println("-----------------------------------");

	    // 12. User enters all other information, checks consent checkboxes and clicks save --> User should successfully save all the entered information
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    intakeTab.SelectOptionAgeProofSelect(driver, this.originalWindow, proofOfAge);
	    intakeTab.SelectOptionResidencyProofSelect(driver, this.originalWindow, proofOfResidency);
	    intakeTab.SelectOptionConsentSelect(driver, this.originalWindow, consentProvidedBy);
	    intakeTab.FillInformationLetterDate_txtDateTxtFld(informationLetterDate);
	    intakeTab.FillConsentDate_txtDateTxtFld(dateOfConsent);
	    cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_12.png");
		System.out.println("-----------------------------------");
		System.out.println("\"User should successfully save all the entered information \u2713");
		System.out.println("-----------------------------------");
		
	    // 7. User clicks on Intake tab and fills in "Application Received Date" --> User should be able to confirm that "Intake" tab matches
	    intakeTab.FillApplicationReceivedDate_txtDateTxtFld(appRecievedDate);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	    driver.findElement(By.id("ctlAppContent_chkDiagnosisProof")).click(); // Proof of Diagnosis Checkbox clicked;
	    driver.findElement(By.id("ctlAppContent_chkConsent")).click(); // Consent Checkbox clicked;
	    
	    // 12. User enters "Application Completed Date" in "Intake" tab --> User should successfully save all the entered information
	    intakeTab.FillApplicationCompletedDate_txtDateTxtFld(appCompletedDate);
	    cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_7p2.png");
		System.out.println("-----------------------------------");
		System.out.println("\"User should successfully save all the entered information \u2713");
		System.out.println("-----------------------------------");

	    // 13, User clicks on the "Save" button in the side tab --> User should see the new childhood budget application showing up in the application list
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	    intakeTab.GetSaveLnk().click();
	    String intakeProcessAfter = driver.findElement(By.xpath("//*[@id=\"ctlAppList_dgdClientApps__ctl2_IntakeType\"]")).getText();
	    assertTrue(intakeProcessAfter.equals(intakeProccess));
	    String applicantTypeAfter = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[2]/td[3]/span")).getText();
	    assertTrue(applicantTypeAfter.equals(applicantType));
	    cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_13.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to see the new DoN Pilot application showing up in the application list \u2713");
		System.out.println("-----------------------------------");

	    System.out.println("**************************");
	    System.out.println("Regression Test Case PASSED! - Create new application - Standard New ");
	    System.out.println("**************************");
	}
}
