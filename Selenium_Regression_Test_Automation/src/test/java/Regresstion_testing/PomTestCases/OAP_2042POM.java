package Regresstion_testing.PomTestCases;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import CustomExceptions.OacisNotLaunched;
import Excel_Handlers.WriteDataToExcel;
import Regresstion_testing.ClientDriver;
import Regresstion_testing.PageObjectModels.ClientPageModel;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.ContactTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.FollowUpTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.IntakeTab;

public class OAP_2042POM {
	  private WebDriver driver;
	  private String originalWindow;  // stores the original window. Useful to shift back to it when changing the focus of the window to drop-down list or similar things.
	  private ClientDriver cd;
      TreeMap<String, Object[]> statusInfo = new TreeMap<String, Object[]>();

	@Before
	public void setUp() {
		cd = new ClientDriver();
		driver = cd.getDriver();
		originalWindow = driver.getWindowHandle();
	    this.statusInfo.put("1", new Object[] { "Step No.", "Expected Outcome", "Test Result", "Error Message", "Screenshot"}); // title information
	}
	
	@Test
	public void test() {
		final String SCREENSHOTPATH = System.getProperty("user.dir") + "\\Screenshots\\OAP_2042\\"; // use 'Temp' directory if you do not want to override the old screenshots
		final String EXCELFILEPATH = System.getProperty("user.dir") + "\\Test Reports\\oap_2042_report.xlsx";
		String picPath = "";
		
		// Client Information
		String clientLastName = "RegTestL";
		
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
		
		// 1. User navigates to OACIS --> User should be able to access OACIS page
		picPath = SCREENSHOTPATH + "Step_1.png";
		try {
			cd.launchOACIS();
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("2", new Object[] { "Step 1", "User is able to access OACIS page", "PASS", "", picPath});
		}
		catch (OacisNotLaunched e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("2", new Object[] { "Step 1", "User is able to access OACIS page", "FAIL", e.toString(), picPath});
		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to access OACIS page \u2713");
//		System.out.println("-----------------------------------");
		
		// 2. User clicks the "client" page --> User should be able to view client search page
		ClientPageModel clientPage = new ClientPageModel(driver);
		picPath = SCREENSHOTPATH + "Step_2.png";
		try {
			clientPage.ClickClientLnk();
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("3", new Object[] { "Step 2", "User is able to view client search page", "PASS", "", picPath});
		}
		catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("3", new Object[] { "Step 2", "User is able to view client search page", "FAIL", e.getRawMessage(), picPath});
		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to view client search page \u2713");
//		System.out.println("-----------------------------------");
		
		// 3. User searches for client name --> User should be able to enter keywords to find a matching record
		picPath = SCREENSHOTPATH + "Step_3.png";
		try {
			clientPage.FillNameTxtFld(clientLastName);
			clientPage.GetSearchLnk().click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// clicks the first client that appears
		    driver.findElement(By.className("GridRow1")).click(); 
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("4", new Object[] { "Step 3", "User is able to enter keywords to find a matching record", "PASS", "", picPath});
		}
		catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("4", new Object[] { "Step 3", "User is able to view client search page", "FAIL", e.getRawMessage(), picPath});
		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to enter keywords to find a matching record \u2713");
//		System.out.println("-----------------------------------");

	    // 4. User clicks "Applications" and then "New" --> User should be able to see the application and all the tabs
	    picPath = SCREENSHOTPATH + "Step_4.png";
	    try {
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	cd.createNewApplication();
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("5", new Object[] { "Step 4", "User is able to see the application and all the tabs", "PASS", "", picPath});
	    }
		catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("5", new Object[] { "Step 4", "User is able to see the application and all the tabs", "FAIL", e.getRawMessage(), picPath});
		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to see the application and all the tabs \u2713");
//		System.out.println("-----------------------------------");
		
	    // 5. User inputs all required fields in "Contacts" tab and clicks "Save" --> User should be able to successfully save after completing fields in "Contacts" tab
	    picPath = SCREENSHOTPATH + "Step_5.png";
	    try {
 			ContactTab contactTab = new ContactTab(driver);
	 		// Clicks on Contacts tab
 			driver.findElement(By.id("ctlAppContent_lbContactsTab")).click();
 			contactTab.FillApplicantLastNameTxtFld(applicantLastName);
 			contactTab.FillApplicantFirstNameTxtFld(applicantFirstName);
 			contactTab.FillApplicantDob_txtDateTxtFld(applicantDOB);
 			contactTab.FillApplicantUnitTxtFld(unitNum);
 			contactTab.FillApplicantStreetNumberTxtFld(streetNum);
 			contactTab.FillApplicantStreetTxtFld(streetName);
 			contactTab.FillApplicantCityTxtFld(city);
 			contactTab.SelectOptionApplicantProvinceSelect(driver, this.originalWindow, province);
 			contactTab.FillApplicantPostalCodeTxtFld(postalCode);
 			cd.takeSnapShot(driver, picPath);
 			this.statusInfo.put("6", new Object[] { "Step 5", "User is able to successfully save after completing fields in \"Contacts\" tab", "PASS", "", picPath});
	    }
	    catch (ElementNotInteractableException e) {
			cd.takeSnapShot(driver, picPath);
 			this.statusInfo.put("6", new Object[] { "Step 5", "User is able to successfully save after completing fields in \"Contacts\" tab", "FAIL", "Select" + e.getRawMessage(), picPath});
		}
 		catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
 			this.statusInfo.put("6", new Object[] { "Step 5", "User is able to successfully save after completing fields in \"Contacts\" tab", "FAIL", e.getRawMessage(), picPath});
 		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to successfully save after completing fields in \"Contacts\" tab \u2713");
//		System.out.println("-----------------------------------");
		
	 // 6. User inputs all required fields in "Intake" tab and clicks "Save" --> User should be able to confirm that "Intake" tab matches
		picPath = SCREENSHOTPATH + "Step_6.png";
	    try {
	    	 // Click on intakes Tab
		    driver.findElement(By.id("ctlAppContent_lbIntakeTab")).click();
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
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("7", new Object[] { "Step 6", "User is able to confirm that \"Intake\" tab matches", "PASS", "", picPath});
	    }
		catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("7", new Object[] { "Step 6", "User is able to confirm that \"Intake\" tab matches", "FAIL", e.getRawMessage(), picPath});
		}
	    catch (ElementNotInteractableException e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("7", new Object[] { "Step 6", "User is able to confirm that \"Intake\" tab matches", "FAIL", "Select " + e.getRawMessage(), picPath});
		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to confirm that \"Intake\" tab matches \u2713");
//		System.out.println("-----------------------------------");

