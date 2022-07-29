// Generated by Selenium IDE
package Regresstion_testing;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.internal.Console;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class OAP_2041 {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	  WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
      js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
//    driver.quit();
  }
  @Test
  public void oAP2041() {
	  
	driver.get("http://intra.stage.oacis.children.gov.on.ca/Main.aspx");

    /*
	 * Search for the client and confirm all the information
	 */
    driver.findElement(By.id("ctlQueryBox_txtQuery")).click();
    driver.findElement(By.id("ctlQueryBox_txtQuery")).sendKeys("Mark Alexander");
    driver.findElement(By.cssSelector("img")).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
    driver.findElement(By.className("GridRow1")).click();
    
    WebElement transitionCode = driver.findElement(By.id("ctlClientContent_txtIIO_TransitionCode"));
    WebElement lockStatus = driver.findElement(By.cssSelector("#ctlClientContent_ddl_LockStatus option"));
    WebElement regDate = driver.findElement(By.id("ctlClientContent_txtRegistrationDate"));
    WebElement iioInvitationSentDate = driver.findElement(By.id("ctlClientContent_txtIIO_InvitationSentDate"));
    WebElement consentProviderName = driver.findElement(By.id("ctlClientContent_txtConsentProviderName"));
    WebElement cftDeclinedDate = driver.findElement(By.id("ctlClientContent_DateFieldNoTransferConfirmedDate_txtDate"));

    assertTrue(transitionCode.getAttribute("value").length() == 5); // User should be able to see a five-character alpha-numerical IIO Transition Code assigned for the client.
    assertTrue(lockStatus.getText().equals("Unlocked")); // User should be able to see client lock status is set to "Unlocked" by default.
    assertTrue(regDate.getAttribute("value") == ""); // Registration date field should be empty
    assertTrue(iioInvitationSentDate.getAttribute("value") == ""); // IIO Invitation Sent Date field should be empty
    assertTrue(consentProviderName.getAttribute("value") == ""); // IIO Invitation Sent Date field should be empty
    assertTrue(cftDeclinedDate.getAttribute("value") == ""); // Consent for Transition: Declined Date field should be empty
  }
}
