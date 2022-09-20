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
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.BankingTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.BudgetTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.ContactTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.IntakeTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.PriorityServiceTab;

public class OAP_2043POM {
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
	public void test() { // TBD - Home and Mailing Address Condition
		final String SCREENSHOTPATH = System.getProperty("user.dir") + "\\Screenshots\\OAP_2043\\"; // use 'Temp' directory if you do not want to override the old screenshots
		final String EXCELFILEPATH = System.getProperty("user.dir") + "\\Test Reports\\oap_2043_report.xlsx";
		String picPath = "";
		
		// Client Information
		String clientLastName = "RegTestL";
		String clientDOB = "05-Dec-2018";
		
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
		String intakeProccess = "Standard";
		String applicantType = "Legacy Waitlist";
		// Set 'authorization to true, if the authorization is required and assign values to the authorization related field accordingly.'
		boolean authorization = true;
		String appRecievedDate = "04-Jun-2019";
		String informationLetterDate = "05-Mar-2019";
		String proofOfAge = "Passport";
		String proofOfResidency = "Ontario Driver License";
		String consentProvidedBy = "Both";
		String dateOfConsent = "06-Nov-2019";
		String appCompletedDate = "25-Feb-2020";
		
		// Banking Tab
		String nameOfFinanInst = "TD Bank";
		String accountHolder = "Amanda Martinez";
		String transit = "34562";
		String institution = "234";
		String bankAccount = "25647829";
		
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
			cd.takeSnapShot(driver, picPath);
		    // clicks the first client that appears
		    driver.findElement(By.className("GridRow1")).click();
			this.statusInfo.put("4", new Object[] { "Step 3", "User is able to enter keywords to find a matching record", "PASS", "", picPath});
		}
		catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("4", new Object[] { "Step 3", "User is able to enter keywords to find a matching record", "FAIL", e.getRawMessage(), picPath});
		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to enter keywords to find a matching record \u2713");
//		System.out.println("-----------------------------------");

		
	    // 4. User inputs all required fields in "Contacts" tab and clicks "Save" --> User should be able to successfully save after completing fields in "Contacts" tab
		picPath = SCREENSHOTPATH + "Step_4.png";
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    // User clicks "Applications" and then "New" --> User should be able to see the application and all the tabs
		    cd.createNewApplication();
		    
		    // Clicks on Contacts tab
			driver.findElement(By.id("ctlAppContent_lbContactsTab")).click();
			
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
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("5", new Object[] { "Step 4", "User is able to successfully save after completing fields in \"Contacts\" tab", "PASS", "", picPath});
		}
		catch (ElementNotInteractableException e) {
			cd.takeSnapShot(driver, picPath);
 			this.statusInfo.put("5", new Object[] { "Step 4", "User is able to successfully save after completing fields in \"Contacts\" tab", "FAIL", "Select " + e.getRawMessage(), picPath});
		}
		catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("5", new Object[] { "Step 4", "User is able to successfully save after completing fields in \"Contacts\" tab", "FAIL", e.getRawMessage(), picPath});
		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to successfully save after completing fields in \"Contacts\" tab \u2713");
//		System.out.println("-----------------------------------");
		
	    // 5. User inputs all required fields in "Prior Service" tab and clicks "Save" --> User should be able to confirm that "Prior Service" tab matches
	    picPath = SCREENSHOTPATH + "Step_5.png";
	    try {
	    	// Click on Prior Service Tab
			driver.findElement(By.id("ctlAppContent_lbPriorServiceTab")).click();
		    
			PriorityServiceTab priorService = new PriorityServiceTab(driver);
		    priorService.FillProviderClientDOB_txtDateTxtFld(clientDOB);
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("6", new Object[] { "Step 5", "User is able to confirm that \\\"Prior Service\\\" tab matches", "PASS", "", picPath});
	    }
	    catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
 			this.statusInfo.put("6", new Object[] { "Step 5", "User is able to confirm that \\\"Prior Service\\\" tab matches", "FAIL", e.getRawMessage(), picPath});

		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to confirm that \"Prior Service\" tab matches \u2713");
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
			    intakeTab.FillApplicationCompletedDate_txtDateTxtFld(appCompletedDate);
			    intakeTab.FillInformationLetterDate_txtDateTxtFld(informationLetterDate);
			    intakeTab.FillConsentDate_txtDateTxtFld(dateOfConsent);
			    intakeTab.FillApplicationReceivedDate_txtDateTxtFld(appRecievedDate);
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
			    driver.findElement(By.id("ctlAppContent_chkDiagnosisProof")).click(); // Proof of Diagnosis Checkbox clicked;
			    driver.findElement(By.id("ctlAppContent_chkConsent")).click(); // Consent Checkbox clicked;
		    }
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("7", new Object[] { "Step 6", "User is able to confirm that \"Intake\" tab matches", "PASS", "", picPath});
	    }
	    catch (ElementNotInteractableException e) {
			cd.takeSnapShot(driver, picPath);
 			this.statusInfo.put("7", new Object[] { "Step 6", "User is able to confirm that \"Intake\" tab matches", "FAIL", "Select " + e.getRawMessage(), picPath});
		}
	    catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
 			this.statusInfo.put("7", new Object[] { "Step 6", "User is able to confirm that \"Intake\" tab matches", "FAIL", e.getRawMessage(), picPath});
		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to confirm that \"Intake\" tab matches \u2713");
