package Regresstion_testing.PageObjectModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Regresstion_testing.DriverFactory;

public class ApplicationPriorServiceTab {
	private WebDriver Driver;
	private WebElement QueryTxtFld;
	private WebElement ProviderClientInfoNumTxtFld;
	private WebElement ProviderClientDOB_txtDateTxtFld;
	private WebElement ProviderRegistrationDate_txtDateTxtFld;
	private WebElement ActiveEBBSEndDate_txtDateTxtFld;
	private WebElement MainLnk;
	private WebElement QueueLnk;
	private WebElement ClientLnk;
	private WebElement ReportsLnk;
	private WebElement NewLnk;
	private WebElement SaveLnk;
	private WebElement DeleteLnk;
	private WebElement AppListLnk;
	private WebElement MergeLnk;
	private WebElement ExpensesLnk;
	private WebElement AuthorizationLnk;
	private WebElement NarrativesLnk;
	private WebElement ProviderNameSelect;
	private WebElement MigrationOAPStatusSelect;


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

	public WebElement GetProviderClientInfoNumTxtFld()
	{
		if(this.ProviderClientInfoNumTxtFld==null)
			SetProviderClientInfoNumTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtProviderClientInfoNum\"]")));
		return this.ProviderClientInfoNumTxtFld;
	}

	public void SetProviderClientInfoNumTxtFld(WebElement providerClientInfoNumTxtFld)
	{
		this.ProviderClientInfoNumTxtFld=providerClientInfoNumTxtFld;
	}

	public WebElement GetProviderClientDOB_txtDateTxtFld()
	{
		if(this.ProviderClientDOB_txtDateTxtFld==null)
			SetProviderClientDOB_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlProviderClientDOB_txtDate\"]")));
		return this.ProviderClientDOB_txtDateTxtFld;
	}

	public void SetProviderClientDOB_txtDateTxtFld(WebElement providerClientDOB_txtDateTxtFld)
	{
		this.ProviderClientDOB_txtDateTxtFld=providerClientDOB_txtDateTxtFld;
	}

	public WebElement GetProviderRegistrationDate_txtDateTxtFld()
	{
		if(this.ProviderRegistrationDate_txtDateTxtFld==null)
			SetProviderRegistrationDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlProviderRegistrationDate_txtDate\"]")));
		return this.ProviderRegistrationDate_txtDateTxtFld;
	}

	public void SetProviderRegistrationDate_txtDateTxtFld(WebElement providerRegistrationDate_txtDateTxtFld)
	{
		this.ProviderRegistrationDate_txtDateTxtFld=providerRegistrationDate_txtDateTxtFld;
	}

	public WebElement GetActiveEBBSEndDate_txtDateTxtFld()
	{
		if(this.ActiveEBBSEndDate_txtDateTxtFld==null)
			SetActiveEBBSEndDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlActiveEBBSEndDate_txtDate\"]")));
		return this.ActiveEBBSEndDate_txtDateTxtFld;
	}

	public void SetActiveEBBSEndDate_txtDateTxtFld(WebElement activeEBBSEndDate_txtDateTxtFld)
	{
		this.ActiveEBBSEndDate_txtDateTxtFld=activeEBBSEndDate_txtDateTxtFld;
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

	public WebElement GetAppListLnk()
	{
		if(this.AppListLnk==null)
			SetAppListLnk(Driver.findElement(By.xpath("//*[@id=\"ctlAppPageNav_lnkAppList\"]")));
		return this.AppListLnk;
	}

	public void SetAppListLnk(WebElement appListLnk)
	{
		this.AppListLnk=appListLnk;
	}

	public WebElement GetMergeLnk()
	{
		if(this.MergeLnk==null)
			SetMergeLnk(Driver.findElement(By.xpath("//*[@id=\"ctlAppPageNav_lnkMerge\"]")));
		return this.MergeLnk;
	}

	public void SetMergeLnk(WebElement mergeLnk)
	{
		this.MergeLnk=mergeLnk;
	}

	public WebElement GetExpensesLnk()
	{
		if(this.ExpensesLnk==null)
			SetExpensesLnk(Driver.findElement(By.xpath("//*[@id=\"ctlAppPageNav_lnkExpenses\"]")));
		return this.ExpensesLnk;
	}

	public void SetExpensesLnk(WebElement expensesLnk)
	{
		this.ExpensesLnk=expensesLnk;
	}

	public WebElement GetAuthorizationLnk()
	{
		if(this.AuthorizationLnk==null)
			SetAuthorizationLnk(Driver.findElement(By.xpath("//*[@id=\"ctlAppPageNav_lnkAuthorization\"]")));
		return this.AuthorizationLnk;
	}

	public void SetAuthorizationLnk(WebElement authorizationLnk)
	{
		this.AuthorizationLnk=authorizationLnk;
	}

	public WebElement GetNarrativesLnk()
	{
		if(this.NarrativesLnk==null)
			SetNarrativesLnk(Driver.findElement(By.xpath("//*[@id=\"ctlAppPageNav_lnkNarratives\"]")));
		return this.NarrativesLnk;
	}

	public void SetNarrativesLnk(WebElement narrativesLnk)
	{
		this.NarrativesLnk=narrativesLnk;
	}

	public WebElement GetProviderNameSelect()
	{
		if(this.ProviderNameSelect==null)
			SetProviderNameSelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlProviderName\"]")));
		return this.ProviderNameSelect;
	}

	public void SetProviderNameSelect(WebElement providerNameSelect)
	{
		this.ProviderNameSelect=providerNameSelect;
	}

	public WebElement GetMigrationOAPStatusSelect()
	{
		if(this.MigrationOAPStatusSelect==null)
			SetMigrationOAPStatusSelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlMigrationOAPStatus\"]")));
		return this.MigrationOAPStatusSelect;
	}

	public void SetMigrationOAPStatusSelect(WebElement migrationOAPStatusSelect)
	{
		this.MigrationOAPStatusSelect=migrationOAPStatusSelect;
	}


	public ApplicationPriorServiceTab(WebDriver driver)
	{
		DriverFactory.WaitForPageLoad(driver);
		this.Driver = driver;
	}

	public ApplicationPriorServiceTab FillQueryTxtFld(String text)
	{
		GetQueryTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationPriorServiceTab FillProviderClientInfoNumTxtFld(String text)
	{
		GetProviderClientInfoNumTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationPriorServiceTab FillProviderClientDOB_txtDateTxtFld(String text)
	{
		GetProviderClientDOB_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationPriorServiceTab FillProviderRegistrationDate_txtDateTxtFld(String text)
	{
		GetProviderRegistrationDate_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationPriorServiceTab FillActiveEBBSEndDate_txtDateTxtFld(String text)
	{
		GetActiveEBBSEndDate_txtDateTxtFld().sendKeys(text);
		return this;
	}

	public ApplicationPriorServiceTab ClickMainLnk()
	{
		GetMainLnk().click();
		return new ApplicationPriorServiceTab(Driver);
	}
	public ApplicationPriorServiceTab ClickQueueLnk()
	{
		GetQueueLnk().click();
		return new ApplicationPriorServiceTab(Driver);
	}
	public ApplicationPriorServiceTab ClickClientLnk()
	{
		GetClientLnk().click();
		return new ApplicationPriorServiceTab(Driver);
	}
	public ApplicationPriorServiceTab ClickReportsLnk()
	{
		GetReportsLnk().click();
		return new ApplicationPriorServiceTab(Driver);
	}
	public ApplicationPriorServiceTab ClickNewLnk()
	{
		GetNewLnk().click();
		return new ApplicationPriorServiceTab(Driver);
	}
	public ApplicationPriorServiceTab ClickSaveLnk()
	{
		GetSaveLnk().click();
		return new ApplicationPriorServiceTab(Driver);
	}
	public ApplicationPriorServiceTab ClickDeleteLnk()
	{
		GetDeleteLnk().click();
		return new ApplicationPriorServiceTab(Driver);
	}
	public ApplicationPriorServiceTab ClickAppListLnk()
	{
		GetAppListLnk().click();
		return new ApplicationPriorServiceTab(Driver);
	}
	public ApplicationPriorServiceTab ClickMergeLnk()
	{
		GetMergeLnk().click();
		return new ApplicationPriorServiceTab(Driver);
	}
	public ApplicationPriorServiceTab ClickExpensesLnk()
	{
		GetExpensesLnk().click();
		return new ApplicationPriorServiceTab(Driver);
	}
	public ApplicationPriorServiceTab ClickAuthorizationLnk()
	{
		GetAuthorizationLnk().click();
		return new ApplicationPriorServiceTab(Driver);
	}
	public ApplicationPriorServiceTab ClickNarrativesLnk()
	{
		GetNarrativesLnk().click();
		return new ApplicationPriorServiceTab(Driver);
	}
	public ApplicationPriorServiceTab SelectOptionProviderNameSelect(WebDriver driver, String originalWindow, String optionText)
	{
		WebElement selectElement = this.GetProviderNameSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	public ApplicationPriorServiceTab SelectOptionMigrationOAPStatusSelect(WebDriver driver, String originalWindow, String optionText)
	{
		WebElement selectElement = this.GetMigrationOAPStatusSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	
	// Helper Method
	private ApplicationPriorServiceTab SelectOptionGeneral(WebElement selectElement, WebDriver driver, String originalWindow, String optionText) {
		
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
		return this;
	}
}
