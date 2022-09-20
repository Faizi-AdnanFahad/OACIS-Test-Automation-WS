package Regresstion_testing.PageObjectModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Regresstion_testing.DriverFactory;
import Regresstion_testing.PageObjectModels.ApplicationPageTabs.BudgetTab;

public class NewClientPageModel {
	private WebDriver Driver;
	private WebElement QueryTxtFld;
	private WebElement OAPClientNumberTxtFld;
	private WebElement IIO_TransitionCodeTxtFld;
	private WebElement RegistrationDateTxtFld;
	private WebElement LastNameTxtFld;
	private WebElement FirstNameTxtFld;
	private WebElement MiddleNameTxtFld;
	private WebElement Dob_txtDateTxtFld;
	private WebElement DoNInvitationDate_txtDateTxtFld;
	private WebElement IIO_InvitationSentDateTxtFld;
	private WebElement IIO_DossierSentDateTxtFld;
	private WebElement ConsentProviderNameTxtFld;
	private WebElement DateFieldNoTransferConfirmedTxtFld;
	private WebElement MainLnk;
	private WebElement QueueLnk;
	private WebElement ClientLnk;
	private WebElement ReportsLnk;
	private WebElement NewLnk;
	private WebElement SaveLnk;
	private WebElement DeleteLnk;
	private WebElement ListLnk;
	private WebElement MergeLnk;
	private WebElement ApplicationsLnk;
	private WebElement _LockStatusSelect;
	private WebElement TitleSelect;
	private WebElement GenderSelect;


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

