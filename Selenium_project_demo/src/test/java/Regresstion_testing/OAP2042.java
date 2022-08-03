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

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class OAP2042 {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
  }
  @After
  public void tearDown() {
//    driver.quit();
  }
  @Test
  public void oAP2042() {
    driver.get("http://intra.stage.oacis.children.gov.on.ca/Main.aspx"); // User navigates to OACIS 
    driver.manage().window().setSize(new Dimension(1050, 718));
    driver.findElement(By.id("ctlPrimaryNav_lnkClient")).click(); // User clicks the "client" page 
    driver.findElement(By.id("ctlClientSearch_txtName")).click();
    driver.findElement(By.id("ctlClientSearch_txtName")).sendKeys("John Ballen"); // User searches for client name
    driver.findElement(By.id("ctlClientSearch_lnkSearch")).click();
    
    /*========================================????????=================================================*/
     /*
      * 4. User clicks "New" on side tab
      * 5. User enters client information and clicks "Save"
      */
//    driver.findElement(By.id("ctlStandardOperations_lnkNew")).click();
//    driver.findElement(By.id("ctlClientContent_txtLastName")).click();
//    driver.findElement(By.id("ctlClientContent_txtLastName")).sendKeys("John Ballen");
//    driver.findElement(By.id("ctlClientContent_txtFirstName")).sendKeys("JB F");
//    
    /*=========================================================================================*/
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
    driver.findElement(By.className("GridRow1")).click();
//    driver.findElement(By.id("ctlClientContent_ctlDob_imgCal")).click();
//    driver.findElement(By.id("ctlClientContent_ctlDob_txtDate")).click();
//    {
//      WebElement element = driver.findElement(By.cssSelector("html"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).clickAndHold().perform();
//    }
//    {
//      WebElement element = driver.findElement(By.cssSelector("html"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).perform();
//    }
//    {
//      WebElement element = driver.findElement(By.cssSelector("html"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).release().perform();
//    }
//    driver.findElement(By.id("ctlClientContent_ctlDob_txtDate")).sendKeys("2005/09/11");
//    driver.findElement(By.cssSelector("#ctlStandardOperations_lnkSave > u")).click();
//    driver.findElement(By.cssSelector("#ctlStandardOperations_lnkSave > u")).click();
    
    
    driver.findElement(By.id("ctlPageNav_lnkApplications")).click();
    driver.findElement(By.id("ctlStandardOperations_lnkNew")).click(); // User clicks "Applications" and then "New"
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    // User inputs all required fields in "Contacts" tab and clicks "Save"
    driver.findElement(By.id("ctlAppContent_txtApplicantLastName")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantLastName")).sendKeys("John Ballen");
    driver.findElement(By.id("ctlAppContent_txtApplicantFirstName")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantFirstName")).sendKeys("JB F");
    driver.findElement(By.id("ctlAppContent_txtApplicantUnit")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantUnit")).sendKeys("14");
    driver.findElement(By.id("ctlAppContent_txtApplicantStreetNumber")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantStreetNumber")).sendKeys("679");
    driver.findElement(By.id("ctlAppContent_txtApplicantStreet")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantStreet")).sendKeys("Main Street");
    driver.findElement(By.id("ctlAppContent_txtApplicantPOBox")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantCity")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("html"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector("html"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector("html"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.id("ctlAppContent_txtApplicantCity")).sendKeys("Hamilton");
    driver.findElement(By.id("ctlAppContent_txtApplicantPostalCode")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantPostalCode")).sendKeys("H2K 3J4");
    {
      WebElement element = driver.findElement(By.cssSelector("html"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector("html"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector("html"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.id("ctlStandardOperations_lnkSave")).click();
    
    // User inputs all required fields in "Intake" tab and clicks "Save"
    driver.findElement(By.cssSelector(".GridRowHighlight > td:nth-child(3)")).click();
    driver.findElement(By.id("ctlAppContent_lbIntakeTab")).click();
    driver.findElement(By.id("ctlAppContent_ddlIntakeProcess")).click();
    {
      WebElement dropdown = driver.findElement(By.id("ctlAppContent_ddlIntakeProcess"));
      dropdown.findElement(By.xpath("//option[. = 'Standard']")).click();
    }
    driver.findElement(By.id("ctlAppContent_ddlAppType")).click();
    {
      WebElement dropdown = driver.findElement(By.id("ctlAppContent_ddlAppType"));
      dropdown.findElement(By.xpath("//option[. = 'New']")).click();
    }
    driver.findElement(By.id("ctlStandardOperations_lnkSave")).click();
    driver.findElement(By.cssSelector(".GridRowHighlight > td:nth-child(4)")).click();
    driver.findElement(By.id("ctlAppContent_lbFollowUpTab")).click();
    
    // User inputs all required fields in "Follow up" tab and clicks "Save"
    driver.findElement(By.id("ctlStandardOperations_lnkSave")).click();
  }
}