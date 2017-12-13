package EclipseMavenTest.EclipseMavenTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GuruLoginTest
{
    private WebDriver driver;
    private String baseUrl = "http://demo.guru99.com/";

    @BeforeTest
    public void setUp() throws Exception {
        //System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        //driver = new FirefoxDriver();
    	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCase() throws Exception {
    	driver.get(baseUrl);
    	WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));        
		element.sendKeys("abc@gmail.com");            
		WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));         
	button.click(); 
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
