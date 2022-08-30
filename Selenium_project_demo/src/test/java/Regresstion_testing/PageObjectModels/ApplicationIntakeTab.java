package Regresstion_testing.PageObjectModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Regresstion_testing.DriverFactory;

public class ApplicationIntakeTab {
	private WebDriver Driver;
	private WebElement QueryTxtFld;
	private WebElement ApplicationReceivedDate_txtDateTxtFld;
	private WebElement AppHourReceivedTxtFld;
	private WebElement AppMinuteReceivedTxtFld;
	private WebElement InformationLetterDate_txtDateTxtFld;
	private WebElement LetterSentDate_txtDateTxtFld;
	private WebElement UnreconciledAmountTxtFld;
	private WebElement ConsentDate_txtDateTxtFld;
	private WebElement SchoolBoardTxtFld;
	private WebElement SchoolNameTxtFld;
	private WebElement ApplicationCompletedDate_txtDateTxtFld;
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
	private WebElement AMPMSelect;
	private WebElement IntakeProcessSelect;
	private WebElement AppTypeSelect;
	private WebElement AgeProofSelect;
	private WebElement ResidencyProofSelect;
	private WebElement ConsentSelect;
	private WebElement AttendingSchoolSelect;
	
	private LandingPageModel LandingPage;


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

