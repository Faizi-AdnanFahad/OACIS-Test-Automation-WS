// Generated by Selenium IDE
package Regresstion_testing;

import org.junit.Test;
import org.junit.Before;
import org.apache.batik.svggen.font.table.Program;
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
import org.openqa.selenium.support.ui.Select;

public class OAP2042 {
  private WebDriver driver;
  //private Map<String, Object> vars;//Required if driver is created using DriverManager
  //JavascriptExecutor js;//Required if driver is created using DriverManager
  private String originalWindow;  // stores the original window. Useful to shift back to it when changing the focus of the window to drop-down list or similar things.

  @Before
  public void setUp() {
	  driver = DriverFactory.CreateIEDriverManually();
	  // js = (JavascriptExecutor) driver; //Required if driver is created using DriverManager
	  // vars = new HashMap<String, Object>(); //Required if driver is created using DriverManager
	  originalWindow = driver.getWindowHandle();
  
  }
  @After
  public void tearDown() {
//    driver.quit();
  }
  @Test
  public void oAP2042() {  
	System.out.println("Launching the Oacis website...");
    driver.get("http://intra.stage.oacis.children.gov.on.ca/Main.aspx"); // User navigates to OACIS 
    driver.manage().window().setSize(new Dimension(1050, 718));
    driver.findElement(By.id("ctlPrimaryNav_lnkClient")).click(); // User clicks the "client" page 
    driver.findElement(By.id("ctlClientSearch_txtName")).click();
    driver.findElement(By.id("ctlClientSearch_txtName")).sendKeys("Richard"); // User searches for client name
    driver.findElement(By.id("ctlClientSearch_lnkSearch")).click();
    
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
    driver.findElement(By.className("GridRow1")).click();
    
	System.out.println("Creating a new application...");
    driver.findElement(By.id("ctlPageNav_lnkApplications")).click();
    driver.findElement(By.id("ctlStandardOperations_lnkNew")).click(); // User clicks "Applications" and then "New"
    System.out.println("New application is being created...");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    //User inputs all required fields in "Contacts" tab and clicks "Save"
    System.out.println("The information is being entered...");
    driver.findElement(By.id("ctlAppContent_txtApplicantLastName")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantLastName")).sendKeys("Amanda Johsnon");
    driver.findElement(By.id("ctlAppContent_txtApplicantFirstName")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantFirstName")).sendKeys("AJP F");
    driver.findElement(By.id("ctlAppContent_txtApplicantUnit")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantUnit")).sendKeys("14");
    driver.findElement(By.id("ctlAppContent_txtApplicantStreetNumber")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantStreetNumber")).sendKeys("679");
    driver.findElement(By.id("ctlAppContent_txtApplicantStreet")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantStreet")).sendKeys("Main Street");
    driver.findElement(By.id("ctlAppContent_txtApplicantPOBox")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantCity")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantCity")).sendKeys("Hamilton");
    driver.findElement(By.id("ctlAppContent_txtApplicantPostalCode")).click();
    driver.findElement(By.id("ctlAppContent_txtApplicantPostalCode")).sendKeys("H2K 3J4");
    
    // User inputs all required fields in "Intake" tab and clicks "Save"
    driver.findElement(By.id("ctlAppContent_lbIntakeTab")).click();
	WebElement intakeProcess = driver.findElement(By.id("ctlAppContent_ddlIntakeProcess")); // Intake process
    SelectOption("Standard", intakeProcess);
    
	WebElement appType = driver.findElement(By.cssSelector("#ctlAppContent_panelIntakeSection1 table #ctlAppContent_ddlAppType")); // Intake process
    SelectOption("New", appType);
    driver.findElement(By.id("ctlStandardOperations_lnkSave")).click();
  }
  
  public void SelectOption(String optionText, WebElement selectElement) {
		Actions action = new Actions(driver);//Create an object to store a chain of keypresses
		selectElement.click();//cause the select element to be highlighted
		Select foundSelect = new Select(selectElement);//convert webelement to select element

		List<WebElement> selectOptions = foundSelect.getOptions();//get select options
		String iOptionValue;
		for (int i = 0; i < selectOptions.size(); i++) {//cycle through all the options in the dropdown, compare them to desired value
		
			iOptionValue = selectOptions.get(i).getText();
			if (!iOptionValue.equals(optionText)) {
				action.sendKeys(Keys.DOWN);//if not matching, add a 'arrow down' keypress to the chain of key presses to cause the next option to be highlighted
			}
			else {
				action.sendKeys(Keys.TAB);//if matching, tab out of the select element, to allow the curerntly highlighted option to be the selected option
				break;
			}
		}
		action.build().perform();//perform the chain of keypresses

		driver.switchTo().window(originalWindow);  //selecting an option causes focus to be lost from the current window - must switch focus back to browser window
									//Requires having already saved the browser window handle somewhere after browser window is initialized - found using driver.CurrentWindowHandle 
	}
  
//  public void SelectOption(int optionNum) {
//		Actions action = new Actions(driver);//Create an object to store a chain of keypresses
//		WebElement foundElement = driver.findElement(By.id("ctlAppContent_ddlIntakeProcess"));//find webelement
//		foundElement.click();//cause the select element to be highlighted
//		Select foundSelect = new Select(foundElement);//convert webelement to select element
//
//		List<WebElement> selectOptions = foundSelect.getOptions();
//
//		for (int i = 0; i < optionNum; i++) { //cycle through all the options in the dropdown i times - defiend by index of desired select option{
//			action.sendKeys(Keys.DOWN);//add 'arrow down' keypress to chain of keypresses
//		}
//		
//		action.sendKeys(Keys.TAB);//tab out of the select element, to allow the curerntly highlighted option to be the selected option
//		action.build().perform();//perform the chain of keypresses
//		driver.switchTo().window(originalWindow); //selecting an option causes focus to be lost from the current window - must switch focus back to browser window
//									//Requires having already saved the browser window handle somewhere after browser window is initialized - found using driver.CurrentWindowHandle 
//	}
}
