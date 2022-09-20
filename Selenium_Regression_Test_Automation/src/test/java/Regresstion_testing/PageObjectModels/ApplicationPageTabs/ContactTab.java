package Regresstion_testing.PageObjectModels.ApplicationPageTabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Regresstion_testing.DriverFactory;

public class ContactTab {
	private WebDriver Driver;
	private WebElement QueryTxtFld;
	private WebElement ApplicantLastNameTxtFld;
	private WebElement ApplicantFirstNameTxtFld;
	private WebElement ApplicantDob_txtDateTxtFld;
	private WebElement ReferenceNumberTxtFld;
	private WebElement ApplicantUnitTxtFld;
	private WebElement ApplicantStreetNumberTxtFld;
	private WebElement ApplicantStreetTxtFld;
	private WebElement ApplicantPOBoxTxtFld;
	private WebElement ApplicantCityTxtFld;
	private WebElement ApplicantPostalCodeTxtFld;
	private WebElement ApplicantEmailTxtFld;
	private WebElement PhoneHomeTxtFld;
	private WebElement ApplicantExt1TxtFld;
	private WebElement PhoneCellTxtFld;
	private WebElement ApplicantExt2TxtFld;
	private WebElement ApplicantOtherLanguageTxtFld;
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
	private WebElement RenewLnk;
	private WebElement AuthorizationLnk;
	private WebElement NarrativesLnk;
	private WebElement ApplicantProvinceSelect;
	private WebElement ApplicantLanguageSelect;


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

