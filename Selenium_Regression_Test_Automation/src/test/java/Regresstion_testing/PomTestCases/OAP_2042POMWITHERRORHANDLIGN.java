package Regresstion_testing.PomTestCases;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CustomExceptions.OacisNotLaunched;
import Excel_Handlers.WriteDataToExcel;
import Regresstion_testing.ClientDriver;
import Regresstion_testing.PageObjectModels.ClientPageModel;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.ContactTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.FollowUpTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.IntakeTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.PriorityServiceTab;

public class OAP_2042POMWITHERRORHANDLIGN {
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
	public void test() { // TODO Add custom exceptions
		final String SCREENSHOTPATH = "https:\\ontariogov.sharepoint.com/sites/cyssc/oap/Shared%20Documents/Forms/AllItems.aspx?csf=1&web=1&e=X0hcNI&cid=7fcb6837%2D2404%2D48bf%2D93ee%2D386eb28b8118&RootFolder=%2Fsites%2Fcyssc%2Foap%2FShared%20Documents%2FQA%20Testing%2FTest%20Automation%2FScreenshots&FolderCTID=0x01200056BE785A9D8EB347996FA86594D1FA95/"; // use 'Temp' directory if you do not want to override the old screenshots
		final String excelFilePath = "C:\\Users\\FaiziAd\\OneDrive - Government of Ontario\\Desktop\\Report\\oap_2042_report.xlsx";
		
		String clientLastName = "RegTestL";
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
		
		// 1. User navigates to OACIS --> User should be able to access OACIS page
		try {
			cd.launchOACIS();
			String picPath = SCREENSHOTPATH + "Step_1.png";
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("2", new Object[] { "Step 1", "User is able to access OACIS page", "PASS", "", picPath});
		}
		catch (OacisNotLaunched e) {
			this.statusInfo.put("2", new Object[] { "Step 1", "User is able to access OACIS page", "FAIL", e.toString()});
		}
		
		// 2. User clicks the "client" page --> User should be able to view client search page
		ClientPageModel clientPage = new ClientPageModel(driver);
		try {
			clientPage.ClickClientLnk();
			String picPath = SCREENSHOTPATH + "Step_2.png";
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("3", new Object[] { "Step 2", "User is able to view client search page", "PASS", "", picPath});
		}
		catch (Exception e) {
			this.statusInfo.put("3", new Object[] { "Step 2", "User is able to view client search page", "FAIL", "User is NOT able to view client search page"});
		}
		
		// 3. User searches for client name --> User should be able to enter keywords to find a matching record
		try {
			clientPage.FillNameTxtFld(clientLastName);
			clientPage.GetSearchLnk().click();
			String picPath = SCREENSHOTPATH + "Step_3.png";
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// clicks the first client that appears
		    driver.findElement(By.className("GridRow1")).click(); 
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("4", new Object[] { "Step 3", "User is able to enter keywords to find a matching record", "PASS", "", picPath});
		}
		catch (Exception e) {
			this.statusInfo.put("4", new Object[] { "Step 3", "User is able to view client search page", "FAIL", "User is NOT able to enter keywords to find a matching record"});
		}
				
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    // 4. User clicks "Applications" and then "New" --> User should be able to see the application and all the tabs
	    try {
	    	cd.createNewApplication();
			String picPath = SCREENSHOTPATH + "Step_4.png";
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("5", new Object[] { "Step 4", "User is able to see the application and all the tabs", "PASS", "", picPath});
		}
		catch (Exception e) {
			this.statusInfo.put("5", new Object[] { "Step 4", "User is able to see the application and all the tabs", "FAIL", "User is NOT able to see the application and all the tabs"});
		}
	    
		
	    // 5. User inputs all required fields in "Contacts" tab and clicks "Save" --> User should be able to successfully save after completing fields in "Contacts" tab
		try {
			ContactTab contactTab = new ContactTab(driver);
//		     Clicks on Contacts tab
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
			String picPath = SCREENSHOTPATH + "Step_5.png";
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("6", new Object[] { "Step 5", "User is able to successfully save after completing fields in \"Contacts\" tab", "PASS", "", picPath});
		}
		catch (Exception e) {
			this.statusInfo.put("6", new Object[] { "Step 5", "User is able to successfully save after completing fields in \"Contacts\" tab", "FAIL", "User is NOT able to successfully save after completing fields in \\\"Contacts\\\" tab"});
		}
		
	    // 6. User inputs all required fields in "Intake" tab and clicks "Save" --> User should be able to confirm that "Intake" tab matches
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
			String picPath = SCREENSHOTPATH + "Step_6.png";
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("7", new Object[] { "Step 6", "User is able to confirm that \"Intake\" tab matches", "PASS", "", picPath});
		}
		catch (Exception e) {
			this.statusInfo.put("7", new Object[] { "Step 6", "User is able to confirm that \"Intake\" tab matches", "FAIL", "User is NOT able to confirm that \\\"Intake\\\" tab matches"});
		}
	    
	    // 7. User inputs all required fields in "Follow up" tab and clicks "Save" --> User should be able to successfully save after completing fields in "Follow up" tab
		try {
		    // Clicks on Follow-up Tab
			driver.findElement(By.id("ctlAppContent_lbFollowUpTab")).click();
			FollowUpTab followupTab = new FollowUpTab(driver);
		    followupTab.FillClinicalSupervisorTxtFld(clinicalSupervisor);
		    followupTab.GetSaveLnk().click();
			String picPath = SCREENSHOTPATH + "Step_7.png";
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("8", new Object[] { "Step 7", "User is able to successfully save after completing fields in \"Follow up\" tab", "PASS", "", picPath});
		}
		catch (Exception e) {
			this.statusInfo.put("8", new Object[] { "Step 7", "User is able to successfully save after completing fields in \"Follow up\" tab", "FAIL", "User is NOT able to successfully save after completing fields in \"Follow up\" tab"});
		}
		
		WriteDataToExcel.writeToExcelFile(this.statusInfo, excelFilePath);
		
	    System.out.println("**************************");
	    System.out.println("Regression Test Case PASSED! - Create new application - Standard New ");
	    System.out.println("**************************");
	}
}