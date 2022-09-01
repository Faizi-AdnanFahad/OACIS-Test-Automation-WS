package Regresstion_testing.PomTestCases;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Regresstion_testing.ClientDriver;
import Regresstion_testing.PageObjectModels.ClientPageModel;

public class OAP_2046POM {
	private WebDriver driver;
	  private String originalWindow;  // stores the original window. Useful to shift back to it when changing the focus of the window to drop-down list or similar things.
	  private ClientDriver cd;
	  
	@Before
	public void setUp() {
		cd = new ClientDriver();
		driver = cd.getDriver();
		originalWindow = driver.getWindowHandle();
	}
	@Test
	public void test() {
		
		String clientLastName = "Maggi Maggi";

		/***********************************************************************************************/
		// 1. User navigates to OACIS --> User should be able to access OACIS page
		cd.launchOACIS();
		
		// 2. User clicks the "client" page --> User should be able to view client search page
		ClientPageModel clientPage = new ClientPageModel(driver);
		clientPage.ClickClientLnk();
		
		// 3. User searches for client name --> User should be able to enter keywords to find a matching record
		clientPage.FillNameTxtFld(clientLastName);
		clientPage.GetSearchLnk().click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	    // clicks the first client that appears
	    driver.findElement(By.className("GridRow1")).click();
	    
		// 4. User clicks on "List" on the side tab --> User should be able to view a list of applications available
		clientPage.GetApplicationsLnk().click();
		
		// Finding the number of applications
		int numOfapplicant = 0;
		String numOfApplicationMsg = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div/div[1]/table/tbody/tr/td[2]/span")).getText();
		if (!numOfApplicationMsg.equals("There are no applications for this client.")) {
			numOfapplicant = numOfApplicationMsg.charAt(0) - '0';
		}
		System.out.println(numOfapplicant);
		///html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[2]/td[2]/span
		///html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[3]/td[2]/span
		///html/body/form/table/tbody/tr/td[2]/div/div[2]/table/tbody/tr[3]
		/***********************************************************************************************/
	}

}

























