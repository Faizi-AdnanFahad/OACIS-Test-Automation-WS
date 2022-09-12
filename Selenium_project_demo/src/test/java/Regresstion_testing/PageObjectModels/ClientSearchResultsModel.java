package Regresstion_testing.PageObjectModels;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Regresstion_testing.DriverFactory;
import Regresstion_testing.POMPage;
import Regresstion_testing.ScreenShotHelper;
import Regresstion_testing.ScreenShotInterface;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.ContactTab;

public class ClientSearchResultsModel implements ScreenShotInterface {
	

	

	
	private WebDriver Driver;
	private WebElement QueryTxtFld;
	private WebElement NameTxtFld;
	private WebElement MainLnk;
	private WebElement QueueLnk;
	private WebElement ClientLnk;
	private WebElement MaintenanceLnk;
	private WebElement ReportsLnk;
	private WebElement NewLnk;
	private WebElement SaveLnk;
	private WebElement DeleteLnk;
	private WebElement ListLnk;
	private WebElement MergeLnk;
	private WebElement ApplicationsLnk;
	private WebElement SearchLnk;
	private WebElement ExactMatchCheckBox;
	private WebElement AccessOAPCheckBox;

	public ClientSearchResultsModel TakeScreenShot() {
		ScreenShotHelper.TakeScreenShot(Driver);
		return this;
		
	}
	
	public ClientInformationModel ClickFirstRow() {
		 Driver.findElement(By.className("GridRow1")).click(); 
		 return new ClientInformationModel(Driver);
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

	public WebElement GetNameTxtFld()
	{
		if(this.NameTxtFld==null)
			SetNameTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientSearch_txtName\"]")));
		return this.NameTxtFld;
	}

	public void SetNameTxtFld(WebElement nameTxtFld)
	{
		this.NameTxtFld=nameTxtFld;
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

	public WebElement GetNewLnk()
	{
		if(this.NewLnk==null)
			SetNewLnk(Driver.findElement(By.xpath("//*[@id=\"ctlStandardOperations_lnkNew\"]")));
		return this.NewLnk;
	}

	public void SetNewLnk(WebElement newLnk)
	{
		this.NewLnk=newLnk;
	}

	public WebElement GetSaveLnk()
	{
		if(this.SaveLnk==null)
			SetSaveLnk(Driver.findElement(By.xpath("//*[@id=\"ctlStandardOperations_lnkSave\"]")));
		return this.SaveLnk;
	}

	public void SetSaveLnk(WebElement saveLnk)
	{
		this.SaveLnk=saveLnk;
	}

	public WebElement GetDeleteLnk()
	{
		if(this.DeleteLnk==null)
			SetDeleteLnk(Driver.findElement(By.xpath("//*[@id=\"ctlStandardOperations_lnkDelete\"]")));
		return this.DeleteLnk;
	}

	public void SetDeleteLnk(WebElement deleteLnk)
	{
		this.DeleteLnk=deleteLnk;
	}

	public WebElement GetListLnk()
	{
		if(this.ListLnk==null)
			SetListLnk(Driver.findElement(By.xpath("//*[@id=\"ctlPageNav_lnkList\"]")));
		return this.ListLnk;
	}

	public void SetListLnk(WebElement listLnk)
	{
		this.ListLnk=listLnk;
	}

	public WebElement GetMergeLnk()
	{
		if(this.MergeLnk==null)
			SetMergeLnk(Driver.findElement(By.xpath("//*[@id=\"ctlPageNav_lnkMerge\"]")));
		return this.MergeLnk;
	}

	public void SetMergeLnk(WebElement mergeLnk)
	{
		this.MergeLnk=mergeLnk;
	}

	public WebElement GetApplicationsLnk()
	{
		if(this.ApplicationsLnk==null)
			SetApplicationsLnk(Driver.findElement(By.xpath("//*[@id=\"ctlPageNav_lnkApplications\"]")));
		return this.ApplicationsLnk;
	}

	public void SetApplicationsLnk(WebElement applicationsLnk)
	{
		this.ApplicationsLnk=applicationsLnk;
	}

	public WebElement GetSearchLnk()
	{
		if(this.SearchLnk==null)
			SetSearchLnk(Driver.findElement(By.xpath("//*[@id=\"ctlClientSearch_lnkSearch\"]")));
		return this.SearchLnk;
	}

	public void SetSearchLnk(WebElement searchLnk)
	{
		this.SearchLnk=searchLnk;
	}

	public WebElement GetExactMatchCheckBox()
	{
		if(this.ExactMatchCheckBox==null)
			SetExactMatchCheckBox(Driver.findElement(By.xpath("//*[@id=\"ctlClientSearch_chkExactMatch\"]")));
		return this.ExactMatchCheckBox;
	}

	public void SetExactMatchCheckBox(WebElement exactMatchCheckBox)
	{
		this.ExactMatchCheckBox=exactMatchCheckBox;
	}

	public WebElement GetAccessOAPCheckBox()
	{
		if(this.AccessOAPCheckBox==null)
			SetAccessOAPCheckBox(Driver.findElement(By.xpath("//*[@id=\"ctlClientSearch_chkAccessOAP\"]")));
		return this.AccessOAPCheckBox;
	}

	public void SetAccessOAPCheckBox(WebElement accessOAPCheckBox)
	{
		this.AccessOAPCheckBox=accessOAPCheckBox;
	}


	public ClientSearchResultsModel(WebDriver driver)
	{
		DriverFactory.WaitForPageLoad(driver);
		this.Driver = driver;
	}

	public ClientSearchResultsModel FillQueryTxtFld(String text)
	{
		GetQueryTxtFld().sendKeys(text);
		return this;
	}


	public ClientSearchResultsModel FillNameTxtFld(String text)
	{
		GetNameTxtFld().sendKeys(text);
		return this;
	}

//	public Place_Holder ClickMainLnk()
//	{
//		GetMainLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickQueueLnk()
//	{
//		GetQueueLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickClientLnk()
//	{
//		GetClientLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickMaintenanceLnk()
//	{
//		GetMaintenanceLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickReportsLnk()
//	{
//		GetReportsLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickNewLnk()
//	{
//		GetNewLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickSaveLnk()
//	{
//		GetSaveLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickDeleteLnk()
//	{
//		GetDeleteLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickListLnk()
//	{
//		GetListLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickMergeLnk()
//	{
//		GetMergeLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickApplicationsLnk()
//	{
//		GetApplicationsLnk().click();
//		return new Place_Holder(Driver);
//	}
	public ClientInformationModel ClickSearchLnk()
	{
		GetSearchLnk().click();
		return new ClientInformationModel (Driver);
	}
	public ClientSearchResultsModel ClickExactMatchCheckBox()
	{
		GetExactMatchCheckBox().click();
		return this;
	}
	public ClientSearchResultsModel ClickAccessOAPCheckBox()
	{
		GetAccessOAPCheckBox().click();
		return this;
	}



}