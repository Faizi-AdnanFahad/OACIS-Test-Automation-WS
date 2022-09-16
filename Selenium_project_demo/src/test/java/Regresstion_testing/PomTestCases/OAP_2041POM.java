package Regresstion_testing.PomTestCases;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import CustomExceptions.OacisNotLaunched;
import Excel_Handlers.WriteDataToExcel;
import Regresstion_testing.ClientDriver;
import Regresstion_testing.PageObjectModels.ClientPageModel;
import Regresstion_testing.PageObjectModels.NewClientPageModel;

public class OAP_2041POM {
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
		final String SCREENSHOTPATH = System.getProperty("user.dir") + "\\Screenshots\\OAP_2041\\"; // use 'Temp' directory if you do not want to override the old screenshots
		final String EXCELFILEPATH = System.getProperty("user.dir") + "\\Test Reports\\oap_2041_report.xlsx";
		String picPath = "";
		
		// Client Information
		String clientLastName = "RegTestL";
		String clientFirstName = "RegTestF";
		String clientDob = "01-May-09";
		
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
		
		// 2. User clicks the "client" page --> User should be able to view client search page
		picPath = SCREENSHOTPATH + "Step_2.png";
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
		
		// 3. User clicks on "New" on the side tab  --> User should be able to see a blank client page form to fill out
		picPath = SCREENSHOTPATH + "Step_3.png";
		NewClientPageModel newClientPage = new NewClientPageModel(driver);
		try {
			clientPage.GetNewLnk().click();
			WebElement[] webpageElements = {newClientPage.GetIIO_TransitionCodeTxtFld(), newClientPage.GetRegistrationDateTxtFld(),
										    newClientPage.GetLastNameTxtFld(), newClientPage.GetFirstNameTxtFld(), newClientPage.GetMiddleNameTxtFld(),
										    newClientPage.GetDob_txtDateTxtFld(), newClientPage.GetDoNInvitationDate_txtDateTxtFld(), newClientPage.GetIIO_InvitationSentDateTxtFld(),
										    newClientPage.GetIIO_DossierSentDateTxtFld(), newClientPage.GetConsentProviderNameTxtFld()};
			for (int i = 0; i < webpageElements.length; i ++) {
		    	WebElement webElement = webpageElements[i];
		    	assertTrue(webElement.getAttribute("value") == ""); // User should be able to see a blank client page form to fill out
		    }
			cd.takeSnapShot(driver, picPath);
		    // clicks the first client that appears
			this.statusInfo.put("4", new Object[] { "Step 3", "User should be able to see a blank client page form to fill out", "PASS", "", picPath});
		}
		catch (AssertionError e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("4", new Object[] { "Step 3", "User should be able to see a blank client page form to fill out", "FAIL", "Assersion Error: One of the fields is not empty!", picPath});
		}
		catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("4", new Object[] { "Step 3", "User should be able to see a blank client page form to fill out", "FAIL", e.getRawMessage(), picPath});
		}
		
		// 4. User clicks on "New" on the side tab --> User should be able to fill out the requested fields on client page.
		picPath = SCREENSHOTPATH + "Step_4.png";
		try {
			newClientPage.FillLastNameTxtFld(clientLastName);
			newClientPage.FillFirstNameTxtFld(clientFirstName);
			newClientPage.FillDob_txtDateTxtFld(clientDob);
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("5", new Object[] { "Step 4", "User should be able to fill out the requested fields on client page.", "PASS", "", picPath});
		}
		catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("5", new Object[] { "Step 4", "User should be able to fill out the requested fields on client page.", "FAIL", e.getRawMessage(), picPath});
		}
		
		// 5. User clicks on "Save" on the side tab --> User should be able to view the saved client information with the updated time at the bottom
		picPath = SCREENSHOTPATH + "Step_5.png";
		try {
			clientPage.GetSaveLnk().click();
		    WebElement updatedLabel = cd.getDriver().findElement(By.id("ctlClientContent_lblUpdated"));
			cd.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	  
		    assertTrue(updatedLabel.isDisplayed());
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("6", new Object[] { "Step 5", "User should be able to view the saved client information with the updated time at the bottom.", "PASS", "", picPath});
		}
		catch (AssertionError e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("6", new Object[] { "Step 5", "User should be able to see a blank client page form to fill out", "FAIL", "Assersion Error: The updated time isn't shown at the bottom of the page.!", picPath});
		}
		catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("6", new Object[] { "Step 5", "User should be able to fill out the requested fields on client page.", "FAIL", e.getRawMessage(), picPath});
		}
		
		// 6. User checks IIO Transition Code field on the client page --> User should be able to see a five-character alphanumerical IIO Transition Code assigned for the client.
		picPath = SCREENSHOTPATH + "Step_6.png";
		NewClientPageModel test = new NewClientPageModel(driver);
		try {
			assertTrue(test.GetIIO_TransitionCodeTxtFld().getAttribute("value").length() == 5);
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("7", new Object[] { "Step 6", "User should be able to see a five-character alphanumerical IIO Transition Code assigned for the client.", "PASS", "", picPath});
		}
		catch (AssertionError e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("7", new Object[] { "Step 6", "User should be able to see a five-character alphanumerical IIO Transition Code assigned for the client.", "FAIL", "Assersion Error: The transision field is not 5 character!", picPath});
		}
		
		// 7. User checks Client Lock Status field on the client page --> User should be able to see client lock status is set to "Unlocked" by default.
		picPath = SCREENSHOTPATH + "Step_7.png";
		try {
			Select select = new Select(driver.findElement(By.xpath("//*[@id=\"ctlClientContent_ddl_LockStatus\"]")));
			WebElement option = select.getFirstSelectedOption();
			assertTrue(option.getText().equals("Unlocked"));
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("8", new Object[] { "Step 7", "User should be able to see client lock status is set to \"Unlocked\" by default.", "PASS", "", picPath});
		}
		catch (AssertionError e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("8", new Object[] { "Step 7", "User should be able to see client lock status is set to \"Unlocked\" by default.", "FAIL", "Assersion Error: client lock status is not set to Unlocked!", picPath});
		}
		catch (NoSuchElementException e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("8", new Object[] { "Step 7", "User should be able to fill out the requested fields on client page.", "FAIL", e.getRawMessage(), picPath});
		}
		
		// 8. User checks Registration Date field on the client page --> Registration date field should be empty
		picPath = SCREENSHOTPATH + "Step_8.png";
		try {
			assertTrue(test.GetRegistrationDateTxtFld().getAttribute("value").equals(""));
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("9", new Object[] { "Step 8", "Registration date field should be empty", "PASS", "", picPath});
		}
		catch (AssertionError e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("9", new Object[] { "Step 8", "Registration date field should be empty", "FAIL", "Assersion Error: Registration date field is not empty", picPath});
		}
		
		// 9. User checks IIO Invitation Sent Date field on the client page --> IIO Invitation Sent Date field should be empty
		picPath = SCREENSHOTPATH + "Step_9.png";
		try {
			assertTrue(test.GetIIO_InvitationSentDateTxtFld().getAttribute("value").equals(""));
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("10", new Object[] { "Step 9", "IIO Invitation Sent Date field should be empty", "PASS", "", picPath});
		}
		catch (AssertionError e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("10", new Object[] { "Step 9", "IIO Invitation Sent Date field should be empty", "FAIL", "Assersion Error: IIO Invitation Sent Date field is not empty", picPath});
		}
		
		// 10. User checks Consent Provider Name field on the client page --> Consent Provider Name field should be empty
		picPath = SCREENSHOTPATH + "Step_10.png";
		try {
			assertTrue(test.GetConsentProviderNameTxtFld().getAttribute("value").equals(""));
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("11", new Object[] { "Step 10", "Consent Provider Name field should be empty", "PASS", "", picPath});
		}
		catch (AssertionError e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("11", new Object[] { "Step 10", "Consent Provider Name field should be empty", "FAIL", "Assersion Error: Consent Provider Name field is not empty", picPath});
		}
		
		// 11. User checks Consent for Transition: Declined Date field on the client page --> Consent for Transition: Declined Date field should be empty
		picPath = SCREENSHOTPATH + "Step_11.png";
		try {
			assertTrue(test.GetDateFieldNoTransferConfirmedTxtFld().getAttribute("value").equals(""));
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("12", new Object[] { "Step 11", "Consent for Transition: Declined Date field should be empty", "PASS", "", picPath});
		}
		catch (AssertionError e) {
			cd.takeSnapShot(driver, picPath);
			this.statusInfo.put("12", new Object[] { "Step 11", "Consent for Transition: Declined Date field should be empty", "FAIL", "Assersion Error: Consent for Transition: Declined Date field is not empty", picPath});
		}
		
		WriteDataToExcel.writeToExcelFile(this.statusInfo, EXCELFILEPATH);
	    System.out.println("**************************");
	    System.out.println("done");
	    System.out.println("**************************");

	}
}