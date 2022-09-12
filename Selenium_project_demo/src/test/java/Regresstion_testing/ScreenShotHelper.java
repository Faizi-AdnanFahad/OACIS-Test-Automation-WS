package Regresstion_testing;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotHelper {

	private static int iCounter=1;
	

	public static void TakeScreenShot(WebDriver driver) {
		// TODO Auto-generated method stub

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			
		
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\data\\Screenshots\\test"+iCounter+".png"));
		}
		catch(Exception e) {
			
		}
		iCounter++;
	}
	
	//public static <T> T TakeScreenshotT(WebDriver driver, Class<T> type) throws InstantiationException, IllegalAccessException {
//		
//		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		try {
//			
//		
//			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\data\\Screenshots\\test2.png"));
//		}
//		catch(Exception e) {
//			
//		}
//		
//		return type.newInstance();
//	
//		
//	}
// 
}
