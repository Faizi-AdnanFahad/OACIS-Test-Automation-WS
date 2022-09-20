package Regresstion_testing.PageObjectModels.AuthorizationPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Regresstion_testing.DriverFactory;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.BankingTab;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.FollowUpTab;

public class ServiceLinesPage {
	private WebDriver Driver;
	private WebElement QueryTxtFld;
	private WebElement UnitsTxtFld;
	private WebElement RateTxtFld;
	private WebElement AmountTxtFld;
	private WebElement MainLnk;
	private WebElement QueueLnk;
	private WebElement ClientLnk;
	private WebElement ReportsLnk;
	private WebElement NewLnk;
	private WebElement SaveLnk;
	private WebElement DeleteLnk;
	private WebElement AuthListLnk;
	private WebElement ServiceLinesLnk;
	private WebElement PaymentsLnk;
	private WebElement ApplicationLnk;
	private WebElement BusinessUnitSelect;


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

	public WebElement GetUnitsTxtFld()
	{
		if(this.UnitsTxtFld==null)
			SetUnitsTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlServiceLines_txtUnits\"]")));
		return this.UnitsTxtFld;
	}

	public void SetUnitsTxtFld(WebElement unitsTxtFld)
	{
		this.UnitsTxtFld=unitsTxtFld;
	}

	public WebElement GetRateTxtFld()
	{
		if(this.RateTxtFld==null)
			SetRateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlServiceLines_txtRate\"]")));
		return this.RateTxtFld;
	}

	public void SetRateTxtFld(WebElement rateTxtFld)
	{
		this.RateTxtFld=rateTxtFld;
	}

	public WebElement GetAmountTxtFld()
	{
		if(this.AmountTxtFld==null)
			SetAmountTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlServiceLines_txtAmount\"]")));
		return this.AmountTxtFld;
	}

	public void SetAmountTxtFld(WebElement amountTxtFld)
	{
		this.AmountTxtFld=amountTxtFld;
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

	public WebElement GetAuthListLnk()
	{
		if(this.AuthListLnk==null)
			SetAuthListLnk(Driver.findElement(By.xpath("//*[@id=\"ctlAuthPageNav_lnkAuthList\"]")));
		return this.AuthListLnk;
	}

	public void SetAuthListLnk(WebElement authListLnk)
	{
		this.AuthListLnk=authListLnk;
	}

	public WebElement GetServiceLinesLnk()
	{
		if(this.ServiceLinesLnk==null)
			SetServiceLinesLnk(Driver.findElement(By.xpath("//*[@id=\"ctlAuthPageNav_lnkServiceLines\"]")));
		return this.ServiceLinesLnk;
	}

	public void SetServiceLinesLnk(WebElement serviceLinesLnk)
	{
		this.ServiceLinesLnk=serviceLinesLnk;
	}

	public WebElement GetPaymentsLnk()
	{
		if(this.PaymentsLnk==null)
			SetPaymentsLnk(Driver.findElement(By.xpath("//*[@id=\"ctlAuthPageNav_lnkPayments\"]")));
		return this.PaymentsLnk;
	}

	public void SetPaymentsLnk(WebElement paymentsLnk)
	{
		this.PaymentsLnk=paymentsLnk;
	}

	public WebElement GetApplicationLnk()
	{
		if(this.ApplicationLnk==null)
			SetApplicationLnk(Driver.findElement(By.xpath("//*[@id=\"ctlAuthPageNav_lnkApplication\"]")));
		return this.ApplicationLnk;
	}

	public void SetApplicationLnk(WebElement applicationLnk)
	{
		this.ApplicationLnk=applicationLnk;
	}

	public WebElement GetBusinessUnitSelect()
	{
		if(this.BusinessUnitSelect==null)
			SetBusinessUnitSelect(Driver.findElement(By.xpath("//*[@id=\"ctlServiceLines_ddlBusinessUnit\"]")));
		return this.BusinessUnitSelect;
	}

	public void SetBusinessUnitSelect(WebElement businessUnitSelect)
	{
		this.BusinessUnitSelect=businessUnitSelect;
	}


	public ServiceLinesPage(WebDriver driver)
	{
		DriverFactory.WaitForPageLoad(driver);
		this.Driver = driver;
	}

	public ServiceLinesPage FillQueryTxtFld(String text)
	{
		GetQueryTxtFld().sendKeys(text);
		return this;
	}


	public ServiceLinesPage FillUnitsTxtFld(String text)
	{
		GetUnitsTxtFld().sendKeys(text);
		return this;
	}


	public ServiceLinesPage FillRateTxtFld(String text)
	{
		GetRateTxtFld().sendKeys(text);
		return this;
	}


	public ServiceLinesPage FillAmountTxtFld(String text)
	{
		GetAmountTxtFld().sendKeys(text);
		return this;
	}

	public ServiceLinesPage ClickMainLnk()
	{
		GetMainLnk().click();
		return new ServiceLinesPage(Driver);
	}
	public ServiceLinesPage ClickQueueLnk()
	{
		GetQueueLnk().click();
		return new ServiceLinesPage(Driver);
	}
	public ServiceLinesPage ClickClientLnk()
	{
		GetClientLnk().click();
		return new ServiceLinesPage(Driver);
	}
	public ServiceLinesPage ClickReportsLnk()
	{
		GetReportsLnk().click();
		return new ServiceLinesPage(Driver);
	}
	public ServiceLinesPage ClickNewLnk()
	{
		GetNewLnk().click();
		return new ServiceLinesPage(Driver);
	}
	public ServiceLinesPage ClickSaveLnk()
	{
		GetSaveLnk().click();
		return new ServiceLinesPage(Driver);
	}
	public ServiceLinesPage ClickDeleteLnk()
	{
		GetDeleteLnk().click();
		return new ServiceLinesPage(Driver);
	}
	public ServiceLinesPage ClickAuthListLnk()
	{
		GetAuthListLnk().click();
		return new ServiceLinesPage(Driver);
	}
	public ServiceLinesPage ClickServiceLinesLnk()
	{
		GetServiceLinesLnk().click();
		return new ServiceLinesPage(Driver);
	}
	public ServiceLinesPage ClickPaymentsLnk()
	{
		GetPaymentsLnk().click();
		return new ServiceLinesPage(Driver);
	}
	public ServiceLinesPage ClickApplicationLnk()
	{
		GetApplicationLnk().click();
		return new ServiceLinesPage(Driver);
	}
	public ServiceLinesPage SelectOptionBusinessUnitSelect(WebDriver driver, String originalWindow, String optionText)
	{
		WebElement selectElement = this.GetBusinessUnitSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	// Helper Method
	private ServiceLinesPage SelectOptionGeneral(WebElement selectElement, WebDriver driver, String originalWindow, String optionText) {
		
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
