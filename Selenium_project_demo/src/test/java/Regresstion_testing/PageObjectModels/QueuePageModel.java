package Regresstion_testing.PageObjectModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Regresstion_testing.DriverFactory;
import Regresstion_testing.ScreenShotHelper;
import Regresstion_testing.ScreenShotInterface;

public class QueuePageModel implements ScreenShotInterface{
	private WebDriver Driver;
	private WebElement QueryTxtFld;
	private WebElement ReceivedDate_txtDateTxtFld;
	private WebElement HourReceivedTxtFld;
	private WebElement MinuteReceivedTxtFld;
	private WebElement IdentificationTxtFld;
	private WebElement MainLnk;
	private WebElement QueueLnk;
	private WebElement ClientLnk;
	private WebElement ReportsLnk;
	private WebElement NewLnk;
	private WebElement SaveLnk;
	private WebElement DeleteLnk;
	private WebElement ListLnk;
	private WebElement FormSelect;
	private WebElement AMPMSelect;
	private WebElement FormSourceSelect;
	private WebElement FormNameSelect;
	
	
	public QueuePageModel TakeScreenShot() {
		ScreenShotHelper.TakeScreenShot(Driver);
		return this;
		
	}
	
	public QueuePageModel(WebDriver driver) {
		DriverFactory.WaitForPageLoad(driver);
		this.Driver = driver;
	}