//		System.out.println("-----------------------------------");
	    
	    // 7. User confirms budget amount in "Budget" tab --> User should be able to confirm that "Budget" tab matches 
	    picPath = SCREENSHOTPATH + "Step_7.png";
	    try {
	    	// Click on budget Tab
			driver.findElement(By.id("ctlAppContent_lbBudgetTab")).click();

		    BudgetTab budgetTab = new BudgetTab(driver);
		    String annualBudAmntStr = budgetTab.GetCurrentBudgetTxtFld().getAttribute("value");
		    int annualBudgAmnt = Integer.parseInt(annualBudAmntStr);
		    assertTrue(annualBudgAmnt != 0);
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("8", new Object[] { "Step 7", "User is able to confirm that \"Budget\" tab matches", "PASS", "", picPath});
	    }
	    catch (AssertionError e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("8", new Object[] { "Step 7", "User is able to confirm that \"Budget\" tab matches", "FAIL", "Budget Amount is populated as 0", picPath});
	    }
	    catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("8", new Object[] { "Step 7", "User is able to confirm that \"Budget\" tab matches", "FAIL", e.getRawMessage(), picPath});
	    }
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to confirm that \"Budget\" tab matches \u2713");
//		System.out.println("-----------------------------------");
	    
	    // 8. User inputs all required fields in "Banking" tab and clicks "Save" --> User should be able to that "Banking" tab matches
	    picPath = SCREENSHOTPATH + "Step_8.png";
	    BankingTab bankingTab = new BankingTab(driver);
	    try {
	    	// Click on Banking Tab
			driver.findElement(By.id("ctlAppContent_lbBankingTab")).click();

		    bankingTab.FillBankNameTxtFld(nameOfFinanInst);
		    bankingTab.FillAccountHolderTxtFld(accountHolder);
		    bankingTab.FillBankBranchTxtFld(transit);
		    bankingTab.FillBankTxtFld(institution);
		    bankingTab.FillBankAccountTxtFld(bankAccount);
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("9", new Object[] { "Step 8", "User is able to see that \"Banking\" tab matches", "PASS", "", picPath});
	    }
	    catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
 			this.statusInfo.put("9", new Object[] { "Step 8",  "User is able to see that \"Banking\" tab matches", "FAIL", e.getRawMessage(), picPath});
		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to that \"Banking\" tab matches \u2713");
//		System.out.println("-----------------------------------");

	    // 9. ??????UNCLEAR??????
	    
	    // 10, User clicks on the "Save" button in the side tab --> User should see the new childhood budget application showing up in the application list
	    picPath = SCREENSHOTPATH + "Step_9.png";
	    try {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		    bankingTab.GetSaveLnk().click();
		    String intakeProcessAfter = driver.findElement(By.xpath("//*[@id=\"ctlAppList_dgdClientApps__ctl2_IntakeType\"]")).getText();
		    assertTrue(intakeProcessAfter.equals(intakeProccess));
		    String applicantTypeAfter = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[2]/td[3]/span")).getText();
		    assertTrue(applicantTypeAfter.equals(applicantType));
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("9", new Object[] { "Step 8", "User is able to see the new childhood budget application showing up in the application list", "PASS", "", picPath});
	    }
	    catch (AssertionError e) {
			cd.takeSnapShot(driver, picPath);
 			this.statusInfo.put("10", new Object[] { "Step 9", "User is able to see the new childhood budget application showing up in the application list", "FAIL", "The correct application was not created!", picPath});

		}
	    catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
 			this.statusInfo.put("10", new Object[] { "Step 9", "User is able to see the new childhood budget application showing up in the application list", "FAIL", e.getRawMessage(), picPath});
		}
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to see the new childhood budget application showing up in the application list \u2713");
//		System.out.println("-----------------------------------");
	    
	    // Generate the excel report
		WriteDataToExcel.writeToExcelFile(this.statusInfo, EXCELFILEPATH);

	    // Should be deleted afterward
	    System.out.println("**************************");
	    System.out.println("done");
	    System.out.println("**************************");
	}
}
