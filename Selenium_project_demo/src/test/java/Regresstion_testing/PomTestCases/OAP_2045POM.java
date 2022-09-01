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
		
		// 2. User clicks the "client" page --> User should be able to view client search page
		ClientPageModel clientPage = new ClientPageModel(driver);
		clientPage.ClickClientLnk();

		// 3. User searches for client name --> User should be able to enter keywords to find a matching record
		clientPage.FillNameTxtFld(clientLastName);
		clientPage.GetSearchLnk().click();
	
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    // 4. User clicks on the client --> User should see the client page with their details
	    driver.findElement(By.className("GridRow1")).click(); 
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    // 5. User clicks "Applications" and then "New" --> User should be able to see the application and all the tabs
	    cd.createNewApplication();
	    
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
		
	    // 7. User clicks on Intake tab and fills in "Application Received Date" --> User should be able to confirm that "Intake" tab matches
	    driver.findElement(By.id("ctlAppContent_lbIntakeTab")).click();
	    
	    // 7. User inputs all required fields in "Intake" tab and clicks "Save" --> User should be able to confirm that "Intake" tab matches 
	    IntakeTab intakeTab = new IntakeTab(driver);
	    
	    // 8. User clicks on the "Intake Process" dropdown --> User confirms "Determination of Needs Pilot" is selected in the dropdow
	    // 9. User clicks on "Determination of Needs" as Intake Process --> User successfully selects "Determination of Needs Pilot" as Intake Process
	    intakeTab.SelectOptionIntakeProcessSelect(driver, this.originalWindow, intakeProccess);
	    
	    // 10. User clicks on the "Applicant Type" dropdown --> Confirm "Pilot" is added in the dropdown
	    // 11. User clicks on "Pilot" as Applicant Type --> User successfully selects "Pilot" as Applicant Type
	    intakeTab.SelectOptionAppTypeSelect(driver, this.originalWindow, applicantType);
	    
	    // 12. User enters all other information, checks consent checkboxes and clicks save --> User should successfully save all the entered information
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    intakeTab.SelectOptionAgeProofSelect(driver, this.originalWindow, proofOfAge);
	    intakeTab.SelectOptionResidencyProofSelect(driver, this.originalWindow, proofOfResidency);
	    intakeTab.SelectOptionConsentSelect(driver, this.originalWindow, consentProvidedBy);
	    intakeTab.FillInformationLetterDate_txtDateTxtFld(informationLetterDate);
	    intakeTab.FillConsentDate_txtDateTxtFld(dateOfConsent);
	    
	    // 7. User clicks on Intake tab and fills in "Application Received Date" --> User should be able to confirm that "Intake" tab matches
	    intakeTab.FillApplicationReceivedDate_txtDateTxtFld(appRecievedDate);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	    driver.findElement(By.id("ctlAppContent_chkDiagnosisProof")).click(); // Proof of Diagnosis Checkbox clicked;
	    driver.findElement(By.id("ctlAppContent_chkConsent")).click(); // Consent Checkbox clicked;
	    
	    // 12. User enters "Application Completed Date" in "Intake" tab --> User should successfully save all the entered information
	    intakeTab.FillApplicationCompletedDate_txtDateTxtFld(appCompletedDate);

	    // 12, User clicks on the "Save" button in the side tab
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	    intakeTab.GetSaveLnk().click();
	    String intakeProcessAfter = driver.findElement(By.xpath("//*[@id=\"ctlAppList_dgdClientApps__ctl2_IntakeType\"]")).getText();
	    assertTrue(intakeProcessAfter.equals(intakeProccess));
	    String applicantTypeAfter = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[2]/td[3]/span")).getText();
	    assertTrue(applicantTypeAfter.equals(applicantType));
	    
	    System.out.println("**************************");
	    System.out.println("Regression Test Case PASSED! - Create new application - Standard New ");
	    System.out.println("**************************");
	}
}
