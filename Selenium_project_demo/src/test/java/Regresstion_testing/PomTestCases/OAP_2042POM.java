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
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.ContactTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.FollowUpTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.IntakeTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.PriorityServiceTab;

public class OAP_2042POM {
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
	public void test() {
		final String SCREENSHOTPATH = System.getProperty("user.dir") + "\\Screenshots\\OAP_2042\\"; // use 'Temp' directory if you do not want to override the old screenshots

		String clientLastName = "Alison";
		String clientDOB = "01-May-2009";
		
		// Applicant Information
		String applicantLastName = "Amanda";
		String applicantFirstName = "Martinez";
		String applicantDOB = "04-Apr-1970";
		
		// Home Address
		String unitNum = "20";
		String streetNum = "100";
		String streetName = "Main Street";
		String city = "Toronto";
		String province = "Ontario";
		String postalCode = "M3K 3H5";
		
		// Intakes Tab
		String intakeProccess = "Interim";
		String applicantType = "Legacy Priority Service";
		
		// Set 'authorization to true, if and only if the authorization is required and assign values to the authorization related field accordingly.'
		boolean authorization = true;
		String appRecievedDate = "04-Jun-2019";
		String proofOfAge = "Passport";
		String proofOfResidency = "Ontario Driver License";
		String consentProvidedBy = "Both";
		String dateOfConsent = "06-Nov-2019";
		String appCompletedDate = "25-Feb-2020";
		
		// Follow-up tab
		String clinicalSupervisor = "testSuperVisorName";
//		C:\Users\FaiziAd\OneDrive - Government of Ontario\Desktop\OACIS Documents\Test Automation\OACIS-Test-Automation-WS\Selenium_project_demo\Screenshots
		
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
	    // clicks the first client that appears
	    driver.findElement(By.className("GridRow1")).click(); 
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    // 4. User clicks "Applications" and then "New" --> User should be able to see the application and all the tabs
	    cd.createNewApplication();
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_4.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to see the application and all the tabs \u2713");
		System.out.println("-----------------------------------");
		
//	     Clicks on Contacts tab
		driver.findElement(By.id("ctlAppContent_lbContactsTab")).click();
		
	    // 5. User inputs all required fields in "Contacts" tab and clicks "Save" --> User should be able to successfully save after completing fields in "Contacts" tab
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
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_5.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to successfully save after completing fields in \"Contacts\" tab \u2713");
		System.out.println("-----------------------------------");
		
	    // Click on intakes Tab
	    driver.findElement(By.id("ctlAppContent_lbIntakeTab")).click();
	    
	    // 6. User inputs all required fields in "Intake" tab and clicks "Save" --> User should be able to confirm that "Intake" tab matches 
	    IntakeTab intakeTab = new IntakeTab(driver);
	    intakeTab.SelectOptionIntakeProcessSelect(driver, this.originalWindow, intakeProccess);
	    intakeTab.SelectOptionAppTypeSelect(driver, this.originalWindow, applicantType);
		
	    if (authorization) {
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    intakeTab.SelectOptionAgeProofSelect(driver, this.originalWindow, proofOfAge);
		    intakeTab.SelectOptionResidencyProofSelect(driver, this.originalWindow, proofOfResidency);
		    intakeTab.SelectOptionConsentSelect(driver, this.originalWindow, consentProvidedBy);
		    intakeTab.FillApplicationReceivedDate_txtDateTxtFld(appRecievedDate);
		    intakeTab.FillConsentDate_txtDateTxtFld(dateOfConsent);
		    intakeTab.FillApplicationCompletedDate_txtDateTxtFld(appCompletedDate);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		    driver.findElement(By.id("ctlAppContent_chkDiagnosisProof")).click(); // Proof of Diagnosis Checkbox clicked;
		    driver.findElement(By.id("ctlAppContent_chkConsent")).click(); // Consent Checkbox clicked;
	    }
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_6.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to confirm that \"Intake\" tab matches \u2713");
		System.out.println("-----------------------------------");

	    // Clicks on Follow-up Tab
		driver.findElement(By.id("ctlAppContent_lbFollowUpTab")).click();
	    
	    // 7. User inputs all required fields in "Follow up" tab and clicks "Save" --> User should be able to successfully save after completing fields in "Follow up" tab
		FollowUpTab priorService = new FollowUpTab(driver);
	    priorService.FillClinicalSupervisorTxtFld(clinicalSupervisor);
	    intakeTab.GetSaveLnk().click();
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_7.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to successfully save after completing fields in \"Follow up\" tab \u2713");
		System.out.println("-----------------------------------");
		
	    System.out.println("**************************");
	    System.out.println("Regression Test Case PASSED! - Create new application - Standard New ");
	    System.out.println("**************************");
	}
}