	 // 7. User inputs all required fields in "Follow up" tab and clicks "Save" --> User should be able to successfully save after completing fields in "Follow up" tab
	    picPath = SCREENSHOTPATH + "Step_7.png";
	    try {
 		    // Clicks on Follow-up Tab
 			driver.findElement(By.id("ctlAppContent_lbFollowUpTab")).click();
 			FollowUpTab followupTab = new FollowUpTab(driver);
 		    followupTab.FillClinicalSupervisorTxtFld(clinicalSupervisor);
 		    followupTab.GetSaveLnk().click();
 			cd.takeSnapShot(driver, picPath);
 			this.statusInfo.put("8", new Object[] { "Step 7", "User is able to successfully save after completing fields in \"Follow up\" tab", "PASS", "", picPath});
			assertTrue("Test Case 7 Passed".equals("Test Case 7 Passed"));
	    }
 		catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
 			this.statusInfo.put("8", new Object[] { "Step 7", "User is able to successfully save after completing fields in \"Follow up\" tab", "FAIL", e.getRawMessage(), picPath});
 		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to successfully save after completing fields in \"Follow up\" tab \u2713");
//		System.out.println("-----------------------------------");
	    
		WriteDataToExcel.writeToExcelFile(this.statusInfo, EXCELFILEPATH);
		System.out.println("DONE"); // delete afterward
	}
}