//package Regresstion_testing;
//
//import static org.junit.Assert.*;
//
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import Regresstion_testing.PageObjectModels.ClientPageModel;
//
//public class OAP_2043 {
//
//	@Test
//	public void test() {
//		String clientLastName = "oap2041TestL";
//
//		ClientDriver cd = new ClientDriver();
//		WebDriver driver = cd.getDriver();
//
//		// 1. User navigates to OACIS  --> User should be able to access OACIS page
//		cd.launchOACIS();
//		
//		// 2. User clicks the "client" page --> User should be able to view client search page
//		cd.searchForClientByLastName(clientLastName); // 2. User clicks the "client" page 3. User searches for client name
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
//	    driver.findElement(By.className("GridRow1")).click(); // clicks the first client that appears
//	    
//	    ClientPageModel cpm = new ClientPageModel(driver);
//	    cpm.GetApplicationsLnk().click(); // Clicks on the application page.
//	    
//	    
////	    Map<String, String> contactObj = new HashMap<String, String>();
////	    // User enters/confirms information in "Contacts" tab
////		contactObj.put("applicantFirstName", "Amanda Johsnon");
////		contactObj.put("applicantLastName", "AJP F");
////		contactObj.put("unitNum", "14");
////		contactObj.put("streetNum", "144");
////		contactObj.put("streetName", "Main Street");
////		contactObj.put("city", "Hamilton");
////		contactObj.put("postalCode", "H1J 2K4");
////	    cd.fillUpContactTab(contactObj);
//	}
//
//}
