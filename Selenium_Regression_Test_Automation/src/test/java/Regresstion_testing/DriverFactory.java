package Regresstion_testing;

import java.time.Duration;
import java.util.HashMap;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static WebDriver CreateIEDriverManually() {//Create IE driver: manually
		WebDriver driver;
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\imports\\WebDrivers\\IEDriverServer.exe");
		InternetExplorerOptions ieOptions = new InternetExplorerOptions();
		ieOptions.attachToEdgeChrome();
		ieOptions.withEdgeExecutablePath("C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe");
		ieOptions.introduceFlakinessByIgnoringSecurityDomains();//IntroduceInstabilityByIgnoringProtectedModeSettings = true;
		driver = new InternetExplorerDriver(ieOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public static WebDriver CreateIEDriverDriverManager() {//Create IE driver: with Driver manager
		WebDriver driver;
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\imports\\WebDrivers\\IEDriverServer.exe");
		InternetExplorerOptions ieOptions = new InternetExplorerOptions();	
		ieOptions.attachToEdgeChrome();
		ieOptions.withEdgeExecutablePath("C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe");
		ieOptions.introduceFlakinessByIgnoringSecurityDomains();//IntroduceInstabilityByIgnoringProtectedModeSettings = true;
		driver = WebDriverManager.iedriver().capabilities(ieOptions).create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public static WebDriver CreateEdgeDriverManually() {//Create Edge driver manually
		
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\imports\\WebDrivers\\msedgedriver.exe");
		WebDriver driver;
		EdgeOptions eOptions = new EdgeOptions();
		eOptions.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
		// eOptions.addExtensions(new File("C:\\Users\\OKeeffKy\\OneDrive - Government of Ontario\\Documents\\02Projects\\ProgProj\\OACISSeleniumJava\\Selenium-IDE-chromeext.crx"));
		driver = new EdgeDriver(eOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public static WebDriver CreateEdgeDriverDriverManager() {//**********Create Edge Driver using DriverManager
		 WebDriver driver;
		 EdgeOptions eOptions = new EdgeOptions();
		 System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\imports\\WebDrivers\\msedgedriver.exe");
		 eOptions.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
		 //eOptions.addExtensions(new File("C:\\Users\\OKeeffKy\\OneDrive - Government of Ontario\\Documents\\02Projects\\ProgProj\\OACISSeleniumJava\\Selenium-IDE-chromeext.crx"));
		 driver = WebDriverManager.edgedriver().capabilities(eOptions).create();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 return driver;
	}
	
	public static WebDriver CreateEdgeDriverForSeleniumRecording() { // Can be used when the Selenium recording is needed. 
		WebDriverManager.edgedriver().setup();
	    WebDriver driver = new EdgeDriver();
	    return driver;
	}
	public static void WaitForPageLoad(WebDriver driver)
	{
		System.out.println("Waiting for page to load...");
		Wait<WebDriver> Wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//JavascriptExecutor driverExec =  (JavascriptExecutor) driver;
		Wait.until(new Function<WebDriver, boolean[]>() {
			public boolean[] apply(WebDriver Driver) {
				JavascriptExecutor driverExec =  (JavascriptExecutor) Driver;
							
				boolean pageLoaded[]=new boolean[] {driverExec.executeScript("return document.readyState").equals("complete")};
				return pageLoaded;
			}
		});
		System.out.println("Wait over - Page loaded.");
	}
}
