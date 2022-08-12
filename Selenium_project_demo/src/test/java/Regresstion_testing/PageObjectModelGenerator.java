package Regresstion_testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import Regresstion_testing.PageObjectModels.LandingPageModel;

public class PageObjectModelGenerator {

	private static String PropertyDefinitions = "";
	private static String GettersSettersDefinitions = "";
	private static String ActionMethodsDefinitions = "";
	
	@Test
	public void RunPageModelGeneration() {
		WebDriver driver = DriverFactory.CreateIEDriverManually();
	    driver.get("http://intra.stage.oacis.children.gov.on.ca/Main.aspx"); 
	    System.out.println("Starting");
	    
	   LandingPageModel landingPage = new LandingPageModel(driver);
	   landingPage.ClickClientLnk()
	   .ClickMainLnk();
	}
 
	public static void PrintPageModelCode(WebDriver driver)
	{
		PropertyDefinitions += "\nprivate WebDriver Driver;";
		   
		ActionMethodsDefinitions += ""
		+"\n\npublic ThisClassName(WebDriver driver)" +
		"\n{" +
		"\n\tDriverFactory.WaitForPageLoad(driver);" +
		"\n\tthis.Driver = driver;\n" +
		"}";
		
		DriverFactory.WaitForPageLoad(driver);
		WebElement activeTab = null;
		System.out.println("Getting page elements....");

		try
		{
			System.out.println("Checking if Page has tabs...");
			activeTab = driver.findElement(By.xpath("//div[@class=\"SectionTabOn\"]"));//Check if this is a tabbed page (ie. application page)
		}catch(Exception ex)
		{
			activeTab = null;
		}
		
		List<WebElement> allTextInputs; 
		List<WebElement> allLinks;
		List<WebElement> allSelects;
		List<WebElement> allCheckBoxes;
		List<List<WebElement>> allRelevantElements=new ArrayList<List<WebElement>>();
		
		if (activeTab != null)//If this is a tabbed page, sort the elements by whether they are contained in a div marked 'TabOn' (Selecting elements only present in divs marked 'tabOn' does not seem to be accurate)
		{
			System.out.println("Page has tabs-> parsing page for only visible elements....");

			System.out.println("->Getting entire page elements....");
			List<WebElement> allSectionOffTextInputs = new ArrayList<WebElement>();//Get elements appearing in only off tabs
			List<WebElement> allSectionOffLinks = new ArrayList<WebElement>();
			List<WebElement> allSectionOffSelects = new ArrayList<WebElement>();
			
			List<WebElement>  allTextInputsEntirePage = driver.findElements(By.xpath("//input[@type=\"text\" and starts-with(@id,\"ctl\") and not(contains(@class,\"idden\")) ]"));//Get elements in both on and off tabs
			List<WebElement>  allLinksEntirePage =  driver.findElements(By.xpath("//a[contains(@id,\"ctl\") and contains(@id,\"lnk\")]"));
			List<WebElement>  allSelectsEntirePage =  driver.findElements(By.xpath("//select[@*]"));
			 // @"//select[contains(@id,\"ctl\")]"
			List<WebElement> allSectionOffDivs =  driver.findElements(By.xpath("//div[@class=\"SectionTabOff\"]"));//Get all the divs marked 'TabOff'
			
			System.out.println("->Getting section off elements....");

			for(Iterator<WebElement> i = allSectionOffDivs.iterator(); i.hasNext();)//Loop through all the divs labeled 'TabOff'
			{
				WebElement iSectionOffDiv = i.next();
				List<WebElement> sectionOffTexts = iSectionOffDiv.findElements(By.xpath("./descendant::input[@type=\"text\" and starts-with(@id,\"ctl\") and not(contains(@class,\"idden\"))]"));//Get specific elements from within each div labeled 'TabOff'
				List<WebElement> sectionOffLinks = iSectionOffDiv.findElements(By.xpath("./descendant::a[contains(@id,\"ctl\") and contains(@id,\"lnk\")]"));
				List<WebElement> sectionOffSelects = iSectionOffDiv.findElements(By.xpath("./descendant::select[@*]"));
				
				allSectionOffTextInputs.addAll(sectionOffTexts);//Add elements from this section off div to a collection of all section off divs
				allSectionOffLinks.addAll(sectionOffLinks);
				allSectionOffSelects.addAll(sectionOffSelects);
			}
			
			List<WebElement> allTextInputsExceptSectionOff = allTextInputsEntirePage;//Initialize list with all elements from both tab on and taboff divs
			List<WebElement> allLinksExceptSectionOff = allLinksEntirePage; 
			List<WebElement> allSelectsExceptSectionOff = allSelectsEntirePage;
			
			System.out.println("->Filtering to only tab on elements....");

			allTextInputsExceptSectionOff.removeAll(allSectionOffTextInputs);//Remove section off elements from collection of all elements - leaving only tabon elements
			allLinksExceptSectionOff.removeAll(allSectionOffLinks);//.ToList().AsReadOnly();
			allSelectsExceptSectionOff.removeAll(allSectionOffSelects);
			
			allRelevantElements.add(allTextInputsExceptSectionOff);//Add tabon element list to list of all types of tab on elements
			allRelevantElements.add(allLinksExceptSectionOff);
			allRelevantElements.add(allSelectsExceptSectionOff);
			 
			System.out.println("Page tab parsing complete.");
		}
		else
		{
			System.out.println("Page has no tabs - getting page elements....");

			allTextInputs = driver.findElements(By.xpath("//input[@type=\"text\" and starts-with(@id,\"ctl\") and not(contains(@class,\"idden\")) ]"));
			allLinks = driver.findElements(By.xpath("//a[contains(@id,\"ctl\") and contains(@id,\"lnk\")]"));
			allSelects = driver.findElements(By.xpath("//select[@*]"));
			 
			allRelevantElements.add(allTextInputs);//Add tabon element list to list of all types of tab on elements
			allRelevantElements.add(allLinks);
			allRelevantElements.add(allSelects);
			// allCheckBoxes = DriverHelper.FindElementsWithWait(driver, @"//input[@type=""checkbox"" and starts-with(@id,""ctl"") ]");
		}
		
		System.out.println("Generating page element property definitions...");
			 
		for(Iterator<List<WebElement>> i = allRelevantElements.iterator();i.hasNext();) {
			List<WebElement> iElementList=i.next();
			 
			for(Iterator<WebElement> iInner = iElementList.iterator(); iInner.hasNext();) {
				WebElement iElement = iInner.next();
				String id = iElement.getAttribute("id");
				int iOfUnderScore;
				String propName="";
				String propNameLower="";
				String propNameUpper="";
				boolean propNameFound=false;
				// id="ctlQueryBox_txtQuery" 
				iOfUnderScore = id.indexOf("_")+1;
				propName = id.substring(iOfUnderScore, id.length());
				while(propNameFound==false) {
					if ( propName.substring(0, 3).equals("txt") || propName.substring(0, 3).equals("ctl"))
					{
						System.out.println("Generating text input property methods...");
						propNameLower = String.format("%s%sTxtFld",propName.substring(3, 4).toLowerCase(),propName.substring(4,propName.length()));
						propNameUpper= String.format("%s%sTxtFld",propName.substring(3, 4).toUpperCase(),propName.substring(4,propName.length()));
						
						ActionMethodsDefinitions += String.format("" 
						+"\n\npublic ThisClassName Fill%s(String text)",propNameUpper) 
						+"\n{" + String.format(""
						+"\n\tGet%s().sendKeys(text);",propNameUpper)
						+"\n\treturn this;" 
						+"\n}\n"; 
						propNameFound=true;
					}
					else if (propName.substring(0, 3).equals("lnk"))
					{
						System.out.println("Generating link property methods...");
						propNameLower = String.format("%s%sLnk",propName.substring(3, 4).toLowerCase(),propName.substring(4,propName.length()));
						propNameUpper= String.format("%s%sLnk",propName.substring(3, 4).toUpperCase(),propName.substring(4,propName.length()));

						ActionMethodsDefinitions += String.format(""
						+"\npublic Place_Holder Click%s()",propNameUpper) + String.format(""
						+"\n{" 
						+"\n\tGet%s().click();",propNameUpper)
						+"\n\treturn new Place_Holder(Driver);"
						+"\n}";
						propNameFound=true;
					}
					else if (propName.substring(0, 3).equals("ddl"))//select
					{
						System.out.println("Generating select element property methods...");
						propNameLower = String.format("%s%sSelect",propName.substring(3, 4).toLowerCase(),propName.substring(4,propName.length()));
						propNameUpper= String.format("%s%sSelect",propName.substring(3, 4).toUpperCase(),propName.substring(4,propName.length()));
						 
						ActionMethodsDefinitions += String.format(""
						+"\npublic ThisClassName SelectOption%s(int optionNum)",propNameUpper) + String.format(""
						+"\n{"
						+"\n\tActions action = new Actions(Driver);"
						+"\n\tSelect elementAsSelect = new Select(%s);",propNameUpper) + String.format(""
						+"\n\tGet%s().click();",propNameUpper)
						+"\n\tList<WebElement> selectOptions = elementAsSelect.getOptions();" 
						+"\n\tfor (int i = 0; i < optionNum; i++)"
						+"\n\t{" 
						+"\n\t\taction.sendKeys(Keys.DOWN);" 
						+"\n\t}" 
						+"\n\taction.sendKeys(Keys.TAB);"
						+"\n\taction.build().perform();"
						+"\n\tDriver.switchTo().Window(LandingPage.BrowserWindowHandle);" 
						+"\n\treturn this;"
						+"\n}";
						propNameFound=true;
					}
					else {
						if(id.indexOf("_txt")>0) {
							propName = String.format("txt%s",id.substring(iOfUnderScore,id.indexOf("_txt")-4));
						}
						else if(id.indexOf("_ctl")>0) {
							propName = String.format("txt%s",id.substring(iOfUnderScore,id.indexOf("_ctl")-4));
						}
						else if(id.indexOf("_lnk")>0) {
							propName = String.format("lnk%s",id.substring(iOfUnderScore,id.indexOf("_lnk")-4));
						}
						else if(id.indexOf("_ddl")>0) {
							propName = String.format("ddl%s",id.substring(iOfUnderScore,id.indexOf("_ddl")-4));
						}
						propNameFound=false;
					}
				}
				GeneratePropertyAndGettersSetters(propNameLower,propNameUpper,id);	
			}
		}
		System.out.println("\nCopy and paste below text into Java class defintion:\n\n");
	     System.out.println(PropertyDefinitions);
		 System.out.println(GettersSettersDefinitions);
		 System.out.println(ActionMethodsDefinitions);
	 }
	
	public static void GeneratePropertyAndGettersSetters(String propNameLower, String propNameUpper, String id) {
		PropertyDefinitions +=  String.format("\nprivate WebElement %s;", propNameUpper);
		GettersSettersDefinitions +=  String.format(""
			+ "\n\npublic WebElement Get%s()", propNameUpper) + String.format(""
			+"\n{" 
			+"\n\tif(this.%s==null)",propNameUpper) + String.format(""
			//+"\n\t{"
			+"\n\t\tSet%s(Driver.findElement(By.xpath(\"//*[@id=\\\"%s\\\"]\")));",propNameUpper, id)+String.format(""
			//+ "\n\t}"
			+"\n\treturn this.%s;",propNameUpper) + String.format(""
			+ "\n}"
			+"\n\npublic void Set%s(WebElement %s)",propNameUpper,propNameLower)+ String.format(""
			+"\n{"
			+"\n\tthis.%s=%s;",propNameUpper,propNameLower) + ""
			+ "\n}";
		}
	}