	public WebElement GetOAPClientNumberTxtFld()
	{
		if(this.OAPClientNumberTxtFld==null)
			SetOAPClientNumberTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_txtOAPClientNumber\"]")));
		return this.OAPClientNumberTxtFld;
	}

	public void SetOAPClientNumberTxtFld(WebElement oAPClientNumberTxtFld)
	{
		this.OAPClientNumberTxtFld=oAPClientNumberTxtFld;
	}

	public WebElement GetIIO_TransitionCodeTxtFld()
	{
		if(this.IIO_TransitionCodeTxtFld==null)
			SetIIO_TransitionCodeTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_txtIIO_TransitionCode\"]")));
		return this.IIO_TransitionCodeTxtFld;
	}

	public void SetIIO_TransitionCodeTxtFld(WebElement iIO_TransitionCodeTxtFld)
	{
		this.IIO_TransitionCodeTxtFld=iIO_TransitionCodeTxtFld;
	}

	public WebElement GetRegistrationDateTxtFld()
	{
		if(this.RegistrationDateTxtFld==null)
			SetRegistrationDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_txtRegistrationDate\"]")));
		return this.RegistrationDateTxtFld;
	}

	public void SetRegistrationDateTxtFld(WebElement registrationDateTxtFld)
	{
		this.RegistrationDateTxtFld=registrationDateTxtFld;
	}

	public WebElement GetLastNameTxtFld()
	{
		if(this.LastNameTxtFld==null)
			SetLastNameTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_txtLastName\"]")));
		return this.LastNameTxtFld;
	}

	public void SetLastNameTxtFld(WebElement lastNameTxtFld)
	{
		this.LastNameTxtFld=lastNameTxtFld;
	}

	public WebElement GetFirstNameTxtFld()
	{
		if(this.FirstNameTxtFld==null)
			SetFirstNameTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_txtFirstName\"]")));
		return this.FirstNameTxtFld;
	}

	public void SetFirstNameTxtFld(WebElement firstNameTxtFld)
	{
		this.FirstNameTxtFld=firstNameTxtFld;
	}

	public WebElement GetMiddleNameTxtFld()
	{
		if(this.MiddleNameTxtFld==null)
			SetMiddleNameTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_txtMiddleName\"]")));
		return this.MiddleNameTxtFld;
	}

	public void SetMiddleNameTxtFld(WebElement middleNameTxtFld)
	{
		this.MiddleNameTxtFld=middleNameTxtFld;
	}

	public WebElement GetDob_txtDateTxtFld()
	{
		if(this.Dob_txtDateTxtFld==null)
			SetDob_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_ctlDob_txtDate\"]")));
		return this.Dob_txtDateTxtFld;
	}

	public void SetDob_txtDateTxtFld(WebElement dob_txtDateTxtFld)
	{
		this.Dob_txtDateTxtFld=dob_txtDateTxtFld;
	}

	public WebElement GetDoNInvitationDate_txtDateTxtFld()
	{
		if(this.DoNInvitationDate_txtDateTxtFld==null)
			SetDoNInvitationDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_ctlDoNInvitationDate_txtDate\"]")));
		return this.DoNInvitationDate_txtDateTxtFld;
	}

	public void SetDoNInvitationDate_txtDateTxtFld(WebElement doNInvitationDate_txtDateTxtFld)
	{
		this.DoNInvitationDate_txtDateTxtFld=doNInvitationDate_txtDateTxtFld;
	}

	public WebElement GetIIO_InvitationSentDateTxtFld()
	{
		if(this.IIO_InvitationSentDateTxtFld==null)
			SetIIO_InvitationSentDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_txtIIO_InvitationSentDate\"]")));
		return this.IIO_InvitationSentDateTxtFld;
	}

	public void SetIIO_InvitationSentDateTxtFld(WebElement iIO_InvitationSentDateTxtFld)
	{
		this.IIO_InvitationSentDateTxtFld=iIO_InvitationSentDateTxtFld;
	}

	public WebElement GetIIO_DossierSentDateTxtFld()
	{
		if(this.IIO_DossierSentDateTxtFld==null)
			SetIIO_DossierSentDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_txtIIO_DossierSentDate\"]")));
		return this.IIO_DossierSentDateTxtFld;
	}

	public void SetIIO_DossierSentDateTxtFld(WebElement iIO_DossierSentDateTxtFld)
	{
		this.IIO_DossierSentDateTxtFld=iIO_DossierSentDateTxtFld;
	}

	public WebElement GetConsentProviderNameTxtFld()
	{
		if(this.ConsentProviderNameTxtFld==null)
			SetConsentProviderNameTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_txtConsentProviderName\"]")));
		return this.ConsentProviderNameTxtFld;
	}

	public void SetConsentProviderNameTxtFld(WebElement consentProviderNameTxtFld)
	{
		this.ConsentProviderNameTxtFld=consentProviderNameTxtFld;
	}

	public WebElement GetDateFieldNoTransferConfirmedTxtFld()
	{
		if(this.DateFieldNoTransferConfirmedTxtFld==null)
			SetDateFieldNoTransferConfirmedTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_DateFieldNoTransferConfirmedDate_txtDate\"]")));
		return this.DateFieldNoTransferConfirmedTxtFld;
	}

	public void SetDateFieldNoTransferConfirmedTxtFld(WebElement dateFieldNoTransferConfirmedTxtFld)
	{
		this.DateFieldNoTransferConfirmedTxtFld=dateFieldNoTransferConfirmedTxtFld;
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

	public WebElement Get_LockStatusSelect()
	{
		if(this._LockStatusSelect==null)
			Set_LockStatusSelect(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_ddl_LockStatus\"]")));
		return this._LockStatusSelect;
	}

	public void Set_LockStatusSelect(WebElement _LockStatusSelect)
	{
		this._LockStatusSelect=_LockStatusSelect;
	}

	public WebElement GetTitleSelect()
	{
		if(this.TitleSelect==null)
			SetTitleSelect(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_ddlTitle\"]")));
		return this.TitleSelect;
	}

	public void SetTitleSelect(WebElement titleSelect)
	{
		this.TitleSelect=titleSelect;
	}

	public WebElement GetGenderSelect()
	{
		if(this.GenderSelect==null)
			SetGenderSelect(Driver.findElement(By.xpath("//*[@id=\"ctlClientContent_ddlGender\"]")));
		return this.GenderSelect;
	}

	public void SetGenderSelect(WebElement genderSelect)
	{
		this.GenderSelect=genderSelect;
	}


	public NewClientPageModel(WebDriver driver)
	{
		DriverFactory.WaitForPageLoad(driver);
		this.Driver = driver;
	}

	public NewClientPageModel FillQueryTxtFld(String text)
	{
		GetQueryTxtFld().sendKeys(text);
		return this;
	}


	public NewClientPageModel FillOAPClientNumberTxtFld(String text)
	{
		GetOAPClientNumberTxtFld().sendKeys(text);
		return this;
	}


	public NewClientPageModel FillIIO_TransitionCodeTxtFld(String text)
	{
		GetIIO_TransitionCodeTxtFld().sendKeys(text);
		return this;
	}


	public NewClientPageModel FillRegistrationDateTxtFld(String text)
	{
		GetRegistrationDateTxtFld().sendKeys(text);
		return this;
	}


	public NewClientPageModel FillLastNameTxtFld(String text)
	{
		GetLastNameTxtFld().sendKeys(text);
		return this;
	}


	public NewClientPageModel FillFirstNameTxtFld(String text)
	{
		GetFirstNameTxtFld().sendKeys(text);
		return this;
	}


	public NewClientPageModel FillMiddleNameTxtFld(String text)
	{
		GetMiddleNameTxtFld().sendKeys(text);
		return this;
	}


	public NewClientPageModel FillDob_txtDateTxtFld(String text)
	{
		GetDob_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public NewClientPageModel FillDoNInvitationDate_txtDateTxtFld(String text)
	{
		GetDoNInvitationDate_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public NewClientPageModel FillIIO_InvitationSentDateTxtFld(String text)
	{
		GetIIO_InvitationSentDateTxtFld().sendKeys(text);
		return this;
	}


	public NewClientPageModel FillIIO_DossierSentDateTxtFld(String text)
	{
		GetIIO_DossierSentDateTxtFld().sendKeys(text);
		return this;
	}


	public NewClientPageModel FillConsentProviderNameTxtFld(String text)
	{
		GetConsentProviderNameTxtFld().sendKeys(text);
		return this;
	}


	public NewClientPageModel FillDateFieldNoTransferConfirmedTxtFld(String text)
	{
		GetDateFieldNoTransferConfirmedTxtFld().sendKeys(text);
		return this;
	}

	public NewClientPageModel ClickMainLnk()
	{
		GetMainLnk().click();
		return new NewClientPageModel(Driver);
	}
	public NewClientPageModel ClickQueueLnk()
	{
		GetQueueLnk().click();
		return new NewClientPageModel(Driver);
	}
	public NewClientPageModel ClickClientLnk()
	{
		GetClientLnk().click();
		return new NewClientPageModel(Driver);
	}
	public NewClientPageModel ClickReportsLnk()
	{
		GetReportsLnk().click();
		return new NewClientPageModel(Driver);
	}
	public NewClientPageModel ClickNewLnk()
	{
		GetNewLnk().click();
		return new NewClientPageModel(Driver);
	}
	public NewClientPageModel ClickSaveLnk()
	{
		GetSaveLnk().click();
		return new NewClientPageModel(Driver);
	}
	public NewClientPageModel ClickDeleteLnk()
	{
		GetDeleteLnk().click();
		return new NewClientPageModel(Driver);
	}
	public NewClientPageModel ClickListLnk()
	{
		GetListLnk().click();
		return new NewClientPageModel(Driver);
	}
	public NewClientPageModel ClickMergeLnk()
	{
		GetMergeLnk().click();
		return new NewClientPageModel(Driver);
	}
	public NewClientPageModel ClickApplicationsLnk()
	{
		GetApplicationsLnk().click();
		return new NewClientPageModel(Driver);
	}
	public NewClientPageModel SelectOption_LockStatusSelect(WebDriver driver, String originalWindow, String optionText)
	{
		WebElement selectElement = this.Get_LockStatusSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	public NewClientPageModel SelectOptionTitleSelect(WebDriver driver, String originalWindow, String optionText)
	{
		WebElement selectElement = this.GetTitleSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	public NewClientPageModel SelectOptionGenderSelect(WebDriver driver, String originalWindow, String optionText)
	{
		WebElement selectElement = this.GetGenderSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	
	// Helper Method
	private NewClientPageModel SelectOptionGeneral(WebElement selectElement, WebDriver driver, String originalWindow, String optionText) {
		
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
