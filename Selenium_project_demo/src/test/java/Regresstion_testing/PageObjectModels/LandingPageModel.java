package Regresstion_testing.PageObjectModels;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import Regresstion_testing.DriverFactory;
import Regresstion_testing.POMPage;
import Regresstion_testing.ScreenShotHelper;
import Regresstion_testing.ScreenShotInterface;

public class LandingPageModel implements ScreenShotInterface{
	
	private WebDriver Driver;
	private WebElement QueryTxtFld;
	private WebElement MainLnk;
	private WebElement QueueLnk;
	private WebElement ClientLnk;
	private WebElement MaintenanceLnk;
	private WebElement ReportsLnk;
	private WebElement SupplierSearchLnk;

	public LandingPageModel TakeScreenShot() {
		ScreenShotHelper.TakeScreenShot(Driver);
		return this;
		
	}
	
	public WebElement GetQueryTxtFld()
	{
		if(this.QueryTxtFld==null)
			SetQueryTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlQueryBox_txtQuery\"]")));
		return this.QueryTxtFld;
	}

	public void SetQueryTxtFld(WebElement queryTxtFld)
	{
		this.QueryTxtFld=queryTxtFld;
	}

	public WebElement GetMainLnk()
	{
		if(this.MainLnk==null)
			SetMainLnk(Driver.findElement(By.xpath("//*[@id=\"ctlPrimaryNav_lnkMain\"]")));
		return this.MainLnk;
	}

	public void SetMainLnk(WebElement mainLnk)
	{
		this.MainLnk=mainLnk;
	}

	public WebElement GetQueueLnk()
	{
		if(this.QueueLnk==null)
			SetQueueLnk(Driver.findElement(By.xpath("//*[@id=\"ctlPrimaryNav_lnkQueue\"]")));
		return this.QueueLnk;
	}

	public void SetQueueLnk(WebElement queueLnk)
	{
		this.QueueLnk=queueLnk;
	}

	public WebElement GetClientLnk()
	{
		if(this.ClientLnk==null)
			SetClientLnk(Driver.findElement(By.xpath("//*[@id=\"ctlPrimaryNav_lnkClient\"]")));
		return this.ClientLnk;
	}

	public void SetClientLnk(WebElement clientLnk)
	{
		this.ClientLnk=clientLnk;
	}

	public WebElement GetMaintenanceLnk()
	{
		if(this.MaintenanceLnk==null)
			SetMaintenanceLnk(Driver.findElement(By.xpath("//*[@id=\"ctlPrimaryNav_lnkMaintenance\"]")));
		return this.MaintenanceLnk;
	}

	public void SetMaintenanceLnk(WebElement maintenanceLnk)
	{
		this.MaintenanceLnk=maintenanceLnk;
	}

	public WebElement GetReportsLnk()
	{
		if(this.ReportsLnk==null)
			SetReportsLnk(Driver.findElement(By.xpath("//*[@id=\"ctlPrimaryNav_lnkReports\"]")));
		return this.ReportsLnk;
	}

	public void SetReportsLnk(WebElement reportsLnk)
	{
		this.ReportsLnk=reportsLnk;
	}

	public WebElement GetSupplierSearchLnk()
	{
		if(this.SupplierSearchLnk==null)
			SetSupplierSearchLnk(Driver.findElement(By.xpath("//*[@id=\"ctlPageNav_lnkSupplierSearch\"]")));
		return this.SupplierSearchLnk;
	}

	public void SetSupplierSearchLnk(WebElement supplierSearchLnk)
	{
		this.SupplierSearchLnk=supplierSearchLnk;
	}


	public LandingPageModel(WebDriver driver)
	{
		DriverFactory.WaitForPageLoad(driver);
		this.Driver = driver;
	}

	public LandingPageModel FillQueryTxtFld(String text)
	{
		GetQueryTxtFld().sendKeys(text);
		return this;
	}

//		public Place_Holder ClickMainLnk()
//		{
//			GetMainLnk().click();
//			return new Place_Holder(Driver);
//		}
//		public Place_Holder ClickQueueLnk()
//		{
//			GetQueueLnk().click();
//			return new Place_Holder(Driver);
//		}
	public ClientPageModel ClickClientLnk()
	{
		GetClientLnk().click();
		return new ClientPageModel(Driver);
	}
//		public Place_Holder ClickMaintenanceLnk()
//		{
//			GetMaintenanceLnk().click();
//			return new Place_Holder(Driver);
//		}
//		public Place_Holder ClickReportsLnk()
//		{
//			GetReportsLnk().click();
//			return new Place_Holder(Driver);
//		}
//		public Place_Holder ClickSupplierSearchLnk()
//		{
//			GetSupplierSearchLnk().click();
//			return new Place_Holder(Driver);
//		}


}