	public WebElement GetApplicantLastNameTxtFld()
	{
		if(this.ApplicantLastNameTxtFld==null)
			SetApplicantLastNameTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtApplicantLastName\"]")));
		return this.ApplicantLastNameTxtFld;
	}

	public void SetApplicantLastNameTxtFld(WebElement applicantLastNameTxtFld)
	{
		this.ApplicantLastNameTxtFld=applicantLastNameTxtFld;
	}

	public WebElement GetApplicantFirstNameTxtFld()
	{
		if(this.ApplicantFirstNameTxtFld==null)
			SetApplicantFirstNameTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtApplicantFirstName\"]")));
		return this.ApplicantFirstNameTxtFld;
	}

	public void SetApplicantFirstNameTxtFld(WebElement applicantFirstNameTxtFld)
	{
		this.ApplicantFirstNameTxtFld=applicantFirstNameTxtFld;
	}

	public WebElement GetApplicantDob_txtDateTxtFld()
	{
		if(this.ApplicantDob_txtDateTxtFld==null)
			SetApplicantDob_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlApplicantDob_txtDate\"]")));
		return this.ApplicantDob_txtDateTxtFld;
	}

	public void SetApplicantDob_txtDateTxtFld(WebElement applicantDob_txtDateTxtFld)
	{
		this.ApplicantDob_txtDateTxtFld=applicantDob_txtDateTxtFld;
	}

	public WebElement GetReferenceNumberTxtFld()
	{
		if(this.ReferenceNumberTxtFld==null)
			SetReferenceNumberTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtReferenceNumber\"]")));
		return this.ReferenceNumberTxtFld;
	}

	public void SetReferenceNumberTxtFld(WebElement referenceNumberTxtFld)
	{
		this.ReferenceNumberTxtFld=referenceNumberTxtFld;
	}

	public WebElement GetApplicantUnitTxtFld()
	{
		if(this.ApplicantUnitTxtFld==null)
			SetApplicantUnitTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtApplicantUnit\"]")));
		return this.ApplicantUnitTxtFld;
	}

	public void SetApplicantUnitTxtFld(WebElement applicantUnitTxtFld)
	{
		this.ApplicantUnitTxtFld=applicantUnitTxtFld;
	}

	public WebElement GetApplicantStreetNumberTxtFld()
	{
		if(this.ApplicantStreetNumberTxtFld==null)
			SetApplicantStreetNumberTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtApplicantStreetNumber\"]")));
		return this.ApplicantStreetNumberTxtFld;
	}

	public void SetApplicantStreetNumberTxtFld(WebElement applicantStreetNumberTxtFld)
	{
		this.ApplicantStreetNumberTxtFld=applicantStreetNumberTxtFld;
	}

	public WebElement GetApplicantStreetTxtFld()
	{
		if(this.ApplicantStreetTxtFld==null)
			SetApplicantStreetTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtApplicantStreet\"]")));
		return this.ApplicantStreetTxtFld;
	}

	public void SetApplicantStreetTxtFld(WebElement applicantStreetTxtFld)
	{
		this.ApplicantStreetTxtFld=applicantStreetTxtFld;
	}

	public WebElement GetApplicantPOBoxTxtFld()
	{
		if(this.ApplicantPOBoxTxtFld==null)
			SetApplicantPOBoxTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtApplicantPOBox\"]")));
		return this.ApplicantPOBoxTxtFld;
	}

	public void SetApplicantPOBoxTxtFld(WebElement applicantPOBoxTxtFld)
	{
		this.ApplicantPOBoxTxtFld=applicantPOBoxTxtFld;
	}

	public WebElement GetApplicantCityTxtFld()
	{
		if(this.ApplicantCityTxtFld==null)
			SetApplicantCityTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtApplicantCity\"]")));
		return this.ApplicantCityTxtFld;
	}

	public void SetApplicantCityTxtFld(WebElement applicantCityTxtFld)
	{
		this.ApplicantCityTxtFld=applicantCityTxtFld;
	}

	public WebElement GetApplicantPostalCodeTxtFld()
	{
		if(this.ApplicantPostalCodeTxtFld==null)
			SetApplicantPostalCodeTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtApplicantPostalCode\"]")));
		return this.ApplicantPostalCodeTxtFld;
	}

	public void SetApplicantPostalCodeTxtFld(WebElement applicantPostalCodeTxtFld)
	{
		this.ApplicantPostalCodeTxtFld=applicantPostalCodeTxtFld;
	}

	public WebElement GetApplicantEmailTxtFld()
	{
		if(this.ApplicantEmailTxtFld==null)
			SetApplicantEmailTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtApplicantEmail\"]")));
		return this.ApplicantEmailTxtFld;
	}

	public void SetApplicantEmailTxtFld(WebElement applicantEmailTxtFld)
	{
		this.ApplicantEmailTxtFld=applicantEmailTxtFld;
	}

	public WebElement GetPhoneHomeTxtFld()
	{
		if(this.PhoneHomeTxtFld==null)
			SetPhoneHomeTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtPhoneHome\"]")));
		return this.PhoneHomeTxtFld;
	}

	public void SetPhoneHomeTxtFld(WebElement phoneHomeTxtFld)
	{
		this.PhoneHomeTxtFld=phoneHomeTxtFld;
	}

	public WebElement GetApplicantExt1TxtFld()
	{
		if(this.ApplicantExt1TxtFld==null)
			SetApplicantExt1TxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtApplicantExt1\"]")));
		return this.ApplicantExt1TxtFld;
	}

	public void SetApplicantExt1TxtFld(WebElement applicantExt1TxtFld)
	{
		this.ApplicantExt1TxtFld=applicantExt1TxtFld;
	}

	public WebElement GetPhoneCellTxtFld()
	{
		if(this.PhoneCellTxtFld==null)
			SetPhoneCellTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtPhoneCell\"]")));
		return this.PhoneCellTxtFld;
	}

	public void SetPhoneCellTxtFld(WebElement phoneCellTxtFld)
	{
		this.PhoneCellTxtFld=phoneCellTxtFld;
	}

	public WebElement GetApplicantExt2TxtFld()
	{
		if(this.ApplicantExt2TxtFld==null)
			SetApplicantExt2TxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtApplicantExt2\"]")));
		return this.ApplicantExt2TxtFld;
	}

	public void SetApplicantExt2TxtFld(WebElement applicantExt2TxtFld)
	{
		this.ApplicantExt2TxtFld=applicantExt2TxtFld;
	}

	public WebElement GetApplicantOtherLanguageTxtFld()
	{
		if(this.ApplicantOtherLanguageTxtFld==null)
			SetApplicantOtherLanguageTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtApplicantOtherLanguage\"]")));
		return this.ApplicantOtherLanguageTxtFld;
	}

	public void SetApplicantOtherLanguageTxtFld(WebElement applicantOtherLanguageTxtFld)
	{
		this.ApplicantOtherLanguageTxtFld=applicantOtherLanguageTxtFld;
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
	
	public WebElement GetRenewLnk()
	{
		if(this.ExpensesLnk==null)
			SetRenewLnk(Driver.findElement(By.xpath("//*[@id=\"ctlAppPageNav_lnkRenew\"]")));
		return this.RenewLnk;
	}
	
	public void SetRenewLnk(WebElement renewLink)
	{
		this.RenewLnk=renewLink;
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

	public WebElement GetApplicantProvinceSelect()
	{
		if(this.ApplicantProvinceSelect==null)
			SetApplicantProvinceSelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlApplicantProvince\"]")));
		return this.ApplicantProvinceSelect;
	}

	public void SetApplicantProvinceSelect(WebElement applicantProvinceSelect)
	{
		this.ApplicantProvinceSelect=applicantProvinceSelect;
	}

	public WebElement GetApplicantLanguageSelect()
	{
		if(this.ApplicantLanguageSelect==null)
			SetApplicantLanguageSelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlApplicantLanguage\"]")));
		return this.ApplicantLanguageSelect;
	}

	public void SetApplicantLanguageSelect(WebElement applicantLanguageSelect)
	{
		this.ApplicantLanguageSelect=applicantLanguageSelect;
	}


	public ContactTab(WebDriver driver)
	{
		DriverFactory.WaitForPageLoad(driver);
		this.Driver = driver;
	}

	public ContactTab FillQueryTxtFld(String text)
	{
		GetQueryTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantLastNameTxtFld(String text)
	{
		GetApplicantLastNameTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantFirstNameTxtFld(String text)
	{
		GetApplicantFirstNameTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantDob_txtDateTxtFld(String text)
	{
		GetApplicantDob_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillReferenceNumberTxtFld(String text)
	{
		GetReferenceNumberTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantUnitTxtFld(String text)
	{
		GetApplicantUnitTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantStreetNumberTxtFld(String text)
	{
		GetApplicantStreetNumberTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantStreetTxtFld(String text)
	{
		GetApplicantStreetTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantPOBoxTxtFld(String text)
	{
		GetApplicantPOBoxTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantCityTxtFld(String text)
	{
		GetApplicantCityTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantPostalCodeTxtFld(String text)
	{
		GetApplicantPostalCodeTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantEmailTxtFld(String text)
	{
		GetApplicantEmailTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillPhoneHomeTxtFld(String text)
	{
		GetPhoneHomeTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantExt1TxtFld(String text)
	{
		GetApplicantExt1TxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillPhoneCellTxtFld(String text)
	{
		GetPhoneCellTxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantExt2TxtFld(String text)
	{
		GetApplicantExt2TxtFld().sendKeys(text);
		return this;
	}


	public ContactTab FillApplicantOtherLanguageTxtFld(String text)
	{
		GetApplicantOtherLanguageTxtFld().sendKeys(text);
		return this;
	}

	public ContactTab ClickMainLnk()
	{
		GetMainLnk().click();
		return new ContactTab(Driver);
	}
	public ContactTab ClickQueueLnk()
	{
		GetQueueLnk().click();
		return new ContactTab(Driver);
	}
	public ContactTab ClickClientLnk()
	{
		GetClientLnk().click();
		return new ContactTab(Driver);
	}
	public ContactTab ClickReportsLnk()
	{
		GetReportsLnk().click();
		return new ContactTab(Driver);
	}
	public ContactTab ClickNewLnk()
	{
		GetNewLnk().click();
		return new ContactTab(Driver);
	}
	public ContactTab ClickSaveLnk()
	{
		GetSaveLnk().click();
		return new ContactTab(Driver);
	}
	public ContactTab ClickDeleteLnk()
	{
		GetDeleteLnk().click();
		return new ContactTab(Driver);
	}
	public ContactTab ClickAppListLnk()
	{
		GetAppListLnk().click();
		return new ContactTab(Driver);
	}
	public ContactTab ClickMergeLnk()
	{
		GetMergeLnk().click();
		return new ContactTab(Driver);
	}
	public ContactTab ClickExpensesLnk()
	{
		GetExpensesLnk().click();
		return new ContactTab(Driver);
	}
	public ContactTab ClickAuthorizationLnk()
	{
		GetAuthorizationLnk().click();
		return new ContactTab(Driver);
	}
	public ContactTab ClickNarrativesLnk()
	{
		GetNarrativesLnk().click();
		return new ContactTab(Driver);
	}
	public ContactTab SelectOptionApplicantProvinceSelect(WebDriver driver, String originalWindow, String optionText)
	{
		WebElement selectElement = this.GetApplicantProvinceSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	public ContactTab SelectOptionApplicantLanguageSelect(WebDriver driver, String originalWindow, String optionText)
	{
		WebElement selectElement = this.GetApplicantLanguageSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	
	// Helper Method
	private ContactTab SelectOptionGeneral(WebElement selectElement, WebDriver driver, String originalWindow, String optionText) {
		
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
