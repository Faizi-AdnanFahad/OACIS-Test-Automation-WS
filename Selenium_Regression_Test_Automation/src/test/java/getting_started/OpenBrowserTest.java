package getting_started;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowserTest {
    public WebDriver driver;
    
    @Test
    public void edgeSession() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://google.com");
//        String title = driver.getTitle();
//        System.out.println(title);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); // waits for 500ms before trying to access any element. Helps to avoid accessing elements that aren't there.
        
        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchBox.sendKeys("Selenium");
        searchButton.click();
//        System.out.println("Click should work");
//        driver.quit();
    }
}
