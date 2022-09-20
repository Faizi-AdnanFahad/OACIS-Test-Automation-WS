//// Generated by Selenium IDE
//package Regresstion_testing;
//
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.ie.InternetExplorerOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.beust.jcommander.internal.Console;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
//import java.util.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.Duration;
//public class OAP_2041 {
//	  @Test
//	  public void oAP2041() {
//		String lastName = "oap2041TestL";
//		String firstName = "oap2041TestF";
//		String dob = "01-May-09";
//		  
//		ClientDriver cd = new ClientDriver();
//		
//		// 1. User navigates to OACIS --> User should be able to access OACIS page
//		cd.launchOACIS();
//		 
//		// 2. User clicks on the "Client" tab --> User should be able to view client page
//		// 3. User clicks on "New" on the side tab  --> User should be able to see a blank client page form to fill out
//		
//		// Search for the client and confirm all the information - Useful mainly for duplicate checking TBD
//		cd.searchForClientByLastName(lastName);
//		
//		// 4. User clicks on "New" on the side tab --> User should be able to fill out the requested fields on client page.
//		cd.createClient(lastName, firstName, dob);
//		
//		// 5. User clicks on "Save" on the side tab --> User should be able to view the saved client information with the updated time at the bottom
//	    WebElement updatedLabel = cd.getDriver().findElement(By.id("ctlClientContent_lblUpdated"));
//		cd.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	  
//	    assertTrue(updatedLabel.isDisplayed());
//		
//		cd.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	  
//		WebElement transitionCode = cd.getDriver().findElement(By.id("ctlClientContent_txtIIO_TransitionCode"));
//		WebElement lockStatus = cd.getDriver().findElement(By.cssSelector("#ctlClientContent_ddl_LockStatus option"));
//		WebElement regDate = cd.getDriver().findElement(By.id("ctlClientContent_txtRegistrationDate"));
//		WebElement iioInvitationSentDate = cd.getDriver().findElement(By.id("ctlClientContent_txtIIO_InvitationSentDate"));
//		WebElement consentProviderName = cd.getDriver().findElement(By.id("ctlClientContent_txtConsentProviderName"));
//		WebElement cftDeclinedDate = cd.getDriver().findElement(By.id("ctlClientContent_DateFieldNoTransferConfirmedDate_txtDate"));
//		
//		System.out.println("Checking that all fields are empty...");
//		
//		// 6. User checks IIO Transition Code field on the client page --> User should be able to see a five-character alphanumerical IIO Transition Code assigned for the client.
//		assertTrue(transitionCode.getAttribute("value").length() == 5);
//		
//		// 7. User checks Client Lock Status field on the client page --> User should be able to see client lock status is set to "Unlocked" by default.
//		assertTrue(lockStatus.getText().equals("Unlocked"));
//		
//		// 8. User checks Registration Date field on the client page --> Registration date field should be empty
//		assertTrue(regDate.getAttribute("value") == "");
//		
//		// 9. User checks IIO Invitation Sent Date field on the client page --> IIO Invitation Sent Date field should be empty
//		assertTrue(iioInvitationSentDate.getAttribute("value") == "");
//		
//		// 10. User checks Consent Provider Name field on the client page --> IIO Invitation Sent Date field should be empty
//		assertTrue(consentProviderName.getAttribute("value") == "");
//		
//		// 11. User checks Consent for Transition: Declined Date field on the client page --> Consent for Transition: Declined Date field should be empty
//		assertTrue(cftDeclinedDate.getAttribute("value") == "");
//		System.out.println("All fields are empty. Verified!");
//		System.out.println("OAP 2041 is PASSED!");
//	  }
//}