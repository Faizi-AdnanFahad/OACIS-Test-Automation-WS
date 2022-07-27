package getting_started;

import org.junit.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class InstallDriversTest {
	 @Test
	    public void edgeSession() {
	        WebDriverManager.edgedriver().setup();

	        WebDriver driver = new EdgeDriver();

	        driver.quit();
	    }
}
