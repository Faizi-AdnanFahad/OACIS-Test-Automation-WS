//package Regresstion_testing.PomTestCases;
//
//import static org.junit.Assert.*;
//
//import java.time.Duration;import org.apache.commons.math3.analysis.function.Divide;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import Regresstion_testing.ClientDriver;
//import Regresstion_testing.PageObjectModels.ClientPageModel;
//import Regresstion_testing.PageObjectModels.ApplicationPageTabs.BankingTab;
//import Regresstion_testing.PageObjectModels.ApplicationPageTabs.BudgetTab;
//import Regresstion_testing.PageObjectModels.ApplicationPageTabs.ContactTab;
//import Regresstion_testing.PageObjectModels.ApplicationPageTabs.IntakeTab;
//import Regresstion_testing.PageObjectModels.ApplicationPageTabs.PriorityServiceTab;
//import Regresstion_testing.PageObjectModels.AuthorizationPage.AuthorizationPage;
//import Regresstion_testing.PageObjectModels.AuthorizationPage.ServiceLinesPage;
//
//public class OAP_2047POM {
//	private WebDriver driver;
//	  private String originalWindow;  // stores the original window. Useful to shift back to it when changing the focus of the window to drop-down list or similar things.
//	  private ClientDriver cd;
//	  
//	@Before
//	public void setUp() {
//		cd = new ClientDriver();
//		driver = cd.getDriver();
//		originalWindow = driver.getWindowHandle();
//	}
//	@Test
//	public void test() {
//		final String SCREENSHOTPATH = System.getProperty("user.dir") + "\\Screenshots\\OAP_2047\\"; // use 'Temp' directory if you do not want to override the old screenshots
//
//		String clientLastName = "majeed";
//		String bussinessUnit = "F209 - OAP Services";
//		String serviceLinesAmount = "500";
//		
//		/***********************************************************************************************/
//		// 1. User navigates to OACIS --> User should be able to access OACIS page
//		cd.launchOACIS();
//		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_1.png");
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to access OACIS page  \u2713");
//		System.out.println("-----------------------------------");
//
//		// Searches and clicks the first clients matching the last name searched.
//		ClientPageModel clientPage = new ClientPageModel(driver);
//		clientPage.ClickClientLnk();
//		clientPage.FillNameTxtFld(clientLastName);
//		clientPage.GetSearchLnk().click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	    driver.findElement(By.className("GridRow1")).click();
//	    
//		// Searches and finds an appropriate application
//		clientPage.GetApplicationsLnk().click();
//		this.findAndClickCBorInterimApplication();
//		
//		// 2. User clicks on Budget page of an application --> The Budget page is available
// 		driver.findElement(By.id("ctlAppContent_lbBudgetTab")).click();
// 	    BudgetTab budgetTab = new BudgetTab(driver);
// 		Double authorizedTotalBefore = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"ctlAppContent_lblAuthorizedTotal\"]")).getText());
// 	    budgetTab.GetCurrentBudgetTxtFld().isDisplayed();
// 	    budgetTab.GetFundingStartDate_txtDateTxtFld().isDisplayed();
// 	    budgetTab.GetBudgetYearSelect().isDisplayed();
// 	    budgetTab.GetNeedsProfileLevelSelect().isDisplayed();
//		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_2.png");
// 	    System.out.println("-----------------------------------");
//		System.out.println("The Budget page is available  \u2713");
//		System.out.println("-----------------------------------");
//		
//		// 3. User clicks on "Authorization" on budget tab --> User should be able to view a blank authorization page
//		budgetTab.GetAuthorizationLnk().click();
// 	   	WebElement numAuthorMsg = driver.findElement(By.xpath("//*[@id=\"ctlAuthList_lblListStatus\"]"));
// 	   	assertTrue(numAuthorMsg.getText().equals("There are no authorizations found."));
//		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_3.png");
// 	   	System.out.println("-----------------------------------");
//		System.out.println("User is able to view a blank authorization page  \u2713");
//		System.out.println("-----------------------------------");
//		
//		// 4. User creates a new authorization and save --> User should be able to view a new authorization created and saved
// 	   	AuthorizationPage authorizationPage = new AuthorizationPage(driver);
//		authorizationPage.GetNewLnk().click();
//		authorizationPage.GetSaveLnk().click();
//		authorizationPage.GetAuthListLnk().click();
//		int numAuthorization = driver.findElement(By.xpath("//*[@id=\"ctlAuthList_lblListStatus\"]")).getText().charAt(0) - '0';
//		assertTrue(numAuthorization > 0);
//		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_4.png");
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to view a new authorization created and saved  \u2713");
//		System.out.println("-----------------------------------");
//		
//		// 5. User clicks on "Service Lines" on the side tab --> User should be able to view a blank service line page
//		driver.findElement(By.xpath("//*[@id=\"ctlAuthList_dgdAuths\"]/tbody/tr[2]")).click();
//		authorizationPage.GetServiceLinesLnk().click();
//		driver.findElements(By.xpath("//*[@id=\"ctlServiceLines_dgdServiceLines\"]/tbody/tr[2]")).isEmpty(); // checks that there isn't a service line
//		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_5.png");
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to view a blank service line page  \u2713");
//		System.out.println("-----------------------------------");
//		
//		// 6. User selects "OAP Services" from Business Unit drop-down list and input amount for the new service line and save --> User should be able to view a new service line created and saved
//		ServiceLinesPage serviceLinesPage = new ServiceLinesPage(driver);
//		serviceLinesPage.GetNewLnk().click();
//		serviceLinesPage.SelectOptionBusinessUnitSelect(driver, this.originalWindow, bussinessUnit);
//		serviceLinesPage.FillAmountTxtFld(serviceLinesAmount);
//		serviceLinesPage.GetSaveLnk().click();
//		assertFalse(driver.findElements(By.xpath("//*[@id=\"ctlServiceLines_dgdServiceLines\"]/tbody/tr[2]")).isEmpty());
//		assertEquals(Double.parseDouble(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/div[2]/div/table/tbody/tr[2]/td[3]/span")).getText()), Double.parseDouble(serviceLinesAmount), 0.01);
//		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_6.png");
//		System.out.println("-----------------------------------");
//		System.out.println("User is able to view the new service line created and saved  \u2713");
//		System.out.println("-----------------------------------");
//		
//		// 7. User returns to the budget tab of the application --> User should be able to see newly created authorization in the authorization list and "Authorized Total" amount been updated
// 		serviceLinesPage.GetApplicationLnk().click();
// 		driver.findElement(By.id("ctlAppContent_lbBudgetTab")).click();
// 		Double annualBudgAmnt = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtCurrentBudget\"]")).getAttribute("value"));
// 		Double authorizedTotalAfter = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"ctlAppContent_lblAuthorizedTotal\"]")).getText());
// 		Double balance = Double.parseDouble(driver.findElement(By.xpath("//*[@id=\"ctlAppContent_lblBalance\"]")).getText());
// 		Double serviceAmntInt = Double.parseDouble(serviceLinesAmount);
// 		assertEquals(balance, annualBudgAmnt - authorizedTotalAfter, 0.01);
// 		assertEquals(authorizedTotalAfter, authorizedTotalBefore + serviceAmntInt, 0.01);
// 		String authMSGBudgetTab = driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlAuthList_lblListStatus\"]")).getText();
// 		int numOfAuthBudgTab = authMSGBudgetTab.charAt(0) - '0';
// 		assertTrue(numOfAuthBudgTab > 0);
//		cd.takeSnapShot(driver, SCREENSHOTPATH + "Step_7.png");
// 		System.out.println("-----------------------------------");
//		System.out.println("User is able to see newly created authorization in the authorization list and \"Authorized Total\" amount been updated  \u2713");
//		System.out.println("-----------------------------------");
// 		/***********************************************************************************************/
//
//	    System.out.println("**************************");
//	    System.out.println("Regression Test Case PASSED! - Create new application - Standard New ");
//	    System.out.println("**************************");
//	}
//	//*[@id="ctlAppContent_ctlAuthList_lblListStatus"]
//	public void fillContactTabIfBlank(ContactTab contactTab, String applicantDOB, String unitNum, String streetNum, String streetName, String city, String postalCode, String refNum, String province) {
//		driver.findElement(By.id("ctlAppContent_lbContactsTab")).click();
//		if (contactTab.GetApplicantDob_txtDateTxtFld().getAttribute("value").equals("")) {
//			contactTab.FillApplicantDob_txtDateTxtFld(applicantDOB);
//		}
//		if (contactTab.GetApplicantUnitTxtFld().getAttribute("value").equals("")) {
//			contactTab.FillApplicantUnitTxtFld(unitNum);
//		}
//		if (contactTab.GetApplicantStreetNumberTxtFld().getAttribute("value").equals("")) {
//			contactTab.FillApplicantStreetNumberTxtFld(streetNum);
//		}
//		if (contactTab.GetApplicantStreetTxtFld().getAttribute("value").equals("")) {
//			contactTab.FillApplicantStreetTxtFld(streetName);
//		}
//		if (contactTab.GetApplicantCityTxtFld().getAttribute("value").equals("")) {
//			contactTab.FillApplicantCityTxtFld(city);
//		}
//		if (contactTab.GetApplicantPostalCodeTxtFld().getAttribute("value").equals("")) {
//			contactTab.FillApplicantPostalCodeTxtFld(postalCode);
//		}
//		if (contactTab.GetReferenceNumberTxtFld().getAttribute("value").equals("")) {
//			contactTab.FillReferenceNumberTxtFld(refNum);
//		}
//		contactTab.SelectOptionApplicantProvinceSelect(driver, this.originalWindow, province);
//	}
//	
//	public void findAndClickCBorInterimApplication() {
//		// Finding the number of applications
//		int numOfapplicant = 0;
//		String numOfApplicationMsg = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[1]/table/tbody/tr/td[2]/span")).getText();
//		if (!numOfApplicationMsg.equals("There are no applications for this client.")) {
//			numOfapplicant = numOfApplicationMsg.charAt(0) - '0';
//		}
//		WebElement cbOrInterimApplication = null;
//		for (int i = 0; i < numOfapplicant; i ++) {
//			int rowNum = 2 + i;
//		    String intakeProcess = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[" + rowNum + "]/td[2]/span")).getText();
//		    String applicantType = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[" + rowNum + "]/td[3]/span")).getText();
//			if (intakeProcess.equals("Interim") && !applicantType.equals("Renewal")) {
//				cbOrInterimApplication = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[" + rowNum + "]"));
//				cbOrInterimApplication.click();
//				break;
//			}
//			else if (intakeProcess.equals("Standard") && (!applicantType.equals("New") || !applicantType.equals("Renewal"))) {
//				cbOrInterimApplication = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[" + rowNum + "]"));
//				cbOrInterimApplication.click();
//				break;
//			}
//		}
//	}
//}