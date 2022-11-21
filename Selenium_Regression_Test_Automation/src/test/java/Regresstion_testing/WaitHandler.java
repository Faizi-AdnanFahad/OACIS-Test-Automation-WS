package Regresstion_testing;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHandler {
	public static void WaitForPageLoad(WebDriver driver) {
		//Description:
		//Function to allow Selenium to wait for the webpage to fully load before proceeding
		//Uses JavaScript to watch value of DOM property 'readyState'  
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		//Potential additional parameters to add to the wait object if needed while debugging:
//		.withTimeout(Duration.ofSeconds(30L))
//		.pollingEvery(Duration.ofSeconds(5L))
//		.ignoring(NoSuchElementException.class);
			
		wait.until(
				new Function<WebDriver,Boolean>() {
					public Boolean apply(WebDriver drv) {
						return ((JavascriptExecutor)drv).executeScript("return document.readyState").equals("complete");//Executes JavaScript script to wait until value of DOM property 'readyState' equals complete
					}
				});
	}
}
