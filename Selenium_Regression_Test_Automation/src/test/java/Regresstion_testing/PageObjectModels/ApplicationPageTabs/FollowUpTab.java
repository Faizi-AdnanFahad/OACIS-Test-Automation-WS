package Regresstion_testing.PageObjectModels.ApplicationPageTabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Regresstion_testing.DriverFactory;

public class FollowUpTab {
	private WebDriver Driver;
	private WebElement QueryTxtFld;
	private WebElement FollowUpDate_txtDateTxtFld;
	private WebElement DiagnosisRemovedDate_txtDateTxtFld;
	private WebElement ClosedDate_txtDateTxtFld;
	private WebElement ExpensesProvidedDate_txtDateTxtFld;
	private WebElement AttestationProvidedDate_txtDateTxtFld;
	private WebElement ClinicalSupervisorTxtFld;
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
	private WebElement ClosureReasonSelect;


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

	public WebElement GetFollowUpDate_txtDateTxtFld()
	{
		if(this.FollowUpDate_txtDateTxtFld==null)
			SetFollowUpDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlFollowUpDate_txtDate\"]")));
		return this.FollowUpDate_txtDateTxtFld;
	}

	public void SetFollowUpDate_txtDateTxtFld(WebElement followUpDate_txtDateTxtFld)
	{
		this.FollowUpDate_txtDateTxtFld=followUpDate_txtDateTxtFld;
	}

	public WebElement GetDiagnosisRemovedDate_txtDateTxtFld()
	{
		if(this.DiagnosisRemovedDate_txtDateTxtFld==null)
			SetDiagnosisRemovedDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlDiagnosisRemovedDate_txtDate\"]")));
		return this.DiagnosisRemovedDate_txtDateTxtFld;
	}

	public void SetDiagnosisRemovedDate_txtDateTxtFld(WebElement diagnosisRemovedDate_txtDateTxtFld)
	{
		this.DiagnosisRemovedDate_txtDateTxtFld=diagnosisRemovedDate_txtDateTxtFld;
	}

	public WebElement GetClosedDate_txtDateTxtFld()
	{
		if(this.ClosedDate_txtDateTxtFld==null)
			SetClosedDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlClosedDate_txtDate\"]")));
		return this.ClosedDate_txtDateTxtFld;
	}

	public void SetClosedDate_txtDateTxtFld(WebElement closedDate_txtDateTxtFld)
	{
		this.ClosedDate_txtDateTxtFld=closedDate_txtDateTxtFld;
	}

	public WebElement GetExpensesProvidedDate_txtDateTxtFld()
	{
		if(this.ExpensesProvidedDate_txtDateTxtFld==null)
			SetExpensesProvidedDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlExpensesProvidedDate_txtDate\"]")));
		return this.ExpensesProvidedDate_txtDateTxtFld;
	}

	public void SetExpensesProvidedDate_txtDateTxtFld(WebElement expensesProvidedDate_txtDateTxtFld)
	{
		this.ExpensesProvidedDate_txtDateTxtFld=expensesProvidedDate_txtDateTxtFld;
	}

	public WebElement GetAttestationProvidedDate_txtDateTxtFld()
	{
		if(this.AttestationProvidedDate_txtDateTxtFld==null)
			SetAttestationProvidedDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlAttestationProvidedDate_txtDate\"]")));
		return this.AttestationProvidedDate_txtDateTxtFld;
	}

	public void SetAttestationProvidedDate_txtDateTxtFld(WebElement attestationProvidedDate_txtDateTxtFld)
	{
		this.AttestationProvidedDate_txtDateTxtFld=attestationProvidedDate_txtDateTxtFld;
	}

	public WebElement GetClinicalSupervisorTxtFld()
	{
		if(this.ClinicalSupervisorTxtFld==null)
			SetClinicalSupervisorTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtClinicalSupervisor\"]")));
		return this.ClinicalSupervisorTxtFld;
	}

	public void SetClinicalSupervisorTxtFld(WebElement clinicalSupervisorTxtFld)
	{
		this.ClinicalSupervisorTxtFld=clinicalSupervisorTxtFld;
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

	public WebElement GetClosureReasonSelect()
	{
		if(this.ClosureReasonSelect==null)
			SetClosureReasonSelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlClosureReason\"]")));
		return this.ClosureReasonSelect;
	}

	public void SetClosureReasonSelect(WebElement closureReasonSelect)
	{
		this.ClosureReasonSelect=closureReasonSelect;
	}


	public FollowUpTab(WebDriver driver)
	{
		DriverFactory.WaitForPageLoad(driver);
		this.Driver = driver;
	}

	public FollowUpTab FillQueryTxtFld(String text)
	{
		GetQueryTxtFld().sendKeys(text);
		return this;
	}


	public FollowUpTab FillFollowUpDate_txtDateTxtFld(String text)
	{
		GetFollowUpDate_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public FollowUpTab FillDiagnosisRemovedDate_txtDateTxtFld(String text)
	{
		GetDiagnosisRemovedDate_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public FollowUpTab FillClosedDate_txtDateTxtFld(String text)
	{
		GetClosedDate_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public FollowUpTab FillExpensesProvidedDate_txtDateTxtFld(String text)
	{
		GetExpensesProvidedDate_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public FollowUpTab FillAttestationProvidedDate_txtDateTxtFld(String text)
	{
		GetAttestationProvidedDate_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public FollowUpTab FillClinicalSupervisorTxtFld(String text)
	{
		GetClinicalSupervisorTxtFld().sendKeys(text);
		return this;
	}

	public FollowUpTab ClickMainLnk()
	{
		GetMainLnk().click();
		return new FollowUpTab(Driver);
	}
	public FollowUpTab ClickQueueLnk()
	{
		GetQueueLnk().click();
		return new FollowUpTab(Driver);
	}
	public FollowUpTab ClickClientLnk()
	{
		GetClientLnk().click();
		return new FollowUpTab(Driver);
	}
	public FollowUpTab ClickReportsLnk()
	{
		GetReportsLnk().click();
		return new FollowUpTab(Driver);
	}
	public FollowUpTab ClickNewLnk()
	{
		GetNewLnk().click();
		return new FollowUpTab(Driver);
	}
	public FollowUpTab ClickSaveLnk()
	{
		GetSaveLnk().click();
		return new FollowUpTab(Driver);
	}
	public FollowUpTab ClickDeleteLnk()
	{
		GetDeleteLnk().click();
		return new FollowUpTab(Driver);
	}
	public FollowUpTab ClickAppListLnk()
	{
		GetAppListLnk().click();
		return new FollowUpTab(Driver);
	}
	public FollowUpTab ClickMergeLnk()
	{
		GetMergeLnk().click();
		return new FollowUpTab(Driver);
	}
	public FollowUpTab ClickExpensesLnk()
	{
		GetExpensesLnk().click();
		return new FollowUpTab(Driver);
	}
	public FollowUpTab ClickAuthorizationLnk()
	{
		GetAuthorizationLnk().click();
		return new FollowUpTab(Driver);
	}
	public FollowUpTab ClickNarrativesLnk()
	{
		GetNarrativesLnk().click();
		return new FollowUpTab(Driver);
	}
	public FollowUpTab SelectOptionClosureReasonSelect(WebDriver driver, String originalWindow, String optionText)
	{
		WebElement selectElement = this.GetClosureReasonSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	
	// Helper Method
	private FollowUpTab SelectOptionGeneral(WebElement selectElement, WebDriver driver, String originalWindow, String optionText) {
		
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