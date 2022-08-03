package getting_started;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.codec.w3c.W3CHttpCommandCodec;
import org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.codec.w3c.W3CHttpCommandCodec;
import org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import java.util.*;
import java.io.IOException;
import java.lang.reflect.Field;

public class DriverVariations {
	  private WebDriver eDriver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
	    //**********Create IE driver: manually*********************
				//	WebDriver ieDriver;
				//	System.setProperty("webdriver.ie.driver","C:\\Users\\OKeeffKy\\SeleniumDrivers\\32bit\\IEDriverServer.exe");
				//	InternetExplorerOptions ieOptions = new InternetExplorerOptions();
				//	ieOptions.attachToEdgeChrome();
				//	ieOptions.withEdgeExecutablePath("C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe");
				//	ieOptions.introduceFlakinessByIgnoringSecurityDomains();//IntroduceInstabilityByIgnoringProtectedModeSettings = true;
				//	driver = new InternetExplorerDriver(ieOptions);
				//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//**********Create IE driver: with Driver manager*********************
		  		//	WebDriver ieDriver;
				//	InternetExplorerOptions options = new InternetExplorerOptions();	
				//	ieOptions.attachToEdgeChrome();
				//	ieOptions.withEdgeExecutablePath("C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe");
				//	ieOptions.introduceFlakinessByIgnoringSecurityDomains();//IntroduceInstabilityByIgnoringProtectedModeSettings = true;
				//	ieDriver = WebDriverManager.iedriver().capabilities(ieOptions).create();
				//	WebDriverManager.iedriver().setup();
				//	ieDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//	js = (JavascriptExecutor) eDriver;
				//	vars = new HashMap<String, Object>();
						
			
		//**********Create Edge driver manually*********************
				System.setProperty("webdriver.edge.driver","C:\\Users\\OKeeffKy\\SeleniumDrivers\\edgedriver_win32\\msedgedriver.exe");
				WebDriver eDriver;
				EdgeOptions eOptions = new EdgeOptions();
				eOptions.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
				// eOptions.addExtensions(new File("C:\\Users\\OKeeffKy\\OneDrive - Government of Ontario\\Documents\\02Projects\\ProgProj\\OACISSeleniumJava\\Selenium-IDE-chromeext.crx"));
				// https://microsoftedge.microsoft.com/addons/detail/open-in-ie/ncemgeeikbbjoojolbihkpcoiomidhfi
				eDriver = new EdgeDriver(eOptions);
				//driver = WebDriverManager.iedriver().capabilities(ieOptions).create();
		   
		//**********Create Edge Driver: via DriverManager*********************
				// WebDriver eDriver;
				// EdgeOptions eOptions = new EdgeOptions();
				// System.setProperty("webdriver.edge.driver","C:\\Users\\OKeeffKy\\SeleniumDrivers\\edgedriver_win32\\msedgedriver.exe");
				// eOptions.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
				// eOptions.addExtensions(new File("C:\\Users\\OKeeffKy\\OneDrive - Government of Ontario\\Documents\\02Projects\\ProgProj\\OACISSeleniumJava\\Selenium-IDE-chromeext.crx"));
				// WebDriverManager.edgedriver().setup();
			    // edgeDriver.create().capabilities(eOptions).create();
				// eDriver = WebDriverManager.edgedriver().create();
				// eDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				// js = (JavascriptExecutor) eDriver;
				// vars = new HashMap<String, Object>();
				
		//**********Remote Driver test - for switching between IE and Edge Driver*********
				// HttpCommandExecutor executor = (HttpCommandExecutor) driver.getCommandExecutor();
				// URL url = executor.getAddressOfRemoteServer();
				// SessionId session_id = driver.getSessionId();
				// driver = createDriverFromSession(session_id, url);
	  }
	  
	  public static RemoteWebDriver createDriverFromSession(final SessionId sessionId, URL command_executor){//Create remote driver to allow switching between ie and edge driver
		    CommandExecutor executor = new HttpCommandExecutor(command_executor) {

		    @Override
		    public Response execute(Command command) throws IOException {
		        Response response = null;
		        if (command.getName() == "newSession") {
		            response = new Response();
		            response.setSessionId(sessionId.toString());
		            response.setStatus(0);
		            response.setValue(Collections.<String, String>emptyMap());

		            try {
		                Field commandCodec = null;
		                commandCodec = this.getClass().getSuperclass().getDeclaredField("commandCodec");
		                commandCodec.setAccessible(true);
		                commandCodec.set(this, new W3CHttpCommandCodec());

		                Field responseCodec = null;
		                responseCodec = this.getClass().getSuperclass().getDeclaredField("responseCodec");
		                responseCodec.setAccessible(true);
		                responseCodec.set(this, new W3CHttpResponseCodec());
		            } catch (NoSuchFieldException e) {
		                e.printStackTrace();
		            } catch (IllegalAccessException e) {
		                e.printStackTrace();
		            }

		        } else {
		            response = super.execute(command);
		        }
		        return response;
		    }
		    };

		    return new RemoteWebDriver(executor, new DesiredCapabilities());
		}
	  @After
	  public void tearDown() {
	    //driver.quit();
	  }
	  @Test
	  public void TestNavigation() {
		// driver.get("https://microsoftedge.microsoft.com/addons/detail/selenium-ide/ajdpfmkffanmkhejnopjppegokpogffp");
	    eDriver.get("http://intra.stage.oacis.children.gov.on.ca/");
//	    driver.manage().window().setSize(new Dimension(974, 1040));
//	    driver.findElement(By.id("ctlQueryBox_txtQuery")).click();
//	    driver.findElement(By.id("ctlQueryBox_txtQuery")).sendKeys("jh");
//	    driver.findElement(By.id("ctlQueryBox_txtQuery")).sendKeys(Keys.ENTER);
//	    driver.findElement(By.id("ctlClientSearch_dgdClientSearch__ctl2_lblApplicantName")).click();
//	    driver.findElement(By.id("ctlPageNav_lnkApplications")).click();
//	    driver.findElement(By.cssSelector(".GridRowHighlight > td:nth-child(2)")).click();
	  }
	}