	public WebElement GetApplicationReceivedDate_txtDateTxtFld()
	{
		if(this.ApplicationReceivedDate_txtDateTxtFld==null)
			SetApplicationReceivedDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlApplicationReceivedDate_txtDate\"]")));
		return this.ApplicationReceivedDate_txtDateTxtFld;
	}

	public void SetApplicationReceivedDate_txtDateTxtFld(WebElement applicationReceivedDate_txtDateTxtFld)
	{
		this.ApplicationReceivedDate_txtDateTxtFld=applicationReceivedDate_txtDateTxtFld;
	}

	public WebElement GetAppHourReceivedTxtFld()
	{
		if(this.AppHourReceivedTxtFld==null)
			SetAppHourReceivedTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtAppHourReceived\"]")));
		return this.AppHourReceivedTxtFld;
	}

	public void SetAppHourReceivedTxtFld(WebElement appHourReceivedTxtFld)
	{
		this.AppHourReceivedTxtFld=appHourReceivedTxtFld;
	}

	public WebElement GetAppMinuteReceivedTxtFld()
	{
		if(this.AppMinuteReceivedTxtFld==null)
			SetAppMinuteReceivedTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtAppMinuteReceived\"]")));
		return this.AppMinuteReceivedTxtFld;
	}

	public void SetAppMinuteReceivedTxtFld(WebElement appMinuteReceivedTxtFld)
	{
		this.AppMinuteReceivedTxtFld=appMinuteReceivedTxtFld;
	}

	public WebElement GetInformationLetterDate_txtDateTxtFld()
	{
		if(this.InformationLetterDate_txtDateTxtFld==null)
			SetInformationLetterDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlInformationLetterDate_txtDate\"]")));
		return this.InformationLetterDate_txtDateTxtFld;
	}

	public void SetInformationLetterDate_txtDateTxtFld(WebElement informationLetterDate_txtDateTxtFld)
	{
		this.InformationLetterDate_txtDateTxtFld=informationLetterDate_txtDateTxtFld;
	}

	public WebElement GetLetterSentDate_txtDateTxtFld()
	{
		if(this.LetterSentDate_txtDateTxtFld==null)
			SetLetterSentDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlLetterSentDate_txtDate\"]")));
		return this.LetterSentDate_txtDateTxtFld;
	}

	public void SetLetterSentDate_txtDateTxtFld(WebElement letterSentDate_txtDateTxtFld)
	{
		this.LetterSentDate_txtDateTxtFld=letterSentDate_txtDateTxtFld;
	}

	public WebElement GetUnreconciledAmountTxtFld()
	{
		if(this.UnreconciledAmountTxtFld==null)
			SetUnreconciledAmountTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtUnreconciledAmount\"]")));
		return this.UnreconciledAmountTxtFld;
	}

	public void SetUnreconciledAmountTxtFld(WebElement unreconciledAmountTxtFld)
	{
		this.UnreconciledAmountTxtFld=unreconciledAmountTxtFld;
	}

	public WebElement GetConsentDate_txtDateTxtFld()
	{
		if(this.ConsentDate_txtDateTxtFld==null)
			SetConsentDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlConsentDate_txtDate\"]")));
		return this.ConsentDate_txtDateTxtFld;
	}

	public void SetConsentDate_txtDateTxtFld(WebElement consentDate_txtDateTxtFld)
	{
		this.ConsentDate_txtDateTxtFld=consentDate_txtDateTxtFld;
	}

	public WebElement GetSchoolBoardTxtFld()
	{
		if(this.SchoolBoardTxtFld==null)
			SetSchoolBoardTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtSchoolBoard\"]")));
		return this.SchoolBoardTxtFld;
	}

	public void SetSchoolBoardTxtFld(WebElement schoolBoardTxtFld)
	{
		this.SchoolBoardTxtFld=schoolBoardTxtFld;
	}

	public WebElement GetSchoolNameTxtFld()
	{
		if(this.SchoolNameTxtFld==null)
			SetSchoolNameTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_txtSchoolName\"]")));
		return this.SchoolNameTxtFld;
	}

	public void SetSchoolNameTxtFld(WebElement schoolNameTxtFld)
	{
		this.SchoolNameTxtFld=schoolNameTxtFld;
	}

	public WebElement GetApplicationCompletedDate_txtDateTxtFld()
	{
		if(this.ApplicationCompletedDate_txtDateTxtFld==null)
			SetApplicationCompletedDate_txtDateTxtFld(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ctlApplicationCompletedDate_txtDate\"]")));
		return this.ApplicationCompletedDate_txtDateTxtFld;
	}

	public void SetApplicationCompletedDate_txtDateTxtFld(WebElement applicationCompletedDate_txtDateTxtFld)
	{
		this.ApplicationCompletedDate_txtDateTxtFld=applicationCompletedDate_txtDateTxtFld;
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

	public WebElement GetAMPMSelect()
	{
		if(this.AMPMSelect==null)
			SetAMPMSelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlAMPM\"]")));
		return this.AMPMSelect;
	}

	public void SetAMPMSelect(WebElement aMPMSelect)
	{
		this.AMPMSelect=aMPMSelect;
	}

	public WebElement GetIntakeProcessSelect()
	{
		if(this.IntakeProcessSelect==null)
			SetIntakeProcessSelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlIntakeProcess\"]")));
		return this.IntakeProcessSelect;
	}

	public void SetIntakeProcessSelect(WebElement intakeProcessSelect)
	{
		this.IntakeProcessSelect=intakeProcessSelect;
	}

	public WebElement GetAppTypeSelect()
	{
		if(this.AppTypeSelect==null)
			SetAppTypeSelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlAppType\"]")));
		return this.AppTypeSelect;
	}

	public void SetAppTypeSelect(WebElement appTypeSelect)
	{
		this.AppTypeSelect=appTypeSelect;
	}

	public WebElement GetAgeProofSelect()
	{
		if(this.AgeProofSelect==null)
			SetAgeProofSelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlAgeProof\"]")));
		return this.AgeProofSelect;
	}

	public void SetAgeProofSelect(WebElement ageProofSelect)
	{
		this.AgeProofSelect=ageProofSelect;
	}

	public WebElement GetResidencyProofSelect()
	{
		if(this.ResidencyProofSelect==null)
			SetResidencyProofSelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlResidencyProof\"]")));
		return this.ResidencyProofSelect;
	}

	public void SetResidencyProofSelect(WebElement residencyProofSelect)
	{
		this.ResidencyProofSelect=residencyProofSelect;
	}

	public WebElement GetConsentSelect()
	{
		if(this.ConsentSelect==null)
			SetConsentSelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlConsent\"]")));
		return this.ConsentSelect;
	}

	public void SetConsentSelect(WebElement consentSelect)
	{
		this.ConsentSelect=consentSelect;
	}

	public WebElement GetAttendingSchoolSelect()
	{
		if(this.AttendingSchoolSelect==null)
			SetAttendingSchoolSelect(Driver.findElement(By.xpath("//*[@id=\"ctlAppContent_ddlAttendingSchool\"]")));
		return this.AttendingSchoolSelect;
	}

	public void SetAttendingSchoolSelect(WebElement attendingSchoolSelect)
	{
		this.AttendingSchoolSelect=attendingSchoolSelect;
	}


	public ApplicationIntakeTab(WebDriver driver)
	{
		DriverFactory.WaitForPageLoad(driver);
		this.Driver = driver;
		this.LandingPage = new LandingPageModel(driver);
	}

	public ApplicationIntakeTab FillQueryTxtFld(String text)
	{
		GetQueryTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationIntakeTab FillApplicationReceivedDate_txtDateTxtFld(String text)
	{
		GetApplicationReceivedDate_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationIntakeTab FillAppHourReceivedTxtFld(String text)
	{
		GetAppHourReceivedTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationIntakeTab FillAppMinuteReceivedTxtFld(String text)
	{
		GetAppMinuteReceivedTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationIntakeTab FillInformationLetterDate_txtDateTxtFld(String text)
	{
		GetInformationLetterDate_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationIntakeTab FillLetterSentDate_txtDateTxtFld(String text)
	{
		GetLetterSentDate_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationIntakeTab FillUnreconciledAmountTxtFld(String text)
	{
		GetUnreconciledAmountTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationIntakeTab FillConsentDate_txtDateTxtFld(String text)
	{
		GetConsentDate_txtDateTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationIntakeTab FillSchoolBoardTxtFld(String text)
	{
		GetSchoolBoardTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationIntakeTab FillSchoolNameTxtFld(String text)
	{
		GetSchoolNameTxtFld().sendKeys(text);
		return this;
	}


	public ApplicationIntakeTab FillApplicationCompletedDate_txtDateTxtFld(String text)
	{
		GetApplicationCompletedDate_txtDateTxtFld().sendKeys(text);
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
//	public Place_Holder ClickAppListLnk()
//	{
//		GetAppListLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickMergeLnk()
//	{
//		GetMergeLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickExpensesLnk()
//	{
//		GetExpensesLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickAuthorizationLnk()
//	{
//		GetAuthorizationLnk().click();
//		return new Place_Holder(Driver);
//	}
//	public Place_Holder ClickNarrativesLnk()
//	{
//		GetNarrativesLnk().click();
//		return new Place_Holder(Driver);
//	}
	public ApplicationIntakeTab SelectOptionAMPMSelect(int optionNum)
	{
		Actions action = new Actions(Driver);
		Select elementAsSelect = new Select(AMPMSelect);
		GetAMPMSelect().click();
		List<WebElement> selectOptions = elementAsSelect.getOptions();
		for (int i = 0; i < optionNum; i++)
		{
			action.sendKeys(Keys.DOWN);
		}
		action.sendKeys(Keys.TAB);
		action.build().perform();
		Driver.switchTo().window(LandingPage.BrowserWindowHandle);
		return this;
	}
	
	public ApplicationIntakeTab SelectOptionIntakeProcessSelect(WebDriver driver, String originalWindow, String optionText) {
		WebElement selectElement = this.GetIntakeProcessSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	
	
	public ApplicationIntakeTab SelectOptionAppTypeSelect(WebDriver driver, String originalWindow, String optionText) {
		return this.SelectOptionGeneral(this.GetAppTypeSelect(), driver, originalWindow, optionText);
	}
	
	public ApplicationIntakeTab SelectOptionAgeProofSelect(WebDriver driver, String originalWindow, String optionText) 	{
		WebElement selectElement = this.GetAgeProofSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);

	}
	
	public ApplicationIntakeTab SelectOptionResidencyProofSelect(WebDriver driver, String originalWindow, String optionText) 	{
		WebElement selectElement = this.GetResidencyProofSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	
	public ApplicationIntakeTab SelectOptionConsentSelect(WebDriver driver, String originalWindow, String optionText) 	{
		WebElement selectElement = this.GetConsentSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	
	public ApplicationIntakeTab SelectOptionAttendingSchoolSelect(WebDriver driver, String originalWindow, String optionText) 	{
		WebElement selectElement = this.GetAttendingSchoolSelect();
		return this.SelectOptionGeneral(selectElement, driver, originalWindow, optionText);
	}
	
	// Helper Method
	private ApplicationIntakeTab SelectOptionGeneral(WebElement selectElement, WebDriver driver, String originalWindow, String optionText) {
		
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
