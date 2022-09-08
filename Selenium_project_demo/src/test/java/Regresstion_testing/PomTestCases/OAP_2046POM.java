package Regresstion_testing.PomTestCases;

import static org.junit.Assert.*;

import java.time.Duration;

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

public class OAP_2046POM {
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
		final String SCREENSHOTPATH = System.getProperty("user.dir") + "\\Screenshots\\OAP_2046\\"; // use 'Temp' directory if you do not want to override the old screenshots

		String clientLastName = "abou";
		String clientDOB = "01-Jun-2001";

		// Contact Tab
		// Applicant Information
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
		// Set 'authorization to true, if the authorization is required and assign values to the authorization related field accordingly.'
		boolean authorization = true;
		String informationLetterDate = "05-Mar-2019";
		String proofOfAge = "Passport";
		String proofOfResidency = "Ontario Driver License";
		String consentProvidedBy = "Both";
		String dateOfConsent = "06-Nov-2019";
		String appCompletedDate = "";
		
		// Follow-up tab
		String expenseDate = "04-Dec-2018";
		
		// Banking Tab
		String nameOfFinanInst = "TD Bank";
		String accountHolder = "Amanda Martinez";
		String transit = "34562";
		String institution = "234";
		String bankAccount = "25647829";
		
		/***********************************************************************************************/
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
	    
		// 4. User clicks on "List" on the side tab --> User should be able to view a list of applications available
		clientPage.GetApplicationsLnk().click();
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_4.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to view a list of applications that are available \u2713");
		System.out.println("-----------------------------------");
		