	public WebElement GetQueryTxtFld() {
		if(this.QueryTxtFld==null)
			SetQueryTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlQueryBox_txtQuery\"]")));
		return this.QueryTxtFld;
	}

	public void SetQueryTxtFld(WebElement queryTxtFld)
	{
		this.QueryTxtFld=queryTxtFld;
	}

	public WebElement GetReceivedDate_txtDateTxtFld()
	{
		if(this.ReceivedDate_txtDateTxtFld==null)
			SetReceivedDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlQueueContent_ctlReceivedDate_txtDate\"]")));
		return this.ReceivedDate_txtDateTxtFld;
	}

	public void SetReceivedDate_txtDateTxtFld(WebElement receivedDate_txtDateTxtFld)
	{
		this.ReceivedDate_txtDateTxtFld=receivedDate_txtDateTxtFld;
	}

	public WebElement GetHourReceivedTxtFld()
	{
		if(this.HourReceivedTxtFld==null)
			SetHourReceivedTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlQueueContent_txtHourReceived\"]")));
		return this.HourReceivedTxtFld;
	}

	public void SetHourReceivedTxtFld(WebElement hourReceivedTxtFld)
	{
		this.HourReceivedTxtFld=hourReceivedTxtFld;
	}

	public WebElement GetMinuteReceivedTxtFld()
	{
		if(this.MinuteReceivedTxtFld==null)
			SetMinuteReceivedTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlQueueContent_txtMinuteReceived\"]")));
		return this.MinuteReceivedTxtFld;
	}

	public void SetMinuteReceivedTxtFld(WebElement minuteReceivedTxtFld)
	{
		this.MinuteReceivedTxtFld=minuteReceivedTxtFld;
	}

	public WebElement GetIdentificationTxtFld()
	{
		if(this.IdentificationTxtFld==null)
			SetIdentificationTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlQueueContent_txtIdentification\"]")));
		return this.IdentificationTxtFld;
	}

	public void SetIdentificationTxtFld(WebElement identificationTxtFld)
	{
		this.IdentificationTxtFld=identificationTxtFld;
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
			SetListLnk(Driver.findElement(By.xpath("//*[@id=\"ctlQueuePageNav_lnkList\"]")));
		return this.ListLnk;
	}

	public void SetListLnk(WebElement listLnk)
	{
		this.ListLnk=listLnk;
	}

	public WebElement GetFormSelect()
	{
		if(this.FormSelect==null)
			SetFormSelect(Driver.findElement(By.xpath("//*[@id=\"ctlQueueList_ddlForm\"]")));
		return this.FormSelect;
	}

	public void SetFormSelect(WebElement formSelect)
	{
		this.FormSelect=formSelect;
	}

	public WebElement GetAMPMSelect()
	{
		if(this.AMPMSelect==null)
			SetAMPMSelect(Driver.findElement(By.xpath("//*[@id=\"ctlQueueContent_ddlAMPM\"]")));
		return this.AMPMSelect;
	}

	public void SetAMPMSelect(WebElement aMPMSelect)
	{
		this.AMPMSelect=aMPMSelect;
	}

	public WebElement GetFormSourceSelect()
	{
		if(this.FormSourceSelect==null)
			SetFormSourceSelect(Driver.findElement(By.xpath("//*[@id=\"ctlQueueContent_ddlFormSource\"]")));
		return this.FormSourceSelect;
	}

	public void SetFormSourceSelect(WebElement formSourceSelect)
	{
		this.FormSourceSelect=formSourceSelect;
	}

	public WebElement GetFormNameSelect()
	{
		if(this.FormNameSelect==null)
			SetFormNameSelect(Driver.findElement(By.xpath("//*[@id=\"ctlQueueContent_ddlFormName\"]")));
		return this.FormNameSelect;
	}

	public void SetFormNameSelect(WebElement formNameSelect)
	{
		this.FormNameSelect=formNameSelect;
	}

	public QueuePageModel FillQueryTxtFld(String text)
	{
		GetQueryTxtFld().sendKeys(text);
		return this;
	}


	public QueuePageModel FillReceivedDate_txtDateTxtFld(String text)
	{
		GetReceivedDate_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public QueuePageModel FillHourReceivedTxtFld(String text)
	{
		GetHourReceivedTxtFld().sendKeys(text);
		return this;
	}


	public QueuePageModel FillMinuteReceivedTxtFld(String text)
	{
		GetMinuteReceivedTxtFld().sendKeys(text);
		return this;
	}


	public QueuePageModel FillIdentificationTxtFld(String text)
	{
		GetIdentificationTxtFld().sendKeys(text);
		return this;
	}

	public QueuePageModel ClickMainLnk()
	{
		GetMainLnk().click();
		return new QueuePageModel(Driver);
	}
	public QueuePageModel ClickQueueLnk()
	{
		GetQueueLnk().click();
		return new QueuePageModel(Driver);
	}
	public QueuePageModel ClickClientLnk()
	{
		GetClientLnk().click();
		return new QueuePageModel(Driver);
	}
	public QueuePageModel ClickReportsLnk()
	{
		GetReportsLnk().click();
		return new QueuePageModel(Driver);
	}
	public QueuePageModel ClickNewLnk()
	{
		GetNewLnk().click();
		return new QueuePageModel(Driver);
	}
	public QueuePageModel ClickSaveLnk()
	{
		GetSaveLnk().click();
		return new QueuePageModel(Driver);
	}
	public QueuePageModel ClickDeleteLnk()
	{
		GetDeleteLnk().click();
		return new QueuePageModel(Driver);
	}
	public QueuePageModel ClickListLnk()
	{
		GetListLnk().click();
		return new QueuePageModel(Driver);
	}
//	public QueuePageModel SelectOptionFormSelect(int optionNum)
//	{
//		Actions action = new Actions(Driver);
//		Select elementAsSelect = new Select(FormSelect);
//		GetFormSelect().click();
//		List<WebElement> selectOptions = elementAsSelect.getOptions();
//		for (int i = 0; i < optionNum; i++)
//		{
//			action.sendKeys(Keys.DOWN);
//		}
//		action.sendKeys(Keys.TAB);
//		action.build().perform();
//		Driver.switchTo().Window(LandingPage.BrowserWindowHandle);
//		return this;
//	}
//	public QueuePageModel SelectOptionAMPMSelect(int optionNum)
//	{
//		Actions action = new Actions(Driver);
//		Select elementAsSelect = new Select(AMPMSelect);
//		GetAMPMSelect().click();
//		List<WebElement> selectOptions = elementAsSelect.getOptions();
//		for (int i = 0; i < optionNum; i++)
//		{
//			action.sendKeys(Keys.DOWN);
//		}
//		action.sendKeys(Keys.TAB);
//		action.build().perform();
//		Driver.switchTo().Window(LandingPage.BrowserWindowHandle);
//		return this;
//	}
//	public QueuePageModel SelectOptionFormSourceSelect(int optionNum)
//	{
//		Actions action = new Actions(Driver);
//		Select elementAsSelect = new Select(FormSourceSelect);
//		GetFormSourceSelect().click();
//		List<WebElement> selectOptions = elementAsSelect.getOptions();
//		for (int i = 0; i < optionNum; i++)
//		{
//			action.sendKeys(Keys.DOWN);
//		}
//		action.sendKeys(Keys.TAB);
//		action.build().perform();
//		Driver.switchTo().Window(LandingPage.BrowserWindowHandle);
//		return this;
//	}
//	public QueuePageModel SelectOptionFormNameSelect(int optionNum)
//	{
//		Actions action = new Actions(Driver);
//		Select elementAsSelect = new Select(FormNameSelect);
//		GetFormNameSelect().click();
//		List<WebElement> selectOptions = elementAsSelect.getOptions();
//		for (int i = 0; i < optionNum; i++)
//		{
//			action.sendKeys(Keys.DOWN);
//		}
//		action.sendKeys(Keys.TAB);
//		action.build().perform();
//		Driver.switchTo().Window(LandingPage.BrowserWindowHandle);
//		return this;
//	}


}
