package getting_started;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OACSMainPage {
    public WebDriver driver;
    
    @Test
    public void edgeSession() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("http://intra.stage.oacis.children.gov.on.ca/Main.aspx");

        WebElement oapSearchField = driver.findElement(By.id("ctlQueryBox_txtQuery"));
        
        WebElement searchbtn = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[1]/div[1]/img"));
        oapSearchField.sendKeys("OAP0018295");
        searchbtn.click();
//        driver.quit();
        // test
    }
}





























