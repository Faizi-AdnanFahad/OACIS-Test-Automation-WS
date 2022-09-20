package Regresstion_testing.PageObjectModels.ApplicationPageTabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Regresstion_testing.DriverFactory;

public class BankingTab {
	private WebDriver Driver;
	private WebElement QueryTxtFld;
	private WebElement BankNameTxtFld;
	private WebElement AccountHolderTxtFld;
	private WebElement BankBranchTxtFld;
	private WebElement BankTxtFld;
	private WebElement BankAccountTxtFld;
	private WebElement BankConsentDate_txtDateTxtFld;
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
	private WebElement BankConsentProvidedBySelect;


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

	public WebElement GetBankNameTxtFld()
	{
		if(this.BankNameTxtFld==null)
			SetBankNameTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtBankName\"]")));
		return this.BankNameTxtFld;
	}

	public void SetBankNameTxtFld(WebElement bankNameTxtFld)
	{
		this.BankNameTxtFld=bankNameTxtFld;
	}

	public WebElement GetAccountHolderTxtFld()
	{
		if(this.AccountHolderTxtFld==null)
			SetAccountHolderTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtAccountHolder\"]")));
		return this.AccountHolderTxtFld;
	}

	public void SetAccountHolderTxtFld(WebElement accountHolderTxtFld)
	{
		this.AccountHolderTxtFld=accountHolderTxtFld;
	}

	public WebElement GetBankBranchTxtFld()
	{
		if(this.BankBranchTxtFld==null)
			SetBankBranchTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtBankBranch\"]")));
		return this.BankBranchTxtFld;
	}

	public void SetBankBranchTxtFld(WebElement bankBranchTxtFld)
	{
		this.BankBranchTxtFld=bankBranchTxtFld;
	}

	public WebElement GetBankTxtFld()
	{
		if(this.BankTxtFld==null)
			SetBankTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtBank\"]")));
		return this.BankTxtFld;
	}

	public void SetBankTxtFld(WebElement bankTxtFld)
	{
		this.BankTxtFld=bankTxtFld;
	}

	public WebElement GetBankAccountTxtFld()
	{
		if(this.BankAccountTxtFld==null)
			SetBankAccountTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtBankAccount\"]")));
		return this.BankAccountTxtFld;
	}

	public void SetBankAccountTxtFld(WebElement bankAccountTxtFld)
	{
		this.BankAccountTxtFld=bankAccountTxtFld;
	}

	public WebElement GetBankConsentDate_txtDateTxtFld()
	{
		if(this.BankConsentDate_txtDateTxtFld==null)
			SetBankConsentDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlBankConsentDate_txtDate\"]")));
		return this.BankConsentDate_txtDateTxtFld;
	}

	public void SetBankConsentDate_txtDateTxtFld(WebElement bankConsentDate_txtDateTxtFld)
	{
		this.BankConsentDate_txtDateTxtFld=bankConsentDate_txtDateTxtFld;
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

	public WebElement GetBankConsentProvidedBySelect()
	{
		if(this.BankConsentProvidedBySelect==null)
			SetBankConsentProvidedBySelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlBankConsentProvidedBy\"]")));
		return this.BankConsentProvidedBySelect;
	}

	public void SetBankConsentProvidedBySelect(WebElement bankConsentProvidedBySelect)
	{
		this.BankConsentProvidedBySelect=bankConsentProvidedBySelect;
	}


	public BankingTab(WebDriver driver)
	{
		DriverFactory.WaitForPageLoad(driver);
		this.Driver = driver;
	}

	public BankingTab FillQueryTxtFld(String text)
	{
		GetQueryTxtFld().sendKeys(text);
		return this;
	}


	public BankingTab FillBankNameTxtFld(String text)
	{
		GetBankNameTxtFld().sendKeys(text);
		return this;
	}


	public BankingTab FillAccountHolderTxtFld(String text)
	{
		GetAccountHolderTxtFld().sendKeys(text);
		return this;
	}


	public BankingTab FillBankBranchTxtFld(String text)
	{
		GetBankBranchTxtFld().sendKeys(text);
		return this;
	}


	public BankingTab FillBankTxtFld(String text)
	{
		GetBankTxtFld().sendKeys(text);
		return this;
	}


	public BankingTab FillBankAccountTxtFld(String text)
	{
		GetBankAccountTxtFld().sendKeys(text);
		return this;
	}


	public BankingTab FillBankConsentDate_txtDateTxtFld(String text)
	{
		GetBankConsentDate_txtDateTxtFld().sendKeys(text);
		return this;
	}

	public BankingTab ClickMainLnk()
	{
		GetMainLnk().click();
		return new BankingTab(Driver);
	}
	public BankingTab ClickQueueLnk()
	{
		GetQueueLnk().click();
		return new BankingTab(Driver);
	}
	public BankingTab ClickClientLnk()
	{
		GetClientLnk().click();
		return new BankingTab(Driver);
	}
	public BankingTab ClickReportsLnk()
	{
		GetReportsLnk().click();
		return new BankingTab(Driver);
	}
	public BankingTab ClickNewLnk()
	{
		GetNewLnk().click();
		return new BankingTab(Driver);
	}
	public BankingTab ClickSaveLnk()
	{
		GetSaveLnk().click();
		return new BankingTab(Driver);
	}
	public BankingTab ClickDeleteLnk()
	{
		GetDeleteLnk().click();
		return new BankingTab(Driver);
	}
	public BankingTab ClickAppListLnk()
	{
		GetAppListLnk().click();
		return new BankingTab(Driver);
	}
	public BankingTab ClickMergeLnk()
	{
		GetMergeLnk().click();
		return new BankingTab(Driver);
	}
	public BankingTab ClickExpensesLnk()
	{
		GetExpensesLnk().click();
		return new BankingTab(Driver);
	}
	public BankingTab ClickAuthorizationLnk()
	{
		GetAuthorizationLnk().click();
		return new BankingTab(Driver);
	}
	public BankingTab ClickNarrativesLnk()
	{
		GetNarrativesLnk().click();
		return new BankingTab(Driver);
	}
	public BankingTab SelectOptionBankConsentProvidedBySelect(WebDriver driver, String originalWindow, String optionText)
	{
		WebElement selectElement = this.GetBankConsentProvidedBySelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	// Helper Method
	private BankingTab SelectOptionGeneral(WebElement selectElement, WebDriver driver, String originalWindow, String optionText) {
		
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
