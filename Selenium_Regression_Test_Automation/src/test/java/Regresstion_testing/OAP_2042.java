//// Generated by Selenium IDE
//package Regresstion_testing;
//
//import org.junit.Test;
//import org.junit.Before;
//import org.apache.batik.svggen.font.table.Program;
//import org.apache.commons.io.FileUtils;
//import org.junit.After;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
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
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.OutputType;
//
//import java.util.*;
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.Duration;
//import org.openqa.selenium.support.ui.Select;
//
//public class OAP_2042 {
//  private WebDriver driver;
//  //private Map<String, Object> vars;//Required if driver is created using DriverManager
//  //JavascriptExecutor js;//Required if driver is created using DriverManager
//  private String originalWindow;  // stores the original window. Useful to shift back to it when changing the focus of the window to drop-down list or similar things.
//
//  @Before
//  public void setUp() {
//	  driver = DriverFactory.CreateIEDriverManually();
//	  // js = (JavascriptExecutor) driver; //Required if driver is created using DriverManager
//	  // vars = new HashMap<String, Object>(); //Required if driver is created using DriverManager
//	  originalWindow = driver.getWindowHandle();
//  
//  }
//  @After
//  public void tearDown() {
////    driver.quit();
//  }
//  @Test
//  public void oAP2042() {
//	String clientLastName = "oap2041TestL";
//	String intakeProccess = "Standard";
//	String applicantType = "New";
//	
//	ClientDriver cd = new ClientDriver();
//	
//	// 1. User navigates to OACIS --> User should be able to access OACIS page
//	cd.launchOACIS();
//	try {
//		this.takeSnapShot(driver, "C:\\Users\\FaiziAd\\Downloads\\test.png");
//	}
//	catch (Exception e) {
//		// TODO: handle exception
//		System.out.println(e);
//	}
//	// 2. User clicks the "client" page --> User should be able to view client search page
//	// 3. User searches for client name --> User should be able to enter keywords to find a matching record
//	cd.searchForClientByLastName(clientLastName); 
//    
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
//    driver.findElement(By.className("GridRow1")).click(); // clicks the first client that appears
//    
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    
//    // 4. User clicks "Applications" and then "New" --> User should be able to see the application and all the tabs
//	cd.createNewApplication();
//	
//	Map<String, String> contactObj = new HashMap<String, String>();
//    // 5. User inputs all required fields in "Contacts" tab and clicks "Save" --> User should be able to successfully save after completing fields in "Contacts" tab
//	contactObj.put("applicantFirstName", "Amanda Johsnon");
//	contactObj.put("applicantLastName", "AJP F");
//	contactObj.put("unitNum", "14");
//	contactObj.put("streetNum", "144");
//	contactObj.put("streetName", "Main Street");
//	contactObj.put("city", "Hamilton");
//	contactObj.put("postalCode", "H1J 2K4");
//
//	cd.fillUpContactTab(contactObj);
//    
//    // 6. User inputs all required fields in "Intake" tab and clicks "Save" --> User should be able to successfully save after completing fields in "Intake" tab, including "Application Type"
//    System.out.println("Choosing the application type...");
//    driver.findElement(By.id("ctlAppContent_lbIntakeTab")).click();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	WebElement intakeProcessDropdown = driver.findElement(By.id("ctlAppContent_ddlIntakeProcess")); // Intake process
//    this.SelectOption(intakeProccess, intakeProcessDropdown, originalWindow);
//    
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	WebElement appTypeDropdown = driver.findElement(By.cssSelector("#ctlAppContent_panelIntakeSection1 table #ctlAppContent_ddlAppType")); // Intake process
//    this.SelectOption(applicantType, appTypeDropdown, originalWindow);
//    driver.findElement(By.id("ctlStandardOperations_lnkSave")).click();
//    System.out.println("The Intake tab has been filled!");
//    System.out.println("**********************************************************");  
//    
//  }
//  
//
//  public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
//	  //Convert web driver object to TakeScreenshot
//	  TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
//	  //Call getScreenshotAs method to create image file
//	  File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//	  //Move image file to new destination
//	  File DestFile = new File(fileWithPath);
//	  //Copy file at destination
//	  FileUtils.copyFile(SrcFile, DestFile);
//  }
//  
//  /* Helper method */
//	/* Given a drop-down web-element with a text option, it selects the option in the drop-down */
//	public void SelectOption(String optionText, WebElement selectElement, String originalWindow) {
//		Actions action = new Actions(driver);//Create an object to store a chain of keypresses
//		selectElement.click();//cause the select element to be highlighted
//		Select foundSelect = new Select(selectElement);//convert webelement to select element
//
//		List<WebElement> selectOptions = foundSelect.getOptions();//get select options
//		String iOptionValue;
//		for (int i = 0; i < selectOptions.size(); i++) {//cycle through all the options in the dropdown, compare them to desired value
//		
//			iOptionValue = selectOptions.get(i).getText();
//			if (!iOptionValue.equals(optionText)) {
//				action.sendKeys(Keys.DOWN);//if not matching, add a 'arrow down' keypress to the chain of key presses to cause the next option to be highlighted
//			}
//			else {
//				action.sendKeys(Keys.TAB);//if matching, tab out of the select element, to allow the curerntly highlighted option to be the selected option
//				break;
//			}
//		}
//		action.build().perform();//perform the chain of keypresses
//
//		driver.switchTo().window(originalWindow);  //selecting an option causes focus to be lost from the current window - must switch focus back to browser window
//									//Requires having already saved the browser window handle somewhere after browser window is initialized - found using driver.CurrentWindowHandle 
//	}
//	
////public void SelectOption(int optionNum) {
////		Actions action = new Actions(driver);//Create an object to store a chain of keypresses
////		WebElement foundElement = driver.findElement(By.id("ctlAppContent_ddlIntakeProcess"));//find webelement
////		foundElement.click();//cause the select element to be highlighted
////		Select foundSelect = new Select(foundElement);//convert webelement to select element
////
////		List<WebElement> selectOptions = foundSelect.getOptions();
////
////		for (int i = 0; i < optionNum; i++) { //cycle through all the options in the dropdown i times - defiend by index of desired select option{
////			action.sendKeys(Keys.DOWN);//add 'arrow down' keypress to chain of keypresses
////		}
////		
////		action.sendKeys(Keys.TAB);//tab out of the select element, to allow the curerntly highlighted option to be the selected option
////		action.build().perform();//perform the chain of keypresses
////		driver.switchTo().window(originalWindow); //selecting an option causes focus to be lost from the current window - must switch focus back to browser window
////									//Requires having already saved the browser window handle somewhere after browser window is initialized - found using driver.CurrentWindowHandle 
////	}
//}