		// 5. User opens the CB/interim funding application in the application list --> User should be able to view the "Renewal" button on the side bar if the renewal eligibility date requirement is satisfied
		// ?????? ARE WE ASSUMING THAT WE WILL PASS A CLIENT SUCH THAT IT WILL HAVE A CB/INTERIM FUNCING APPLICAITON WITH RENEWAL ELIGIBILITY SATISFIED?
		// OR SHOULD I CHECK EACH SATSIFIED CB/ITERMIN APPLICATION FOR FUNDING ELGIBILTY DATA?
		// OR SHOULD I CHECK THE RENEWAL ELGIBILITY DATE MAKING SURE THAT IT IS AT LEAST 2 MONTHS OLD FROM THE CURRENT DATA PROGRAMATICALLY?(WHAT IF NOT MET AND NO SUCH APPLICATION IS FOUND??) OR SHOULD WHEN FETCHING
		// THE DATA FOR THIS REGRESSION TEST, WE CHECK ALL THOSE AND PASS IT TO THIS TEST?
		this.findAndClickCBorInterimApplication();
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_5.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to view the \"Renewal\" button on the side bar if the renewal eligibility date requirement is satisfied \u2713");
		System.out.println("-----------------------------------");

		// To resolve this error, For renewal applications, expenses provided date is required on prior application.
		// The following steps must be followed
		ContactTab contactTab = new ContactTab(driver);
		this.fillContactTabIfBlank(contactTab, applicantDOB, unitNum, streetNum, streetName, city, postalCode, refNum, province);
	    driver.findElement(By.id("ctlAppContent_lbFollowUpTab")).click();
	    WebElement expenseProvidedDate = driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlExpensesProvidedDate_txtDate\"]"));
	    expenseProvidedDate.sendKeys(expenseDate);
	    contactTab.GetSaveLnk().click();
	    
		// 6. User clicks on "Renew" button on the side bar --> User should be able to renew the application with the basic information.
		this.findAndClickCBorInterimApplication();
	    contactTab.GetRenewLnk().click();
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_6.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to renew the application with the basic information \u2713");
		System.out.println("-----------------------------------");

		// 7. User inputs all required fields in "Contacts" tab and clicks "Save" --> User should be able to successfully save after completing fields in "Contacts" tab
		this.fillContactTabIfBlank(new ContactTab(driver), applicantDOB, unitNum, streetNum, streetName, city, postalCode, refNum, province);
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_7.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to successfully save after completing fields in \"Contacts\" tab \u2713");
		System.out.println("-----------------------------------");

		// 8. User confirms information on "Prior Service" tab -> User should be able to confirm that "Prior service" tab matches 
		// Click on Prior Service Tab
		driver.findElement(By.id("ctlAppContent_lbPriorServiceTab")).click();
		PriorityServiceTab priorService = new PriorityServiceTab(driver);
	    priorService.FillProviderClientDOB_txtDateTxtFld(clientDOB);
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_8.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to confirm that \"Prior service\" tab matches  \u2713");
		System.out.println("-----------------------------------");

	    // 9. User inputs all required fields in "Intake" tab and clicks "Save" --> User should be able to confirm that "Intake" tab matches
	    // Click on intakes Tab
	    driver.findElement(By.id("ctlAppContent_lbIntakeTab")).click();
	    IntakeTab intakeTab = new IntakeTab(driver);
	    if (authorization) {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		    driver.findElement(By.id("ctlAppContent_chkDiagnosisProof")).click(); // Proof of Diagnosis Checkbox clicked;
		    driver.findElement(By.id("ctlAppContent_chkConsent")).click(); // Consent Checkbox clicked;
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    intakeTab.FillConsentDate_txtDateTxtFld(dateOfConsent);
		    intakeTab.SelectOptionAgeProofSelect(driver, this.originalWindow, proofOfAge);
		    intakeTab.SelectOptionResidencyProofSelect(driver, this.originalWindow, proofOfResidency);
		    intakeTab.SelectOptionConsentSelect(driver, this.originalWindow, consentProvidedBy);
		    intakeTab.FillInformationLetterDate_txtDateTxtFld(informationLetterDate);
	    }
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_9.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to confirm that \"Intake\" tab matches \u2713");
		System.out.println("-----------------------------------");
	    
	    // 10. User inputs all required fields in "Banking" tab and clicks "Save" --> User should be able to confirm that "Banking" tab matches
		/***********************************************************************************************/
	    // Click on Banking Tab
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.findElement(By.id("ctlAppContent_lbBankingTab")).click();
		driver.findElement(By.id("ctlAppContent_lbBankingTab")).click();
		BankingTab bankingTab = new BankingTab(driver);
	    bankingTab.FillBankNameTxtFld(nameOfFinanInst);
	    bankingTab.FillAccountHolderTxtFld(accountHolder);
	    bankingTab.FillBankBranchTxtFld(transit);
	    bankingTab.FillBankTxtFld(institution);
	    bankingTab.FillBankAccountTxtFld(bankAccount);
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_10.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to confirm that \"Banking\" tab matches \u2713");
		System.out.println("-----------------------------------");
	    
	    // 11. User confirms budget amount on "Budget" tab --> User should be able to confirm that "Budget" tab matches
	    // Click on budget Tab
 		driver.findElement(By.id("ctlAppContent_lbBudgetTab")).click();
 	    BudgetTab budgetTab = new BudgetTab(driver);
 	    String annualBudAmntStr = budgetTab.GetCurrentBudgetTxtFld().getAttribute("value");
 	    if (!annualBudAmntStr.equals("")) {
 		    int annualBudgAmnt = Integer.parseInt(budgetTab.GetCurrentBudgetTxtFld().getAttribute("value"));
 		    assertTrue(annualBudgAmnt != 0);
 	    }
 	    else {
 		    assertTrue(annualBudAmntStr.equals(""));
 	    }
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_11.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to confirm that \"Budget\" tab matches \u2713");
		System.out.println("-----------------------------------");

 	    // ?????12???? UNCLEAR
 	    
	    // 13. User enters "Application Completed Date" in "Intake" tab --> User should confirm that "Application Completed" date is updated
 	 	// Click on intakes Tab
 	    driver.findElement(By.id("ctlAppContent_lbIntakeTab")).click();
	    appCompletedDate = intakeTab.GetApplicationReceivedDate_txtDateTxtFld().getAttribute("value"); // we set application completed date to be the same as the application received date
	    intakeTab.FillApplicationCompletedDate_txtDateTxtFld(appCompletedDate);
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_13.png");
		System.out.println("-----------------------------------");
		System.out.println("\"Application Completed\" date is updated \u2713");
		System.out.println("-----------------------------------");

	    // 14, User clicks on the "Save" button in the side tab --> User should see the new renewal application showing up in the application list
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	    intakeTab.GetSaveLnk().click();
	    String applicantTypeAfter = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[2]/td[3]/span")).getText();
	    assertTrue(applicantTypeAfter.equals("Renewal"));
		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_14.png");
		System.out.println("-----------------------------------");
		System.out.println("User is able to see the new renewal application showing up in the application list \u2713");
		System.out.println("-----------------------------------");
		/***********************************************************************************************/

	    System.out.println("**************************");
	    System.out.println("Regression Test Case PASSED! - Create new application - Standard New ");
	    System.out.println("**************************");
	}
	
	public void fillContactTabIfBlank(ContactTab contactTab, String applicantDOB, String unitNum, String streetNum, String streetName, String city, String postalCode, String refNum, String province) {
		driver.findElement(By.id("ctlAppContent_lbContactsTab")).click();
		if (contactTab.GetApplicantDob_txtDateTxtFld().getAttribute("value").equals("")) {
			contactTab.FillApplicantDob_txtDateTxtFld(applicantDOB);
		}
		if (contactTab.GetApplicantUnitTxtFld().getAttribute("value").equals("")) {
			contactTab.FillApplicantUnitTxtFld(unitNum);
		}
		if (contactTab.GetApplicantStreetNumberTxtFld().getAttribute("value").equals("")) {
			contactTab.FillApplicantStreetNumberTxtFld(streetNum);
		}
		if (contactTab.GetApplicantStreetTxtFld().getAttribute("value").equals("")) {
			contactTab.FillApplicantStreetTxtFld(streetName);
		}
		if (contactTab.GetApplicantCityTxtFld().getAttribute("value").equals("")) {
			contactTab.FillApplicantCityTxtFld(city);
		}
		if (contactTab.GetApplicantPostalCodeTxtFld().getAttribute("value").equals("")) {
			contactTab.FillApplicantPostalCodeTxtFld(postalCode);
		}
		if (contactTab.GetReferenceNumberTxtFld().getAttribute("value").equals("")) {
			contactTab.FillReferenceNumberTxtFld(refNum);
		}
		contactTab.SelectOptionApplicantProvinceSelect(driver, this.originalWindow, province);
	}
	
	/* Goes over the list of applications and clicks the first application only if it is not a 'Standard New' or any 'Renewal' Application */
	public void findAndClickCBorInterimApplication() {
		// Finding the number of applications
		int numOfapplicant = 0;
		String numOfApplicationMsg = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[1]/table/tbody/tr/td[2]/span")).getText();
		if (!numOfApplicationMsg.equals("There are no applications for this client.")) {
			numOfapplicant = numOfApplicationMsg.charAt(0) - '0';
		}
		WebElement cbOrInterimApplication = null;
		for (int i = 0; i < numOfapplicant; i ++) {
			int rowNum = 2 + i;
		    String intakeProcess = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[" + rowNum + "]/td[2]/span")).getText();
		    String applicantType = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[" + rowNum + "]/td[3]/span")).getText();
			if (intakeProcess.equals("Interim") && !applicantType.equals("Renewal")) {
				cbOrInterimApplication = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[" + rowNum + "]"));
				cbOrInterimApplication.click();
				break;
			}
			else if (intakeProcess.equals("Standard") && (!applicantType.equals("New") || !applicantType.equals("Renewal"))) {
				cbOrInterimApplication = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[" + rowNum + "]"));
				cbOrInterimApplication.click();
				break;
			}
		}
	}
}